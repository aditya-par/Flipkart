package util;

import model.Center;
import model.Location;

import java.util.List;

public class CenterUtil {

    public static Center createCenter(String name, String city, List<String> daysClosedList, Integer maxSlots) {
        return new Center(name, city, daysClosedList, maxSlots);
    }

}
