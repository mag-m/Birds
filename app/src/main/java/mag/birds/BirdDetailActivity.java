package mag.birds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;

public class BirdDetailActivity extends AppCompatActivity {

    private Observation observation;
    private static final DateFormat dateFormat = DateFormat.getDateInstance();
    private int birdId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_detail);

        Intent intent = getIntent();
        Observation observation = (Observation) intent.getSerializableExtra("OBSERVATION");
        birdId = observation.getBirdId();

       // observation = (Observation) getIntent().getSerializableExtra("Observation");

        TextView birdIdView = findViewById(R.id.BirdDetailBirdIdTV);
        birdIdView.setText("Bird id: " + observation.getBirdId());

        TextView commentView = findViewById(R.id.BirdDetailCommentTV);
        commentView.setText("Comment: " + observation.getComment());

        TextView createdView = findViewById(R.id.BirdDetailCreatedTV);
        createdView.setText("Created: " + dateFormat.format(observation.getCreated().getTime()));
        //createdView.setText("Created: " + observation.getCreated());

        TextView idView = findViewById(R.id.BirdDetailIdTV);
        idView.setText("Id: " + observation.getId());

        TextView latitudeView = findViewById(R.id.BirdDetailLatitudeTV);
        latitudeView.setText("Latitude: " + observation.getLatitude());

        TextView longitudeView = findViewById(R.id.BirdDetailLongitudeTV);
        longitudeView.setText("Longitude: " + observation.getLatitude());

        TextView placenameView = findViewById(R.id.BirdDetailPlacenameTV);
        placenameView.setText("Placename: " + observation.getPlacename());

        TextView populationView = findViewById(R.id.BirdDetailPopulationTV);
        populationView.setText("Population: " + observation.getPopulation());

        TextView userIdView = findViewById(R.id.BirdDetailUserIdTV);
        userIdView.setText("UserId: " + observation.getUserId());

        TextView nameDanishView = findViewById(R.id.BirdDetailNameDanishTV);
        nameDanishView.setText("NameDanish: " + observation.getNameDanish());

        TextView nameEnglishView = findViewById(R.id.BirdDetailNameEnglishTV);
        populationView.setText("NameEnglish: " + observation.getNameEnglish());










    }
}
