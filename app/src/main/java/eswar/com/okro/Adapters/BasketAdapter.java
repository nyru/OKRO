package eswar.com.okro.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import eswar.com.okro.Model.BasketitemsModel;
import eswar.com.okro.R;

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.MyViewHolder> {
    private List<BasketitemsModel> basketitemsModelList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView itemname,weight,price,itemsno;
        ImageView  itempic,plus,minus;

        public MyViewHolder(View view) {
            super(view);
            itemname = (TextView) view.findViewById(R.id.from_name);
            weight = (TextView) view.findViewById(R.id.plist_weight_text);
            price = (TextView) view.findViewById(R.id.plist_price_text);
            itemsno=view.findViewById(R.id.cart_product_quantity_tv);
            itempic=view.findViewById(R.id.list_image);
            plus=view.findViewById(R.id.cart_plus_img);
            minus=view.findViewById(R.id.cart_minus_img);
        }
    }
    public BasketAdapter(List<BasketitemsModel> basketitemsModelList) {
        this.basketitemsModelList = basketitemsModelList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_rowww, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        BasketitemsModel basketitemsModel = basketitemsModelList.get(position);
        holder.itempic.setImageResource(basketitemsModel.getItempic());
        holder.itemname.setText(basketitemsModel.getItemname());
        holder.price.setText(basketitemsModel.getPrice());
        holder.weight.setText(basketitemsModel.getWeight());
        holder.minus.setImageResource(basketitemsModel.getMinus());
        holder.itemsno.setText(basketitemsModel.getItemsno());
        holder.plus.setImageResource(basketitemsModel.getPlus());


    }
    @Override
    public int getItemCount() {
        return basketitemsModelList.size();
    }
}
