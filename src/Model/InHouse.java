package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class InHouse extends Part {

    private SimpleIntegerProperty machineID;

    public InHouse() {


        machineID = new SimpleIntegerProperty();

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

    public String getType(){
        return "InHouse";
    }
}
