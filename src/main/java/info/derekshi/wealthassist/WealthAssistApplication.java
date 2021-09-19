package info.derekshi.wealthassist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class WealthAssistApplication {

	public static void main(String[] args) {
		SpringApplication.run(WealthAssistApplication.class, args);
	}

	@GetMapping("/")
	public @ResponseBody ResponseEntity<String> get() {
		return new ResponseEntity<String>("GET Response", HttpStatus.OK);
	}
}
