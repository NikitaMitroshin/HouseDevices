package by.mitroshin.homedev.entity.entertaiment;

import by.mitroshin.homedev.entity.Appointment;
import by.mitroshin.homedev.entity.HomeDevice;
import by.mitroshin.homedev.entity.Manufacturer;
import by.mitroshin.homedev.exception.LogicException;

/**
 * Created by HP M6 on 20.05.2015.
 */
public class EntertaimentDevice extends HomeDevice {

    public EntertaimentDevice(Manufacturer manufacturer, int power, String model) throws LogicException {
        super(manufacturer, power, model);
        appointment = Appointment.ENTERTAIMENT;
    }

}
