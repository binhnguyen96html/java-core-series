package com.javacore1.javacore1;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Javacore1Application {

	public static void main(String[] args) {
		// SpringApplication.run(Javacore1Application.class, args);
		
		CaChuon caChuon = new CaChuon();
		caChuon.colorEye = "yellow";

		System.out.println("Color eye: " + caChuon.colorEye);
	}

}
