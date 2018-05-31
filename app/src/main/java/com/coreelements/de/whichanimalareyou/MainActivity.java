package com.coreelements.de.whichanimalareyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Spinner                     spinner;
    Button                      button;
    TextView                    textView;
    ArrayAdapter<CharSequence>  adapter;
    int                         statementNumber = 1;

    Quiz                        quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        textView = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);

        quiz = new Quiz();
        displayStatement();
    }

    private void displayStatement() {
        textView.setText(quiz.getStatement(statementNumber));
        textView.setText(textView.getText() + " (" + statementNumber + "/8)");
    }

    @Override
    public void onClick(View v) {

        if (statementNumber < 8) {
            quiz.setValue(statementNumber - 1, Integer.parseInt(spinner.getSelectedItem().toString()));
            statementNumber++;
            displayStatement();
        } else {
            quiz.setValue(statementNumber - 1, Integer.parseInt(spinner.getSelectedItem().toString()));
            String values = "values";
            startActivity(new Intent(this, DisplayAnimal.class).putExtra(values, quiz.getValues()));
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
