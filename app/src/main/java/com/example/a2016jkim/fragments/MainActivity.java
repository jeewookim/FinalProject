package com.example.a2016jkim.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FooFragment.OnItemSelectedListener{
    private int status;
    FooFragment fragment;
    @Override
    public void onFragmentClicked(Button pink) {
        if (fragment != null && fragment.isInLayout()) {
            fragment.setText("");
        }
        pink.setText("goodbye");



        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        FooFragment fragmentDemo = FooFragment.newInstance(5, "my title");
        status = 1;

        ft.replace(R.id.pinkholder, fragmentDemo);
        ft.commit();
        System.out.print(status);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        fragment = (FooFragment) getSupportFragmentManager().findFragmentById(R.id.pinkholder);


        // Begin the transaction
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
// Replace the contents of the container with the new fragment
        final Button home = (Button)findViewById(R.id.button1);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                //ft.replace(R.id.placeholder, new FooFragment());
// or ft.add(R.id.your_placeholder, new FooFragment());
// Complete the changes added above
               // ft.commit();
                home.setText("goodbye");
                if (status == 1){
                    Toast.makeText(getApplicationContext(), "goodbye", Toast.LENGTH_SHORT);
                }

                    FooFragment fragmentDemo = FooFragment.newInstance(5, "my title");
                    status = 1;

                    ft.replace(R.id.placeholder, fragmentDemo);
                    ft.commit();
                    System.out.print(status);
            }
        });

    }

             @Override
             public boolean onCreateOptionsMenu(Menu menu) {
                 // Inflate the menu; this adds items to the action bar if it is present.
                 getMenuInflater().inflate(R.menu.menu_main, menu);
                 return true;
             }

             @Override
             public boolean onOptionsItemSelected(MenuItem item) {
                 // Handle action bar item clicks here. The action bar will
                 // automatically handle clicks on the Home/Up button, so long
                 // as you specify a parent activity in AndroidManifest.xml.
                 int id = item.getItemId();

                 //noinspection SimplifiableIfStatement
                 if (id == R.id.action_settings) {
                     return true;
                 }

                 return super.onOptionsItemSelected(item);
             }
         }


