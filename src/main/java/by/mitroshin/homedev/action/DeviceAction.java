package by.mitroshin.homedev.action;

import by.mitroshin.homedev.entity.AbstractHomeDevice;
import by.mitroshin.homedev.entity.Home;
import by.mitroshin.homedev.report.Reporter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HP M6 on 23.05.2015.
 */
public class DeviceAction {

    public static int countTotalPower(Home home) throws IOException {;
        int result = 0;
        for(AbstractHomeDevice homeDevice : home.getDevices()){
            result = result + homeDevice.getPower();
        }
        Reporter.REPORTER.printReport("Total power for all devices in home: " + home.getName() + " is " + result);
        return result;

    }

    public static ArrayList<AbstractHomeDevice> getDeviceByPower(Home home, int startValue, int endValue) throws IOException {
        ArrayList<AbstractHomeDevice> result = new ArrayList<AbstractHomeDevice>();
        for(AbstractHomeDevice homeDevice : home.getDevices()){
            if(homeDevice.getPower() > startValue && homeDevice.getPower() < endValue){
                result.add(homeDevice);
                Reporter.REPORTER.printReport("Power of " + homeDevice.getName() + " " + homeDevice.getManufacturer()
                        + " " + homeDevice.getModel() + " is between " + startValue + " and " + endValue);
            }
        }
        return result;
    }

    public static ArrayList<AbstractHomeDevice> getTurnedOnDevices(Home home) throws IOException {
        ArrayList<AbstractHomeDevice> result = new ArrayList<AbstractHomeDevice>();
        for(AbstractHomeDevice homeDevice : home.getDevices()){
            if(homeDevice.isTurnedOn()){
                result.add(homeDevice);
                Reporter.REPORTER.printReport(homeDevice.getName() + " " + homeDevice.getManufacturer() + " "
                        + homeDevice.getModel() + " is turned ON");
            }
        }
        return result;
    }

}
