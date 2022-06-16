package calculator;

import calculator.exception.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/calcul", produces = MediaType.APPLICATION_JSON_VALUE)
public class CalculatorController {

	private final CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping("/add")
	public Double add(@RequestParam double operand1, @RequestParam double operand2) {
		return calculatorService.add(operand1, operand2);
	}

	@GetMapping("subtract")
	public Double subtract(@RequestParam double operand1, @RequestParam double operand2) {
		return calculatorService.substract(operand1, operand2);
	}

	@GetMapping("/multiply")
	public Double multiply(@RequestParam double operand1, @RequestParam double operand2) {
		return calculatorService.multiply(operand1, operand2);
	}

	@GetMapping("/divide")
	public Double divide(@RequestParam double operand1, @RequestParam double operand2) throws ArithmeticException {
		return calculatorService.divide(operand1, operand2);
	}

	@ExceptionHandler(ArithmeticException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError processArithmeticException(ArithmeticException ex, HttpServletRequest request) {
		return new ApiError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}
}
