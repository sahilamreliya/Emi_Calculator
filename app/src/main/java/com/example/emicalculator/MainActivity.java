package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText price,downpayment,interestrate,years;
    Button calculate;
    TextView EMIANS,EMIANS2,EMIANS3,amt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        price = findViewById(R.id.etprice);
        downpayment = findViewById(R.id.etdp);
        interestrate = findViewById(R.id.etir);
        years= findViewById(R.id.etym);
        calculate = findViewById(R.id.btca);
        EMIANS = findViewById(R.id.tvans);
        EMIANS2 = findViewById(R.id.tvans2);
        EMIANS3 = findViewById(R.id.tvans3);
        amt = findViewById(R.id.amount);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double p = Double.parseDouble(price.getText().toString());
                double d = Double.parseDouble(downpayment.getText().toString());
                double i = Double.parseDouble(interestrate.getText().toString());
                double y = Double.parseDouble(years.getText().toString());

                i =  i/ (12*100);
                float final_ans = 1.0f;

                 for (int  t=0; t<y; t++){

                     final_ans *=1+ i;

                 }

                 float p_amt = (float) (p - d);

                float emi = (float) (p_amt*i*(final_ans/(final_ans -1 )));

                DecimalFormat decimalFormat = new DecimalFormat("0");

                int final_emi = Integer.parseInt(decimalFormat.format(emi));

                amt.setText("EMI AMOUNT :- "+p_amt);

                EMIANS.setText("EMI PER MONTH :- " + final_emi);

                int total = (int) (final_emi * y);

                EMIANS2.setText("EMI" + (total-p_amt));

                EMIANS3.setText("TOTAL PAY :- " + total);


            }
        });
    }
}