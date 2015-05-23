package by.mitroshin.homedev.run;

import by.mitroshin.homedev.action.DeviceAction;
import by.mitroshin.homedev.entity.*;
import by.mitroshin.homedev.entity.clothes.iron.SoleType;
import by.mitroshin.homedev.entity.clothes.washer.LoadingType;
import by.mitroshin.homedev.entity.entertaiment.dvdplayer.Colour;
import by.mitroshin.homedev.entity.entertaiment.tvset.DisplayType;
import by.mitroshin.homedev.entity.kitchen.cooker.CooktopType;
import by.mitroshin.homedev.entity.kitchen.microvawe.ControlType;
import by.mitroshin.homedev.factory.HomeDeviceFactoryVariant;
import by.mitroshin.homedev.report.Reporter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


import java.io.IOException;


/**
 * Created by HP M6 on 21.05.2015.
 */
public class HomeRunner {
    public final static Logger LOG = Logger.getLogger(HomeRunner.class);

    static{
        new DOMConfigurator().doConfigure("config/log4j.xml", LogManager.getLoggerRepository());
        try {
            Reporter.REPORTER.printReport("\nPROGRAM STARTED\n");
        } catch (IOException e) {
            LOG.error("Logic exception!!!", e);
        }
    }

    public static void main(String[] args) {
        try {
            HomeDeviceFactoryVariant.createIron(Manufacturer.BOSH, 200, "asd12", SoleType.ALUMNIUM);
            HomeDeviceFactoryVariant.createCooker(Manufacturer.SONY, 500, "VO23", CooktopType.ELECTRIC);
            HomeDeviceFactoryVariant.createDVDPlayer(Manufacturer.PANASONIC, 100, "AIO42", Colour.BLACK);
            HomeDeviceFactoryVariant.createMicrowave(Manufacturer.PHILIPS, 600, "mi90", ControlType.AUTO);
            HomeDeviceFactoryVariant.createTvSet(Manufacturer.SONY, 600, "tvb90", DisplayType.LCD);
            HomeDeviceFactoryVariant.createWasher(Manufacturer.BOSH, 600, "tvb90", LoadingType.FRONT);
            Home home = new Home("Party House", HomeDeviceFactoryVariant.HOME_DEVICES);
            DeviceAction.countTotalPower(home);
            DeviceAction.getDeviceByPower(home, 120, 230);
            DeviceAction.getTurnedOnDevices(home);
        } catch (LogicException e) {
            LOG.error("Logic exception!!!", e);
        } catch (IOException e) {
            LOG.error("Logic exception!!!", e);
        }
    }
}
