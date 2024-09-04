package com.javacore1.javacore1;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Javacore1Application {

	public static void main(String[] args) {
		// SpringApplication.run(Javacore1Application.class, args);

		// Boxing is the process of converting a primitive type into its corresponding
		// wrapper class object. This can be done manually or automatically
		// (auto-boxing).
		// primitive -> wrapper : boxing -> manually
		int a = 50;
		Integer a2 = new Integer(a);

		// auto boxing
		Integer a3 = 5;
		

		// Unboxing is the reverse process where the object of a wrapper class is
		// converted back to its corresponding primitive type.
		// manual unboxing
		Integer b = new Integer(50);

		// auto unboxing
		int b2 = b;
	}

}
