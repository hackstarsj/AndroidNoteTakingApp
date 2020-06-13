package com.supercoders.androidnotetakingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class ViewNoteDataActivity extends AppCompatActivity {

    private String id;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.delete){
            deleteNote();
        }
        return true;
    }

    private void deleteNote() {
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("users").child(StaticUtils.getUserEmail(ViewNoteDataActivity.this)).child("noteModels").child(id);
        databaseReference.removeValue();
        startActivity(new Intent(ViewNoteDataActivity.this,MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note_data);
        id=getIntent().getStringExtra(Constants.id);
        String notetext=getIntent().getStringExtra(Constants.note_text);
        String create_time=getIntent().getStringExtra(Constants.create_time);

        TextView note_time=findViewById(R.id.create_time);
        FloatingActionButton floatingActionButton=findViewById(R.id.save);
        final EditText edittext_area=findViewById(R.id.edittext_area);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNotes(id,edittext_area.getText().toString());
            }
        });

        edittext_area.setText(notetext);
        note_time.setText(create_time);

    }

    private void saveNotes(String id,String toString) {
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("users").child(StaticUtils.getUserEmail(ViewNoteDataActivity.this)).child("noteModels");
        NoteModel noteModel=new NoteModel(id,toString,new Date().toString());
        databaseReference.child(id).setValue(noteModel);
        startActivity(new Intent(ViewNoteDataActivity.this,MainActivity.class));
    }
}