package com.droidrank.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements magicView {
   // Button btn_execute;
    EditText et_number;
    TextView tv_result;
    MagicController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }



    public void execute(View view) {
        if (checkEmptyNumber()){
            if (checkIsOdd()){
                controller.performMagic(getOddNumber());
            }else {
                showMessage("Error, entered number isn't odd..!");

            }
        }else {
            showMessage("Empty data not valid");
        }

    }

    @Override
    public void setup() {
        et_number= (EditText) findViewById(R.id.et_number);
        tv_result= (TextView) findViewById(R.id.tv_result);
        controller=new MagicController(this);
    }

    @Override
    public boolean checkIsOdd() {
        return getOddNumber() % 2 !=0;
    }

    @Override
    public boolean checkEmptyNumber() {
        return !et_number.getText().toString().isEmpty();
    }

    @Override
    public void showMessage(String mes) {
        et_number.setError(mes);
        //Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getOddNumber() {
        return Integer.parseInt(et_number.getText().toString().trim());
    }

    @Override
    public void updateUI(String output) {
        tv_result.setText(output);
    }


}
