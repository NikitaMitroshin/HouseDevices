package by.mitroshin.homedev.entity.clothes.iron;

import by.mitroshin.homedev.entity.Manufacturer;
import by.mitroshin.homedev.entity.Name;
import by.mitroshin.homedev.entity.clothes.ClothesDevice;
import by.mitroshin.homedev.entity.LogicException;

import java.io.IOException;

/**
 * Created by HP M6 on 20.05.2015.
 */
public class Iron extends ClothesDevice {


    public Iron(Manufacturer manufacturer, int power, String model, SoleType soleType) throws LogicException, IOException {
        super(manufacturer, power, model, soleType);
        name = Name.IRON;
    }


}
