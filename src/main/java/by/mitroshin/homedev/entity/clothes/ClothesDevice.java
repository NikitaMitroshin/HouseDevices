package by.mitroshin.homedev.entity.clothes;

import by.mitroshin.homedev.entity.Appointment;
import by.mitroshin.homedev.entity.HomeDevice;
import by.mitroshin.homedev.entity.Manufacturer;
import by.mitroshin.homedev.exception.LogicException;

/**
 * Created by HP M6 on 20.05.2015.
 */
public class ClothesDevice extends HomeDevice {

    public ClothesDevice(Manufacturer manufacturer, int power, String model) throws LogicException {
        super(manufacturer, power, model);
        appointment = Appointment.CLOTHES;
    }


}
