package com.example.tal.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class DisplayMessageActivity extends ActionBarActivity{

    final static int DEFAULT_CLASS_NUM = 4;
    int curr_num_classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_display_message);

        //Get the classes inputted by the user from the intent
        Intent intent = getIntent();
        final ArrayList<String> classList = intent.getStringArrayListExtra(MainActivity.EXTRA_CLASSLIST);
        curr_num_classes = intent.getIntExtra(MainActivity.EXTRA_NUM, DEFAULT_CLASS_NUM);

        //Create the text view
        final TextView textView = new TextView(this);
        textView.setTextSize(30);

        //Thread that does all of the CAPE querying and string printing
       Thread getCapeData = new Thread(new Runnable(){
           @Override
           public void run(){
               final Document doc;
               try{
                   //Create the URL that displays the cape URL that contains the first user-unputted class
                   String capeURL =  "http://www.cape.ucsd.edu/responses/Results.aspx?CourseNumber=" + classList.get(0);

                   //Connect to the website
                   doc = Jsoup.connect(capeURL)
                           .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                           .referrer("http://www.google.com")
                           .get();

                       //create another thread that will run on the UI - NEEDED
                       runOnUiThread(new Runnable(){
                           @Override
                           public void run(){
                           Element table = doc.select("table").get(0); //select the first (only) table.
                           Elements rows = table.select("tr");
                           ArrayList<String> workHours = new ArrayList<String>(); //ArrayList that can store the hours expected

                           for (int i = 1; i < rows.size(); i++) {    //first row is the col names so skip it.
                               Element row = rows.get(i);
                               Elements cols = row.select("td");
                               workHours.add(cols.get(7).text());     //column 7 of the table is the work hrs column
                           }

                               //Create a string to display to the screen.
                               //Display the classes inputted by the user
                               String setText = "CLASSES: ";
                               for (int i=0; i<curr_num_classes; i++){
                                   setText = setText + "\nClass "+ (i+1) + ": " + classList.get(i);
                               }

                               //Append the work hours for the first class to the string
                               setText = setText + "\nHours for first class: " + workHours.get(0);

                               //Store the string we just created into the textView object
                           textView.setText(setText);

                           // Set the text view as the activity layout (print the string to the screen)
                           setContentView(textView);
                           }
                       });
               }
               catch(Exception e){
                   e.printStackTrace();
                   System.exit(1);
               }
           }
       });

        //Function that starts the above thread
        getCapeData.start();

/*
        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");
        ArrayList<String> workHours = new ArrayList<String>();

        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            workHours.add(cols.get(7).text());
        }

        textView.setText("Class One: " + classList.get(0) + "\nClass Two: " + classList.get(1) + "\nClass Three: " +
                classList.get(2) + "\nClass Four: " + classList.get(3) + "\nClass Five: " + classList.get(4) + "\nQuery: " + workHours.get(0));

        // Set the text view as the activity layout
        setContentView(textView);
*/
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
