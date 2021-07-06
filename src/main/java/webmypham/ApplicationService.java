package webmypham;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.time.LocalDate;
@SpringBootApplication(scanBasePackages={"webmypham"})

public class ApplicationService {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationService.class,args);

	}
}