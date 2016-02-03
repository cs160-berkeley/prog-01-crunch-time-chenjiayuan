package bosschen.crunchtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //spinner
        final Spinner spinner = (Spinner) findViewById(R.id.exercise_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.exercises_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //change unit according to spinner selection
        TextView repminSelectText = (TextView)findViewById(R.id.repminSelect);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                TextView repminSelectText = (TextView) findViewById(R.id.repminSelect);
                changeImage(spinner.getSelectedItem().toString());
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    //change source image
    private void changeImage(String e) {
        ImageView view = (ImageView)findViewById(R.id.imageView);
        TextView description = (TextView)findViewById(R.id.wiki);
        if (e.equals("Pushup")) {
            view.setImageResource(R.drawable.pushup);
            description.setText(R.string.wiki1);
        } else if (e.equals("Situp")) {
            view.setImageResource(R.drawable.situp);
            description.setText(R.string.wiki2);
        } else if (e.equals("Squats")) {
            view.setImageResource(R.drawable.squats);
            description.setText(R.string.wiki3);
        } else if (e.equals("Leg-lift")) {
            view.setImageResource(R.drawable.leglift);
            description.setText(R.string.wiki4);
        } else if (e.equals("Plank")) {
            view.setImageResource(R.drawable.plank);
            description.setText(R.string.wiki5);
        } else if (e.equals("Jumping Jacks")) {
            view.setImageResource(R.drawable.jumpingjack);
            description.setText(R.string.wiki6);
        } else if (e.equals("Pullup")) {
            view.setImageResource(R.drawable.pullup);
            description.setText(R.string.wiki7);
        } else if (e.equals("Cycling")) {
            view.setImageResource(R.drawable.cycling);
            description.setText(R.string.wiki8);
        } else if (e.equals("Walking")) {
            view.setImageResource(R.drawable.walking);
            description.setText(R.string.wiki9);
        } else if (e.equals("Jogging")) {
            view.setImageResource(R.drawable.jogging);
            description.setText(R.string.wiki10);
        } else if (e.equals("Swimming")) {
            view.setImageResource(R.drawable.swimming);
            description.setText(R.string.wiki11);
        } else if (e.equals("Stair-Climbing")) {
            view.setImageResource(R.drawable.stairclimbing);
            description.setText(R.string.wiki12);
        } else {
            view.setImageResource(R.drawable.pushup);
            description.setText(R.string.wiki1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //handle option select
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Intent intent;
        switch (item.getItemId()) {
            case R.id.help:
                intent = new Intent(this, Main4Activity.class);
                startActivity(intent);
                return true;
            case R.id.option1:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.option2:
                intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                return true;
            case R.id.option3:
                intent = new Intent(this, Main3Activity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
