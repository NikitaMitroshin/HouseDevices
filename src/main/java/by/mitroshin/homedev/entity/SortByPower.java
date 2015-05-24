package by.mitroshin.homedev.entity;

import java.util.Comparator;

/**
 * Created by HP M6 on 21.05.2015.
 */
public class SortByPower implements Comparator<HomeDevice> {

    @Override
    public int compare(HomeDevice o1, HomeDevice o2) {
        if(o1.getPower() > o2.getPower()) {
            return 1;
        }
        else if(o1.getPower() < o2.getPower()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
