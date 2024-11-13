package comm.example.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "comm.exmaple.demo2")
@EnableJpaRepositories(basePackages = "comm.exmaple.demo2")
@EntityScan(basePackages = "comm.exmaple.demo2")
public class Demo2Application {
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

}
