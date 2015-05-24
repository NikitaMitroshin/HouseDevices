package by.mitroshin.homedev.entity.clothes.washer;

import by.mitroshin.homedev.entity.Manufacturer;
import by.mitroshin.homedev.entity.Name;
import by.mitroshin.homedev.entity.clothes.ClothesDevice;
import by.mitroshin.homedev.entity.LogicException;

import java.io.IOException;

/**
 * Created by HP M6 on 20.05.2015.
 */
public class Washer extends ClothesDevice {

    public Washer(Manufacturer manufacturer, int power, String model, LoadingType loadingType) throws LogicException, IOException {
        super(manufacturer, power, model, loadingType);
        name = Name.WASHER;
    }

}
