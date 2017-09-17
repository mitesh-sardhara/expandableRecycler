package com.fivido.sectionedexpandablegridlayout.models;

import java.util.List;

/**
 * Created by bpncool on 2/23/2016.
 */
public class Category {

    public String name;
    public boolean isExpanded;
    public boolean status;
    public List<SubCategory> subCategories;

    /*public Category(String name) {
        this.name = name;
        isExpanded = false;
    }

    public String getName() {
        return name;
    }*/
}
