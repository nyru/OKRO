package eswar.com.okro.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import eswar.com.okro.R;

public class CartActivity extends AppCompatActivity {
TextView tv_placeorder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        tv_placeorder=findViewById(R.id.tv_placeorder);
        tv_placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(CartActivity.this);
                LayoutInflater factory = LayoutInflater.from(CartActivity.this);
                final View viewww = factory.inflate(R.layout.placeimage, null);
                alertadd.setView(viewww);


                alertadd.show();
            }
        });
    }
}
