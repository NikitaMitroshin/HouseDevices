package by.mitroshin.homedev.entity.clothes.iron;

import by.mitroshin.homedev.entity.Manufacturer;
import by.mitroshin.homedev.entity.clothes.ClothesDevice;
import by.mitroshin.homedev.exception.LogicException;

/**
 * Created by HP M6 on 20.05.2015.
 */
public class Iron extends ClothesDevice {
    private SoleType soleType;

    public Iron(Manufacturer manufacturer, int power, String model, SoleType soleType) throws LogicException {
        super(manufacturer, power, model);
        this.soleType = soleType;
    }

    public SoleType getSoleType() {
        return soleType;
    }

    public void setSoleType(SoleType soleType) {
        this.soleType = soleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Iron iron = (Iron) o;

        if (soleType != iron.soleType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (soleType != null ? soleType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", soleType = "+soleType + "}";
    }
}
