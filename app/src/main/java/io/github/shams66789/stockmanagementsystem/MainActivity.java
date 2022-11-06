package io.github.shams66789.stockmanagementsystem;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declaring variables
    TextView textView1;
    TextView textView;
    TextView textView2;
    Button button;
    EditText editText;
    String passcode;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // linking components of layout
        editText = findViewById(R.id.editTextNumberPassword2);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView4);
        textView1 = findViewById(R.id.textView5);
        textView2 = findViewById(R.id.textView8);

        // Setting text on textview
        textView1.setText("Welcome");

        // adding on click listener on button
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("FILE_NAME", MODE_PRIVATE);
                passcode = sp.getString("key",null);
                if (passcode == null) {
                    textView2.setText("Your account does not exists! Please register first");
                    Toast.makeText(MainActivity.this, "Your account does not exists! Please register first",
                            Toast.LENGTH_SHORT).show();
                }
                String code = editText.getText().toString();
                if (code.equals(passcode)){
                    Intent intent = new Intent(MainActivity.this, OperationPage.class);
                    startActivity(intent);
                }else {
                    textView2.setText("Passcode not matched!");
                }
            }
        });

        ActivityResultLauncher<Intent> activityResultLaunch = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == 123) {
                            Intent data = result.getData();
                            assert data != null;
                            String myStr = data.getStringExtra("Passcode");
                            SharedPreferences sp = getSharedPreferences("FILE_NAME", MODE_PRIVATE);
                            SharedPreferences.Editor edit = sp.edit();
                            edit.putString("key", myStr);
                            edit.apply();
//                            if (!TextUtils.isEmpty(myStr )) {
//                                passcode.setText(myStr);
//                            }
                            //Toast.makeText(MainActivity.this, "passcode", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

        // adding on click listener for new user
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewUser.class);
                activityResultLaunch.launch(intent);
            }
        });
    }
}