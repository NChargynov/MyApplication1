package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button zero, one, two, three, four, five, six, seven, eight, nine, minus, plus,
            divide, multiply, equal, dot, clear;
    private TextView info, result;
    private final char ADDITION = '+';
    private final char MINUS = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private double val1 = Double.NaN;
    private double val2;
    private final char EQU = '0';
    private char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zero = findViewById(R.id.btn_zero);
        one = findViewById(R.id.btn_one);
        two = findViewById(R.id.btn_two);
        three = findViewById(R.id.btn_three);
        four = findViewById(R.id.btn_four);
        five = findViewById(R.id.btn_five);
        six = findViewById(R.id.btn_six);
        seven = findViewById(R.id.btn_seven);
        eight = findViewById(R.id.btn_eight);
        nine = findViewById(R.id.btn_nine);
        minus = findViewById(R.id.btn_minus);
        plus = findViewById(R.id.btn_plus);
        divide = findViewById(R.id.btn_divide);
        multiply = findViewById(R.id.btn_multiply);
        equal = findViewById(R.id.btn_equal);
        dot = findViewById(R.id.btn_dot);
        clear = findViewById(R.id.btn_clear);
        info = findViewById(R.id.result);
        result = findViewById(R.id.txt_info);
    }

    private void compute() {
        if (!Double.isNaN(val1)) {
            val2 = Double.parseDouble(info.getText().toString());

            switch (ACTION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case MINUS:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EQU:
                    break;
            }
        } else {
            val1 = Double.parseDouble(info.getText().toString());
        }
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_zero:
                info.setText(info.getText().toString() + "0");
                break;
            case R.id.btn_one:
                info.setText(info.getText().toString() + "1");
                break;
            case R.id.btn_two:
                info.setText(info.getText().toString() + "2");
                break;
            case R.id.btn_three:
                info.setText(info.getText().toString() + "3");
                break;
            case R.id.btn_four:
                info.setText(info.getText().toString() + "4");
                break;
            case R.id.btn_five:
                info.setText(info.getText().toString() + "5");
                break;
            case R.id.btn_six:
                info.setText(info.getText().toString() + "6");
                break;
            case R.id.btn_seven:
                info.setText(info.getText().toString() + "7");
                break;
            case R.id.btn_eight:
                info.setText(info.getText().toString() + "8");
                break;
            case R.id.btn_nine:
                info.setText(info.getText().toString() + "9");
                break;
            case R.id.btn_minus:
                compute();
                ACTION = MINUS;
                result.setText(String.valueOf(val1) + "-");
                info.setText(null);
                break;
            case R.id.btn_plus:
                compute();
                ACTION = ADDITION;
                result.setText(String.valueOf(val1) + "+");
                info.setText(null);
                break;
            case R.id.btn_divide:
                compute();
                ACTION = DIVISION;
                result.setText(String.valueOf(val1) + "/");
                info.setText(null);
                break;
            case R.id.btn_equal:
                compute();
                ACTION = EQU;
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                info.setText(null);
                break;
            case R.id.btn_dot:
                info.setText(info.getText().toString() + ".");
                break;
            case R.id.btn_multiply:
                compute();
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(val1) + "*");
                info.setText(null);
                break;
            case R.id.btn_clear:
                if(info.getText().length() > 0){
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
                break;
        }
    }
}
