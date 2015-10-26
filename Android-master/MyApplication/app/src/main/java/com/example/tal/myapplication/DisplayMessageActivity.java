package com.example.tal.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;


public class DisplayMessageActivity extends ActionBarActivity {

    final static int DEFAULT_CLASS_NUM = 4;

    int curr_num_classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get the items from the intent
        Intent intent = getIntent();
        ArrayList<String> classList = intent.getStringArrayListExtra(MainActivity.EXTRA_CLASSLIST);
        curr_num_classes = intent.getIntExtra(MainActivity.EXTRA_NUM, DEFAULT_CLASS_NUM);

        //Create the text view
        String setText = "CLASSES: ";
        for (int i=0; i<curr_num_classes; i++){
            setText = setText + "\nClass "+ (i+1) + ": " + classList.get(i);
        }
        /*switch (curr_num_classes){
            case (8):
                setText = setText + "\nClass 8: " + classList.get(7);
            case (7):
                setText = setText + "\nClass 7: " + classList.get(6);
            case (6):
                setText = setText + "\nClass 6: " + classList.get(5);
            case (5):
                setText = setText + "\nClass 5: " + classList.get(4);
            case (4):
                setText = setText + "\nClass 4: " + classList.get(3);
            case (3):
                setText = setText + "\nClass 3: " + classList.get(2);
            case (2):
                setText = setText + "\nClass 2: " + classList.get(1);
            default:
                setText = setText + "\nClass 1: " + classList.get(0) ;
                break;
        }*/


        TextView textView = new TextView(this);
        textView.setTextSize(30);
        textView.setText(setText);

        // Set the text view as the activity layout
        setContentView(textView);
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
