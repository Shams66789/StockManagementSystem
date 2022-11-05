package io.github.shams66789.stockmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewUser extends AppCompatActivity {
    // Declaring variables
    EditText editText;
    EditText editText1;
    EditText editText2;
    Button button;
    TextView textView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        // linking with layout
        editText = findViewById(R.id.editTextTextPersonName);
        editText1 = findViewById(R.id.editTextNumberPassword);
        editText2 = findViewById(R.id.editTextNumberPassword3);
        button = findViewById(R.id.button2);
        textView = findViewById(R.id.textView7);

        // operations
        button.setOnClickListener(v -> {
            String name = editText.getText().toString();
            String passcode1 = editText1.getText().toString();
            String passcode2 = editText2.getText().toString();
            if(passcode1.equals(passcode2)) {
                textView.setText("Passcode Matched!");

            }else{
                textView.setText("Passcode not matched! Try again");
            }
        });

    }
}