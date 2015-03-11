package com.application.tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends ActionBarActivity {
private RadioGroup buttonGroup;
    private TextView totalAmount;
    private TextView tipAmount;
    private EditText userBill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGroup = (RadioGroup) findViewById(R.id.buttonGroup);
        userBill = (EditText) findViewById(R.id.bill_Form);
        tipAmount = (TextView) findViewById(R.id.tipValue);
        totalAmount = (TextView) findViewById(R.id.totalValue);
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
    public void onClickFindAmount(View view) {

        buttonGroup = (RadioGroup) findViewById(R.id.buttonGroup);
        userBill = (EditText) findViewById(R.id.bill_Form);
        tipAmount = (TextView) findViewById(R.id.tipValue);
        totalAmount = (TextView) findViewById(R.id.totalValue);

        String temp = userBill.getText().toString();
     NumberFormat format = java.text.NumberFormat.getCurrencyInstance();

        double userBillAmnt = Double.parseDouble(temp);



        Double tipTemp = 0.0;
        Double totalTemp = 0.0;


            boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId())
        {

            case R.id.ten:
                tipTemp =  userBillAmnt * .10;
                totalTemp = userBillAmnt + tipTemp;

                totalTemp = castRoundTo2(totalTemp);
                tipAmount.setText(format.format(tipTemp));

                totalAmount.setText(format.format(totalTemp));
                userBill.setText(format.format(userBillAmnt));
                break;
            case R.id.eighteen:    tipTemp = userBillAmnt * .18;
                totalTemp = userBillAmnt + tipTemp;

                totalTemp = castRoundTo2(totalTemp);
                tipAmount.setText(format.format(tipTemp));

                totalAmount.setText(format.format(totalTemp));
                userBill.setText(format.format(userBillAmnt));
                break;
            case R.id.twenty:
                tipTemp = userBillAmnt * .20;
                totalTemp = userBillAmnt + tipTemp;

                totalTemp = castRoundTo2(totalTemp);
                tipAmount.setText(format.format(tipTemp));

                totalAmount.setText(format.format(totalTemp));
                userBill.setText(format.format(userBillAmnt));
                break;
            case R.id.fifteen:
                tipTemp = userBillAmnt * .15;
                totalTemp = userBillAmnt + tipTemp;

                totalTemp = castRoundTo2(totalTemp);
                tipAmount.setText(format.format(tipTemp));

                totalAmount.setText(format.format(totalTemp));
                userBill.setText(format.format(userBillAmnt));
                break;

        }
      
        view.refreshDrawableState();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        buttonGroup = (RadioGroup) findViewById(R.id.buttonGroup);
        userBill = (EditText) findViewById(R.id.bill_Form);
        tipAmount = (TextView) findViewById(R.id.tipValue);
        totalAmount = (TextView) findViewById(R.id.totalValue);


        tipAmount.setText((String) savedInstanceState.get("tip"));

        totalAmount.setText((String)savedInstanceState.get("total"));
           userBill.setText((String)savedInstanceState.get("bill"));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
          outState.putString("tip",tipAmount.getText().toString());
        outState.putString("total", totalAmount.getText().toString());
        outState.putString("bill", userBill.getText().toString());
    }
        public  double castRoundTo2(double d) {
        return (long) (d * 100 + 0.5) / 100.0;
    }

        public static double round2(double d) {
        return roundToFactor(d, 100);
    }

        public static double roundToFactor(double d, double f) {
        return Math.round(d * f) / f;
    }


}
