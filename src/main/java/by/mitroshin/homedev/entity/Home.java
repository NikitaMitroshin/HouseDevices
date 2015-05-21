package by.mitroshin.homedev.entity;

import by.mitroshin.homedev.log.LogRunner;

import java.util.ArrayList;

/**
 * Created by HP M6 on 21.05.2015.
 */
public class Home {
    private ArrayList<HomeDevice> devices;

    public Home(ArrayList<HomeDevice> devices) {
        LogRunner.LOG.info("Creating object "+getClass().getSimpleName());
        this.devices = devices;
        LogRunner.LOG.info("Object "+getClass().getSimpleName()+" created");
    }

    public ArrayList<HomeDevice> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<HomeDevice> devices) {
        this.devices = devices;
    }

    public void addDevice(HomeDevice device){
        this.devices.add(device);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Home home = (Home) o;

        if (devices != null ? !devices.equals(home.devices) : home.devices != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return devices != null ? devices.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Home{" +
                "devices = " + devices +
                '}';
    }

    public int countTotalPower(){;
        int result = 0;
        for(HomeDevice homeDevice : devices){
            result = result + homeDevice.getPower();
        }
        LogRunner.LOG.info("Total power for "+getClass().getSimpleName()+" is "+result);
        return result;

    }

    public ArrayList<HomeDevice> getDeviceByPower(int startValue, int endValue){
        ArrayList<HomeDevice> result = new ArrayList<HomeDevice>();
        for(HomeDevice homeDevice : devices){
            if(homeDevice.getPower()>startValue && homeDevice.getPower() < endValue){
                result.add(homeDevice);
                LogRunner.LOG.info("Power of "+homeDevice.getClass().getSimpleName()+" "+homeDevice.getManufacturer()+" "
                                    +homeDevice.getModel() + " is between " + startValue + " and "+endValue);
            }
        }
        return result;
    }

    public ArrayList<HomeDevice> getTurnedOnDevices(){
        ArrayList<HomeDevice> result = new ArrayList<HomeDevice>();
        for(HomeDevice homeDevice : devices){
            if(homeDevice.turnedOn){
                result.add(homeDevice);
                LogRunner.LOG.info(homeDevice.getClass().getSimpleName()+" "+homeDevice.getManufacturer()+" "+homeDevice.getModel() +
                                    " is turned ON");
            }
        }
        return result;
    }
}
