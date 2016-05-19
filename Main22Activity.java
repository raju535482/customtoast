package com.example.sony.customtoast;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class Main22Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
     String[] an={"Naruto", "Sasuke", "Itachi", "Obito", "Kakashi", "Jiraiya", "Oruchimaru",};
    String[] pos={"Genin","chunin","Jonin","Senin",};
    Button btn7,btn8,btn3;
Spinner sp;
RatingBar rb;
    AutoCompleteTextView atv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        btn3=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        sp=(Spinner)findViewById(R.id.spin);
        atv=(AutoCompleteTextView)findViewById(R.id.atext);
        sp.setOnItemSelectedListener(this);
        rb=(RatingBar)findViewById(R.id.rtb);
            ArrayAdapter<String> a=new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,pos);
        atv.setThreshold(1);
        atv.setAdapter(a);
        atv.setTextColor(Color.RED);

        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_spinner_item,an);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);
        addListeneronButtonClick();

    }
    public void addListeneronButtonClick() {
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating=String.valueOf(rb.getRating());
                Toast.makeText(getApplicationContext(),rating,Toast.LENGTH_LONG).show();
            }
        });

    }
  /*  public void sendMessage(View view)
    {
        Intent intent = new Intent(Main22Activity.this, MainActivity.class);
        startActivity(intent);
    }
*/
    public void sendMessage1(View view)
    {
        Intent intent = new Intent(Main22Activity.this, Main23Activity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getApplicationContext(), an[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
