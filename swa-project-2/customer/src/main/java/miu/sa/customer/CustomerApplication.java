package miu.sa.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerApplication implements CommandLineRunner {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("url = " + url);
		System.out.println("username = " + username);
		System.out.println("password = " + password);
	}
}
