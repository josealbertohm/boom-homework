package com.spring.boom.credit.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring.boom.credit.homework.tools.TableBean;

@SpringBootApplication
public class HomeworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(HomeworkApplication.class, args);
		// Add the Employee Test data
		TableBean tableBean = context.getBean(TableBean.class);
		tableBean.setupDummyData();
	}
}