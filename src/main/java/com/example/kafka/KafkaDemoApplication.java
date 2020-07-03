package com.example.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class KafkaDemoApplication {

	@Autowired
	private KafkaTemplate kafkaTemplate;

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}

	@GetMapping("/test")
	public String test() {
		log.info("发送消息----->" + "Hello Kafka");
		kafkaTemplate.send("someTopic", "Hello Kafka");
		return "success";
	}

}
