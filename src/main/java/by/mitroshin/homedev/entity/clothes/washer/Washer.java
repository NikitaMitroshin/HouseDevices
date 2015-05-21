package by.mitroshin.homedev.entity.clothes.washer;

import by.mitroshin.homedev.entity.Manufacturer;
import by.mitroshin.homedev.entity.clothes.ClothesDevice;
import by.mitroshin.homedev.exception.LogicException;

/**
 * Created by HP M6 on 20.05.2015.
 */
public class Washer extends ClothesDevice {

    private LoadingType loadingType;

    public Washer(Manufacturer manufacturer, int power, String model, LoadingType loadingType) throws LogicException {
        super(manufacturer, power, model);
        this.loadingType = loadingType;
    }

    public LoadingType getLoadingType() {
        return loadingType;
    }

    public void setLoadingType(LoadingType loadingType) {
        this.loadingType = loadingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Washer washer = (Washer) o;

        if (loadingType != washer.loadingType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (loadingType != null ? loadingType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", loadingType = "+loadingType + "}";
    }
}
