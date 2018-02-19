package com.example.vittorusso.calculadorahistoricos;

import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    String textEnt, strNum1, strNum2;
    float num1, num2, numResult;
    String TAG = "VittoDebug";
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDel, btnDiv, btnTim, btnMin, btnAdd, btnDot, btnEqual;
    TextView tvEnter, tvResult;
    Boolean opStatus = false;
    Boolean opDot = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnTim = (Button) findViewById(R.id.btnTim);
        btnMin = (Button) findViewById(R.id.btnMin);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnEqual = (Button) findViewById(R.id.btnEqual);

        tvEnter = (TextView) findViewById(R.id.tvEnter);
        tvResult = (TextView) findViewById(R.id.tvResult);





    }
    public void btn7(View view) {
        textEnt = tvEnter.getText().toString();
        textEnt = textEnt + "7";
        tvEnter.setText(textEnt);
        opStatus = false;
    }

    public void btn8(View view) {
        textEnt = tvEnter.getText().toString();
        textEnt = textEnt + "8";
        tvEnter.setText(textEnt);
        opStatus = false;
    }

    public void btn9(View view) {
        textEnt = tvEnter.getText().toString();
        textEnt = textEnt + "9";
        tvEnter.setText(textEnt);
        opStatus = false;
    }

    public void btn4(View view) {
        textEnt = tvEnter.getText().toString();
        textEnt = textEnt + "4";
        tvEnter.setText(textEnt);
        opStatus = false;
    }

    public void btn5(View view) {
        textEnt = tvEnter.getText().toString();
        textEnt = textEnt + "5";
        tvEnter.setText(textEnt);
        opStatus = false;
    }

    public void btn6(View view) {
        textEnt = tvEnter.getText().toString();
        textEnt = textEnt + "6";
        tvEnter.setText(textEnt);
        opStatus = false;
    }

    public void btn1(View view) {
        textEnt = tvEnter.getText().toString();
        textEnt = textEnt + "1";
        tvEnter.setText(textEnt);
        opStatus = false;
    }

    public void btn2(View view) {
        textEnt = tvEnter.getText().toString();
        textEnt = textEnt + "2";
        tvEnter.setText(textEnt);
        opStatus = false;
    }

    public void btn3(View view) {
        textEnt = tvEnter.getText().toString();
        textEnt = textEnt + "3";
        tvEnter.setText(textEnt);
        opStatus = false;
    }


    public void btn0(View view) {
        textEnt = tvEnter.getText().toString();
        textEnt = textEnt + "0";
        tvEnter.setText(textEnt);
        opStatus = false;
    }

    public void btnDel(View view) {
        textEnt = tvEnter.getText().toString();
        if (textEnt!= null && textEnt.length() > 0) {
            System.out.println(textEnt.substring(textEnt.length()-1));

            if ((textEnt.substring(textEnt.length()-1).equals("x") || textEnt.substring(textEnt.length()-1).equals("+") || textEnt.substring(textEnt.length()-1).equals("-") || textEnt.substring(textEnt.length()-1).equals("÷"))){
                opStatus = false;

            }
            if (textEnt.substring(textEnt.length()-1) == "."){
                opDot = false;
            }

            textEnt = textEnt.substring(0, textEnt.length() - 1);
        }else{
            opStatus = false;
            opDot = false;
        }
        tvEnter.setText(textEnt);
    }

    public void btnDiv(View view) {
        if (opStatus){

        }else{
            textEnt = tvEnter.getText().toString();
            textEnt = textEnt + "÷";
            tvEnter.setText(textEnt);
            opStatus = true;
            opDot = false;
        }
    }

    public void btnTim(View view) {
        if (opStatus){

        }else{
            textEnt = tvEnter.getText().toString();
            textEnt = textEnt + "x";
            tvEnter.setText(textEnt);
            opStatus = true;
            opDot = false;
        }
    }

    public void btnMin(View view) {
        if (opStatus){

        }else{
            textEnt = tvEnter.getText().toString();
            textEnt = textEnt + "-";
            tvEnter.setText(textEnt);
            opStatus = true;
            opDot = false;
        }
    }

    public void btnAdd(View view) {
        if (opStatus){

        }else{
            textEnt = tvEnter.getText().toString();
            textEnt = textEnt + "+";
            tvEnter.setText(textEnt);
            opStatus = true;
            opDot = false;
        }
    }

    public void btnDot(View view) {
        if (opStatus){

        }else{
            textEnt = tvEnter.getText().toString();
            textEnt = textEnt + ".";
            tvEnter.setText(textEnt);
            opDot = true;
        }
    }

    public void btnEqual(View view) {
        Equal();
    }

    public void LayoutClick(View view) {
        Intent iSecond = new Intent(this,EditActivity.class);
        iSecond.putExtra("textEnt", textEnt);
        startActivityForResult(iSecond,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                String textSal = data.getStringExtra("textSal");
                tvEnter.setText(textSal);
                Equal();
            }
        }
    }

    public void Equal () {
        textEnt = tvEnter.getText().toString();

        ArrayList<String> Operatores = new ArrayList<>();
        ArrayList<Float> Numbers = new ArrayList<>();

        Pattern p = Pattern.compile("[-x+÷]+|\\d+");
        Matcher m = p.matcher(textEnt);
        final ArrayList<String> allMatches = new ArrayList<>();
        while (m.find()) {
            allMatches.add(m.group());
            if (isNumeric(m.group())){
                Numbers.add(Float.valueOf(m.group()));
                System.out.println("Number: " + m.group());
            }else{
                Operatores.add(m.group());
                System.out.println("Operator: " + m.group());
            }
        }

        float Acum = 0;
        int j = 0;
        for(int i=0;i<Numbers.size();i=i+2){
            if(i>=Numbers.size()-1){
                switch (Operatores.get(j)) {
                    case "+":
                        Acum = Acum + Numbers.get(i-1);
                        break;
                    case "-":
                        Acum = Acum - Numbers.get(i-1);
                        break;
                    case "x":
                        Acum = Acum * Numbers.get(i-1);
                        break;
                    case "÷":
                        Acum = Acum / Numbers.get(i-1);
                        break;
                }
            }else{
                switch (Operatores.get(j)) {
                    case "+":
                        Acum = Acum + (Numbers.get(i) + Numbers.get(i + 1));
                        break;
                    case "-":
                        Acum = Acum + (Numbers.get(i) - Numbers.get(i + 1));
                        break;
                    case "x":
                        Acum = Acum + (Numbers.get(i) * Numbers.get(i + 1));
                        break;
                    case "÷":
                        Acum = Acum + (Numbers.get(i) / Numbers.get(i + 1));
                        break;
                }
            }



            j++;
        }


        tvResult.setText(String.valueOf(Acum));
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}


