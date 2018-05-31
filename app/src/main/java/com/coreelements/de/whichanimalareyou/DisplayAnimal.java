package com.coreelements.de.whichanimalareyou;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.KeyEvent.KEYCODE_ENTER;

public class DisplayAnimal extends AppCompatActivity implements View.OnKeyListener {

    Bundle mBundle;
    int[] mValues;
    ImageView imageView;
    TextView textView, spTextView;
    String mAnimal;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_animal);

        imageView = (ImageView)findViewById(R.id.imageView);
        textView = (TextView)findViewById(R.id.textView4);

        editText = (EditText)findViewById(R.id.editText);
        editText.setOnKeyListener(this);

        spTextView = (TextView)findViewById(R.id.speechBubbleTextView);

        mBundle = getIntent().getExtras();
        mValues = mBundle.getIntArray("values");
        evaluateValues();
    }

    private void evaluateValues() {
        if (mValues[0] == 5 && mValues[1] == 5 && mValues[2] == 5 && mValues[3] == 5 && mValues[4] == 5 && mValues[5] == 5 && mValues[6] == 5 && mValues[7] == 5) {
            showAnimal("Sloth");
        } else if (mValues[0] < 2 && mValues[2] < 3 && mValues[7] > 2) {
            showAnimal("Sloth");
        } else if (mValues[1] == 5 && mValues[3] == 1 && mValues[6] >2) {
            showAnimal("Ant");
        } else if (mValues[4] > 4 && mValues[5] > 2 && mValues[1] > 1 && mValues[7] < 4) {
            showAnimal("Monkey");
        } else if (mValues[3] > 4 && mValues[7] < 4) {
            showAnimal("Dolphin");
        } else if (mValues[5] >2 && mValues[4] >3 && mValues[7] > 3) {
            showAnimal("Eagle");
        } else if (mValues[0] < 3 && mValues[3] < 4 && mValues[7] < 5) {
            showAnimal("Pig");
        } else if (mValues[6] > 3 && mValues[5] > 3 && mValues[1] > 4 && mValues[2] < 3 && mValues[7] < 3) {
            showAnimal("Elephant");
        } else if (mValues[6] > 3 && mValues[0] > 2 && mValues[1] > 2 && mValues[2] > 1 && mValues[7] > 3) {
            showAnimal("Tiger");
        } else if (mValues[6] > 3 && mValues[0] < 4 && mValues[2] < 3 && mValues[7] > 3) {
            showAnimal("Redpanda");
        } else {
            showAnimal("Human");
        }
    }

    private void showAnimal(String animal) {
        mAnimal = animal;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (animal.equals("Sloth")) {
                imageView.setImageDrawable(getDrawable(R.drawable.sloth));
            } else if (animal.equals("Eagle")) {
                imageView.setImageDrawable(getDrawable(R.drawable.eagle));
            } else if (animal.equals("Dolphin")) {
                imageView.setImageDrawable(getDrawable(R.drawable.dolphin));
            } else if (animal.equals("Elephant")) {
                imageView.setImageDrawable(getDrawable(R.drawable.elephant));
            } else if (animal.equals("Monkey")) {
                imageView.setImageDrawable(getDrawable(R.drawable.monkey));
            } else if (animal.equals("Redpanda")) {
                imageView.setImageDrawable(getDrawable(R.drawable.redpanda));
            } else if (animal.equals("Tiger")) {
                imageView.setImageDrawable(getDrawable(R.drawable.tiger));
            } else if (animal.equals("Pig")) {
                imageView.setImageDrawable(getDrawable(R.drawable.pig));
            } else if (animal.equals("Ant")) {
                imageView.setImageDrawable(getDrawable(R.drawable.ant));
            } else {
                imageView.setImageDrawable(getDrawable(R.drawable.human));
            }
        }

        Toast.makeText(this, "You are a(n): \"" + animal + "\"", Toast.LENGTH_SHORT).show();
        textView.setText(animal);
    }

    private void setSpeechBubble() {
        if (editText.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "You have to enter a caption first!", Toast.LENGTH_SHORT).show();
        } else {
            spTextView.setText( "\"" + editText.getText().toString().trim() + "\"");
            editText.setClickable(false);
            editText.setVisibility(View.INVISIBLE);
        }

        if (mAnimal.equals("Sloth")) {
            spTextView.setY(spTextView.getY() - 160);
            spTextView.setX(spTextView.getX() + 32);
        } else if (mAnimal.equals("Dolphin")) {
            spTextView.setY(spTextView.getY() - 900);
        } else if (mAnimal.equals("Monkey")) {
            spTextView.setY(spTextView.getY() - 515);
        } else if (mAnimal.equals("Eagle")) {
            spTextView.setY(spTextView.getY() - 480);
            spTextView.setX(spTextView.getX() + 350);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                spTextView.setTextColor(getColor(R.color.colorPrimaryDark));
            }
        } else if (mAnimal.equals("Pig")) {
            spTextView.setY(spTextView.getY() - 650);
        } else if (mAnimal.equals("Elephant")) {
            spTextView.setX(spTextView.getX() - 450);
            spTextView.setY(spTextView.getY() - 150);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                spTextView.setTextColor(getColor(R.color.colorPrimaryDark));
            }
        } else if (mAnimal.equals("Tiger")) {
            spTextView.setY(spTextView.getY() - 480);
            spTextView.setX(spTextView.getX() + 50);
        } else if (mAnimal.equals("Redpanda")) {
            spTextView.setY(spTextView.getY() - 400);
        } else if (mAnimal.equals("Human")) {
            spTextView.setY(spTextView.getY() - 800);
        } else if (mAnimal.equals("Ant")) {
            spTextView.setY(spTextView.getY() - 460);
            spTextView.setX(spTextView.getX() - 50);
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (event.getAction()) {
            case ACTION_DOWN:
                if (keyCode == KEYCODE_ENTER) {
                    setSpeechBubble();
                }
                break;
        }
        return false;
    }
}
