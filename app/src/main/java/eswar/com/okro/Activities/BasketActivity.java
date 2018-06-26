package eswar.com.okro.Activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import eswar.com.okro.Adapters.BasketAdapter;
import eswar.com.okro.Adapters.CustomSpinnerAdapter;
import eswar.com.okro.Model.BasketitemsModel;
import eswar.com.okro.R;

public class BasketActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private Spinner spinner_nav;
    private List<BasketitemsModel> basketitemsModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BasketAdapter basketAdapter;
TextView tv_pausebasket,tv_confirmbasket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        spinner_nav = (Spinner) findViewById(R.id.spinner_nav);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
tv_pausebasket=findViewById(R.id.tv_pausebasket);
tv_confirmbasket=findViewById(R.id.tv_confirmbasket);
        basketAdapter = new BasketAdapter(basketitemsModelList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(basketAdapter);
tv_confirmbasket.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (tv_confirmbasket.isClickable()) {
            tv_confirmbasket.setBackgroundResource(R.drawable.rect);
            tv_confirmbasket.setTextColor(Color.WHITE);

            AlertDialog.Builder builder = new AlertDialog.Builder(BasketActivity.this);

            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.confirmdialog, null);

            // Set the custom layout as alert dialog view
            builder.setView(dialogView);

            // Get the custom alert dialog view widgets reference
            Button btn_negative = (Button) dialogView.findViewById(R.id.dialog_neutral_btn);
            final Button btn_neutral = (Button) dialogView.findViewById(R.id.dialog_negative_btn);
TextView tv_dialogtext=dialogView.findViewById(R.id.dialog_tv);
            tv_dialogtext.setText(Html.fromHtml(getString(R.string.nice_html)));


            // Create the alert dialog
            final AlertDialog dialog = builder.create();

            // Set positive/yes button click listener



            // Set negative/no button click listener
            btn_negative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Dismiss the alert dialog
                    if (btn_neutral.isClickable()) {
                        btn_neutral.setBackgroundResource(R.drawable.rect);
                        btn_neutral.setTextColor(Color.WHITE);
                        dialog.cancel();

                    }
                }
            });

            // Set cancel/neutral button click listener
            btn_neutral.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btn_neutral.isClickable()) {
                        btn_neutral.setBackgroundResource(R.drawable.rect);
                        btn_neutral.setTextColor(Color.WHITE);


                        // Dismiss/cancel the alert dialog
                        Intent intent = new Intent(BasketActivity.this, CartActivity.class);
                        startActivity(intent);
                    }
                }
            });

            // Display the custom alert dialog on interface
            dialog.show();
        }
    }
});


        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);


        }
        addItemsToSpinner();

    }

    // add items into spinner dynamically
    public void addItemsToSpinner() {

        ArrayList<String> list = new ArrayList<String>();
        list.add("vegetables");
        list.add("fruits");

        CustomSpinnerAdapter spinAdapter = new CustomSpinnerAdapter(
                getApplicationContext(), list);

        spinner_nav.setAdapter(spinAdapter);

        spinner_nav.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String item = adapter.getItemAtPosition(position).toString();

                // Showing selected spinner item
               switch (position)
               {
                   case  0:adapter.getItemAtPosition(0);

                       additemsvegetables();
                   break;

                   case 1:adapter.getItemAtPosition(1);
                   additemsfruits();
                   break;
               }

                Toast.makeText(getApplicationContext(), "Selected  : " + item,
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
               

            }
        });
    }
    public void additemsvegetables(){
        BasketitemsModel basketitemsModel = new BasketitemsModel(R.drawable.onions, "onion", "200","1kg",R.mipmap.minus,"1",R.mipmap.plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.potato, "Potato", "200","1kg",R.mipmap.minus,"1",R.mipmap.plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.ridgegourd, "Ridge Gourd", "200","1kg",R.mipmap.minus,"1",R.mipmap.plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.onions, "onion", "200","1kg",R.mipmap.minus,"1",R.mipmap.plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.potato, "Potato", "200","1kg",R.mipmap.minus,"1",R.mipmap.plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.ridgegourd, "Ridge Gourd", "200","1kg",R.mipmap.minus,"1",R.mipmap.plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.onions, "onion", "200","1kg",R.mipmap.minus,"1",R.mipmap.plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.potato, "Potato", "200","1kg",R.mipmap.minus,"1",R.mipmap.plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.ridgegourd, "Ridge Gourd", "200","1kg",R.mipmap.minus,"1",R.mipmap.plus);
        basketitemsModelList.add(basketitemsModel);

        basketAdapter.notifyDataSetChanged();
    }
    public void additemsfruits(){
        BasketitemsModel basketitemsModel = new BasketitemsModel(R.drawable.ic_basket, "Apple", "200","1kg",R.drawable.ic_minus,"1",R.drawable.ic_plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.ic_basket, "Apple", "200","1kg",R.drawable.ic_minus,"1",R.drawable.ic_plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.ic_basket, "Apple", "200","1kg",R.drawable.ic_minus,"1",R.drawable.ic_plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.ic_basket, "Apple", "200","1kg",R.drawable.ic_minus,"1",R.drawable.ic_plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.ic_basket, "Apple", "200","1kg",R.drawable.ic_minus,"1",R.drawable.ic_plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.ic_basket, "Apple", "200","1kg",R.drawable.ic_minus,"1",R.drawable.ic_plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.ic_basket, "Apple", "200","1kg",R.drawable.ic_minus,"1",R.drawable.ic_plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.ic_basket, "Apple", "200","1kg",R.drawable.ic_minus,"1",R.drawable.ic_plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.ic_basket, "Apple", "200","1kg",R.drawable.ic_minus,"1",R.drawable.ic_plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.ic_basket, "Apple", "200","1kg",R.drawable.ic_minus,"1",R.drawable.ic_plus);
        basketitemsModelList.add(basketitemsModel);
        basketitemsModel = new BasketitemsModel(R.drawable.ic_basket, "Apple", "200","1kg",R.drawable.ic_minus,"1",R.drawable.ic_plus);
        basketitemsModelList.add(basketitemsModel);

        basketAdapter.notifyDataSetChanged();
    }
}
