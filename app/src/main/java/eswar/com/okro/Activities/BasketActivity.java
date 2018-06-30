package eswar.com.okro.Activities;

import android.app.AlertDialog;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import eswar.com.okro.Adapters.CustomSpinnerAdapter;
import eswar.com.okro.Fragments.FruitsFragment;
import eswar.com.okro.Fragments.LeafyVegetablesFragment;
import eswar.com.okro.Fragments.VegetableFragment;
import eswar.com.okro.R;

public class BasketActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private Spinner spinner_nav;
    private AppCompatDelegate delegate;
FrameLayout frameLayout1,frameLayout2,frameLayout3;
TextView tv_pausebasket,tv_confirmbasket;
    private String[] category=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        spinner_nav = (Spinner) findViewById(R.id.spinner_nav);

        tv_pausebasket=findViewById(R.id.tv_pausebasket);
        tv_confirmbasket=findViewById(R.id.tv_confirmbasket);
frameLayout1=findViewById(R.id.fragments);
frameLayout2=findViewById(R.id.fragments1);
frameLayout3=findViewById(R.id.fragments2);
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

        final ArrayList<String> list = new ArrayList<String>();
        list.add("Vegetables");
        list.add("Leafy Vegetables");
        list.add("Fruits");
        CustomSpinnerAdapter spinAdapter = new CustomSpinnerAdapter(
                getApplicationContext(), list);

        spinner_nav.setAdapter(spinAdapter);

        spinner_nav.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String item = adapter.getItemAtPosition(position).toString();

                FragmentTransaction ft,ft1;
                switch (position) {

                    case 0:

                       frameLayout1.setVisibility(View.VISIBLE);
                       frameLayout2.setVisibility(View.INVISIBLE);
                       frameLayout3.setVisibility(View.INVISIBLE);
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.fragments, new VegetableFragment());
                        ft.commit();

                        break;
                    case 1:
                        frameLayout2.setVisibility(View.VISIBLE);
                        frameLayout1.setVisibility(View.INVISIBLE);
                        frameLayout3.setVisibility(View.INVISIBLE);
                        ft1 = getSupportFragmentManager().beginTransaction();
                        ft1.replace(R.id.fragments1, new LeafyVegetablesFragment());

                        ft1.commit();
                        break;
                    case 2:
                        frameLayout3.setVisibility(View.VISIBLE);
                        frameLayout1.setVisibility(View.INVISIBLE);
                        frameLayout2.setVisibility(View.INVISIBLE);
                        ft1 = getSupportFragmentManager().beginTransaction();
                        ft1.replace(R.id.fragments2, new FruitsFragment());
                        ft1.commit();
                        break;

                }
//                FragmentTransaction ft;
//                if(position==0){
//                    ft = getSupportFragmentManager().beginTransaction();
//                    ft.replace(R.id.fragments, new VegetableFragment());
//                    ft.commit();
//                }
//                 if(position==1){
//
//                    ft = getSupportFragmentManager().beginTransaction();
//                    ft.replace(R.id.fragments, new LeafyVegetablesFragment());
//                    ft.commit();
//                }
//            }

            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {


            }
        });

    }
}
