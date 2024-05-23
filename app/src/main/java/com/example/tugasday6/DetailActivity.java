package com.example.tugasday6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private ImageView teamImage;
    private TextView teamName;
    private TextView teamRegion;
    private TextView teamFollower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        teamImage = findViewById(R.id.team_image);
        teamName = findViewById(R.id.team_name);
        teamRegion = findViewById(R.id.team_region);
        teamFollower = findViewById(R.id.team_follower);

        Intent intent = getIntent();
        if (intent != null) {
            teamName.setText(intent.getStringExtra("name"));
            teamRegion.setText(intent.getStringExtra("region"));
            teamFollower.setText(intent.getStringExtra("follower"));
            teamImage.setImageResource(intent.getIntExtra("imageResourceId", R.drawable.ic_launcher_background));
        }
    }
}

