package com.example.tal.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_NUM = "com.example.tal.myapplication._numClasses";
    public final static String EXTRA_CLASSLIST = "com.example.tal.myapplication._Classlist";
    public List<String> classList;

    int curr_num_classes;
    LinearLayout classOneLayout;
    LinearLayout classTwoLayout;
    LinearLayout classThreeLayout;
    LinearLayout classFourLayout;
    LinearLayout classFiveLayout;
    LinearLayout classSixLayout;
    LinearLayout classSevenLayout;
    LinearLayout classEightLayout;
    EditText classOne;
    EditText classTwo;
    EditText classThree;
    EditText classFour;
    EditText classFive;
    EditText classSix;
    EditText classSeven;
    EditText classEight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        classOneLayout = (LinearLayout) findViewById(R.id.linLayout_1);
        classTwoLayout = (LinearLayout) findViewById(R.id.linLayout_2);
        classThreeLayout = (LinearLayout) findViewById(R.id.linLayout_3);
        classFourLayout = (LinearLayout) findViewById(R.id.linLayout_4);
        classFiveLayout = (LinearLayout) findViewById(R.id.linLayout_5);
        classSixLayout = (LinearLayout) findViewById(R.id.linLayout_6);
        classSevenLayout = (LinearLayout) findViewById(R.id.linLayout_7);
        classEightLayout = (LinearLayout) findViewById(R.id.linLayout_8);
        classOne = (EditText) findViewById(R.id.edit_message1);
        classTwo = (EditText) findViewById(R.id.edit_message2);
        classThree = (EditText) findViewById(R.id.edit_message3);
        classFour = (EditText) findViewById(R.id.edit_message4);
        classFive = (EditText) findViewById(R.id.edit_message5);
        classSix = (EditText) findViewById(R.id.edit_message6);
        classSeven = (EditText) findViewById(R.id.edit_message7);
        classEight = (EditText) findViewById(R.id.edit_message8);

        curr_num_classes = 4;

        HideShow();

    }


    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        classList = new ArrayList<String>();
        Intent intent = new Intent(this, DisplayMessageActivity.class);


        if (curr_num_classes >= 1)
            classList.add(classOne.getText().toString());
        if (curr_num_classes >= 2)
            classList.add(classTwo.getText().toString());
        if (curr_num_classes >= 3)
            classList.add(classThree.getText().toString());
        if (curr_num_classes >= 4)
            classList.add(classFour.getText().toString());
        if (curr_num_classes >= 5)
            classList.add(classFive.getText().toString());
        if (curr_num_classes >= 6)
            classList.add(classSix.getText().toString());
        if (curr_num_classes >= 7)
            classList.add(classSeven.getText().toString());
        if (curr_num_classes >= 8)
            classList.add(classEight.getText().toString());

        intent.putStringArrayListExtra(EXTRA_CLASSLIST, (ArrayList<String>) classList);
        intent.putExtra(EXTRA_NUM, curr_num_classes);
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


    public void removeClass(View view){
        if (curr_num_classes > 1) {
            curr_num_classes--;
            HideShow();
        }
        // what happens if you have something in the text of one of the EditTexts?
    }

    public void addClass(View view){
        if (curr_num_classes < 8) {
            curr_num_classes++;
            HideShow();
        }
    }

    private void HideShow(){
        classOneLayout.setVisibility(View.VISIBLE);
        classTwoLayout.setVisibility(View.VISIBLE);
        classThreeLayout.setVisibility(View.VISIBLE);
        classFourLayout.setVisibility(View.VISIBLE);
        classFiveLayout.setVisibility(View.VISIBLE);
        classSixLayout.setVisibility(View.VISIBLE);
        classSevenLayout.setVisibility(View.VISIBLE);
        classEightLayout.setVisibility(View.VISIBLE);

        switch (curr_num_classes) {
            case (1):
                System.out.println("started");
                classTwoLayout.setVisibility(View.GONE);
            case (2):
                System.out.println("from");
                classThreeLayout.setVisibility(View.GONE);
            case (3):
                System.out.println("the");
                classFourLayout.setVisibility(View.GONE);
            case (4):
                System.out.println("bottom");
                classFiveLayout.setVisibility(View.GONE);
            case (5):
                System.out.println("now");
                classSixLayout.setVisibility(View.GONE);
            case (6):
                System.out.println("we\'re");
                classSevenLayout.setVisibility(View.GONE);
            case (7):
                System.out.println("here");
                classEightLayout.setVisibility(View.GONE);
                break;
            default:
                System.out.println("Error hiding entries: curr_num_classes = " + curr_num_classes);

        }
    }


}
