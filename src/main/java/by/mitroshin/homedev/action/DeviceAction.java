package by.mitroshin.homedev.action;

import by.mitroshin.homedev.entity.*;
import by.mitroshin.homedev.report.Reporter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP M6 on 23.05.2015.
 */
public class DeviceAction {

    //returns total power of all devices in Home
    public static int countTotalPower(Home home) throws IOException {;
        int result = 0;
        for(HomeDevice homeDevice : home.getDevices()){
            result = result + homeDevice.getPower();
        }
        Reporter.INSTANCE.printReport("Total power for all devices in home: " + home.getName() + " is " + result);
        return result;
    }

    //returns collection of devices which power match the specified range
    public static ArrayList<HomeDevice> getDeviceByPower(Home home, int startValue, int endValue) throws IOException {
        ArrayList<HomeDevice> result = new ArrayList<HomeDevice>();
        for(HomeDevice homeDevice : home.getDevices()){
            if(homeDevice.getPower() > startValue && homeDevice.getPower() < endValue){
                result.add(homeDevice);
                Reporter.INSTANCE.printReport("Power of " + homeDevice.getName() + " " + homeDevice.getManufacturer()
                        + " " + homeDevice.getModel() + " is between " + startValue + " and " + endValue);
            }
        }
        return result;
    }

    //returns collection of turnedON devices
    public static ArrayList<HomeDevice> getTurnedOnDevices(Home home) throws IOException {
        ArrayList<HomeDevice> result = new ArrayList<HomeDevice>();
        for(HomeDevice homeDevice : home.getDevices()){
            if(homeDevice.isTurnedOn()){
                result.add(homeDevice);
                Reporter.INSTANCE.printReport(homeDevice.getName() + " " + homeDevice.getManufacturer() + " "
                        + homeDevice.getModel() + " is turned ON");
            }
        }
        return result;
    }

    //returns device that match the specified manufacturer
    public static ArrayList<HomeDevice> getDevicesByManufacturer(Home home,  Manufacturer manufacturer) throws IOException, LogicException {
        ArrayList<HomeDevice> result = new ArrayList<HomeDevice>();
        for(HomeDevice homeDevice : home.getDevices()){
           if(homeDevice.getManufacturer() == manufacturer){
               result.add(homeDevice);
               Reporter.INSTANCE.printReport(homeDevice.getName() + " " + homeDevice.getModel()
                       + " manufacturer is "+manufacturer);
           }
        }
        return result;
    }

    //returns device that match the specified parameters
    public static HomeDevice getDeviceByParameters(Home home, Name name, Manufacturer manufacturer, int power, String model, Type type) throws IOException, LogicException {
        for(HomeDevice homeDevice : home.getDevices()){
            if(homeDevice.getName() == name && homeDevice.getManufacturer() == manufacturer && homeDevice.getPower() == power
                    && homeDevice.getModel().equals(model) && homeDevice.getType() == type){
                        Reporter.INSTANCE.printReport(homeDevice + " matches specified parameters");
                        return homeDevice;
            }
        }
        return null;
    }

    //checks if home have device
    public static boolean isHomeContainsDevice(Home home, HomeDevice device) throws IOException {
        boolean result = false;
        for(HomeDevice homeDevice : home.getDevices()){
            if(homeDevice.equals(device)){
                result = true;
                break;
            }
        }
        Reporter.INSTANCE.printReport(home.getName() + " have " + device + " ? " + result);
        return result;
    }

}
