package by.mitroshin.homedev.entity;

import by.mitroshin.homedev.exception.LogicException;
import by.mitroshin.homedev.log.LogRunner;

/**
 * Created by HP M6 on 20.05.2015.
 */
public abstract class HomeDevice {
        protected Manufacturer manufacturer;
        protected int power;
        protected String model;
        protected boolean turnedOn;
        protected Appointment appointment;

        public void turnOn(){
                turnedOn = true;
        }

        public void turnOff(){
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

        public HomeDevice(Manufacturer manufacturer, int power, String model) throws LogicException {
                LogRunner.LOG.info("Creating object "+getClass().getSimpleName());
                this.manufacturer = manufacturer;
                if(power>0){
                        this.power = power;
                }else {
                        throw new LogicException("power must be more than 0");
                }
                this.model = model;
                this.turnedOn = false;
                LogRunner.LOG.info("Object "+getClass().getSimpleName()+" created");
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                HomeDevice that = (HomeDevice) o;

                if (power != that.power) return false;

                if (appointment != that.appointment) return false;
                if (manufacturer != that.manufacturer) return false;
                if (model != null ? !model.equals(that.model) : that.model != null) return false;

                return true;
        }

        @Override
        public int hashCode() {
                int result = manufacturer != null ? manufacturer.hashCode() : 0;
                result = 31 * result + power;
                result = 31 * result + (model != null ? model.hashCode() : 0);
                result = 31 * result + (turnedOn ? 1 : 0);
                result = 31 * result + (appointment != null ? appointment.hashCode() : 0);
                return result;
        }

        @Override
        public String toString() {
                return getClass().getSimpleName() +
                        "{manufacturer = " + manufacturer +
                        ", power = " + power +
                        ", model = " + model +
                        ", turnedOn = " + turnedOn +
                        ", appointment = " + appointment;
        }
}
