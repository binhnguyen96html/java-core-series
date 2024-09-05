package com.javacore1.javacore1;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Javacore1Application {

	public static void main(String[] args) {
		// SpringApplication.run(Javacore1Application.class, args);

		CaChuon caChuon = new CaChuon("pink", "red");

		System.out.println(caChuon.getColorEye());
		System.out.println(caChuon.getColorSkin());

		caChuon.setColorEye("pink2");
		caChuon.setColorSkin("red2");
		

		System.out.println(caChuon.getColorEye());
		System.out.println(caChuon.getColorSkin());
	}

}
