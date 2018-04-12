package mag.birds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BirdDetailActivity extends AppCompatActivity {

    private Observation observation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_detail);

        Intent intent = getIntent();
        observation = (Observation) getIntent().getSerializableExtra("Observation");


    }
}
