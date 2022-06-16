package calculator;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculatorService {

    public double add(double operand1, double operand2) {
        return BigDecimal.valueOf(operand1).add(BigDecimal.valueOf(operand2)).doubleValue();
    }

    public double substract(double operand1, double operand2) {
        return BigDecimal.valueOf(operand1).subtract(BigDecimal.valueOf(operand2)).doubleValue();
    }

    public double multiply(double operand1, double operand2) {
        return BigDecimal.valueOf(operand1).multiply(BigDecimal.valueOf(operand2)).doubleValue();
    }

    public double divide(double operand1, double operand2) {
        if(operand2 == 0) {
            throw new ArithmeticException("Division by zero");
        }

        return BigDecimal.valueOf(operand1).setScale(10)
                .divide(BigDecimal.valueOf(operand2), RoundingMode.FLOOR)
                .doubleValue();
    }
}
