package repository;

import model.Center;

import java.util.ArrayList;
import java.util.List;

public class BaseCenterRepository implements CenterRepository{

    private static List<Center> centerList = new ArrayList<>();

    public Center getCenter(String centerName) {
        for(Center center: centerList) {
            if (center.getName().equals(centerName)) {
                return center;
            }
        }
        return null;
    }

    public void addCenter(Center center) {
        centerList.addLast(center);
    }

    public List<Center> getCenterList() {
        return centerList;
    }
}
