package eswar.com.okro.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import eswar.com.okro.R;
import eswar.com.okro.Utilities.Validations;

public class LoginActivity extends AppCompatActivity {
EditText ed_firstname,ed_lastname,ed_mobilenumber,ed_enterotp;
TextView tv_openbasket;
    InputMethodManager imm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_firstname=findViewById(R.id.ed_firstname);
        ed_lastname=findViewById(R.id.ed_lastname);
        ed_mobilenumber=findViewById(R.id.ed_mobilenumber);
        ed_mobilenumber.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Validations.isPhoneNumber(ed_mobilenumber, false);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        tv_openbasket=findViewById(R.id.tv_openbasket);
       imm = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(ed_firstname ,
                InputMethodManager.SHOW_IMPLICIT);
        imm.showSoftInput(ed_lastname ,
                InputMethodManager.SHOW_IMPLICIT);
        imm.showSoftInput(ed_mobilenumber ,
                InputMethodManager.SHOW_IMPLICIT);


        tv_openbasket.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (ed_firstname.getText().toString().length() == 0) {
                    ed_firstname.setError("Enter First Name");
                    ed_firstname.requestFocus();
                }


                if (ed_mobilenumber.getText().toString().length() == 0 )
                {

                    ed_mobilenumber.setError("Enter mobile number");
                    ed_mobilenumber.requestFocus();


                } else {
                    openDialog();
                }
            }

    });
}
    private void openDialog(){
        LayoutInflater inflater = LayoutInflater.from(LoginActivity.this);
        View subView = inflater.inflate(R.layout.dialog_otp, null);
        final EditText subEditText = (EditText)subView.findViewById(R.id.ed_enterotp);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ENTER OTP");
        builder.setView(subView);
        AlertDialog alertDialog = builder.create();

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(LoginActivity.this,DashBoardActivity.class);
                    startActivity(intent);





            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(LoginActivity.this, "Cancel", Toast.LENGTH_LONG).show();
            }
        });

        builder.show();
    }
}



