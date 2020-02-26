package com.rms;

import com.rms.dao.WorkOrderDao;
import com.rms.model.Category;
import com.rms.model.WorkOrder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class WorkOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkOrderServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(WorkOrderDao wod) {
		return args -> {
			// wod.save(new WorkOrder(null, Category.LIGHTING, "Light over the white board is flickering", "ardonp@gmail.com", 0, 0));  
			// wod.save(new WorkOrder(null, Category.DOORS, "Door is ajar", "ardonp@gmail.com", 0, 0)); 
			// wod.save(new WorkOrder(null, Category.AIR_CONDITIONING, "AC is rattling", "ardonp@gmail.com", 0, 0));
		};
	}

}
