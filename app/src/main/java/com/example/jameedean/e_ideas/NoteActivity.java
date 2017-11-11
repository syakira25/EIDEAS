package com.example.jameedean.e_ideas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

/**
 * Created by JameeDean on 11/12/2017.
 */

public class NoteActivity extends AppCompatActivity {

    private FirebaseDatabase mDatabase;

    private EditText mETTitle;
    private EditText mETDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mDatabase = FirebaseDatabase.getInstance();

        mETTitle = (EditText) findViewById(R.id.et_title);
        mETDescription = (EditText) findViewById(R.id.et_description);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_save:
                // What to do when save
                DatabaseReference myRef = mDatabase.getReference("message");
                myRef.setValue(new Note(mETTitle.getText().toString(), mETDescription.getText().toString())).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Intent intent = new Intent(getBaseContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
