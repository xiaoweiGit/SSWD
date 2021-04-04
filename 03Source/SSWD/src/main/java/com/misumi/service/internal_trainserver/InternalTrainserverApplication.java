package com.misumi.service.internal_trainserver;

import com.misumi.service.internal_trainserver.storage.StorageProperties;
import com.misumi.service.internal_trainserver.storage.StorageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ServletComponentScan
@EnableTransactionManagement
@Log4j2
@EnableConfigurationProperties(StorageProperties.class)
@SpringBootApplication
public class InternalTrainserverApplication implements CommandLineRunner {

	@Value("${server.port:8833}")
	private String serverPort;

	@Value("${server.context-path:/demo}")
	private String serverContextPath;

	public static void main(String[] args) {
		SpringApplication.run(InternalTrainserverApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		log.info("Application is success, Index >> http://127.0.0.1:{}{}", serverPort, serverContextPath);
		log.info("Application is success, Login Page >> http://127.0.0.1:{}{}/lessons.html", serverPort, serverContextPath);
		log.info("Application is success, Swagger Url >> http://127.0.0.1:{}{}/swagger-ui.html", serverPort, serverContextPath);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.init();
		};
	}
}
