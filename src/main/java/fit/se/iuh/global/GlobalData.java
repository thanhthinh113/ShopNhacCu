package fit.se.iuh.global;

import java.util.ArrayList;
import java.util.List;

import fit.se.iuh.model.Product;

public class GlobalData {
    //tao bien toan cuc
    public static List<Product> cart;

    static {
        cart = new ArrayList<>();
    }

}
