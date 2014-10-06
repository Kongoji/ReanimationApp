package com.shawnbe.stopwatchDemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Reanimation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reanimation);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.reanimation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void doReanimation(View view) {

        Calendar c;
        int mhour, msecond, mnano;
        int mminute;

        //Timmy

        c = Calendar.getInstance();
        mhour = c.get(Calendar.HOUR);
        mminute = c.get(Calendar.MINUTE);
        msecond = c.get(Calendar.SECOND);
        mnano = c.get(Calendar.MILLISECOND);


        Log.d("Reanimation", mhour + ":" + mminute + ":" + msecond + ":" + mnano  );

        TextView counter = (TextView) findViewById(R.id.counter);
        int tpCounter = Integer.parseInt(counter.getText().toString());


        List<String> listItems = new ArrayList<String>();


        for (int d = tpCounter + 1; d < 7; d++) {
            listItems.add(String.valueOf(d));
        }

        final CharSequence[] items = listItems.toArray(new CharSequence[listItems.size()]);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Welche Reanimation hast du durchgeführt?");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                // Do something with the selection
                TextView counter = (TextView) findViewById(R.id.counter);
                counter.setText(items[item]);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();


    }


}
