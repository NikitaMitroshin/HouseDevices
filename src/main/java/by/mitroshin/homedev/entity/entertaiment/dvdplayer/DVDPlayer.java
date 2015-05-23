package by.mitroshin.homedev.entity.entertaiment.dvdplayer;

import by.mitroshin.homedev.entity.Manufacturer;
import by.mitroshin.homedev.entity.Name;
import by.mitroshin.homedev.entity.entertaiment.EntertaimentDevice;
import by.mitroshin.homedev.entity.LogicException;

import java.io.IOException;

/**
 * Created by HP M6 on 20.05.2015.
 */
public class DVDPlayer extends EntertaimentDevice {

    public DVDPlayer(Manufacturer manufacturer, int power, String model, Colour colour) throws LogicException, IOException {
        super(manufacturer, power, model, colour);
        name = Name.DVD_PLAYER;
    }

}
