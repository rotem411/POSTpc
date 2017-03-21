package com.rotemarbiv.sicret;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {
    String inputTextString = "";
    KeyListener listen;
    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = (EditText)findViewById(R.id.inputText);
        listen = inputText.getKeyListener();
        inputText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    switch (keyCode)
                    {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            print(v);
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });
        EditText outputText = (EditText)findViewById(R.id.outputText);
        outputText.setKeyListener(null);
    }

    public void print(View view){

        Calendar cldr = Calendar.getInstance();
        EditText text = (EditText)findViewById(R.id.inputText);
        inputTextString = cldr.get(Calendar.HOUR) + ":" + cldr.get(Calendar.MINUTE) +":  "+ text.getText().toString() + "\n" + inputTextString ;
        text.setText("");
        text = (EditText)findViewById(R.id.outputText);
        text.setText(inputTextString);
        inputText.setKeyListener(listen);

    }
}
