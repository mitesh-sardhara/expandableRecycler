package com.fivido.sectionedexpandablegridlayout.adapters;

/**
 * Created by bpncool on 2/24/2016.
 */

import com.fivido.sectionedexpandablegridlayout.models.Category;

/**
 * interface to listen changes in state of sections
 */
public interface SectionStateChangeListener {
    void onSectionStateChanged(Category category, boolean isOpen);
}