package com.fivido.sectionedexpandablegridlayout.adapters;

import com.fivido.sectionedexpandablegridlayout.models.Category;
import com.fivido.sectionedexpandablegridlayout.models.SubCategory;

/**
 * Created by lenovo on 2/23/2016.
 */
public interface ItemClickListener {
    void itemClicked(SubCategory subCategory);
    void itemClicked(Category category);
}
