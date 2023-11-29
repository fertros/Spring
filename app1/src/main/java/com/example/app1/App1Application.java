package com.example.app1;

import com.example.app1.Services.Service1;
import com.example.app1.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App1Application {



	public static void main(String[] args) {
		final var context = SpringApplication.run(App1Application.class, args);
		final var name = context.getBean("nombre");
		System.out.println(name);
		final var s1 =  context.getBean(Service1.class);
		System.out.println(s1.algo());
		final var s2 =  context.getBean(Service1.class);
		System.out.println(s2.algo());
	}
	//Lo que devuelve el metodo se transforma en un BEAN.
	@Bean("nombre")
	public String name() {
		return "Pedro";
	}

}
