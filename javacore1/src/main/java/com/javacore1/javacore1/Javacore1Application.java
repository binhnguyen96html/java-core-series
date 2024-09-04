package com.javacore1.javacore1;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Javacore1Application {

	public static void main(String[] args) {
		// SpringApplication.run(Javacore1Application.class, args);

		// CaChuon caChuon1 = new CaChuon();

		CaChuon caChuon2 = new CaChuon("yellow", "black", "yellow2", "black2");

		System.out.println("Color eye: " + caChuon2.getColorEye());

	}

}
