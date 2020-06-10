package com.pad.tiktok;

import com.google.gson.annotations.SerializedName;



class VideoInfo {
    @SerializedName("description")
    public String description;
    @SerializedName("likecount")
    public int likeCount;
    @SerializedName("avatar")
    public String avatarUrl;
    @SerializedName("_id")
    public String _id;
    @SerializedName("feedurl")
    public String feedUrl;
    @SerializedName("nickname")
    public String nickname;


    @Override
    public String toString() {
        return "VideoInfo{" +
                "id=" + _id +
                ", feedUrl='" + feedUrl +
                ", nickname=" + nickname +
                ", description=" + description +
                ", likeCount=" + likeCount +
                ", avatar=" + avatarUrl +
                '}';
    }
}
