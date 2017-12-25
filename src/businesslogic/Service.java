package businesslogic;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Double.NaN;

public class Service {

    //collection filtering
    private List<Double> filter(List<Double> list, double hilimit, double lowlimit){
        List<Double> filteredData = new LinkedList<>();
        for(Double element : list){
            if((element >= lowlimit) && (element <= hilimit)){
                filteredData.add(element);
            }
        }
        return filteredData;
    }

    //get avarage value
    private double getAvarage(List<Double> filteredData){
        double sum = 0;
        for(Double element : filteredData){
            sum += element;
        }
        return sum / filteredData.size();
    }

    //avarage more count or not
    private boolean isAvarageMoreThenCount(int count, double avarage){
        return avarage > count;
    }

    //replace positive elements by zero
    private List<Double> resetPositiveValue(List<Double> result){
        List<Double> list = new LinkedList<>();
        for(Double element : result){
            if (element > 0) {
                list.add(new Double(0));
            } else {
                list.add(element);
            }
        }
        return list;
    }

    //return DTO Result
    public Result startProcessingData(List<Double> list, double hilimit, double lowlimit){
        List<Double> result = list;
        List<Double> filteredData = filter(result, hilimit, lowlimit);

        double avarage = NaN;

        if (filteredData.size() > 0) {
            avarage = getAvarage(filteredData);
            if (isAvarageMoreThenCount(filteredData.size(), avarage)){
               result = resetPositiveValue(result);
            }
        }

        return new Result(filteredData.size(), avarage, result);
    }
}
