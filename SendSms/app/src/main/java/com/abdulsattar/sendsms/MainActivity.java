package com.abdulsattar.sendsms;


import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends Activity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    Button btnSend;
    EditText contactNo;
    EditText Message;
    String phoneNo;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = (Button) findViewById(R.id.btnSendSMS);
        contactNo = (EditText) findViewById(R.id.phoneET);
        Message = (EditText) findViewById(R.id.smsET);

        btnSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMSMessage();
            }
        });
    }

    protected void sendSMSMessage() {
        phoneNo = contactNo.getText().toString();
        message = Message.getText().toString();

    SmsManager manager = SmsManager.getDefault();
    manager.sendTextMessage(phoneNo,null,message,null,null);
    Toast.makeText(getApplicationContext(),"Send Succesfully",Toast.LENGTH_LONG).show();;

    }

}
