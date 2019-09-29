package com.aimheadshot.piotrekj.shopppingproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.aimheadshot.guptastationery.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Storage
{

    // ---------------Singleton pattern---------------
    /**
     * Singleton pattern - It is used when you want to eliminate the option of instantiating more than one object !!! We can use in STORAGE, SERVICE
     */

    private static Storage instance = new Storage();

    Storage() {
        //
    }

    public static Storage getInstance() {
        return instance;
    }

    // -------------------------------------------------


    private List<Shop> shops = new ArrayList<Shop>();
    private List<Product> products = new ArrayList<>();
    private List <Product> bilkaProducts = new ArrayList<>();
    private List <Product> fotexProducts = new ArrayList<>();
    private List <Product> nettoProducts = new ArrayList<>();
    private List <Product> remaProducts = new ArrayList<>();
    private List <Product> kvicklyProducts = new ArrayList<>();
    private List <Product> kiwiProducts = new ArrayList<>();
    private List <Product> NatoProducts = new ArrayList<>();
    private List <Product> p1Products = new ArrayList<>();
    private List <Product> p2Products = new ArrayList<>();
    private List <Product> p3Products = new ArrayList<>();
    private List <Product> p4Products = new ArrayList<>();
    private List <Product> p5Products = new ArrayList<>();
    private List <Product> p6Products = new ArrayList<>();

    private List <Product> shoppingBasket = new ArrayList<>();


    // ----------------- SHOP------------------------

    public List<Shop> getShops() {
        return shops;
    }

    public void setShop(Shop shop) {
        shops.add(shop);
    }

    // --------------- BILKA --------------------------

    public List<Product> getBilkaProducts() {

        return bilkaProducts;
    }

    public void addBilkaProduct(Product bilkaProduct) {

        bilkaProducts.add(bilkaProduct);
    }

    public void removeBilkaProduct(Product bilkaProduct) {

        bilkaProducts.remove(bilkaProduct);
    }

    // ----------------- FOTEX ------------------------

    public List<Product> getFotexProducts() {
            return fotexProducts;
        }

    public void setFotexProduct(Product fotexProduct) {
        fotexProducts.add(fotexProduct);
    }

    public void removeFotexProduct(Product fotexProduct) {
        fotexProducts.remove(fotexProduct);
    }

    // ----------------- NETTO ------------------------

    public List<Product> getNettoProducts() {
        return nettoProducts;
    }

    public void setNettoProduct(Product nettoProduct) {
        nettoProducts.add(nettoProduct);
    }

    public void removeNettoProduct(Product nettoProduct) {
        nettoProducts.remove(nettoProduct);
    }

    // ----------------- REMA 1000------------------------

    public List<Product> getRemaProducts() {
        return remaProducts;
    }

    public void setRemaProduct(Product remaProduct) {
        remaProducts.add(remaProduct);
    }

    public void RemoveRemaProduct(Product remaProduct) {
        remaProducts.remove(remaProduct);
    }

    // ------------------ KVICKLY -----------------------

    public List<Product> getKvicklyProducts() {
        return kvicklyProducts;
    }


    public void setKvicklyProduct(Product kvicklyProduct) {
        kvicklyProducts.add(kvicklyProduct);
    }

    public void removeKvicklyProduct(Product kvicklyProduct) {
    kvicklyProducts.remove(kvicklyProduct);
}

    // ------------------ KIWI -----------------------

    public List<Product> getKiwiProducts() {
        return kiwiProducts;
    }

    public void setKiwiProduct(Product kiwiProduct) {
        kiwiProducts.add(kiwiProduct);
    }

    public void removeKiwiProduct(Product kiwiProduct) {
        kiwiProducts.remove(kiwiProduct);
    }


    // ------------------ NATO -----------------------

    public List<Product> getNatoProducts() {
        return NatoProducts;
    }

    public void setNatoProduct(Product NatoProduct) {
        NatoProducts.add(NatoProduct);
    }

    public void removeNatoProduct(Product NatoProduct) {
        NatoProducts.remove(NatoProduct);
    }

    // ------------------ NATO -----------------------

    public List<Product> getp1Products() {
        return p1Products;
    }

    public void setp1Product(Product p1Product) {
        p1Products.add(p1Product);
    }

    public void removep1Product(Product p1Product) {
        NatoProducts.remove(p1Product);
    }

    // ------------------ NATO -----------------------

    public List<Product> getp2Products() {
        return p2Products;
    }

    public void setp2Product(Product p2Product) {
        p2Products.add(p2Product);
    }

    public void removep2Product(Product p2Product) {
        p2Products.remove(p2Product);
    }

    // ------------------ NATO -----------------------

    public List<Product> getp3Products() {
        return p3Products;
    }

    public void setp3Product(Product p3Product) {
        p3Products.add(p3Product);
    }

    public void removep3Product(Product p3Product) {
        p3Products.remove(p3Product);
    }

    // ------------------ NATO -----------------------

    public List<Product> getp4Products() {
        return p4Products;
    }

    public void setp4Product(Product p4Product) {
        p4Products.add(p4Product);
    }

    public void removep4Product(Product p4Product) {
        p4Products.remove(p4Product);
    }

    // ------------------ NATO -----------------------

    public List<Product> getp5Products() {
        return p5Products;
    }

    public void setp5Product(Product p5Product) {
        p5Products.add(p5Product);
    }

    public void removep5Product(Product p5Product) {
        p5Products.remove(p5Product);
    }

    // ------------------ NATO -----------------------

    public List<Product> getp6Products() {
        return p6Products;
    }

    public void setp6Product(Product p6Product) {
        p6Products.add(p6Product);
    }

    public void removep6Product(Product p6Product) {
        p6Products.remove(p6Product);
    }


    // ------------------ShoppingBasket---------------


    public List<Product> getShoppingBasket() {
        return shoppingBasket;
    }

    public void addToBasket(Product item) {
        shoppingBasket.add(item);
    }

    public void removeShoppingBasket(Product Basket) {
        shoppingBasket.remove(Basket);
    }

    public void clear(){
        shoppingBasket.clear();


    }


    // -------------------------------------------

    public static class BasketActivity extends AppCompatActivity {

        Service service = new Service();

        List<Product> final_order=new ArrayList<>();

        private DatabaseReference databaseReference;
        private FirebaseDatabase firebaseDatabase;
        private FirebaseUser firebaseUser;
        private FirebaseAuth firebaseAuth;
        private final String merchantKey = "hvsEBA4VxU2d32y7";
        private String paytmChecksum = null;
        // Create a tree map from the form post param
        TreeMap<String, String> paytmParams = new TreeMap<String, String>();



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.basket_activity_main);

            firebaseAuth=FirebaseAuth.getInstance();
            firebaseUser=firebaseAuth.getCurrentUser();

            firebaseDatabase=FirebaseDatabase.getInstance();
            databaseReference=firebaseDatabase.getReference().child("Orders");
            databaseReference.keepSynced(true);

            Button confirm_order_button=(Button)findViewById(R.id.confirm_order_button_id);
            confirm_order_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                  //      Toast.makeText(getApplicationContext(),"Paytm",Toast.LENGTH_LONG).show();

                    int final_price= (int) service.totalAmountFromBasket();
                    if (final_price>=500) {
                        startActivity(new Intent(BasketActivity.this, final_order_activity.class));

                    }
                    else
                    {
                        Toast.makeText(BasketActivity.this,"Minimum order amount should be greater than ₹500",Toast.LENGTH_LONG).show();
                    }

                }




            });


            ListView listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(new BasketAdapter(this, R.layout.basket_activity, service.getInstance().getShoppingBasket()));

            // show Total
            TextView t1 = (TextView) findViewById(R.id.TextViewTotal);
            t1.setText(String.valueOf(service.getInstance().totalAmountFromBasket()));
        }

        public void networkNotAvailable() {
	                  /*Display the message as below */
            Toast.makeText(getApplicationContext(), "Network connection error: Check your internet connectivity", Toast.LENGTH_LONG).show();
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.basket_menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item)
        {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.

            int id = item.getItemId();

    //        ------ Remove Button -------

            if(id == R.id.remove_id) {

                    //Toast.makeText(getApplicationContext(), "remove icon is selected", Toast.LENGTH_SHORT).show();

    //            clear Basket
                    Service.getInstance().clearBasket();

    //            clear Counter
                    Service.getInstance().clearCounter();

    //            back to MainActivity
                    Intent toMainActivity = new Intent(BasketActivity.this, MainActivity.class);
                    startActivity(toMainActivity);


    //           delete file with last basket session
                   service.getInstance().clearFile(this);

                }

    //        ------ Back Button,  previous page with products items -------


            return super.onOptionsItemSelected(item);
        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            finish();
        }
    }
}
