package com.fivido.sectionedexpandablegridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.fivido.sectionedexpandablegridlayout.adapters.ItemClickListener;
import com.fivido.sectionedexpandablegridlayout.models.Category;
import com.fivido.sectionedexpandablegridlayout.adapters.SectionedExpandableLayoutHelper;
import com.fivido.sectionedexpandablegridlayout.models.SubCategory;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements ItemClickListener {

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting the recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        SectionedExpandableLayoutHelper sectionedExpandableLayoutHelper = new SectionedExpandableLayoutHelper(this,
                mRecyclerView, this, 2);

        //random data
        ArrayList<SubCategory> arrayList = new ArrayList<>();
        arrayList.add(new SubCategory("08:00 AM", 0));
        arrayList.add(new SubCategory("10:00 AM", 1));
        arrayList.add(new SubCategory("01:00 PM", 2));
        arrayList.add(new SubCategory("05:00 PM", 3));
        sectionedExpandableLayoutHelper.addSection("RAEES (U/A) HINDI", arrayList);
        arrayList = new ArrayList<>();
        arrayList.add(new SubCategory("08:00 AM", 0));
        arrayList.add(new SubCategory("10:00 AM", 1));
        arrayList.add(new SubCategory("01:00 PM", 2));
        arrayList.add(new SubCategory("05:00 PM", 3));
        sectionedExpandableLayoutHelper.addSection("DESINGURA (U/A) TANIL", arrayList);
        arrayList = new ArrayList<>();
        arrayList.add(new SubCategory("08:00 AM", 0));
        arrayList.add(new SubCategory("10:00 AM", 1));
        arrayList.add(new SubCategory("01:00 PM", 2));
        arrayList.add(new SubCategory("05:00 PM", 3));
        sectionedExpandableLayoutHelper.addSection("CIVILWAR (U/A) ENGLISH", arrayList);
        arrayList = new ArrayList<>();
        sectionedExpandableLayoutHelper.addSection("CIVILWAR2 (U/A) ENGLISH", arrayList);

        sectionedExpandableLayoutHelper.notifyDataSetChanged();

        //checking if adding single item works
        sectionedExpandableLayoutHelper.addItem("CIVILWAR (U/A) ENGLISH", new SubCategory("06:30 PM",5));
        sectionedExpandableLayoutHelper.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void itemClicked(SubCategory subCategory) {
        Toast.makeText(this, "SubCategory: " + subCategory.getName() + " clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemClicked(Category category) {
        Toast.makeText(this, "Category: " + category.name + " clicked", Toast.LENGTH_SHORT).show();
    }
}
