package Model;

public class OutSourced extends Part {

    private String companyName;

    public OutSourced(String name, double price, int inStock, int min, int max, String companyName) {
        super(name, price, inStock, min, max);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
