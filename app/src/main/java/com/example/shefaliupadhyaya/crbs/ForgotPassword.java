package com.example.shefaliupadhyaya.crbs;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class ForgotPassword extends AppCompatActivity implements View.OnClickListener {
    private  EditText emailid, newpass;
    private Button submit, cancel;
    Session session = null;
    ProgressDialog pdialog = null;
    Context context = null;
    String recipient, password;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        context = this;
        emailid = (EditText) findViewById(R.id.emailid);
        newpass = (EditText) findViewById(R.id.newpass);
        submit = (Button) findViewById(R.id.submit);
        cancel = (Button) findViewById(R.id.cancel);
        submit.setOnClickListener(this);
        onCancelClick();

    }
    public void onCancelClick() {
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ForgotPassword.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    @Override
    public void onClick(View v) {
        recipient = emailid.getText().toString();
        password = newpass.getText().toString();
        if(recipient.matches(emailPattern) && !password.equals("") && isNetworkAvailable()) {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            session = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("pabipabi420@gmail.com", "pabipabi420");
                }
            });

            pdialog = ProgressDialog.show(context, "", "Sending Mail...", true);
            RetrieveFeedTask task = new RetrieveFeedTask();
            task.execute();
        }
        if(!recipient.matches(emailPattern))
            Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
        if(password.equals(""))
            Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_LONG).show();
        if(!isNetworkAvailable())
        {   final View coordinatorLayoutView = findViewById(R.id.snackbarPosition);
            Snackbar.make(coordinatorLayoutView,"Check network connection", Snackbar.LENGTH_LONG).show();
        }

    }
    class RetrieveFeedTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            try {
                Message message = new MimeMessage(session);
		// provide an email address from which mails will be sent
                message.setFrom(new InternetAddress(""));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
                message.setSubject("New password for your Conference Room Booking System");
                message.setContent(password, "text/html; charset=utf-8");
                Transport.send(message);
            } catch (MessagingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            pdialog.dismiss();
            emailid.setText("");
            newpass.setText("");
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ForgotPassword.this);
            alertDialogBuilder.setMessage("Mail sent successfully!");
            alertDialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Intent intent = new Intent(ForgotPassword.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }
    }
}



