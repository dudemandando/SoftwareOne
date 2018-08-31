package Model;

import javafx.beans.value.ObservableObjectValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    private static ObservableList<Product> products = FXCollections.observableArrayList();
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static Integer modifyPartIdx;
    private static Integer modifyProductId;

    public Inventory() {


    }

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }
    public static ObservableList<Product> getProducts(){
        return products;
    }

    public static Integer getModifyPartIdx() {

        return modifyPartIdx;
    }

    public static void setModifyPartIdx(Integer modifyPartIdx) {

        Inventory.modifyPartIdx = modifyPartIdx;
    }

    public static void setModifyProductId(Integer id) {
        Inventory.modifyProductId = id;

    }
    public static int getModifyProductId(){

        return modifyProductId;
        }

    public static void addProduct(Product item){

        products.add(item);
    }

    public static boolean removeProduct(int idx){
        try{
            products.remove(idx);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public static void addPart(Part item){

        allParts.add(item);
        System.out.println(allParts.size());
    }

    public static boolean deletePart(int idx){
        try{
            allParts.remove(idx);
            return true;
        }catch(Exception e){
            return false;
        }

    }

    public static Product lookupProduct(int idx){

        return products.get(idx);
    }

    public static Part lookupPart(int idx){

        return allParts.get(idx);
    }

    public static void updateProduct(int idx, Product updatedProduct){

        products.set(idx, updatedProduct);
    }

    public static void updatePart(int idx, Part updatedPart){

        allParts.set(idx, updatedPart);
    }

    public static int getPartLength(){

        return allParts.size();
    }

    public static int getProductLength(){
        return products.size();
    }

    public static Part findPartByID(int id){

        for (Part part : allParts) {

            if (part.getPartID() == id){
                return part;
            }
        }
        return null;
    }

    public static Part findPartByName(String name){
        for (Part part : allParts) {

            if (name.equalsIgnoreCase(part.getName())){
                System.out.println("boom");
                return part;
            }
        }
        return null;
    }




    public static void replacePart(Part part){

        int counter = 0;
        for (Part item : allParts) {
            if (item.getPartID() == part.getPartID()){
                allParts.set(counter, part);
            }else{
                counter +=1;
            }
        }

    }

    public static Product findProductByID(int id){
        for (Product product: products){
            if(product.getProductID() == id){
                return product;
            }
        }
        return null;
    }

    public static Product findProductByName(String name){
        for (Product product: products){
            System.out.println(name + "----" + product.getName());
            if(product.getName() == name){
                return product;
            }
        }
        return null;
    }

    public static void replaceProduct(Product product){
        int counter = 0;
        for (Product item: products){
            if(item.getProductID() == product.getProductID()){
                products.set(counter, product);
            }else{
                counter +=1;
            }
        }
    }

    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

}
