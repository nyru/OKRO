package eswar.com.okro.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import eswar.com.okro.R;

public class HarvestAdapter extends BaseAdapter {
    Context context;
    String Item[];
    String SubItem[];
    String flags[];
    LayoutInflater inflter;

    public HarvestAdapter(Context applicationContext, String[] Item, String[] SubItem , String[] flags) {
        this.context = context;
        this.Item = Item;
        this.SubItem = SubItem;
        this.flags = flags;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return Item.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.harvest_row, null);
        TextView item = (TextView) view.findViewById(R.id.tv_veg_harvest);
        TextView subitem = (TextView) view.findViewById(R.id.tv_time_harvest);
        TextView date=view.findViewById(R.id.tv_date_harvest);
        item.setText(Item[i]);
        subitem.setText(SubItem[i]);
        date.setText(flags[i]);
        return view;
    }

}
