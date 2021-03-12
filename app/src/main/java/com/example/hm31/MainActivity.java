package com.example.hm31;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Model> list = new ArrayList<>();
    private MainAdapter adapter;
    private EditText edText;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.skview);
        edText = findViewById(R.id.etText);
        btn = findViewById(R.id.btnSave);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter(list, this);
        recyclerView.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(new Model(edText.getText().toString()));
                adapter.notifyDataSetChanged();
            }
        });

    }
}