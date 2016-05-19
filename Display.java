package com.example.sony.customtoast;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by SONY on 11-02-2016.
 */

/**
 * Created by root on 4/2/16.
 */
public class Display extends Activity {
    ListView lv;
    Database db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main25);
        lv = (ListView) findViewById(R.id.lv1);
        db = new Database(getApplicationContext());
        ArrayList<Menu> alist = new ArrayList<Menu>();
        alist = db.showdata();
        //ArrayAdapter<Student> aa=new ArrayAdapter<Student>(getApplicationContext(),android.R.layout.simple_list_item_1,alist);
        Main25Activity aa = new Main25Activity(getApplicationContext(), alist);
        lv.setAdapter(aa);
    }

}
