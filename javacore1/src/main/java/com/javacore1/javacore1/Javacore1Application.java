package com.javacore1.javacore1;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Javacore1Application {

	public static void main(String[] args) {
		// SpringApplication.run(Javacore1Application.class, args);

		CaChuon_Interface caChuon = new CaChuon_Implement();
		caChuon.boi();
		caChuon.bay();
	}

}
