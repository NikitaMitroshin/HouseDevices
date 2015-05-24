package by.mitroshin.homedev.run;

import by.mitroshin.homedev.action.DeviceAction;
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
import by.mitroshin.homedev.factory.HomeDeviceFactory;
import by.mitroshin.homedev.report.Reporter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by HP M6 on 21.05.2015.
 */
public class HomeRunner {
    public final static Logger LOG = Logger.getLogger(HomeRunner.class);

    static{
        new DOMConfigurator().doConfigure("config/log4j.xml", LogManager.getLoggerRepository());
        try {
            Reporter.INSTANCE.printReport("\nPROGRAM STARTED\n");
        } catch (IOException e) {
            LOG.error("Logic exception!!!", e);
        }
    }

    public static void main(String[] args) {
        try {
            ArrayList<HomeDevice> devices = new ArrayList<HomeDevice>();
            Iron iron = (Iron) HomeDeviceFactory.createHomeDevie(Name.IRON, Manufacturer.BOSH, 200, "asd12", SoleType.ALUMNIUM);
            Washer washer = (Washer) HomeDeviceFactory.createHomeDevie(Name.WASHER, Manufacturer.PHILIPS, 700, "QS584", LoadingType.FRONT);
            TvSet tvSet = (TvSet) HomeDeviceFactory.createHomeDevie(Name.TV_SET, Manufacturer.SONY, 500, "ls9900", DisplayType.PLASMA);
            DVDPlayer dvdPlayer = (DVDPlayer) HomeDeviceFactory.createHomeDevie(Name.DVD_PLAYER, Manufacturer.PANASONIC, 150, "doo882", Colour.BLACK);
            Cooker cooker = (Cooker) HomeDeviceFactory.createHomeDevie(Name.COOKER, Manufacturer.PHILIPS, 800, "cook9000", CooktopType.ELECTRIC);

            washer.turnOn();
            tvSet.turnOn();

            devices.add(iron);
            devices.add(washer);
            devices.add(tvSet);
            devices.add(dvdPlayer);
            devices.add(cooker);

            Home home = new Home("Party House", devices);

            home.sort(new SortByPower());

            DeviceAction.getTurnedOnDevices(home);
            DeviceAction.getDeviceByPower(home, 123, 250);
            DeviceAction.countTotalPower(home);
            DeviceAction.isHomeContainsDevice(home, washer);
            DeviceAction.getDeviceByParameters(home,Name.IRON, Manufacturer.SONY, 123, "sasd12", SoleType.ALUMNIUM);
            DeviceAction.getDevicesByManufacturer(home, Manufacturer.BOSH);

        } catch (LogicException e) {
            LOG.error("Logic exception!!!", e);
        } catch (IOException e) {
            LOG.error("Logic exception!!!", e);
        }
    }
}
