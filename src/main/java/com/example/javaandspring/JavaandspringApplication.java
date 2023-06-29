package com.example.javaandspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaandspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaandspringApplication.class, args);
		test();
	}

	public static void test() {
		System.out.println("잘 작동이 되냐구요!!");
	}

}
