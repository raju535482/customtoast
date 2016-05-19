package com.example.sony.customtoast;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
Button btn1,btn2,btn3,btn4;
EditText et1,et2;
    CheckBox c1,c2,c3,c4,c5;
    ToggleButton tg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        c1=(CheckBox)findViewById(R.id.ch1);
        c2=(CheckBox)findViewById(R.id.ch2);
        c3=(CheckBox)findViewById(R.id.ch3);
        c4=(CheckBox)findViewById(R.id.ch4);
        c5=(CheckBox)findViewById(R.id.ch5);
        et1=(EditText)findViewById(R.id.ed1);
        et2=(EditText)findViewById(R.id.ed2);
        tg1=(ToggleButton)findViewById(R.id.tgb1);
btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();

        int cal = (Integer.parseInt(s1) + Integer.parseInt(s2));

        Toast.makeText(getApplicationContext(), String.valueOf(cal), Toast.LENGTH_LONG).show();

    }
});
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder rs=new StringBuilder();
                rs.append("ToggleButton 1 is...").append(tg1.getText());
                Toast.makeText(getApplicationContext(),rs.toString(),Toast.LENGTH_LONG).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tot=0;
                StringBuilder rs=new StringBuilder();
                rs.append("Selected Item");
                if(c1.isChecked()){
                    rs.append("\nCoffee Rs.30");
                    tot+=30;
                }
                if(c2.isChecked()){
                    rs.append("\nPizza Rs.100");
                    tot+=100;
                }
                if(c3.isChecked()){
                    rs.append("\nBurger Rs.20");
                    tot+=20;
                }
                if(c4.isChecked()){
                    rs.append("\nSprite Rs.10");
                    tot+=10;
                }
                if(c5.isChecked()){
                    rs.append("\nBeer Rs.150");
                    tot+=150;
                }
                rs.append("\n Total:" + tot + "Rs");
                Toast.makeText(getApplicationContext(),rs.toString(),Toast.LENGTH_LONG).show();

            }
        });
                LayoutInflater lt=getLayoutInflater();
        View layout=lt.inflate(R.layout.activity_main2, (ViewGroup) findViewById(R.id.custom_layout));

        Toast t=new Toast(getApplicationContext());
        t.setDuration(Toast.LENGTH_SHORT);
        t.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
        t.setView(layout);
        t.show();

}
    public void sendMessage(View view)
    {
        Intent intent = new Intent(MainActivity.this, Main22Activity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    }

