package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class OutSourced extends Part {

    private SimpleStringProperty companyName;

    public OutSourced(SimpleStringProperty name, SimpleDoubleProperty price, SimpleIntegerProperty inStock, SimpleIntegerProperty min, SimpleIntegerProperty max, SimpleStringProperty companyName) {
        super(name, price, inStock, min, max);

        companyName = new SimpleStringProperty();
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName.get();
    }

    public SimpleStringProperty companyNameProperty() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName.set(companyName);
    }
}
