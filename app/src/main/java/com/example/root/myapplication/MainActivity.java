package com.example.root.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
    {

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            final CheckBox IsBinChecked=(CheckBox)findViewById(R.id.Binario);
            final CheckBox IsOctalChecked=(CheckBox)findViewById(R.id.Octal);
            final CheckBox IsDecChecked=(CheckBox)findViewById(R.id.Decimal);
            final CheckBox IsHexadecChecked=(CheckBox)findViewById(R.id.Hexadecimal);
            Button convert= (Button)findViewById(R.id.button);
            //The snippet below defines what happens when the button is clicked
            convert.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                        public void onClick(View view)
                            {
                                //here we write what happens when the button is clicked
                                Intent intent=new Intent(MainActivity.this, ShowResultsActivity.class);
                                EditText NumToConvert=(EditText) findViewById(R.id.Number);
                                int numtoconvert=Integer.parseInt(NumToConvert.getText().toString());
                                Bundle bundle=new Bundle();
                                bundle.putInt("num2convert",numtoconvert);
                                bundle.putBoolean("Binario",IsBinChecked.isChecked());
                                bundle.putBoolean("Octal",IsOctalChecked.isChecked());
                                bundle.putBoolean("Decimal",IsDecChecked.isChecked());
                                bundle.putBoolean("Hexadecimal",IsHexadecChecked.isChecked());
                                intent.putExtras(bundle);
                                startActivity(intent);

                            }
                }
            );
            //here it ends
        }

    }


