package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class InHouse extends Part {

    private SimpleIntegerProperty machineID;

    public InHouse(SimpleStringProperty name, SimpleDoubleProperty price, SimpleIntegerProperty inStock, SimpleIntegerProperty min, SimpleIntegerProperty max, SimpleIntegerProperty machineID) {
        super(name, price, inStock, min, max);

        machineID = new SimpleIntegerProperty();
        this.machineID = machineID;
    }

    public int getMachineID() {
        return machineID.get();
    }

    public SimpleIntegerProperty machineIDProperty() {
        return machineID;
    }

    public void setMachineID(int machineID) {
        this.machineID.set(machineID);
    }
}
