package com.example.my1stapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class UserActivity extends AppCompatActivity {
    Button btnLogOut;
    Button addPost;
    Button bookslist;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        btnLogOut = (Button) findViewById(R.id.btnLogOut);
        addPost = (Button) findViewById(R.id.b1);
        bookslist = (Button) findViewById(R.id.button);

        bookslist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movetobookslist();
            }
        });

        addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToaddPost();
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(UserActivity.this, ActivityLogin.class);
                startActivity(I);
                Log.e("TAG", "Message");

            }
        });

    }

private void moveToaddPost(){
        Intent intent = new Intent (UserActivity.this, test.class);
startActivity(intent);


}


   private void movetobookslist(){
        Intent intent = new Intent(UserActivity.this, BooksList.class);
        startActivity(intent);

   }

}
