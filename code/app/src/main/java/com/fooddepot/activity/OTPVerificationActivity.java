package com.fooddepot.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fooddepot.R;

import static android.graphics.Color.WHITE;

public class OTPVerificationActivity extends AppCompatActivity {

    EditText otp;
    TextView message;
    Button btn,verify_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);
        otp=(EditText)findViewById(R.id.otp_editxt);
        verify_btn=(Button)findViewById(R.id.verify_btn);
        message =(TextView)findViewById(R.id.message);
    }

    public void onClickVerify(View view){
        if(otp.getText().toString().equals("XYZ")){
            Intent i = new Intent(this,RoleActivity.class);
            i.putExtra("Status","Success");
            startActivity(i);
        }
        else{
            message.setText("Invalid Code. Please try again");
            Button btn = new Button(this);
            btn.setText("  Resend VerificationCode  ");
            btn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btn.setTextColor(WHITE);
            RelativeLayout rl = (RelativeLayout)findViewById(R.id.otpVerificationlayout);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            lp.topMargin=50;
            lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
            lp.addRule(RelativeLayout.BELOW,message.getId());
            rl.addView(btn, lp);
        }
    }
}


