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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP M6 on 23.05.2015.
 */
public class HomeDeviceFactoryVariant {
    public static final ArrayList<AbstractHomeDevice> HOME_DEVICES = new ArrayList<AbstractHomeDevice>();

    private HomeDeviceFactoryVariant(){
    }

    public static Iron createIron(Manufacturer manufacturer, int power, String model, SoleType soletype) throws IOException, LogicException {
        Iron result = new Iron(manufacturer, power, model, soletype);
        HOME_DEVICES.add(result);
        return result;
    }

    public static Washer createWasher(Manufacturer manufacturer, int power, String model, LoadingType loadingType ) throws IOException, LogicException {
        Washer result = new Washer(manufacturer, power, model, loadingType);
        HOME_DEVICES.add(result);
        return result;
    }

    public static DVDPlayer createDVDPlayer(Manufacturer manufacturer, int power, String model, Colour colour) throws IOException, LogicException {
        DVDPlayer result = new DVDPlayer(manufacturer, power, model, colour);
        HOME_DEVICES.add(result);
        return result;
    }

    public static TvSet createTvSet(Manufacturer manufacturer, int power, String model, DisplayType displayType) throws IOException, LogicException {
        TvSet result = new TvSet(manufacturer, power, model, displayType );
        HOME_DEVICES.add(result);
        return result;
    }

    public static Cooker createCooker(Manufacturer manufacturer, int power, String model, CooktopType cooktopType) throws IOException, LogicException {
        Cooker result = new Cooker(manufacturer, power, model, cooktopType);
        HOME_DEVICES.add(result);
        return result;
    }

    public static Microwave createMicrowave(Manufacturer manufacturer, int power, String model, ControlType controlType) throws IOException, LogicException {
        Microwave result = new Microwave(manufacturer, power, model, controlType);
        HOME_DEVICES.add(result);
        return result;
    }



}
