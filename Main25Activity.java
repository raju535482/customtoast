package com.example.sony.customtoast;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Main25Activity extends BaseAdapter {

    Context context;
    ArrayList<Menu> alist;

    Main25Activity(){}

    public Main25Activity(Context context, ArrayList<Menu> alist) {
        this.context = context;
        this.alist = alist;
    }


    @Override
    public int getCount() {
        return alist.size();
    }

    @Override
    public Object getItem(int position) {
        return alist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Menu m1=alist.get(position);
        LayoutInflater inf=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView=inf.inflate(R.layout.activity_main26,null);
        TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
        tv1=(TextView)convertView.findViewById(R.id.tw1);
        tv2=(TextView)convertView.findViewById(R.id.tw2);
        tv3=(TextView)convertView.findViewById(R.id.tw3);
        tv4=(TextView)convertView.findViewById(R.id.tw4);
        tv5=(TextView)convertView.findViewById(R.id.tw5);
        tv6=(TextView)convertView.findViewById(R.id.tw6);
        tv7=(TextView)convertView.findViewById(R.id.tw7);
        tv1.setText(String.valueOf(m1.getOrder()));
        tv2.setText(m1.getSalad());
        tv3.setText(m1.getSabji());
        tv4.setText(m1.getCold());
        tv5.setText(m1.getPapad());
        tv6.setText(m1.getDal());
        tv7.setText(m1.getSweet());
        Button update=(Button)convertView.findViewById(R.id.btup);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,Main24Activity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("order", Integer.toString(m1.getOrder()));
                i.putExtra("salad", m1.getSalad());
                i.putExtra("sabji", m1.getSabji());
                i.putExtra("cold", m1.getCold());
                i.putExtra("papad", m1.getPapad());
                i.putExtra("dal", m1.getDal());
                i.putExtra("sweet", m1.getSweet());
                v.getContext().startActivity(i);
            }
        });
        Button delete=(Button)convertView.findViewById((R.id.btdel));
        delete.setOnClickListener(new View.OnClickListener() {
         @Override
        public void onClick(View v) {
             Database db;
             db=new Database(context);
             db.delete(m1);
             Intent i=new Intent(context,Main24Activity.class);
             i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
             v.getContext().startActivity(i);

         }
});

        return convertView;
    }
}
