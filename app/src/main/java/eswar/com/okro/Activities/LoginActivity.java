package eswar.com.okro.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import eswar.com.okro.R;

public class LoginActivity extends AppCompatActivity {
EditText ed_firstname,ed_lastname,ed_mobilenumber,ed_enterotp;
TextView tv_openbasket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_firstname=findViewById(R.id.ed_firstname);
        ed_lastname=findViewById(R.id.ed_lastname);
        ed_mobilenumber=findViewById(R.id.ed_mobilenumber);
        ed_enterotp=findViewById(R.id.ed_enterotp);
        tv_openbasket=findViewById(R.id.tv_openbasket);
    }
}
