package com.android.isp_application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class EmailUsActivity extends AppCompatActivity {

    EditText mSubjectEt, mMessageEt;
    Button mSendEmailBtn;
    private static final String RECIPIENT_EMAIL = "example@isp.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_us);

        mSubjectEt = findViewById(R.id.SubjectEt);
        mMessageEt = findViewById(R.id.MessageEt);
        mSendEmailBtn = findViewById(R.id.sendEmailBtn);

        mSendEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = mSubjectEt.getText().toString().trim();
                String message = mMessageEt.getText().toString().trim();

                sendEmail(RECIPIENT_EMAIL, subject,message);
            }
        });
    }
    private void sendEmail(String recipient, String subject, String message){
        Intent mEmailIntent = new Intent(Intent.ACTION_SEND);

        mEmailIntent.setData(Uri.parse("mailto:"));
        mEmailIntent.setType("text/plain");

        mEmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipient});
        mEmailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        mEmailIntent.putExtra(Intent.EXTRA_TEXT,message);

        try {
            startActivity(Intent.createChooser(mEmailIntent,"Choose an Email Client"));
        }
        catch (Exception e) {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}