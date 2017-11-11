package com.example.jameedean.e_ideas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotesAdapter mAdapter;

    private final static int NOTE_ADD = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NoteActivity.class);
                startActivityForResult(intent, NOTE_ADD);
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_notes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new NotesAdapter(this);
        recyclerView.setAdapter(mAdapter);

        NoteModel note1 = new NoteModel("Hello World!", "This is a description");
        NoteModel note2 = new NoteModel("Title2", "Another description");
        NoteModel note3 = new NoteModel("Title3", "Again another description");

        mAdapter.addData(note1);
        mAdapter.addData(note2);
        mAdapter.addData(note3);
    }
}
