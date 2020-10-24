package pl.sda.calculator.numbers;

import org.springframework.stereotype.Service;

@Service
public class CalcuatorService {

    public int calculateNumbers(String numbers) {

        String[] numbersMatrix = numbers.strip().split("\\+");
        int firstNumber = Integer.parseInt(numbersMatrix[0]);
        int secondNumber = Integer.parseInt(numbersMatrix[1]);
        return firstNumber + secondNumber;
    }

}
