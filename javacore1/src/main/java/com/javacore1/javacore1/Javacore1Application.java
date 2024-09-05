package com.javacore1.javacore1;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Javacore1Application {

	public static void main(String[] args) {
		// SpringApplication.run(Javacore1Application.class, args);

		// Cach nay khi class CaChuon ko thua ke 
		CaChuon caChuon1 = new CaChuon();
		// boi(): se vao method boi() cua thang con
		caChuon1.boi();

		// Neu da thua ke: thi goi parent class
		LopCa caChuon2 = new CaChuon();
		// boi(): se vao method boi() cua thang me
		caChuon2.boi();

	}

}
