package pl.sda.calculator.numbers;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResultsCache {

    private List<String> resultList = new ArrayList<>() {
    };

    List<String> addAndShowResults(String number, int result){
        addResult(number,result);
        return getDistinctResultsList();
    }

    List<String> getDistinctResultsList() {
        return resultList
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private void addResult(String numbers, int result) {
        resultList.add(numbers + "=" + result);
    }

    private List<String> getAllResultsList() {
        return resultList;
    }

}
