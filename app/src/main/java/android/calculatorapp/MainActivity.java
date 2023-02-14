package android.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

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
        String dataToCalculate = solution.getText().toString();

        // clears value when AC pressed
        if(btnText.equals("AC")){
            solution.setText("");
            result.setText("0");
            return;
        }

        //calculates value of operations
        if(btnText.equals("=")){
            solution.setText(result.getText());
            return;
        }

        //clears last operation if C pressed
        if(btnText.equals("C")){
            if(dataToCalculate.length() > 1){
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }else{
                dataToCalculate = "0";
            }

        }else{
            dataToCalculate = dataToCalculate+btnText;
        }
        solution.setText(dataToCalculate);

        String finalResult = getResult(dataToCalculate);

        if(!finalResult.equals("Error")){
            result.setText(finalResult);
        }
    }

    //calculates result
    String getResult(String data){
        try{
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String result = context.evaluateString(scriptable, data, "JavaScript", 1, null).toString();
            if(result.endsWith(".0")){
                result = result.replace(".0", "");
            }
            return result;
        }catch (Exception e){
            return "Error";
        }
    }
}