package com.aimheadshot.piotrekj.shopppingproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.aimheadshot.guptastationery.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    Service service = new Service();
    Storage storage = new Storage();
    Storage.BasketActivity basket = new Storage.BasketActivity();
    ProductListAdapter productListAdapter;
    ListView listView;
    private List<Shop> shops = storage.getInstance().getShops();
    int[] images = {R.drawable.copy,R.drawable.pen, R.drawable.colors, R.drawable.calc,R.drawable.pensil, R.drawable.box, R.drawable.files,R.drawable.glue, R.drawable.scissors,R.drawable.stapler,R.drawable.tape,R.drawable.board,R.drawable.a4};

    private FirebaseAuth firebaseAuth;


    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth=FirebaseAuth.getInstance();

        service.getInstance().initStorage();

        if(service.getInstance().getShoppingBasket().isEmpty()){

            service.getInstance().readFile(this);
            service.getInstance().retriveBasketFromLastSession();
        }


        listView = (ListView) findViewById(R.id.listView);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Shop clickedShop = shops.get(position);


                Intent intent = new Intent(MainActivity.this, ProductListActivity.class);

                if (intent.getExtras() == null) {
                    intent.putExtra("shop_name1", clickedShop.getTitle());
                    intent.putExtra("shop_name2", clickedShop.getTitle());
                    intent.putExtra("shop_name3", clickedShop.getTitle());
                    intent.putExtra("shop_name4", clickedShop.getTitle());
                    intent.putExtra("shop_name5", clickedShop.getTitle());
                    intent.putExtra("shop_name6", clickedShop.getTitle());
                    intent.putExtra("shop_name7", clickedShop.getTitle());
                    intent.putExtra("shop_name8", clickedShop.getTitle());
                    intent.putExtra("shop_name9", clickedShop.getTitle());
                    intent.putExtra("shop_name10", clickedShop.getTitle());
                    intent.putExtra("shop_name11", clickedShop.getTitle());
                    intent.putExtra("shop_name12", clickedShop.getTitle());
                    intent.putExtra("shop_name13", clickedShop.getTitle());

                    startActivity(intent); // then you start it this way


                }

        }
    });

         //set Adapter to Shops
        productListAdapter = new ProductListAdapter(this, -1, storage.getInstance().getShops(), service, images);
        listView.setAdapter(productListAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_signout){

            firebaseAuth.signOut();
            startActivity(new Intent(MainActivity.this,Login_Activity.class));
            finish();
        }
        if(item.getItemId()==R.id.basket_id_new)
        {
            Intent basket = new Intent(MainActivity.this, Storage.BasketActivity.class);
            startActivity(basket);


            System.err.println("Basket ICON Pressed !!!!!!!!!!  ");

            Service.getInstance().createBasketWithItems();


            service.getInstance().saveData(this);

        }
        return super.onOptionsItemSelected(item);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        alertDialog=new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Are you sure you want to exit ?");
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();

            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialog=alertDialog.create();
        dialog.show();
    }
}
