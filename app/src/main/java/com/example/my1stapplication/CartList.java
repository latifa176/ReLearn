package com.example.my1stapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CartList extends Activity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseReference = database.getReference();
    private ArrayList<ModelProducts> cartcollect;
    private float totalcost=0;
    private int totalproducts=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_activity);
        TextView cartList=(TextView)findViewById(R.id.list) ;
        TextView showCartContent = (TextView) findViewById(R.id.showCart);
        final Button thirdBtn = (Button) findViewById(R.id.cartBtn);

        //Get Global Controller Class object (see application tag in AndroidManifest.xml)
        Controller aController = (Controller) this.getApplicationContext();

        // Get Cart Size
        final int cartSize = aController.getCart().getCartSize();

        String showString = "";
        final String itemName = getIntent().getStringExtra("itemName");
        final String itemPrice = getIntent().getStringExtra("itemPrice");
        final String uni = getIntent().getStringExtra("uni");
        final String coursename = getIntent().getStringExtra("coursename");
/******** Show Cart Products on screen - Start ********/

        if(itemName!=null)
        {
            cartList.setText(itemName+", Price:"+itemPrice);
            /*final FirebaseRecyclerAdapter<ModelProducts,MovieViewHolder> adapter = new FirebaseRecyclerAdapter<SingleProductModel, MovieViewHolder>(
                    SingleProductModel.class,
                    R.layout.cart_item_layout,
                    MovieViewHolder.class,
                    //referencing the node where we want the database to store the data from our Object
                    mDatabaseReference.child("cart").child(mobile).getRef()
            ) {
                @Override
                protected void populateViewHolder(final MovieViewHolder viewHolder, final SingleProductModel model, final int position) {
                    if(tv_no_item.getVisibility()== View.VISIBLE){
                        tv_no_item.setVisibility(View.GONE);
                    }
                    viewHolder.cardname.setText(model.getPrname());
                    viewHolder.cardprice.setText("₹ "+model.getPrprice());
                    viewHolder.cardcount.setText("Quantity : "+model.getNo_of_items());
                    Picasso.with(Cart.this).load(model.getPrimage()).into(viewHolder.cardimage);

                    totalcost += model.getNo_of_items()*Float.parseFloat(model.getPrprice());
                    totalproducts += model.getNo_of_items();
                    cartcollect.add(model);

                    viewHolder.carddelete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(Cart.this,getItem(position).getPrname(),Toast.LENGTH_SHORT).show();
                            getRef(position).removeValue();
                            session.decreaseCartValue();
                            startActivity(new Intent(Cart.this,Cart.class));
                            finish();
                        }
                    });
                }
            };
            mRecyclerView.setAdapter(adapter);*/
        }
        else {
            cartList.setText(" Shopping cart is empty.");
            thirdBtn.setVisibility(View.INVISIBLE);
        }
        // showCartContent.setText(showString);

/******** Show Cart Products on screen - End ********/

        thirdBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if(cartSize >0)
                {
                    Intent i = new Intent(getBaseContext(), ThirdScreen.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(),
                            "Shopping cart is empty.",
                            Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }
}
