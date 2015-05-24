package by.mitroshin.homedev.entity.entertaiment;

import by.mitroshin.homedev.entity.*;

import java.io.IOException;

/**
 * Created by HP M6 on 20.05.2015.
 */
public class EntertaimentDevice extends HomeDevice {

    public EntertaimentDevice(Manufacturer manufacturer, int power, String model, Type type) throws LogicException, IOException {
        super(manufacturer, power, model, type);
        appointment = Appointment.ENTERTAIMENT;
    }

}
