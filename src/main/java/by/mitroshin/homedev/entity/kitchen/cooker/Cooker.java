package by.mitroshin.homedev.entity.kitchen.cooker;

import by.mitroshin.homedev.entity.LogicException;
import by.mitroshin.homedev.entity.Manufacturer;
import by.mitroshin.homedev.entity.kitchen.KitchenDevice;

import java.io.IOException;

/**
 * Created by HP M6 on 23.05.2015.
 */
public class Cooker extends KitchenDevice {
    public Cooker(Manufacturer manufacturer, int power, String model, CooktopType cooktopType) throws LogicException, IOException {
        super(manufacturer, power, model, cooktopType);
    }
}
