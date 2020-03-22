package com.revature.medicine_time;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MedicineTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicineTimeApplication.class, args);
	}

}
