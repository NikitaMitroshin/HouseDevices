package by.mitroshin.homedev.entity.entertaiment.tvset;

import by.mitroshin.homedev.entity.Manufacturer;
import by.mitroshin.homedev.entity.entertaiment.EntertaimentDevice;
import by.mitroshin.homedev.exception.LogicException;

/**
 * Created by HP M6 on 20.05.2015.
 */
public class TvSet extends EntertaimentDevice {

    private DisplayType displayType;

    public TvSet(Manufacturer manufacturer, int power, String model, DisplayType displayType) throws LogicException {
        super(manufacturer, power, model);
        this.displayType = displayType;
    }

    public DisplayType getDisplayType() {
        return displayType;
    }

    public void setDisplayType(DisplayType displayType) {
        this.displayType = displayType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TvSet tvSet = (TvSet) o;

        if (displayType != tvSet.displayType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (displayType != null ? displayType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", displayType = "+displayType + "}";
    }
}
