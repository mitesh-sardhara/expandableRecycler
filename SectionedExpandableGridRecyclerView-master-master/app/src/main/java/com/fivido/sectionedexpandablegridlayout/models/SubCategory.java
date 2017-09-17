package com.fivido.sectionedexpandablegridlayout.models;

/**
 * Created by bpncool on 2/23/2016.
 */
public class SubCategory {

    public final String name;
    public final int id;

    public SubCategory(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
