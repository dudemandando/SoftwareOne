package Model;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.*;

public class Product {

    private ObservableList<Part> associatedParts;
    private SimpleIntegerProperty productID;
    private SimpleStringProperty name;
    private SimpleDoubleProperty price;
    private SimpleIntegerProperty inStock;
    private SimpleIntegerProperty min;
    private SimpleIntegerProperty max;

    public Product() {
        associatedParts = new ObservableList<Part>() {
            @Override
            public void addListener(ListChangeListener<? super Part> listener) {

            }

            @Override
            public void removeListener(ListChangeListener<? super Part> listener) {

            }

            @Override
            public boolean addAll(Part... elements) {
                return false;
            }

            @Override
            public boolean setAll(Part... elements) {
                return false;
            }

            @Override
            public boolean setAll(Collection<? extends Part> col) {
                return false;
            }

            @Override
            public boolean removeAll(Part... elements) {
                return false;
            }

            @Override
            public boolean retainAll(Part... elements) {
                return false;
            }

            @Override
            public void remove(int from, int to) {

            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Part> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Part part) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Part> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Part> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Part get(int index) {
                return null;
            }

            @Override
            public Part set(int index, Part element) {
                return null;
            }

            @Override
            public void add(int index, Part element) {

            }

            @Override
            public Part remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Part> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Part> listIterator(int index) {
                return null;
            }

            @Override
            public List<Part> subList(int fromIndex, int toIndex) {
                return null;
            }

            @Override
            public void addListener(InvalidationListener listener) {

            }

            @Override
            public void removeListener(InvalidationListener listener) {

            }
        };
        productID = new SimpleIntegerProperty();
        name = new SimpleStringProperty();
        price = new SimpleDoubleProperty();
        inStock = new SimpleIntegerProperty();
        min = new SimpleIntegerProperty();
        max = new SimpleIntegerProperty();


    }

    public ObservableList<Part> getAssociatedParts() {
        return associatedParts;
    }

    public int getProductID() {
        return productID.get();
    }

    public SimpleIntegerProperty productIDProperty() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID.set(productID);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public int getInStock() {
        return inStock.get();
    }

    public SimpleIntegerProperty inStockProperty() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock.set(inStock);
    }

    public int getMin() {
        return min.get();
    }

    public SimpleIntegerProperty minProperty() {
        return min;
    }

    public void setMin(int min) {
        this.min.set(min);
    }

    public int getMax() {
        return max.get();
    }

    public SimpleIntegerProperty maxProperty() {
        return max;
    }

    public void setMax(int max) {
        this.max.set(max);
    }

    public void addAssociatedInHousePart(Part item){

        associatedParts.add(item);
    }

    public void removeAssociatedPart(int idx){
            associatedParts.remove(idx);

    }

    public Part lookupAssociatePart(int idx){
        return associatedParts.get(idx);
    }


}
