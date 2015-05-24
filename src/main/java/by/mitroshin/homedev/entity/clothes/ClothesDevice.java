package by.mitroshin.homedev.entity.clothes;

import by.mitroshin.homedev.entity.*;

import java.io.IOException;

/**
 * Created by HP M6 on 20.05.2015.
 */
public class ClothesDevice extends HomeDevice {

    public ClothesDevice(Manufacturer manufacturer, int power, String model, Type type) throws LogicException, IOException {
        super(manufacturer, power, model, type);
        appointment = Appointment.CLOTHES;
    }


}
