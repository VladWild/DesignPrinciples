package businesslogic;

import java.util.List;

public class Result {
    private int count;
    private double avarage;
    private List<Double> list;

    public Result(int count, double avarage, List<Double> list) {
        this.count = count;
        this.avarage = avarage;
        this.list = list;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAvarage() {
        return avarage;
    }

    public void setAvarage(double avarage) {
        this.avarage = avarage;
    }

    public List<Double> getList() {
        return list;
    }

    public void setList(List<Double> list) {
        this.list = list;
    }
}
