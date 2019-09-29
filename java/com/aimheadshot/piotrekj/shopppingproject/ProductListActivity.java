  package com.aimheadshot.piotrekj.shopppingproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.aimheadshot.guptastationery.R;

import java.util.ArrayList;
import java.util.List;


public class ProductListActivity extends AppCompatActivity {

    ListView listView;
    ProductAdapter productAdapter;
    private Service service = new Service();
    int[][] productImages = {{R.drawable.yuva, R.drawable.classmate, R.drawable.classmamtemed, R.drawable.classmatelarge, R.drawable.rough_copy},
                             {R.drawable.reynolds_racer, R.drawable.trimax, R.drawable.papersoft, R.drawable.butterflow, R.drawable.cardin},
                             {R.drawable.wax_color, R.drawable.small_sketch, R.drawable.big_sketch, R.drawable.pencilcolourmed, R.drawable.pencil_color_large},
                             {R.drawable.oreva, R.drawable.orpat, R.drawable.casio_med, R.drawable.casio_14},
                             {R.drawable.apsaragold, R.drawable.apsaramatt, R.drawable.domspensil, R.drawable.natrajeraser,R.drawable.apsaranondust},
                             {R.drawable.matrajbox, R.drawable.domsbox, R.drawable.classmatebox,R.drawable.pencilbox},
                             {R.drawable.flatfile, R.drawable.springclipfile, R.drawable.springfilelarge,R.drawable.izenfile,R.drawable.leaverarchfile},
                             {R.drawable.sayasmall, R.drawable.sayamedium, R.drawable.sayalarge},
                             {R.drawable.fevicol25, R.drawable.fevigum5, R.drawable.fevigum},
                             {R.drawable.staplerno10, R.drawable.stapler26, R.drawable.pinno10,R.drawable.pin26},
                             {R.drawable.samlltape, R.drawable.browntapemed, R.drawable.browntapelarge},
                             {R.drawable.simpleboard, R.drawable.navneetboard, R.drawable.yuvaboard},
                             {R.drawable.a4packet}};

    private static Context mContext;

    public static Context getContext() {

        return mContext;
    }

    public void setContext(Context mContext) {

        this.mContext = this.getApplicationContext();
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        service.getInstance().initStorage();

        listView = (ListView) findViewById(R.id.listView);

        List<Product> products = new ArrayList<>();


        if(getIntent().getExtras() != null) {
            if (getIntent().getExtras().getString("shop_name1").equals("Copy")) {
                products = service.getInstance().getBilkaProducts();
            } else if (getIntent().getExtras().getString("shop_name2").equals("Pens")) {
                products = service.getInstance().getFotexProducts();
            } else if (getIntent().getExtras().getString("shop_name3").equals("Colors")) {
                products = service.getInstance().getNettoProducts();
            } else if (getIntent().getExtras().getString("shop_name4").equals("Calculator")) {
                products = service.getInstance().getRemaProducts();
            } else if (getIntent().getExtras().getString("shop_name5").equals("Pencil & Eraser")) {
                products = service.getInstance().getKvicklyProducts();
            } else if (getIntent().getExtras().getString("shop_name6").equals("Instrument Box")) {
                products = service.getInstance().getKiwiProducts();

            }else if (getIntent().getExtras().getString("shop_name7").equals("Files")) {
                products = service.getInstance().getNatoProducts();

            }else if (getIntent().getExtras().getString("shop_name8").equals("Glue")) {
                products = service.getInstance().getp1Products();

            }else if (getIntent().getExtras().getString("shop_name9").equals("Scissors")) {
                products = service.getInstance().getp2Products();

            }else if (getIntent().getExtras().getString("shop_name10").equals("Stapler")) {
                products = service.getInstance().getp3Products();

            }else if (getIntent().getExtras().getString("shop_name11").equals("Cello Tapes")) {
                products = service.getInstance().getp4Products();

            }else if (getIntent().getExtras().getString("shop_name12").equals("Exam Boards")) {
                products = service.getInstance().getp5Products();

            }else if (getIntent().getExtras().getString("shop_name13").equals("A4 Papers")) {
                products = service.getInstance().getp6Products();

            }
        }

        productAdapter = new ProductAdapter(this, -1, products , service, productImages);

        listView.setAdapter(productAdapter);
        productAdapter.notifyDataSetChanged();
        listView.invalidateViews();
        listView.refreshDrawableState();
    }



    // -----------   BAR ACTIONS  ,  METHODS ---------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        //    ---------     Busket Bar ICON  --------------
        // be iF statment poniewaz mamy tylko jeden button na BAR

        Intent basket = new Intent(ProductListActivity.this, Storage.BasketActivity.class);
            startActivity(basket);


        System.err.println("Basket ICON Pressed !!!!!!!!!!  ");

            Service.getInstance().createBasketWithItems();


            service.getInstance().saveData(this);



        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
