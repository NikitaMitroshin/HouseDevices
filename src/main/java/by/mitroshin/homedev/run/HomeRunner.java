package by.mitroshin.homedev.run;

import by.mitroshin.homedev.entity.Home;
import by.mitroshin.homedev.entity.HomeDevice;
import by.mitroshin.homedev.entity.Manufacturer;
import by.mitroshin.homedev.entity.SortByPower;
import by.mitroshin.homedev.entity.clothes.iron.Iron;
import by.mitroshin.homedev.entity.clothes.iron.SoleType;
import by.mitroshin.homedev.entity.clothes.washer.LoadingType;
import by.mitroshin.homedev.entity.clothes.washer.Washer;
import by.mitroshin.homedev.entity.entertaiment.dvdplayer.Colour;
import by.mitroshin.homedev.entity.entertaiment.dvdplayer.DVDPlayer;
import by.mitroshin.homedev.entity.entertaiment.tvset.DisplayType;
import by.mitroshin.homedev.entity.entertaiment.tvset.TvSet;
import by.mitroshin.homedev.exception.LogicException;
import by.mitroshin.homedev.log.LogRunner;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by HP M6 on 21.05.2015.
 */
public class HomeRunner {
    public static void main(String[] args) {
        try {
            Iron iron = new Iron(Manufacturer.BOSH, 200, "AVC12", SoleType.ALUMNIUM);
            Washer washer = new Washer(Manufacturer.PHILIPS, 500, "qe2455", LoadingType.FRONT);
            DVDPlayer dvdPlayer = new DVDPlayer(Manufacturer.PANASONIC, 250, "as-213", Colour.BLACK);
            TvSet tvSet = new TvSet(Manufacturer.SONY, 400, "en15", DisplayType.LCD );
            washer.turnOn();
            tvSet.turnOn();

            ArrayList<HomeDevice> devices = new ArrayList<HomeDevice>();
            devices.add(iron);
            devices.add(washer);
            devices.add(dvdPlayer);
            devices.add(tvSet);
            Home home = new Home(devices);

            Collections.sort(home.getDevices(), new SortByPower());

            home.countTotalPower();
            home.getDeviceByPower(120, 260);
            home.getTurnedOnDevices();

        } catch (LogicException e) {
            LogRunner.LOG.error("Logic exception!!!", e);
        }
    }
}
