package tech.space_ant.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    Button btnCalculate;
    Button btnClear;
    TextView tvResult;

    RadioButton rbPlus;
    RadioGroup rgOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflate

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);
        tvResult = findViewById(R.id.tvResult);
        rbPlus = findViewById(R.id.rbPlus);
        rgOperator = findViewById(R.id.rgOperator);


        btnClear.setOnClickListener(listener);
        btnCalculate.setOnClickListener(listener);


        /*
        //Anonymous Class
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               int v1 = Integer.parseInt(editText1.getText().toString());
               int v2 = Integer.parseInt(editText2.getText().toString());
               int result = v1+v2;

               //Log.d("calculation","result = "+result);
                //Toast.makeText(MainActivity.this,
                        //"result"+result,Toast.LENGTH_LONG).show();

                tvResult.setText(result+"");


            }
        });
        */


    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(v == btnClear){

                tvResult.setText("0");
                editText1.setText("");
                editText2.setText("");

                Toast.makeText(MainActivity.this,
                        "clear",Toast.LENGTH_LONG).show();
            }

            if(v == btnCalculate){

                int v1 = Integer.parseInt(editText1.getText().toString());
                int v2 = Integer.parseInt(editText2.getText().toString());
                int result = 0;

                /*
                if (rbPlus.isChecked()){

                    result = v1+v2;
                }*/

                switch (rgOperator.getCheckedRadioButtonId()){
                    case R.id.rbPlus:
                        result = v1+v2;
                         break;

                    case  R.id.rbMinus:
                        result = v1-v2;
                        break;
                }



                //Log.d("calculation","result = "+result);
                //Toast.makeText(MainActivity.this,
                //"result"+result,Toast.LENGTH_LONG).show();

                tvResult.setText(" = "+result);
            }


        }
    };

}
