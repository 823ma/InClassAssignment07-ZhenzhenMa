package com.example.seanma.topsecret;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void save(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        EditText user = (EditText) findViewById(R.id.name);

        String username = user.getText().toString();
        // DatabaseReference myRef = database.getReference("Cathy").child("secret");

        DatabaseReference myRef = database.getReference(username).child("secret");

        EditText editText = (EditText) findViewById(R.id.editText);
        String userSecret = editText.getText().toString();
        myRef.setValue(userSecret);

    }

    public void reveal(View view) {
        Intent intent = new Intent (this, SecondActivity.class);
        EditText target =(EditText) findViewById(R.id.target);
        intent.putExtra("target", target.getText(). toString());

        startActivity(intent);

    }
}
