package com.example.my1stapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
public class BooksList extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
List<Post> postslist;
DatabaseReference db;
    ListView listViewPosts;
ImageView home;
ImageButton logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

db= FirebaseDatabase.getInstance().getReference("posts");

        listViewPosts = (ListView) findViewById(R.id.listViewPosts);
        home = (ImageView) findViewById(R.id.home);
        logout=(ImageButton) findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(BooksList.this, ActivityLogin.class);
                startActivity(I);
                Log.e("TAG", "Message");
            }
        });
postslist= new ArrayList<>();

home.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        moveToHome();
    }
});
    }

    public void moveToHome(){

        Intent intent = new Intent(BooksList.this, UserActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                postslist.clear();

                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    Post post = postSnapshot.getValue(Post.class);

postslist.add(post);
                }


                postsList adapter= new postsList(BooksList.this, postslist );
          listViewPosts.setAdapter(adapter);
          listViewPosts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view,
                                      int position, long id) {
                  Intent intent = new Intent(BooksList.this, datailscart.class);
                  intent.putExtra("itemName",postslist.get(position).getMaterialname());
                  intent.putExtra("itemPrice",postslist.get(position).getPrice());
                  intent.putExtra("uni",postslist.get(position).getUniname());
                  intent.putExtra("coursename",postslist.get(position).getCoursename());
                  startActivity(intent);
                  /*ModelProducts product = (ModelProducts) getIntent().g("product");
                  Intent intent = new Intent(BooksList.this, datailscart.class);
                  Bundle bundle = new Bundle();
                  bundle.putSerializable("product", product);
                  Log.d("TAG", "View product: " + product.getProductName());
                  intent.putExtras(bundle);
                  startActivity(intent);*/
              }
          });


            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
