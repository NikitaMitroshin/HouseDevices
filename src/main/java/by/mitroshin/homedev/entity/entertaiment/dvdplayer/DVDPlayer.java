package by.mitroshin.homedev.entity.entertaiment.dvdplayer;

import by.mitroshin.homedev.entity.Manufacturer;
import by.mitroshin.homedev.entity.entertaiment.EntertaimentDevice;
import by.mitroshin.homedev.exception.LogicException;

/**
 * Created by HP M6 on 20.05.2015.
 */
public class DVDPlayer extends EntertaimentDevice {

    private Colour colour;

    public DVDPlayer(Manufacturer manufacturer, int power, String model, Colour colour) throws LogicException {
        super(manufacturer, power, model);
        this.colour = colour;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DVDPlayer dvdPlayer = (DVDPlayer) o;

        if (colour != dvdPlayer.colour) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (colour != null ? colour.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", colour = "+colour + "}";
    }
}
