package com.example.root.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowResultsActivity extends AppCompatActivity {
    private ArrayList<String> NumbersList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_results);
        Intent intent = getIntent();
        ListView ConvNumbersList = (ListView) findViewById(R.id.ConvNumbersList);
        Bundle bundle=intent.getExtras();
        final ArrayAdapter<String> ConvNumbers = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,NumbersList);
        ConvNumbersList.setAdapter(ConvNumbers);
        boolean BinChkd,Octchkd,DecChkd,HxdecChk;
        BinChkd=bundle.getBoolean("Binario");
        Octchkd=bundle.getBoolean("Octal");
        DecChkd=bundle.getBoolean("Decimal");
        HxdecChk=bundle.getBoolean("Hexadecimal");
        int num2convert=bundle.getInt("num2convert");
        if(BinChkd){NumbersList.add(Integer.toBinaryString(num2convert));}
        if(Octchkd){NumbersList.add(Integer.toOctalString(num2convert));}
        if(DecChkd){NumbersList.add(Integer.toString(num2convert));}
        if(HxdecChk){NumbersList.add(Integer.toHexString(num2convert));}
        ConvNumbers.notifyDataSetChanged();
    }
}
