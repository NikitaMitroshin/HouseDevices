package by.mitroshin.homedev.factory;

import by.mitroshin.homedev.entity.*;
import by.mitroshin.homedev.entity.clothes.iron.Iron;
import by.mitroshin.homedev.entity.clothes.iron.SoleType;
import by.mitroshin.homedev.entity.clothes.washer.LoadingType;
import by.mitroshin.homedev.entity.clothes.washer.Washer;
import by.mitroshin.homedev.entity.entertaiment.dvdplayer.Colour;
import by.mitroshin.homedev.entity.entertaiment.dvdplayer.DVDPlayer;
import by.mitroshin.homedev.entity.entertaiment.tvset.DisplayType;
import by.mitroshin.homedev.entity.entertaiment.tvset.TvSet;
import by.mitroshin.homedev.entity.kitchen.cooker.Cooker;
import by.mitroshin.homedev.entity.kitchen.cooker.CooktopType;
import by.mitroshin.homedev.entity.kitchen.microvawe.ControlType;
import by.mitroshin.homedev.entity.kitchen.microvawe.Microwave;


import java.io.IOException;


/**
 * Created by HP M6 on 23.05.2015.
 */
public class HomeDeviceFactory {

    public static HomeDevice createHomeDevie(Name name, Manufacturer manufacturer, int power, String model, Type type) throws IOException, LogicException {
        try {
            switch (name) {
                case TV_SET:
                    return new TvSet(manufacturer, power, model, (DisplayType) type);
                case DVD_PLAYER:
                    return new DVDPlayer(manufacturer, power, model, (Colour) type);
                case MICROWAVE:
                    return new Microwave(manufacturer, power, model, (ControlType) type);
                case COOKER:
                    return new Cooker(manufacturer, power, model, (CooktopType) type);
                case IRON:
                    return new Iron(manufacturer, power, model, (SoleType) type);
                case WASHER:
                    return new Washer(manufacturer, power, model, (LoadingType) type);
                default:
                    throw new LogicException(name + " is incorrect, it must be name of HomeDevice");
            }
        }catch (ClassCastException e){
            throw new LogicException("type is incorrect!", e);
        }
        }
    }






