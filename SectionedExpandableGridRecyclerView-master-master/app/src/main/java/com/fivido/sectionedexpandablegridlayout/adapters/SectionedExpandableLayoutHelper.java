package com.fivido.sectionedexpandablegridlayout.adapters;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fivido.sectionedexpandablegridlayout.models.Category;
import com.fivido.sectionedexpandablegridlayout.models.SubCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by bpncool on 2/23/2016.
 */
public class SectionedExpandableLayoutHelper implements SectionStateChangeListener {

    //data list
    private LinkedHashMap<Category, ArrayList<SubCategory>> mSectionDataMap = new LinkedHashMap<Category, ArrayList<SubCategory>>();
    private ArrayList<Object> mDataArrayList = new ArrayList<Object>();

    //section map
    //TODO : look for a way to avoid this
    private HashMap<String, Category> mSectionMap = new HashMap<String, Category>();

    //adapter
    private SectionedExpandableGridAdapter mSectionedExpandableGridAdapter;

    //recycler view
    RecyclerView mRecyclerView;

    public SectionedExpandableLayoutHelper(Context context, RecyclerView recyclerView, ItemClickListener itemClickListener,
                                           int gridSpanCount) {

        //setting the recycler view
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, gridSpanCount);
        recyclerView.setLayoutManager(gridLayoutManager);
        mSectionedExpandableGridAdapter = new SectionedExpandableGridAdapter(context, mDataArrayList,
                gridLayoutManager, itemClickListener, this);
        recyclerView.setAdapter(mSectionedExpandableGridAdapter);

        mRecyclerView = recyclerView;
    }

    public void notifyDataSetChanged() {
        //TODO : handle this condition such that these functions won't be called if the recycler view is on scroll
        generateDataList();
        mSectionedExpandableGridAdapter.notifyDataSetChanged();
    }

    public void addSection(String section, ArrayList<SubCategory> subCategories) {
        Category newCategory;
        newCategory = new Category();
        newCategory.isExpanded = false;
        newCategory.subCategories = subCategories;
        if(subCategories.size() > 0){
            newCategory.status = true;
        }else{
            newCategory.status = false;
        }

        mSectionMap.put(section, newCategory);
        mSectionDataMap.put(newCategory, subCategories);
    }

    public void addItem(String section, SubCategory subCategory) {
        mSectionDataMap.get(mSectionMap.get(section)).add(subCategory);
    }

    public void removeItem(String section, SubCategory subCategory) {
        mSectionDataMap.get(mSectionMap.get(section)).remove(subCategory);
    }

    public void removeSection(String section) {
        mSectionDataMap.remove(mSectionMap.get(section));
        mSectionMap.remove(section);
    }

    private void generateDataList () {
        mDataArrayList.clear();
        for (Map.Entry<Category, ArrayList<SubCategory>> entry : mSectionDataMap.entrySet()) {
            Category key;
            mDataArrayList.add((key = entry.getKey()));
            if (key.isExpanded)
                mDataArrayList.addAll(entry.getValue());
        }
    }

    @Override
    public void onSectionStateChanged(Category category, boolean isOpen) {
        if (!mRecyclerView.isComputingLayout()) {
            category.isExpanded = isOpen;
            notifyDataSetChanged();
        }
    }
}
