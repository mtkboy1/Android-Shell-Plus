package com.u063.shellplus;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }
    public void executeButton(View view){
        EditText etx = findViewById(R.id.shell_field);
        execute(etx.getText().toString());
    }
    private void execute(String cmd){
        Runtime runtime = Runtime.getRuntime();
        String str = "";
        try {
            Process process = runtime.exec(cmd);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String string = "";
            while((string = in.readLine())!=null){
                str += string;
            }
        } catch (IOException ignored){}

        TextView tx = new TextView(this);
        tx.setTextSize(25);
        tx.setTextColor(Color.rgb(1,100,150));
        tx.setText(cmd);

        LinearLayout ll = findViewById(R.id.scroll);
        ll.addView(tx);

        tx = new TextView(this);
        tx.setTextSize(25);
        tx.setTextColor(Color.BLACK);
        tx.setText(str);

        ll.addView(tx);
    }
}