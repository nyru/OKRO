package eswar.com.okro.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eswar.com.okro.R;

public class LoginActivity extends AppCompatActivity {
EditText ed_firstname,ed_lastname,ed_mobilenumber,ed_enterotp;
TextView tv_openbasket;
    Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
    Matcher m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_firstname=findViewById(R.id.ed_firstname);
        ed_lastname=findViewById(R.id.ed_lastname);
        ed_mobilenumber=findViewById(R.id.ed_mobilenumber);
        ed_enterotp=findViewById(R.id.ed_enterotp);
        tv_openbasket=findViewById(R.id.tv_openbasket);
         m = p.matcher((CharSequence) ed_mobilenumber);
        tv_openbasket.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (ed_firstname.getText().toString().length() == 0) {
                    ed_firstname.setError("Enter First Name");
                    ed_firstname.requestFocus();
                }
                if (ed_lastname.getText().toString().length() == 0) {
                    ed_lastname.setError("Enter Last Name");
                    ed_lastname.requestFocus();
                }

                if (ed_mobilenumber.getText().toString().length() == 0) {
                    ed_mobilenumber.setError("Enter mobile number");
                    ed_mobilenumber.requestFocus();
                } else {
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(LoginActivity.this,DashBoardActivity.class);
                    startActivity(intent);
                }
            }

    });
}
}
