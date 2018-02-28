package com.vanroye.home.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HoofdScherm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoofdscherm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        poplulate_list();
        registerClickCallBack();
        // roomListView.setOnItemClickListener(onListClick);
    }

    private void poplulate_list()
    {
        String[] rooms = {"Keuken", "Bureau", "Badkamer", "Veranda","Gang","Piano","Televisie","Slaapkamer","Sarah", "Gilles"};
        ListAdapter lightsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rooms);
        ListView roomListView = (ListView) findViewById(R.id.Room_List);
        roomListView.setAdapter(lightsAdapter);
    }

    private void registerClickCallBack()
    {
        ListView roomListView = (ListView) findViewById(R.id.Room_List);
        roomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*
                TextView textView = (TextView) view;
                String message = "I've clicked #" + position + " this is: " + textView.getText().toString();
                Toast.makeText(HoofdScherm.this, message, Toast.LENGTH_LONG).show();
                */
                TextView textView = (TextView) view;
                Intent myIntent = new Intent(HoofdScherm.this, DetailScherm.class);
                myIntent.putExtra("room", textView.getText().toString()); //Optional parameters
                HoofdScherm.this.startActivity(myIntent);
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
