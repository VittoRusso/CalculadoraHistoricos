package com.example.vittorusso.calculadorahistoricos;

import android.app.Activity;
        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.LinearLayout.LayoutParams;
        import android.widget.TableRow;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class EditActivity extends AppCompatActivity {

    private String textEnt, strNum1, strNum2;
    private Float num1, num2, numResult;
    private LinearLayout parent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        int numStr = 1;

        Intent iSecond = getIntent();
        textEnt = iSecond.getStringExtra("textEnt");

        final StringBuilder textSal = new StringBuilder(textEnt);

        parent =findViewById(R.id.Parent);

        if (textEnt != null){

            System.out.println("Recibi: "+textEnt);
            String returnString = "";
            Pattern p = Pattern.compile("[-x+÷]+|\\d+");
            Matcher m = p.matcher(textEnt);
            ArrayList<String> allMatches = new ArrayList<>();
            while (m.find()) {
                allMatches.add(m.group());
                System.out.println(m.group());


                LinearLayout child = new LinearLayout(EditActivity.this);
                child.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1.0f));
                child.setOrientation(LinearLayout.HORIZONTAL);
                parent.addView(child);

                final TextView tv = new TextView(this);
                tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,1.0f));
                tv.setGravity(Gravity.LEFT);
                tv.setTextColor(getResources().getColor(android.R.color.black));
                tv.setPadding(20, 20, 20, 20);
                tv.setTextSize(20);
                tv.setText(m.group());

                final Button btn = new Button(this);
                btn.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,1.0f));
                btn.setGravity(Gravity.CENTER);
                btn.setTextColor(getResources().getColor(android.R.color.black));
                btn.setPadding(20, 20, 20, 20);
                btn.setTextSize(20);
                btn.setText("#"+String.valueOf(numStr)+" Edit");
                numStr++;

                child.addView(tv);
                child.addView(btn);

                btn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        String number = btn.getText().toString();
                        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(number);
                        while(m.find()) {
                            System.out.println(m.group(1));
                        }

                        AlertDialog.Builder alert = new AlertDialog.Builder(EditActivity.this);

                        alert.setTitle("Editar Numero");
                        alert.setMessage("Ingrese el numero caracter: ");
                        final EditText input = new EditText(EditActivity.this);
                        alert.setView(input);

                        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                String EditNumber = input.getText().toString();
                                String numChange = btn.getText().toString();
                                int positionChar = Character.getNumericValue(numChange.charAt(1));
                                tv.setText(EditNumber);
                                textSal.setCharAt(positionChar,EditNumber.charAt(0));
                                System.out.println(textSal);
                            }
                        });

                        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }
                        });

                        alert.show();
                    }
                });
            }

            LinearLayout childFinal = new LinearLayout(EditActivity.this);
            childFinal.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1.0f));
            childFinal.setOrientation(LinearLayout.HORIZONTAL);
            parent.addView(childFinal);

            Button btnReturn = new Button(this);
            btnReturn.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,1.0f));
            btnReturn.setGravity(Gravity.CENTER);
            btnReturn.setTextColor(getResources().getColor(android.R.color.black));
            btnReturn.setPadding(20, 20, 20, 20);
            btnReturn.setTextSize(20);
            btnReturn.setText("Regresar");

            childFinal.addView(btnReturn);

            btnReturn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("textSal",textSal.toString());
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
                }
            });




        }
    }
}

