package by.mitroshin.homedev.entity.kitchen;

import by.mitroshin.homedev.entity.*;

import java.io.IOException;

/**
 * Created by HP M6 on 22.05.2015.
 */
public abstract class KitchenDevice extends HomeDevice {

    public KitchenDevice(Manufacturer manufacturer, int power, String model, Type type) throws LogicException, IOException {
        super(manufacturer, power, model, type);
        appointment = Appointment.KITCHEN;
    }
}
