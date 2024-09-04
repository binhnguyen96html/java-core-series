package com.javacore1.javacore1;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Javacore1Application {

	public static void main(String[] args) {
		// SpringApplication.run(Javacore1Application.class, args);

		CaChuon caChuon = new CaChuon();

		// Tinh da hinh - polymorphism: trong 1 class co nhieu method cung ten nhung
		// tham so se khac nhau => overloading
		caChuon.boi();
		caChuon.boi("Ca Chuon boi theo kieu cua Ca Chuon");

		CaBayMau caBayMau = new CaBayMau();
		caBayMau.boi("Ca Bay Mau boi theo kieu Ca Bay Mau");
	}

}
