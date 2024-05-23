package com.example.tugasday6;

public class TeamModel {
    private String name;
    private String region;
    private String follower;
    private int imageResourceId;

    public TeamModel(String name, String region, String follower, int imageResourceId) {
        this.name = name;
        this.region = region;
        this.follower = follower;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getFollower() {
        return follower;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
