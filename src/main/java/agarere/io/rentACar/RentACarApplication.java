package agarere.io.rentACar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

	// Buradaki methodun ismi önemli değil.
	// Uygulama çalıştığı zaman ModelMapper instance ihtiyaç olacak.
	// Buradaki method yeni bir tane ModelMapper instance'ı dönüyor.
	// Bu methodun dönüşündeki instance'ı IoC ye alabilmek için @Bean ekliyoruz başına.
	@Bean
	public ModelMapper getModelMapper () {
		return new ModelMapper();
	}

}
