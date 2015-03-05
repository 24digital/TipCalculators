package com.application.tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
private RadioGroup buttonGroup;
    private TextView totalAmount;
    private TextView tipAmount;
    private EditText userBill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    public void onClickFindAmount(View view)
    {
        view.refreshDrawableState();
        buttonGroup = (RadioGroup)findViewById(R.id.buttonGroup);
        userBill = (EditText)findViewById(R.id.bill_Form);
        String temp = userBill.getText().toString();
      double userBillAmnt =  Double.parseDouble(temp);
      int i =  buttonGroup.getCheckedRadioButtonId();

        tipAmount = (TextView)findViewById(R.id.tipValue);
        totalAmount = (TextView)findViewById(R.id.totalValue);
       Double tipTemp = 0.0;
        Double totalTemp = 0.0;

        switch(i){
            case 1:
           tipTemp = userBillAmnt * .10;
              totalTemp = userBillAmnt + tipTemp;
                tipAmount.setText(String.valueOf(Math.round(tipTemp)));
                totalAmount.setText(String.valueOf(totalTemp));
            case 2:
           tipTemp = userBillAmnt * .15;
           totalTemp = userBillAmnt + tipTemp;
                tipAmount.setText(String.valueOf(Math.round(tipTemp)));
                totalAmount.setText(String.valueOf(totalTemp));
            case 3:
            tipTemp = userBillAmnt * .18;
          totalTemp = userBillAmnt + tipTemp;
                tipAmount.setText(String.valueOf(Math.round(tipTemp)));
                totalAmount.setText(String.valueOf(totalTemp));
            case 4:
           tipTemp = userBillAmnt * .20;
              totalTemp = userBillAmnt + tipTemp;
                tipAmount.setText(String.valueOf(Math.round(tipTemp)));
                totalAmount.setText(String.valueOf(totalTemp));
                    default:
        }



    }
}
