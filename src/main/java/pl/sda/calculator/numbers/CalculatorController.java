package pl.sda.calculator.numbers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller //Ta klasa będzie zwracała całe html
public class CalculatorController {

    @Autowired
    private CalcuatorService calcuatorService;
    @Autowired
    private ResultsCache resultsCache;

    //    @RequestMapping(value = "/calculate", method = RequestMethod.GET)  - alternatywna forma zapisu
    @GetMapping("/calculate")
    public String showCalculator(@RequestParam(required = false) String numbers, Model model) {

        List<String> resultList = populateResultList(numbers, model);
        model.addAttribute("resultList", resultList);

        return "calculatorForm"; //nazwa zwracanego html
    }

    private List<String> populateResultList(String numbers, Model model) {
        List<String> resultList;

        if (numbers != null) {
            int result = calcuatorService.calculateNumbers(numbers);
            model.addAttribute("result", result);
            resultList = resultsCache.addAndShowResults(numbers, result);
        } else {
            resultList = resultsCache.getDistinctResultsList();
        }

        return resultList;
    }

}
