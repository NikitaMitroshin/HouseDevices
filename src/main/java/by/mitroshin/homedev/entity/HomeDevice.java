package by.mitroshin.homedev.entity;


import by.mitroshin.homedev.report.Reporter;

import java.io.IOException;

/**
 * Created by HP M6 on 20.05.2015.
 */
public abstract class HomeDevice {
        protected Manufacturer manufacturer;
        protected Name name;
        protected int power;
        protected String model;
        protected boolean turnedOn;
        protected Appointment appointment;
        protected Type type;

        public boolean isTurnedOn() {
                return turnedOn;
        }

        public Type getType() {
                return type;
        }

        public void setType(Type type) {
                this.type = type;
        }

        public Name getName() {
                return name;
        }

        public final void turnOn(){
                turnedOn = true;
        }

        public final void turnOff(){
                turnedOn = false;
        }

        public Manufacturer getManufacturer() {
                return manufacturer;
        }

        public void setManufacturer(Manufacturer manufacturer) {
                this.manufacturer = manufacturer;
        }

        public int getPower() {
                return power;
        }

        public void setPower(int power) {
                this.power = power;
        }

        public String getModel() {
                return model;
        }

        public void setModel(String model) {
                this.model = model;
        }

        public Appointment getAppointment() {
                return appointment;
        }

        public void setAppointment(Appointment appointment) {
                this.appointment = appointment;
        }

        public HomeDevice(Manufacturer manufacturer, int power, String model, Type type) throws LogicException, IOException {
                Reporter.INSTANCE.printReport("Creating object " + getClass().getSimpleName());
                if(manufacturer != null) {
                        this.manufacturer = manufacturer;
                }else {
                        throw new LogicException(manufacturer + " is incorrect, manufacturer cant be null");
                }
                if (power > 0) {
                        this.power = power;
                } else {
                        throw new LogicException(power + " is incorrect, power must be more than 0");
                }
                if(model != null && model.length() > 3){
                        this.model = model;
                }else {
                        throw new LogicException(model + " is incorrect, model length be more than 3");
                }
                if(type != null){
                        this.type = type;
                }else {
                        throw new LogicException(type + " is incorrect, type cant be null");
                }
                this.turnedOn = false;
                Reporter.INSTANCE.printReport("Object " + getClass().getSimpleName() + " " + getModel() + " created");
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                HomeDevice that = (HomeDevice) o;

                if (power != that.power) return false;
                if (turnedOn != that.turnedOn) return false;
                if (appointment != that.appointment) return false;
                if (manufacturer != that.manufacturer) return false;
                if (model != null ? !model.equals(that.model) : that.model != null) return false;
                if (name != that.name) return false;
                if (type != null ? !type.equals(that.type) : that.type != null) return false;

                return true;
        }

        @Override
        public int hashCode() {
                int result = manufacturer != null ? manufacturer.hashCode() : 0;
                result = 31 * result + (name != null ? name.hashCode() : 0);
                result = 31 * result + power;
                result = 31 * result + (model != null ? model.hashCode() : 0);
                result = 31 * result + (turnedOn ? 1 : 0);
                result = 31 * result + (appointment != null ? appointment.hashCode() : 0);
                result = 31 * result + (type != null ? type.hashCode() : 0);
                return result;
        }

        @Override
        public String toString() {
                return "\n"+getClass().getSimpleName()+"{" +
                        "manufacturer = " + manufacturer +
                        ", name = " + name +
                        ", power = " + power +
                        ", model = " + model +
                        ", turnedOn = " + turnedOn +
                        ", appointment = "+ appointment + ", " +
                        getType().getClass().getSimpleName() + " = " + type +
                        "}";
        }
}
