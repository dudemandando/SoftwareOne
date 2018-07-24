package sample;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products;
    private ArrayList<Part> allParts;

    public Inventory() {
        this.products = new ArrayList<>();
        this.allParts = new ArrayList<>();
    }

    public void addProduct(Product item){
        this.products.add(item);
    }

    public boolean removeProduct(int idx){
        try{
            products.remove(idx);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void addPart(Part item){
        this.allParts.add(item);
    }

    public boolean deletePart(int idx){
        try{
            allParts.remove(idx);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Product lookupProduct(int idx){
        return this.products.get(idx);
    }

    public Part lookupPart(int idx){
        return this.allParts.get(idx);
    }

    public void updateProduct(int idx, Product updatedProduct){
       products.set(idx, updatedProduct);
    }

    public void updatePart(int idx, Part updatedPart){
        allParts.set(idx, updatedPart);
    }

}
