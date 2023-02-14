package android.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView result, solution;
    MaterialButton btnC, btnOpenBracket, btnClosedBracket;
    MaterialButton btnDivide, btnMultiply, btnPlus, btnMinus, btnEquals;
    MaterialButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    MaterialButton btnAC, btnDot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        solution = findViewById(R.id.solution);

        //call all buttons to be assigned
        assignId(btnC, R.id.btnC);
        assignId(btn1, R.id.btn1);
        assignId(btn2, R.id.btn2);
        assignId(btn3, R.id.btn3);
        assignId(btn4, R.id.btn4);
        assignId(btn5, R.id.btn5);
        assignId(btn6, R.id.btn6);
        assignId(btn7, R.id.btn7);
        assignId(btn8, R.id.btn8);
        assignId(btn9, R.id.btn9);
        assignId(btn0, R.id.btn0);
        assignId(btnAC, R.id.btn_all_clear);
        assignId(btnDot, R.id.btn_dot);
        assignId(btnOpenBracket, R.id.btn_closed_bracket);
        assignId(btnClosedBracket, R.id.btn_open_bracket);
        assignId(btnDivide, R.id.btn_divide);
        assignId(btnMultiply, R.id.btn_multiply);
        assignId(btnMinus, R.id.btn_minus);
        assignId(btnPlus, R.id.btn_plus);
        assignId(btnEquals, R.id.btn_equals);

    }

    // assigns material button to id and adds click listener
    void assignId(MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    //function called when button clicked
    @Override
    public void onClick(View view){
        MaterialButton btn = (MaterialButton) view;
        String btnText = btn.getText().toString();
        solution.setText(btnText);

    }
}