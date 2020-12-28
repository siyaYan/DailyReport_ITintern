package com.example.dailyReport.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import com.example.dailyReport.Bean.Access;
import com.example.dailyReport.Bean.Word;
import com.example.dailyReport.Mapper.two.target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//todo use RestTemplate!
@Service
public class ThirdPartyService {
    @Autowired(required = false)
    private target targetData;
    private String WordApiPath = "http://116.62.125.88:10000/api/network/school/getSensitiveWord?";
    private String AccessApiPath = "http://open.lepayedu.com/access-control/entry-data/list";
    public List<Word> getWordsData(int school_id, int days, int size) throws IOException {
        List<Word> words = new ArrayList<>();
        WordApiPath += "schoolId=" + school_id + "&days=" + days + "&size=" + size;
        URL url = new URL(WordApiPath);
        //打开和url之间的连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        if (connection.getResponseCode() == 200) {
            InputStream is = connection.getInputStream();
            // 封装输入流is，并指定字符集
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            // 存放数据
            StringBuffer sbf = new StringBuffer();
            String temp = null;
            while ((temp = br.readLine()) != null) {
                sbf.append(temp);
                sbf.append("\r\n");
            }
            String result = sbf.toString();
            System.out.println(result);
            JSONObject jsonObject = JSON.parseObject(result);
            /*JSONObject resultJsonObject = jsonObject.getJSONObject("result");*/
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            System.out.println(jsonArray);
            //遍历json集合，取出数据
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = (JSONObject) jsonArray.get(i);
                Word word = new Word();
                word.setSchool_id(school_id);
                word.setKeyword(jsonObject2.get("keyword").toString());
                word.setNum(Integer.valueOf(jsonObject2.get("num").toString()));
                words.add(word);
            }
        }
            connection.disconnect();
        return words;
    }
    /*JSONObject jsonObject = new JSONObject();
		jsonObject.;
		jsonObject.put("state", "0");
		jsonObject.put("channel", "channel");
		jsonObject.put("requestCommand", "control");
    String result = contect_flask.post(jsonObject1, "http://172.30.12.188:5003/test/hello");*/
    //school id default=1
    public List<Access> getAccessData(int start,int end) {
        List<Access> accesses = new ArrayList<>();
        String result=null;
        try {
            URL url = new URL(AccessApiPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Connection","keep-Alive");
            connection.setRequestProperty("Content-Type","application/json");
            connection.connect();
            String data =  "beginTime=" + start +
                    "&endTime=" + end +
                    "&mchNo=tf7z" +
                    "&nonceStr=5451a15f1g" +
                    "&page=1" +
                    "&pageSize=10" +
                    "&schoolId=51";

            String key= "&key=dd55a661b919bb7e75319e8c2bade760";

            String sign = DigestUtils.md5DigestAsHex((data+key).getBytes()).toUpperCase();
            String param = "{\"beginTime\":\"" + start
                    + "\",\"endTime\":\"" + end
                    +"\",\"mchNo\":\"" + "tf7z"
                    +"\",\"nonceStr\":\"" + "5451a15f1g"
                    +"\",\"page\":\"" + "1"
                    +"\",\"pageSize\":\"" + "10"
                    +"\",\"schoolId\":\"" + "51"
                    +"\",\"sign\":\"" + sign
                    + "\"}";
            System.out.println(param);
            OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream(), "utf-8");
            osw.write(param);
            osw.flush();
            osw.close();
            if (connection.getResponseCode()==200) {
                InputStream is = connection.getInputStream();
                // 封装输入流is，并指定字符集
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                // 存放数据
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
                System.out.println(result);
            }

            System.out.println(sign);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSON.parseObject(result);
        JSONObject resultJsonObject = jsonObject.getJSONObject("results");
        JSONArray jsonArray = resultJsonObject.getJSONArray("list");
        //遍历json集合，取出数据
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject2 = (JSONObject) jsonArray.get(i);
            Access access = new Access();
            access.setAccess_time((Integer) jsonObject2.get("entry_time"));
            access.setAccess_type((Integer) jsonObject2.get("entry_type"));
            access.setPerson_id(targetData.selectPersonByThirdNo(jsonObject2.get("person_number").toString()).getPerson_id());
            access.setPerson_name(jsonObject2.get("person_name").toString());
            access.setCard_number(jsonObject2.get("mac_sn").toString());
            access.setPosition( jsonObject2.get("entry_address").toString());
            access.setSchool_id(1);
            accesses.add(access);

        }
        return accesses;
    }

    public Boolean insertAccesses(List<Access> accesses) {
        return targetData.insertAccesses(accesses);
    }

    public Boolean accessesService(int start,int end) {
        return insertAccesses(getAccessData(start, end));
    }
}




