package br.com.hexa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.hexa")
public class HexaApplication {

	private static final Logger LOGGER_TECNICO = LoggerFactory.getLogger(HexaApplication.class);

//	@Autowired
//	private Environment environment;
//
//	@Autowired
//	private BuildProperties buildProperties;

	public static void main(String[] args) {
		SpringApplication.run(HexaApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception{
//		LOGGER_TECNICO.info("---------------------------------------------------");
//		LOGGER_TECNICO.info("App Name ........: [ {} ]", buildProperties.getName());
//		LOGGER_TECNICO.info("App Version .....: [ {} ]", buildProperties.getVersion());
//		LOGGER_TECNICO.info("App Build Time ..: [ {} ]", buildProperties.getVersion());
//		LOGGER_TECNICO.info("Environment .....: [ {} ]", environment);
//		LOGGER_TECNICO.info("---------------------------------------------------");
//	}
}
