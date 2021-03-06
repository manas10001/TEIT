package com.example.notes_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sessionManager = new SessionManager(this);
        //redirect user if logged out
        if(sessionManager.getSesion().equals("noUser")){
            Intent intent = new Intent(Home.this, MainActivity.class);
            startActivity(intent);
        }

    }

    //handle selection of menu items
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            //change password activity
            case R.id.changePass:
                try {
                    Intent intent = new Intent(Home.this, Reset_password.class);
                    startActivity(intent);
                }catch(Exception e){
                    Toast.makeText(Home.this,e.toString(), Toast.LENGTH_LONG).show();
                }
                return true;
            //Logout
            case R.id.logout:
                try {
                    sessionManager = new SessionManager(Home.this);
                    sessionManager.removeSession();
                    Intent intent = new Intent(Home.this, MainActivity.class);
                    startActivity(intent);
                }catch(Exception e){
                    Toast.makeText(Home.this,e.toString(), Toast.LENGTH_LONG).show();
                }
                return true;
             case R.id.deleteUser:
                try {
                    Intent intent = new Intent(Home.this, Delete_Account.class);
                    startActivity(intent);
                }catch(Exception e){
                    Toast.makeText(Home.this,e.toString(), Toast.LENGTH_LONG).show();
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //add menu to activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }
}