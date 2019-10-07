package com.example.my1stapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class test extends AppCompatActivity {


    EditText materialname, coursename, uniname,description, IBAN, owner,bankname, price;
    Button buttonDone;
    Spinner spinner;
    DatabaseReference db;
ImageView home;
    ImageButton logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        db = FirebaseDatabase.getInstance().getReference("posts");
       IBAN = (EditText) findViewById(R.id.IBAN);
        materialname = (EditText) findViewById(R.id.materialname);
        coursename = (EditText) findViewById(R.id.coursename);
        uniname = (EditText) findViewById(R.id.uniname);
        owner = (EditText) findViewById(R.id.owner);
        bankname = (EditText) findViewById(R.id.bankname);
        price = (EditText) findViewById(R.id.price);
        description = (EditText) findViewById(R.id.description);
home = (ImageView) findViewById(R.id.home);
        spinner = (Spinner) findViewById(R.id.spinner);
        buttonDone = (Button) findViewById(R.id.button6);
logout=(ImageButton) findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(test.this, ActivityLogin.class);
                startActivity(I);
                Log.e("TAG", "Message");
            }
        });


home.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        moveToHome();
    }
});
buttonDone.setOnClickListener(new View.OnClickListener(){

    @Override
    public void onClick(View v) {
        addPost();

    }
} );






    }


public void addPost(){
        String materialname1= materialname.getText().toString().trim();
    String coursename1= coursename.getText().toString().trim();
    String uniname1= uniname.getText().toString().trim();
    String description1= description.getText().toString().trim();
    String price1= price.getText().toString().trim();
    String owner1= owner.getText().toString().trim();
    String bankname1= bankname.getText().toString().trim();
    String IBAN1= IBAN.getText().toString().trim();
    String spinner1= spinner.getSelectedItem().toString().trim();






    if(!TextUtils.isEmpty(materialname1) &&
            !TextUtils.isEmpty(coursename1) && !TextUtils.isEmpty(uniname1) &&
            !TextUtils.isEmpty(price1) && !TextUtils.isEmpty(spinner1) && !TextUtils.isEmpty(IBAN1) && !TextUtils.isEmpty(bankname1) && !TextUtils.isEmpty(owner1) && !TextUtils.isEmpty(description1) )
    {
        String id=   db.push().getKey();
        Post post = new Post(id,materialname1,coursename1,uniname1,spinner1,price1,IBAN1,bankname1,owner1,description1);
        db.child(id).setValue(post);
        Toast.makeText(this,"Done", Toast.LENGTH_LONG).show();
    }else{
        Toast.makeText(this,"please make sure all information are entered",Toast.LENGTH_LONG).show();

    }

}






    public void moveToHome(){

        Intent intent = new Intent(test.this, UserActivity.class);
        startActivity(intent);
    }


}
