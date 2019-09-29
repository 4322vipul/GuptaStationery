package com.aimheadshot.piotrekj.shopppingproject;

import android.content.Context;
import android.widget.Toast;

import com.aimheadshot.guptastationery.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;


public class Service {

    private boolean InitUsed = false;

    ArrayList<Product> fileproducts = new ArrayList<Product>();

    public ArrayList<Product> getFileproducts() {
        return fileproducts;
    }

    public void setFileproducts(ArrayList<Product> fileproducts) {
        this.fileproducts = fileproducts;
    }

    public Context productListActivity = null;

    public ProductListActivity  productList;


    // ---------------Singleton pattern--------------------------
    /**
     * Singleton pattern - It is used when you want to eliminate the option of instantiating more than one object !!! We can use in STORAGE, SERVICE
     */

    private static Service instance = new Service();

    Service() {
        //
    }

    public static Service getInstance() {
        return instance;
    }

    // ------------------------------------------------------------

    // -------------  Shop functionality  ------------------------

    public Shop createShop(String title, String description, int id) {
        Shop s = new Shop(title, description, id);
        Storage.getInstance().setShop(s);
        return s;
    }

    // ------------------------------------------------------------

    // -------------  BILKA functionality  ------------------------


    public List<Product> getBilkaProducts() {

        return Storage.getInstance().getBilkaProducts();
    }

    public Product createBilkaProduct(String name, int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().addBilkaProduct(pr);
        return pr;
    }

    public Product removeBilkaProduct(String name, int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().removeBilkaProduct(pr);
        return pr;
    }

    // ------------------------------------------------------------


    // -------------- FOTEX functionality ------------------------


    public List<Product> getFotexProducts() {

        return Storage.getInstance().getFotexProducts();
    }

    public Product createFotexProduct(String name, int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().setFotexProduct(pr);
        return pr;
    }

    public Product removeFotexProduct(String name,int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().removeFotexProduct(pr);
        return pr;
    }

    // ------------------------------------------------------------


    // -------------- NETTO functionality -------------------------

    public List<Product> getNettoProducts() {

        return Storage.getInstance().getNettoProducts();
    }


    public Product createNettoProduct(String name, int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().setNettoProduct(pr);
        return pr;
    }

    public Product removeNettoProduct(String name, int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().removeNettoProduct(pr);
        return pr;
    }

    // ------------------------------------------------------------


    // -------------- REMA 1000 functionality -------------------------

    public List<Product> getRemaProducts() {

        return Storage.getInstance().getRemaProducts();
    }

    public Product createRemaProduct(String name, int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().setRemaProduct(pr);
        return pr;
    }

    public Product removeRemaProduct(String name, int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().RemoveRemaProduct(pr);
        return pr;
    }

    // ------------------------------------------------------------


    // -------------- KVICKLY functionality -------------------------

    public List<Product> getKvicklyProducts() {

        return Storage.getInstance().getKvicklyProducts();
    }

    public Product createKvicklyProduct(String name,int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().setKvicklyProduct(pr);
        return pr;
    }

    public Product removeKvicklyProduct(String name,int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().removeKvicklyProduct(pr);
        return pr;
    }

    // ------------------------------------------------------------


    // -------------- KIWI functionality -------------------------

    public List<Product> getKiwiProducts() {

        return Storage.getInstance().getKiwiProducts();
    }

    public Product createKiwiProduct(String name,int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().setKiwiProduct(pr);
        return pr;
    }

    public Product removeKiwiProduct(String name, int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().removeKiwiProduct(pr);
        return pr;
    }
    // -------------- Nato functionality -------------------------

    public List<Product> getNatoProducts() {

        return Storage.getInstance().getNatoProducts();
    }

    public Product createNatoProduct(String name, int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().setNatoProduct(pr);
        return pr;
    }

    public Product removeNatoProduct(String name,int shopsPrice, int id) {
        Product pr = new Product(name,shopsPrice, id);
        Storage.getInstance().removeNatoProduct(pr);
        return pr;
    }

    // -------------- p1 functionality -------------------------

    public List<Product> getp1Products() {

        return Storage.getInstance().getp1Products();
    }

    public Product createp1Product(String name, int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().setp1Product(pr);
        return pr;
    }

    public Product removep1Product(String name,int shopsPrice, int id) {
        Product pr = new Product(name,shopsPrice, id);
        Storage.getInstance().removep1Product(pr);
        return pr;
    }

    // -------------- p2 functionality -------------------------

    public List<Product> getp2Products() {

        return Storage.getInstance().getp2Products();
    }

    public Product createp2Product(String name, int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().setp2Product(pr);
        return pr;
    }

    public Product removep2Product(String name,int shopsPrice, int id) {
        Product pr = new Product(name,shopsPrice, id);
        Storage.getInstance().removep2Product(pr);
        return pr;
    }

    // -------------- p3 functionality -------------------------

    public List<Product> getp3Products() {

        return Storage.getInstance().getp3Products();
    }

    public Product createp3Product(String name, int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().setp3Product(pr);
        return pr;
    }

    public Product removep3Product(String name,int shopsPrice, int id) {
        Product pr = new Product(name,shopsPrice, id);
        Storage.getInstance().removep3Product(pr);
        return pr;
    }

    // -------------- p4 functionality -------------------------

    public List<Product> getp4Products() {

        return Storage.getInstance().getp4Products();
    }

    public Product createp4Product(String name, int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().setp4Product(pr);
        return pr;
    }

    public Product removep4Product(String name,int shopsPrice, int id) {
        Product pr = new Product(name,shopsPrice, id);
        Storage.getInstance().removep4Product(pr);
        return pr;
    }

    // -------------- p5 functionality -------------------------

    public List<Product> getp5Products() {

        return Storage.getInstance().getp5Products();
    }

    public Product createp5Product(String name, int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().setp5Product(pr);
        return pr;
    }

    public Product removep5Product(String name,int shopsPrice, int id) {
        Product pr = new Product(name,shopsPrice, id);
        Storage.getInstance().removep5Product(pr);
        return pr;
    }

    // -------------- p6 functionality -------------------------

    public List<Product> getp6Products() {

        return Storage.getInstance().getp6Products();
    }

    public Product createp6Product(String name, int shopsPrice, int id) {
        Product pr = new Product(name, shopsPrice, id);
        Storage.getInstance().setp6Product(pr);
        return pr;
    }

    public Product removep6Product(String name,int shopsPrice, int id) {
        Product pr = new Product(name,shopsPrice, id);
        Storage.getInstance().removep6Product(pr);
        return pr;
    }

    // -------------- ShoppingBasket -------------------------

    public List<Product> getShoppingBasket() {
        return Storage.getInstance().getShoppingBasket();
    }

    public void clearBasket() {

        Storage.getInstance().clear();
    }

    // -------------- Clear counter from produckt items -------------------------

    public void clearCounter() {


        for (Product i : Service.getInstance().getFotexProducts()) {
            if (i.getCounter() > 0) {
                i.setCounter(0);
            }
        }
        ;

        for (Product i : Service.getInstance().getBilkaProducts()) {
            if (i.getCounter() > 0) {
                i.setCounter(0);
            }
        }
        ;

        for (Product i : Service.getInstance().getNettoProducts()) {
            if (i.getCounter() > 0) {
                i.setCounter(0);
            }
        }
        ;

        for (Product i : Service.getInstance().getKiwiProducts()) {
            if (i.getCounter() > 0) {
                i.setCounter(0);
            }
        }
        ;

        for (Product i : Service.getInstance().getKvicklyProducts()) {
            if (i.getCounter() > 0) {
                i.setCounter(0);
            }
        }
        ;

        for (Product i : Service.getInstance().getRemaProducts()) {
            if (i.getCounter() > 0) {

                i.setCounter(0);
            }
        }
        ;
        for (Product i : Service.getInstance().getNatoProducts()) {
            if (i.getCounter() > 0) {

                i.setCounter(0);
            }
        }
        for (Product i : Service.getInstance().getp1Products()) {
            if (i.getCounter() > 0) {

                i.setCounter(0);
            }
        }
        for (Product i : Service.getInstance().getp2Products()) {
            if (i.getCounter() > 0) {

                i.setCounter(0);
            }
        }
        for (Product i : Service.getInstance().getp3Products()) {
            if (i.getCounter() > 0) {

                i.setCounter(0);
            }
        }
        for (Product i : Service.getInstance().getp4Products()) {
            if (i.getCounter() > 0) {

                i.setCounter(0);
            }
        }
        for (Product i : Service.getInstance().getp5Products()) {
            if (i.getCounter() > 0) {

                i.setCounter(0);
            }
        }
        for (Product i : Service.getInstance().getp6Products()) {
            if (i.getCounter() > 0) {

                i.setCounter(0);
            }
        }
    }


    // -------------- create Basket With Items -------------------------

    public void createBasketWithItems() {



        Storage.getInstance().clear();


        for (Product i : Service.getInstance().getFileproducts()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);
            }
        }


        for (Product i : Service.getInstance().getFotexProducts()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        ;

        for (Product i : Service.getInstance().getBilkaProducts()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        ;

        for (Product i : Service.getInstance().getNettoProducts()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        ;

        for (Product i : Service.getInstance().getKiwiProducts()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        ;

        for (Product i : Service.getInstance().getKvicklyProducts()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        ;

        for (Product i : Service.getInstance().getRemaProducts()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        for (Product i : Service.getInstance().getNatoProducts()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        for (Product i : Service.getInstance().getp1Products()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        for (Product i : Service.getInstance().getp2Products()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        for (Product i : Service.getInstance().getp3Products()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        for (Product i : Service.getInstance().getp4Products()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        for (Product i : Service.getInstance().getp5Products()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }
        for (Product i : Service.getInstance().getp6Products()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);

            }
        }

    }

    // ----------  TOTAL Amount from basket ------------

    public double totalAmountFromBasket() {

        double total = 0;

        for (Product i : Service.getInstance().getShoppingBasket()) {
            total = (i.getShopsPrice() * i.getCounter()) + total;
        }

        return total;
    }

    public double totalPriceForProduct(Product pr) {
        double total = 0;

        total = pr.getShopsPrice() * pr.getCounter();


        return total;
    }


    // -------------- Update Counter  -------------------------

    public void updateProductCounterIncrease(Product pr) {

        pr.setCounter(pr.getCounter() + 1);

    }

    public void updateProductCounterDecrease(Product pr) {

        if (pr.getCounter() > 0) {
            pr.setCounter((pr.getCounter() - 1));
        }

    }


    public int getCounter(Product pr) {

        return pr.getCounter();
    }

//    -----------  SAVE ----------------

    public static void saveData(Context context) {

         //  create file
//       " Windows = \ " " *nix or Mac = / " - separator
        File directory = new File(context.getFilesDir().getAbsolutePath() + File.separator);

        if (!directory.exists()) {
//         mkdirs -    creates the directory named by this abstract pathname, including necessary and non-existent parent directories.
            directory.mkdirs();
        }

        String filename = "myfile.txt";

        try {

            FileOutputStream outputStream = new FileOutputStream(directory + File.separator + filename);
            ObjectOutputStream out = new ObjectOutputStream(outputStream);

            out.writeObject(Service.getInstance().getShoppingBasket());
            out.close();


        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


     //   Toast.makeText(context, "Basket Saved: " + context.getFilesDir(), Toast.LENGTH_SHORT).show();
        System.out.println("Basket saved -----------------------------------------");

    }


// ------------ READ -----------------

    public void readFile(Context context) {

        String filename = "myfile.txt";

        File directory = new File(context.getFilesDir().getAbsolutePath() + File.separator);

        try {

            FileInputStream inputStream = new FileInputStream(directory + File.separator + filename);
            ObjectInputStream input = new ObjectInputStream(inputStream);

            fileproducts = (ArrayList<Product>) input.readObject();

        //    Toast.makeText(context, "Basked was read from last ++ Session ++ ", Toast.LENGTH_SHORT).show();

            input.close();
            inputStream.close();


        }
        catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

//    --------- Clear File -----------
    public void clearFile (Context context){

        File directory = new File(context.getFilesDir().getAbsolutePath() + File.separator);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filename = "myfile.txt";

        try {

            FileOutputStream outputStream = new FileOutputStream(directory + File.separator + filename);
            ObjectOutputStream out = new ObjectOutputStream(outputStream);

            out.writeObject(Service.getInstance().getShoppingBasket());
            out.close();

            Toast.makeText(context, "Basked was Deleted", Toast.LENGTH_SHORT).show();


        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
// ------------ Retrieve data from last session -----------------



    public void retriveBasketFromLastSession() {


        for (Product i : Service.getInstance().getFileproducts()) {
            if (i.getCounter() > 0) {
                Storage.getInstance().addToBasket(i);
            }
        }
    }


    // ----------------- Initializing the Storage in MainActivity ----------------

    public void initStorage() {

        if (InitUsed == false) {

            InitUsed = true;

            // ------------- List of shops ----------------------------------
            Service.getInstance().createShop("Copy", "Variety of copies", R.drawable.copy);
            Service.getInstance().createShop("Pens", "Wide range of pens", R.drawable.pen);
            Service.getInstance().createShop("Colors", "Different types of colors", R.drawable.colors);
            Service.getInstance().createShop("Calculator", "Different sizes available", R.drawable.calc);
            Service.getInstance().createShop("Pencil & Eraser", "All types of pencils", R.drawable.pensil);
            Service.getInstance().createShop("Instrument Box", "Wide range of boxes", R.drawable.box);
            Service.getInstance().createShop("Files", "All types available", R.drawable.files);
            Service.getInstance().createShop("Glue", "Different glues", R.drawable.glue);
            Service.getInstance().createShop("Scissors", "From small to big available", R.drawable.scissors);
            Service.getInstance().createShop("Stapler", "Different sizes", R.drawable.stapler);
            Service.getInstance().createShop("Cello Tapes", "Different sizes and colors", R.drawable.tape);
            Service.getInstance().createShop("Exam Boards", "Different designs and graphics", R.drawable.board);
            Service.getInstance().createShop("A4 Papers", "Different qualities available", R.drawable.a4);

            // ------------- BILKA produckts ----------------------------------
            Service.getInstance().createBilkaProduct("Navneet YUVA", 35, R.drawable.yuva);
            Service.getInstance().createBilkaProduct("Classmate", 35, R.drawable.classmate);
            Service.getInstance().createBilkaProduct("Classmate(long)", 50, R.drawable.classmamtemed);
            Service.getInstance().createBilkaProduct("Classmate(long)", 90, R.drawable.classmatelarge);
            Service.getInstance().createBilkaProduct("Rough copy", 25, R.drawable.rough_copy);

            // ------------- Fotex produckts ----------------------------------
            Service.getInstance().createFotexProduct("Reynolds Racer Gel",  10, R.drawable.reynolds_racer);
            Service.getInstance().createFotexProduct("Reynolds Tri-max", 50, R.drawable.trimax);
            Service.getInstance().createFotexProduct("Cello Paper soft",20, R.drawable.papersoft);
            Service.getInstance().createFotexProduct("Butter flow", 15, R.drawable.butterflow);
            Service.getInstance().createFotexProduct("Pierre Cardin", 300, R.drawable.cardin);

            // ------------- NETTO produckts ----------------------------------
            Service.getInstance().createNettoProduct("Wax Color(medium)", 25, R.drawable.wax_color);
            Service.getInstance().createNettoProduct("Sketch Pen(small)", 10, R.drawable.small_sketch);
            Service.getInstance().createNettoProduct("Sketch Pen(big)", 28, R.drawable.big_sketch);
            Service.getInstance().createNettoProduct("Pencil Color(medium)", 25, R.drawable.pencilcolourmed);
            Service.getInstance().createNettoProduct("Pencil Color(large)", 45, R.drawable.pencil_color_large);

            // ------------- Rema produckts ----------------------------------
            Service.getInstance().createRemaProduct("OREVA", 220, R.drawable.oreva);
            Service.getInstance().createRemaProduct("ORPAT", 270, R.drawable.orpat);
            Service.getInstance().createRemaProduct("Casio(medium)", 425, R.drawable.casio_med);
            Service.getInstance().createRemaProduct("Casio(14 digit)", 870, R.drawable.casio_14);

            // ------------- Kvickly produckts ----------------------------------
            Service.getInstance().createKvicklyProduct("Apsara Gold(Pkt)", 35, R.drawable.apsaragold);
            Service.getInstance().createKvicklyProduct("Apsara Matt magic", 42, R.drawable.apsaramatt);
            Service.getInstance().createKvicklyProduct("Doms", 32, R.drawable.domspensil);
            Service.getInstance().createKvicklyProduct("Eraser Natraj", 18, R.drawable.natrajeraser);
            Service.getInstance().createKvicklyProduct("Apsara nondust", 52, R.drawable.apsaranondust);

            // ------------- Kiwi produckts ----------------------------------
            Service.getInstance().createKiwiProduct("Natraj", 36, R.drawable.matrajbox);
            Service.getInstance().createKiwiProduct("Doms Box", 70, R.drawable.domsbox);
            Service.getInstance().createKiwiProduct("Classmate Box", 250, R.drawable.classmatebox);
            Service.getInstance().createKiwiProduct("Box",50, R.drawable.pencilbox);

            //---------------Nato--------------------------
            Service.getInstance().createNatoProduct("Flat file", 20, R.drawable.flatfile);
            Service.getInstance().createNatoProduct("Spring clip file", 20, R.drawable.springclipfile);
            Service.getInstance().createNatoProduct("Spring clip file", 35, R.drawable.springfilelarge);
            Service.getInstance().createNatoProduct("Ring file Izen", 78, R.drawable.izenfile);
            Service.getInstance().createNatoProduct("Leaver arch file", 96, R.drawable.leaverarchfile);



            //---------------p2--------------------------
            Service.getInstance().createp1Product("Fevicol 25g", 10, R.drawable.fevicol25);
            Service.getInstance().createp1Product("Fevigum", 5, R.drawable.fevigum5);
            Service.getInstance().createp1Product("Fevigum 25g", 10, R.drawable.fevigum);

            //---------------p1--------------------------
            Service.getInstance().createp2Product("Saya small", 25, R.drawable.sayasmall);
            Service.getInstance().createp2Product("Saya medium", 60, R.drawable.sayamedium);
            Service.getInstance().createp2Product("Saya big", 70, R.drawable.sayalarge);

            //---------------p3--------------------------
            Service.getInstance().createp3Product("Stapler No.10", 42, R.drawable.staplerno10);
            Service.getInstance().createp3Product("Stapler 24/6", 92, R.drawable.stapler26);
            Service.getInstance().createp3Product("Pin No.10", 7, R.drawable.pinno10);
            Service.getInstance().createp3Product("Pin 24/6", 15, R.drawable.pin26);

            //---------------p4--------------------------
            Service.getInstance().createp4Product("Small(transparent)", 5, R.drawable.samlltape);
            Service.getInstance().createp4Product("Brown tape(Med)", 16, R.drawable.browntapemed);
            Service.getInstance().createp4Product("Brown tape(big)", 30, R.drawable.browntapelarge);

            //---------------p5--------------------------
            Service.getInstance().createp5Product("Simple board", 20, R.drawable.simpleboard);
            Service.getInstance().createp5Product("Navneet Boss", 65, R.drawable.navneetboard);
            Service.getInstance().createp5Product("Yuva", 75, R.drawable.yuvaboard);

            //---------------p6--------------------------
            Service.getInstance().createp6Product("A4 SPB(Pkt)", 200, R.drawable.a4packet);

//            JSON ARRAY


            JSONArray products_JSON = new JSONArray();

            JSONObject objectBilka = new JSONObject();
            try {
                objectBilka.put("Bilka", Service.getInstance().getBilkaProducts().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            products_JSON.put(objectBilka);


            JSONObject objectFotex = new JSONObject();
            try {
                objectFotex.put("Fotex", Service.getInstance().getFotexProducts().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            products_JSON.put(objectFotex);

//          print out the JSON ARRAY :-)

            System.out.println(products_JSON.toString());






        }

////    -----------  SAVE ----------------
//
//        public void saveData(Context context) throws IOException {
//
//            productListActivity = context;
//
////       create file
////        File file = new File(getFilesDir(),"file.txt");
//
//            String filename = "myfile.txt";
//            String string = Storage.getInstance().getShoppingBasket().toString();
////
//            FileOutputStream outputStream = context.openFileOutput(filename, context.MODE_PRIVATE);
//            outputStream.write(string.getBytes());
//            outputStream.close();
//
//
//            Toast.makeText(context, "Basket Saved: " + context.getFilesDir(), Toast.LENGTH_SHORT).show();
//            System.out.println("Basket saved" );
//
//        }
//
//// ------------ READ -----------------
//
//        public void readFile() throws IOException, ClassNotFoundException {
//
//
//
//            System.err.println("Read FRom Basket !!!!!!!!!!  " );
//
//
//            FileInputStream inputStream = productListActivity.openFileInput("myfile.txt");
//            BufferedInputStream bis = new BufferedInputStream(inputStream);
//            StringBuffer b = new StringBuffer();
//
//            while (bis.available() != 0 ){
//                char c = (char) bis.read();
//                b.append(c);
//            }
////        Toast.makeText(productListActivity, "File reded :-) ", Toast.LENGTH_SHORT).show();
//            Toast.makeText(productListActivity, "File reded :-)"+ b.toString(), Toast.LENGTH_SHORT).show();
//
//            bis.close();
//            inputStream.close();
//
//
//
//        }
//
//
    }


}
