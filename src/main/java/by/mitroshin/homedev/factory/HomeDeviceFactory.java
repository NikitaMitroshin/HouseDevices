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
  //  public static final ArrayList<AbstractHomeDevice> HOME_DEVICES = new ArrayList<AbstractHomeDevice>();

    private HomeDeviceFactory(){
    }

    public static AbstractHomeDevice createHomeDevieFromFactory(Appointment appointment, Name name, Manufacturer manufacturer, int power, String model, Type type) throws IOException, LogicException {
        switch (appointment){
            case ENTERTAIMENT:
                switch (name){
                    case TV_SET: return new TvSet(manufacturer, power, model, (DisplayType) type); break;
                    case DVD_PLAYER: return new DVDPlayer(manufacturer, power, model, (Colour) type); break;
                    default: throw new LogicException(name+" is incorrect, it must be name of ENTERTAIMENT device");
                }
                break;
            case KITCHEN:
                switch (name){
                    case MICROWAVE: return new Microwave(manufacturer, power, model, (ControlType) type); break;
                    case COOKER: return new Cooker(manufacturer, power, model, (CooktopType) type); break;
                    default: throw new LogicException(name+" is incorrect, it must be name of KITCHEN device");
                }
                break;
            case CLOTHES:
                switch (name){
                    case IRON: return new Iron(manufacturer, power, model, (SoleType) type); break;
                    case WASHER: return new Washer(manufacturer, power, model, (LoadingType) type); break;
                    default: throw new LogicException(name+" is incorrect, it must be name of CLOTHES device");
                }
                break;
            default: throw new LogicException(appointment+" is incorrect");
        }
    }





}
