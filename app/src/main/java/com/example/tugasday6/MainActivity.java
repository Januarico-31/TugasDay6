package com.example.tugasday6;

import static android.icu.lang.UCharacter.LineBreak.JT;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ClubAdapter teamAdapter;
    private List<TeamModel> teamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize team list
        teamList = new ArrayList<>();
        teamList.add(new TeamModel("Alter Ego", "Indonesia", "1JT", R.drawable.alter_ego));
        teamList.add(new TeamModel("APBren", "Philippines", "31,1RB", R.drawable.apbren));
        teamList.add(new TeamModel("Aura Fire", "Indonesia", "4JT", R.drawable.aura));
        teamList.add(new TeamModel("Bigetron Alpha", "Philippines", "3JT", R.drawable.bigetron));
        teamList.add(new TeamModel("Blacklist International", "Philippines", "123RB", R.drawable.blacklist));
        teamList.add(new TeamModel("Dewa United", "Indonesia", "126RB", R.drawable.dewa_united));
        teamList.add(new TeamModel("Echo", "Philippines", "138RB", R.drawable.echo));
        teamList.add(new TeamModel("Evos Glory", "Indonesia", "7JT", R.drawable.evos));
        teamList.add(new TeamModel("Geek Fam", "Indonesia", "395RB", R.drawable.geek_fam));
        teamList.add(new TeamModel("Minana Evos", "Philippines", "3111", R.drawable.minanaevos));
        teamList.add(new TeamModel("Onic ID", "Indonesia", "2,4JT", R.drawable.onic));
        teamList.add(new TeamModel("Onic PH", "Philippines", "49,7RB", R.drawable.onicph));
        teamList.add(new TeamModel("Rebellion Zion", "Indonesia", "113RB", R.drawable.rebellion));
        teamList.add(new TeamModel("RRQ Hoshi", "Indonesia", "5,2JT", R.drawable.rrq));
        teamList.add(new TeamModel("RSG PH", "Philippines", "16,3RB", R.drawable.rsgph));
        teamList.add(new TeamModel("Smart Omega", "Philippines", "16,3RB", R.drawable.omega));
        teamList.add(new TeamModel("TNC", "Philippines", "4950", R.drawable.tnc));
        // Tambahkan item tim lainnya hingga minimal 15 tim

        teamAdapter = new ClubAdapter(teamList, new ClubAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(TeamModel team) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("name", team.getName());
                intent.putExtra("region", team.getRegion());
                intent.putExtra("follower", team.getFollower());
                intent.putExtra("imageResourceId", team.getImageResourceId());
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(teamAdapter);
    }
}
