package mag.birds;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;
import android.widget.AdapterView;

import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ReadTask task = new ReadTask();
        task.execute("http://birdobservationservice.azurewebsites.net/Service1.svc/observations");
    }

    private final List<Observation> observationList = new ArrayList<>();
    private ArrayAdapter<Observation> adapter = null;




    private class ReadTask extends ReadHttpTask {

        @Override
        protected void onPostExecute(CharSequence jsonString) {

            try {
                JSONArray array = new JSONArray(jsonString.toString());
                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);

                    int birdid = obj.getInt("BirdId");
                    String comment = obj.getString("Comment");
                    String stringcreated = obj.getString("Created");

                    Calendar created = JsonDateToDate(stringcreated);

                    int id = obj.getInt("Id");
                    double latitude = obj.getDouble("Latitude");
                    double longitude = obj.getDouble("Longitude");
                    String placename = obj.getString("Placename");
                    int population = obj.getInt("Population");
                    String userid = obj.getString("UserId");
                    String namedanish = obj.getString("NameDanish");
                    String nameenglish = obj.getString("NameEnglish");

                    Observation observation = new Observation(birdid, comment, created, id, latitude, longitude, placename, population, userid, namedanish, nameenglish);
                    observationList.add(observation);
                }

                ListView listview = findViewById(R.id.MainAllBirdsListView);
                adapter = new ArrayAdapter<Observation>(getBaseContext(), android.R.layout.simple_list_item_1, observationList);
                listview.setAdapter(adapter);
                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getBaseContext(),BirdDetailActivity.class);
                        Observation observation = observationList.get((int) id);
                        intent.putExtra("OBSERVATION", observation);
                        startActivity(intent);
                    }
                });


            } catch (JSONException ex) {
                Log.e("SHIT", ex.getMessage());
            }


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.toolbarLogout:

                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Konverterer fra epoch..
    public static Calendar JsonDateToDate(String jsonDate) {
        //  "/Date(1321867151710+0100)/"
        int idx1 = jsonDate.indexOf("(");
        int idx2 = jsonDate.indexOf(")") - 5;
        String s = jsonDate.substring(idx1 + 1, idx2);
        long timeInMilliSeconds = Long.valueOf(s);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMilliSeconds);
        return calendar;
    }

    public void MainOrderByNameClicked(View view) {
    Collections.sort(observationList, new Comparator<Observation>() {
        @Override
        public int compare(Observation o1, Observation o2) {
            return o1.getNameEnglish().compareToIgnoreCase(o2.getNameEnglish());
        }
    });
    adapter.notifyDataSetChanged();
    }


    public void MainYourBirdsClicked(View view) {
        Intent intent = new Intent(this, YourBirdsActivity.class);
        startActivity(intent);
    }



    public void MainOrderByDateClicked(View view) {
 Collections.sort(observationList, new Comparator<Observation>() {
     @Override
     public int compare(Observation o1, Observation o2) {
         if (o2.getCreated() == null || o1.getCreated() == null)
             return 0;
         return o2.getCreated().compareTo(o1.getCreated());
     }
 });
        adapter.notifyDataSetChanged();
 }
}
