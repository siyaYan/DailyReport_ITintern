package com.example.dailyReport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @Author: Siya(Xiran) Yan
 * @Date: 11:14 14/12/20
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class DailyReportApplication {
	public static void main(String[] args) {
		SpringApplication.run(DailyReportApplication.class, args);
	}

}
