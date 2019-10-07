package com.example.my1stapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class postsList extends ArrayAdapter<Post> {

private Activity context;
private List<Post> postslist;



public postsList(Activity context, List<Post> postslist){
super(context, R.layout.bookslistlayout, postslist );
this.context=context;
this.postslist=postslist;
}


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listviewitem= inflater.inflate(R.layout.bookslistlayout,null, true);
        TextView materialname1 = (TextView) listviewitem.findViewById(R.id.materialname);
        TextView coursename1 = (TextView) listviewitem.findViewById(R.id.coursename);
        TextView uniname1 = (TextView) listviewitem.findViewById(R.id.uniname);
        TextView price1 = (TextView) listviewitem.findViewById(R.id.price);

        Post post = postslist.get(position);

        materialname1.setText(post.getMaterialname());
        coursename1.setText(post.getCoursename());
        uniname1.setText(post.getUniname());
        price1.setText(post.getPrice());

        return listviewitem;
    }
}
