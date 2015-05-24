package by.mitroshin.homedev.entity;


import by.mitroshin.homedev.report.Reporter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by HP M6 on 21.05.2015.
 */
public class Home {
    private List<HomeDevice> devices;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Home(String name, List<HomeDevice> devices) throws IOException, LogicException {
        Reporter.INSTANCE.printReport("Creating object " + getClass().getSimpleName());
        if(name != null && name.length() > 3){
            this.name = name;
        }else {
            throw new LogicException(name + " is incorrect, name length be more than 3");
        }
        this.devices = devices;
        Reporter.INSTANCE.printReport("Object " + getClass().getSimpleName() + " created");
    }

    public List<HomeDevice> getDevices() {
        return Collections.unmodifiableList(devices);
    }

    public void addDevice(HomeDevice device){
        this.devices.add(device);
    }

    public void sort(Comparator<? super HomeDevice> c) throws IOException {
        devices.sort(c);
        Reporter.INSTANCE.printReport("Devices was sorted by "+c.getClass().getSimpleName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Home home = (Home) o;

        if (devices != null ? !devices.equals(home.devices) : home.devices != null) return false;
        if (name != null ? !name.equals(home.name) : home.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = devices != null ? devices.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{ name = " + name + ", devices = \n" + devices +
                "}";
    }



}
