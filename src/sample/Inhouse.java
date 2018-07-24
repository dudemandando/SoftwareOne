package sample;

public class Inhouse extends Product {

    private int machineID;

    public Inhouse(int productID, String name, double price, int inStock, int min, int max, int machineID) {
        super(productID, name, price, inStock, min, max);
        this.machineID = machineID;
    }

    public int getMachineID() {
        return machineID;
    }

    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }
}
