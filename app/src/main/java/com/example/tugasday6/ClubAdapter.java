package com.example.tugasday6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.TeamViewHolder> {
    private List<TeamModel> teamList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(TeamModel team);
    }

    public ClubAdapter(List<TeamModel> teamList, OnItemClickListener listener) {
        this.teamList = teamList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        TeamModel team = teamList.get(position);
        holder.bind(team, listener);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        private ImageView teamImage;
        private TextView teamName;
        private TextView teamRegion;
        private TextView teamFollower;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            teamImage = itemView.findViewById(R.id.team_image);
            teamName = itemView.findViewById(R.id.team_name);
            teamRegion = itemView.findViewById(R.id.team_region);
            teamFollower = itemView.findViewById(R.id.team_follower);
        }

        public void bind(final TeamModel team, final OnItemClickListener listener) {
            teamImage.setImageResource(team.getImageResourceId());
            teamName.setText(team.getName());
            teamRegion.setText(team.getRegion());
            teamFollower.setText(team.getFollower());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(team);
                }
            });
        }
    }
}
