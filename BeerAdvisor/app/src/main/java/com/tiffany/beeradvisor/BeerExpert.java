package com.tiffany.beeradvisor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tiffany on 4/22/2016.
 */
public class BeerExpert {
    List<String> getBrands(String color){
        List<String> brands = new ArrayList<String>();
        if (color.equals("amber")){
            brands.add("Jack Amber");
            brands.add("Red Moose");
        } else {
            brands.add("Jail Pale Ale");

        }
        return brands;
    }

}
