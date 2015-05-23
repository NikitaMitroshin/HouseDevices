package by.mitroshin.homedev.entity.entertaiment.tvset;

import by.mitroshin.homedev.entity.Manufacturer;
import by.mitroshin.homedev.entity.Name;
import by.mitroshin.homedev.entity.Type;
import by.mitroshin.homedev.entity.entertaiment.EntertaimentDevice;
import by.mitroshin.homedev.entity.LogicException;

import java.io.IOException;

/**
 * Created by HP M6 on 20.05.2015.
 */
public class TvSet extends EntertaimentDevice {



    public TvSet(Manufacturer manufacturer, int power, String model, DisplayType displayType) throws LogicException, IOException {
        super(manufacturer, power, model, displayType);
        name = Name.TV_SET;
    }





}
