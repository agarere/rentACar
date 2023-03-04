package agarere.io.rentACar;

import agarere.io.rentACar.core.utilities.exceptions.BusinessException;
import agarere.io.rentACar.core.utilities.exceptions.ProblemDetails;
import agarere.io.rentACar.core.utilities.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
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

	@ExceptionHandler
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return  problemDetails;
	}

	@ExceptionHandler
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("Validation Exception");

		validationProblemDetails.setValidationErrors(new HashMap<String, String>());

		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails
					.getValidationErrors()
					.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		return  validationProblemDetails;
	}
}
