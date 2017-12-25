package data;

import managers.DataManager;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PropertiesData  implements DataSource{
    DataManager manager;

    public PropertiesData(){
        manager = new DataManager();
    }

    @Override
    public double getHilimit() {
        return Double.valueOf(manager.getHiLimit());
    }

    @Override
    public double getLowlimit() {
        return Double.valueOf(manager.getLowlimit());
    }

    @Override
    public List<Double> getValue() {
        List<Double> list = new LinkedList<>();
        String[] array = manager.getElements();
        for (String elem:array) {
            list.add(new Double(Double.valueOf(elem)));
        }
        return list;
    }
}
