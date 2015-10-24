package com.example.tal.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
   // public final static String EXTRA_MESSAGE = "com.example.tal.myapplication.MESSAGE";
    public List<String> classList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        classList = new ArrayList<String>();
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        EditText classOne = (EditText) findViewById(R.id.edit_message1);
        EditText classTwo = (EditText) findViewById(R.id.edit_message2);
        EditText classThree = (EditText) findViewById(R.id.edit_message3);
        EditText classFour = (EditText) findViewById(R.id.edit_message4);
        EditText classFive = (EditText) findViewById(R.id.edit_message5);

        classList.add(classOne.getText().toString());
        classList.add(classTwo.getText().toString());
        classList.add(classThree.getText().toString());
        classList.add(classFour.getText().toString());
        classList.add(classFive.getText().toString());

        intent.putStringArrayListExtra("classList", (ArrayList<String>) classList);

        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
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
