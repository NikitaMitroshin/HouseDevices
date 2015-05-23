package by.mitroshin.homedev.entity.kitchen.microvawe;

import by.mitroshin.homedev.entity.LogicException;
import by.mitroshin.homedev.entity.Manufacturer;
import by.mitroshin.homedev.entity.Name;
import by.mitroshin.homedev.entity.kitchen.KitchenDevice;

import java.io.IOException;

/**
 * Created by HP M6 on 23.05.2015.
 */
public class Microwave extends KitchenDevice{

    public Microwave(Manufacturer manufacturer, int power, String model, ControlType controlType) throws LogicException, IOException {
        super(manufacturer, power, model, controlType);
        name = Name.MICROWAVE;
    }
}
