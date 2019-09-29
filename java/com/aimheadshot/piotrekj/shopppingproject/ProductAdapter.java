package com.aimheadshot.piotrekj.shopppingproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aimheadshot.guptastationery.R;

import java.util.List;


public class ProductAdapter extends ArrayAdapter<Product> {


    Service service;
    int[][] productImages;

    public ProductAdapter(Context context, int resource, List<Product> objects, Service service, int[][] productImages) {
        super(context, resource, objects);
        this.service = service;
        this.productImages = productImages;
    }

    // method to reload ViewList
    public void refreshViewList() {

        this.notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        // view lookup cache stored in tag
        ViewHolder holder = null;

        // Get the data item for this position
        final Product product = getItem(position);


        if ( convertView == null){

            holder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.product_list_row,null);

            holder.image = (ImageView) convertView.findViewById(R.id.icon);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.number = (TextView) convertView.findViewById(R.id.list_item_number);
            holder.shopPrice = (TextView) convertView.findViewById(R.id.shopPrice);
            holder.buttonAdd = (Button) convertView.findViewById(R.id.addButton);
            holder.buttonRemove = (Button) convertView.findViewById(R.id.removeButton);

            convertView.setTag(holder);

            //-------- ADD Button On Click Listner -----------------
            holder.buttonAdd.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v ) {


                    // reload adapter, ListView
                    refreshViewList();

                    // info on the screen
                  //  Toast.makeText(getContext(), "Product was added  " + product.getName() + " from position: " + position, Toast.LENGTH_SHORT).show();

                    // update counter  +1 in selected  Product  item
                    Service.getInstance().updateProductCounterIncrease(product);

                    //System.out.println("COunter_1 !!!!!!!!!!!!!!! " + position + " " + product.getCounter());

                }

            });

            //----- Reomve Button ------------

            holder.buttonRemove.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                    // reload adapter, ListView
                    refreshViewList();

                    // info on the screen
                  //  Toast.makeText(getContext(), "Product was removed  " + product.getName() +" from position: " + position, Toast.LENGTH_SHORT).show();

                    // update counter to -1 in selected  Product  item
                    Service.getInstance().updateProductCounterDecrease(product);
                }
            });
        }else{

            holder = (ViewHolder) convertView.getTag();

        }

        holder.name.setText(product.getName());

        if(product.getName()=="Navneet YUVA" || product.getName()=="Classmate" || product.getName()=="Classmate(long)" || product.getName()=="Rough copy")
            holder.image.setImageResource(productImages[0][position]);
        else if(product.getName()=="Reynolds Racer Gel" ||product.getName()=="Reynolds Tri-max" || product.getName()=="Cello Paper soft" ||product.getName()=="Butter flow" ||product.getName()=="Pierre Cardin")
            holder.image.setImageResource(productImages[1][position]);
        else if(product.getName()=="Wax Color(medium)" ||product.getName()=="Sketch Pen(small)"||product.getName()=="Sketch Pen(big)"||product.getName()=="Pencil Color(medium)"||product.getName()=="Pencil Color(large)")
            holder.image.setImageResource(productImages[2][position]);
        else if(product.getName()=="OREVA"||product.getName()=="ORPAT"||product.getName()=="Casio(medium)"||product.getName()=="Casio(14 digit)")
            holder.image.setImageResource(productImages[3][position]);
        else if(product.getName()=="Apsara Gold(Pkt)"||product.getName()=="Apsara Matt magic"||product.getName()=="Doms"||product.getName()=="Eraser Natraj"||product.getName()=="Apsara nondust")
            holder.image.setImageResource(productImages[4][position]);
        else if(product.getName()=="Natraj"||product.getName()=="Doms Box"||product.getName()=="Classmate Box"||product.getName()=="Box")
            holder.image.setImageResource(productImages[5][position]);
        else if(product.getName()=="Flat file"||product.getName()=="Spring clip file"||product.getName()=="Spring clip file"||product.getName()=="Ring file Izen"||product.getName()=="Leaver arch file")
            holder.image.setImageResource(productImages[6][position]);
        else if(product.getName()=="Saya small"||product.getName()=="Saya medium"||product.getName()=="Saya big")
            holder.image.setImageResource(productImages[7][position]);
        else if(product.getName()=="Fevicol 25g"||product.getName()=="Fevigum"||product.getName()=="Fevigum 25g")
            holder.image.setImageResource(productImages[8][position]);
        else if(product.getName()=="Stapler No.10"||product.getName()=="Stapler 24/6"||product.getName()=="Pin No.10"||product.getName()=="Pin 24/6")
            holder.image.setImageResource(productImages[9][position]);
        else if(product.getName()=="Small(transparent)"||product.getName()=="Brown tape(Med)"||product.getName()=="Brown tape(big)")
            holder.image.setImageResource(productImages[10][position]);
        else if(product.getName()=="Simple board"||product.getName()=="Navneet Boss"||product.getName()=="Yuva")
            holder.image.setImageResource(productImages[11][position]);
        else if(product.getName()=="A4 SPB(Pkt)")
            holder.image.setImageResource(productImages[12][position]);


        // counter
        holder.number.setText("Ordered : " + String.valueOf(Service.getInstance().getCounter(product)));

        holder.shopPrice.setText("Shop price: ₹" + product.getShopsPrice());

        // Return the completed view to render on screen
        return convertView;
    }




    public class ViewHolder {

        ImageView image;
        TextView name;
        TextView number;
        TextView shopPrice;
        Button buttonRemove;
        Button buttonAdd;

    }
}
