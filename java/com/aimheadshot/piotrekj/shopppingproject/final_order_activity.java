package com.aimheadshot.piotrekj.shopppingproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aimheadshot.guptastationery.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class final_order_activity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText addressEditText;
    private EditText cityEditText;
    private EditText phoneEditText;
    private Button finalConfirmButton;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;

    private AlertDialog.Builder alertDialog;

    Service service = new Service();

    List<Product> final_order=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_order_activity);
        nameEditText=(EditText)findViewById(R.id.name_edit_text_id);
        addressEditText=(EditText)findViewById(R.id.address_edit_text_id);
        cityEditText=(EditText)findViewById(R.id.city_edit_text_id);
        phoneEditText=(EditText)findViewById(R.id.phone_no_edit_text_id);
        finalConfirmButton=(Button)findViewById(R.id.final_confirm_button_id);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("Orders");
        databaseReference.keepSynced(true);

        finalConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Order Successful !!!",Toast.LENGTH_LONG).show();
                final String name=nameEditText.getText().toString().trim();
                final String add=addressEditText.getText().toString().trim();
                final String city=cityEditText.getText().toString().trim();
                final String phoneno=phoneEditText.getText().toString().trim();

                if(!TextUtils.isEmpty(name)&& !TextUtils.isEmpty(add) && !TextUtils.isEmpty(city)&& !TextUtils.isEmpty(phoneno)){

                    Map<String,String> cust_data=new HashMap<>();
                    cust_data.put("cust_name",name);
                    cust_data.put("cust_add",add);
                    cust_data.put("cust_city",city);
                    cust_data.put("cust_phoneno",phoneno);

                    final_order=service.getShoppingBasket();
                    Log.d("final order", String.valueOf(final_order));


                        String userid = firebaseAuth.getCurrentUser().getUid();
                        DatabaseReference currenUserDb = databaseReference.child(userid);

                        currenUserDb.child("order").setValue(final_order);
                        currenUserDb.child("cust_details").setValue(cust_data);
                        alertDialog=new AlertDialog.Builder(final_order_activity.this);
                        alertDialog.setTitle("Order Placed!!");
                        alertDialog.setMessage("Your order is placed successfully and will be delivered to you shortly.");
                        alertDialog.setCancelable(false);
                        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                              dialog.cancel();
                              startActivity(new Intent(final_order_activity.this,MainActivity.class));
                              finish();
                            }
                        });
                    AlertDialog dialog=alertDialog.create();
                    dialog.show();
                    }

                else{

                    Toast.makeText(getApplicationContext(),"Fill all the fields",Toast.LENGTH_LONG).show();

                }



            }
        });
    }
}
