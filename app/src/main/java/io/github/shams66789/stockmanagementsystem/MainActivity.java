package io.github.shams66789.stockmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declaring variables
    TextView textView1;
    TextView textView;
    Button button;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // linking components of layout
        editText = findViewById(R.id.editTextNumberPassword2);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView4);
        textView1 = findViewById(R.id.textView5);

        // Setting text on textview
        textView1.setText("Welcome");

        // adding on click listener on button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // adding on click listener for new user
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewUser.class);
                registerForActivityResult(intent, 1);
                startActivityForResult(intent,1);
            }
        });
    }

    private void registerForActivityResult(Intent intent, int i) {
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String strEditText = data.getStringExtra("editTextValue");
            }
        }
    }
}