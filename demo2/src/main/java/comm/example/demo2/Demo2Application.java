package comm.example.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "comm.exmaple.demo2.Search", exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@EntityScan(basePackages = "comm.exmaple.demo2.Search")
@ComponentScan(basePackages = {"comm.exmaple.demo2.Search"})
public class Demo2Application {
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

}
