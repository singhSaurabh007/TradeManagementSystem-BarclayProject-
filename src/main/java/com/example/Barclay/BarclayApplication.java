package com.example.Barclay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

import com.example.Barclay.repository.TradeRepository;
import com.example.Barclay.service.TradeService;


@SpringBootApplication()
public class BarclayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarclayApplication.class, args);
	}
	
	@Autowired
	private TradeRepository tr;
	
	public void run(String... args) throws Exception {
		
		
		
		 
		
	}

}
