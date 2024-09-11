package com.spy.lr01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText First_Text_Area;
    private EditText Seccond_Text_Area;
    private EditText Third_Text_Area;
    private double First_Number_Int;
    private double Seccond_Number_Int;
    private double Result = 0;

    public void calculate() {
        String First_Number = First_Text_Area.getText().toString();
        First_Number_Int = Double.parseDouble(First_Number);

        String Seccond_Number = Seccond_Text_Area.getText().toString();
        Seccond_Number_Int = Double.parseDouble(Seccond_Number);
    }

    public void handleClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        if (buttonText.equals("+")) {
            calculate();
            Result = First_Number_Int + Seccond_Number_Int;
            Third_Text_Area.setText(String.valueOf(Result));
        } else if (buttonText.equals("-")) {
            calculate();
            Result = First_Number_Int - Seccond_Number_Int;
            Third_Text_Area.setText(String.valueOf(Result));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        First_Text_Area = findViewById(R.id.editTextNumber);
        Seccond_Text_Area = findViewById(R.id.editTextNumber2);
        Third_Text_Area = findViewById(R.id.editTextNumber3);

        Button button_mul = findViewById(R.id.button);
        button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                Result = First_Number_Int * Seccond_Number_Int;
                Third_Text_Area.setText(String.valueOf(Result));
            }
        });
        Button button_div = findViewById(R.id.button2);
        button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                Result = First_Number_Int / Seccond_Number_Int;
                Third_Text_Area.setText(String.valueOf(Result));
            }
        });

    }
}