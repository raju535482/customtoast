package com.example.sony.customtoast;

import android.content.ContentValues;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.sony.customtoast.R.*;
import static com.example.sony.customtoast.R.id.radio1;

public class Main24Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {
    String[] an={"Laddoo", "Gulaab Jamun", "Kaju Katri",};
    String userChoice;
    Spinner sp2;
Button bt1,bt2,btn3;
    RadioGroup rg;
    RadioButton temp;
//    RadioButton r1,r2,r3;
    CheckBox c1,c2,c3;
    TextView tv1, tv2, tv3,tv4,tv5,tv6,tv7;
    EditText ed1, ed2, ed3,ed4;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main24);
        tv1 = (TextView) findViewById(id.tw1);
        btn3=(Button)findViewById(id.btn13);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv2 = (TextView) findViewById(id.tw2);
        tv3 = (TextView) findViewById(id.tw3);
        tv4 = (TextView) findViewById(id.tw4);
        tv5 = (TextView) findViewById(id.tw5);
        tv6 = (TextView) findViewById(id.tw6);
        tv7 = (TextView) findViewById(id.tw7);
        ed1 = (EditText) findViewById(id.edt1);
        ed2 = (EditText) findViewById(id.edt2);
        ed3 = (EditText) findViewById(id.edt3);
        ed4 = (EditText) findViewById(id.edt4);
//        r1 = (RadioButton) findViewById(radio1);
//        r2 = (RadioButton) findViewById(id.radio2);
//        r3 = (RadioButton) findViewById(id.radio3);
        rg=(RadioGroup)findViewById(id.rg1);
        c1 = (CheckBox) findViewById(id.cb1);
        c2 = (CheckBox) findViewById(id.cb2);
        c3 = (CheckBox) findViewById(id.cb3);
        bt1 = (Button) findViewById(id.btn11);
        bt2 = (Button) findViewById(id.btn12);
        sp2=(Spinner)findViewById(id.sp2);
        sp2.setOnItemSelectedListener(this);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_spinner_item,an);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(aa);

        db = new Database(getApplicationContext());
        if (getIntent().getExtras() != null) {
            ed4.setText(getIntent().getStringExtra("order"));

            c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    c1.setText(getIntent().getStringExtra("salad"));

                }
            }); c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    c2.setText(getIntent().getStringExtra("salad"));

                }
            });
            c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    c3.setText(getIntent().getStringExtra("salad"));

                }
            });
            rg.setOnCheckedChangeListener(this);
            ed1.setText(getIntent().getStringExtra("cold"));
            ed2.setText(getIntent().getStringExtra("papad"));
            ed3.setText(getIntent().getStringExtra("dal"));
            sp2.setOnItemSelectedListener(this);
            aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, an);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp2.setAdapter(aa);

            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int rbid=rg.getCheckedRadioButtonId();
                    temp=(RadioButton)findViewById(rbid);
                    Menu m1=new Menu();
                    m1.setOrder(Integer.parseInt(ed4.getText().toString()));
                    m1.setSalad(userChoice);
                    m1.setSabji(temp.getText().toString());
                    m1.setCold(ed1.getText().toString());
                    m1.setPapad(ed2.getText().toString());
                    m1.setDal(ed3.getText().toString());
                    m1.setSweet(sp2.getSelectedItem().toString());
                    db.update(m1);
                    Toast.makeText(getApplication(), "Updated...", Toast.LENGTH_LONG).show();

                }
            });
        }
    else {
            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int rbid=rg.getCheckedRadioButtonId();
                    temp=(RadioButton)findViewById(rbid);
                    Menu m1=new Menu();
                    m1.setOrder(Integer.parseInt(ed4.getText().toString()));
                    m1.setSalad(userChoice);
                    m1.setSabji(temp.getText().toString());
                    m1.setCold(ed1.getText().toString());
                    m1.setPapad(ed2.getText().toString());
                    m1.setDal(ed3.getText().toString());
                    m1.setSweet(sp2.getSelectedItem().toString());
                    db.insert(m1);
                    Toast.makeText(getApplication(), "Inserted...", Toast.LENGTH_LONG).show();

                }
            });
        }
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main24Activity.this, Display.class);
                startActivity(i);
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

       String st=parent.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(),st,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }
}