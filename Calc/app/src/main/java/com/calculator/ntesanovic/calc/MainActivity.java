package com.calculator.ntesanovic.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultTV;
    private EditText firstValueET, secondValueET;
    private Button plus, subtract, multiply, divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTV = findViewById(R.id.result);

        firstValueET = findViewById(R.id.firstNumber);
        secondValueET = findViewById(R.id.secondNumber);

        plus = findViewById(R.id.plus);
        subtract = findViewById(R.id.subtract);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);

        plus.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);

    }


    @Override
    public void onClick(View button){

        switch (button.getId()){
            case R.id.plus:
                try{
                    double firstValue = Double.parseDouble(firstValueET.getText().toString());
                    double secondValue = Double.parseDouble(secondValueET.getText().toString());
                    double result = Operations.add(firstValue, secondValue);
                    String output = Double.toString(result);
                    resultTV.setText(output);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;

            case R.id.subtract:
                try{
                    double firstValue = Double.parseDouble(firstValueET.getText().toString());
                    double secondValue = Double.parseDouble(secondValueET.getText().toString());
                    double result = Operations.subtract(firstValue, secondValue);
                    String output = Double.toString(result);
                    resultTV.setText(output);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;

            case R.id.multiply:
                try{
                    double firstValue = Double.parseDouble(firstValueET.getText().toString());
                    double secondValue = Double.parseDouble(secondValueET.getText().toString());
                    double result = Operations.multiply(firstValue, secondValue);
                    String output = Double.toString(result);
                    resultTV.setText(output);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            case R.id.divide:
                try{
                    double firstValue = Double.parseDouble(firstValueET.getText().toString());
                    double secondValue = Double.parseDouble(secondValueET.getText().toString());
                    double result = Operations.divide(firstValue, secondValue);
                    String output = Double.toString(result);
                    resultTV.setText(output);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
        }

    }

}
