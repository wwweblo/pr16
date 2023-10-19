package com.example.prr16;

import static android.content.ContentValues.TAG;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final String SAVED_TEXT = "asd";
    Button btnLoad;
    Button btnSave;
    Button btnOk;
    Button btnCansel;
    EditText edText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnSave = findViewById(R.id.btnSave);

        btnLoad.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        edText = findViewById(R.id.edText);
        loadText();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }

    void saveText() {
        SharedPreferences sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, edText.getText().toString());
        ed.commit();
        Toast.makeText(this, "Сохранився", Toast.LENGTH_SHORT).show();
    }

    void loadText() {
        SharedPreferences sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        edText.setText(savedText);
        Toast.makeText(this, "Загрузився", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSave){
            saveText();
        }
        if (v.getId() == R.id.btnLoad){
            loadText();
        }
    }
}