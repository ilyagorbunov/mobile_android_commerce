 package com.packag.androidecommerce;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.accountkit.AccountKitLoginResult;
import com.facebook.accountkit.ui.AccountKitActivity;
import com.facebook.accountkit.ui.AccountKitConfiguration;
import com.facebook.accountkit.ui.LoginType;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import dmax.dialog.SpotsDialog;


 public class MainActivity extends AppCompatActivity {

     private static final int REQUEST_CODE = 1000;
     Button btn_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_continue = (Button)findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startLoginPage(LoginType.PHONE);
            }
        });
    }

     private void startLoginPage(LoginType loginType) {
         Intent intent = new Intent(this, AccountKitActivity.class);
         AccountKitConfiguration.AccountKitConfigurationBuilder builder  =
                 new AccountKitConfiguration.AccountKitConfigurationBuilder(loginType,
                         AccountKitActivity.ResponseType.TOKEN);
         intent.putExtra(AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,builder.build());
         startActivityForResult(intent,REQUEST_CODE);
     }

     //ctrl + o

     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
         super.onActivityResult(requestCode, resultCode, data);
         if(requestCode == REQUEST_CODE)
         {
             AccountKitLoginResult result = data.getParcelableExtra(AccountKitLoginResult.RESULT_KEY);

             if(result.getError() != null)
             {
                 Toast.makeText(this, ""+result.getError().getErrorType().getMessage(), Toast.LENGTH_SHORT).show();
             }
             else if(result.wasCancelled())
             {
                 Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
             }
             else
             {
                 if(result.getAccessToken() != null)
                 {
                     AlertDialog alertDialog = new SpotsDialog(MainActivity.this);
                     alertDialog.show();
                     alertDialog.setMessage("Please waiting...");

                     //Get User phone and check exist on serve

                 }
             }
         }
     }

     private void printKeyHash() {
        try{
            PackageInfo info = getPackageManager().getPackageInfo("com.packag.androidecommerce",
                    PackageManager.GET_SIGNATURES);
            for(Signature signature:info.signatures)
            {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KEYHASH", Base64.encodeToString(md.digest(),Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
