package com.example.deni.Jarvis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView list;
    private EditText input;
    private MessageAdapter adapter;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        input = (EditText) findViewById(R.id.editText);
        send = (Button) findViewById(R.id.send);
        adapter = new MessageAdapter(this, new ArrayList<String>());
        list.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = input.getText().toString();
                adapter.add(text);
                input.setText("");
                respont(text);
            }
        });

        adapter.add("Hey human!");
    }

    private void respont(String text) {
        adapter.add(text);

    }
}
