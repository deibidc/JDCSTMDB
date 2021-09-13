package com.deibidc.jdcstmdb.modelo;

import com.google.gson.annotations.SerializedName;

public class RetroResponsePlaying {

    @SerializedName("poster_path")
    private String backdrop_path;
    @SerializedName("id")
    private Integer id;
    @SerializedName("original_title")
    private String original_title;
    @SerializedName("overview")
    private String overview;
    @SerializedName("vote_average")
    private String vote_average;

    public RetroResponsePlaying(String backdrop_path, Integer id, String original_title, String overview, String vote_average) {
        this.backdrop_path = backdrop_path;
        this.id = id;
        this.original_title = original_title;
        this.overview = overview;
        this.vote_average = vote_average;
    }

    public String getBackdrop_pathh() { return backdrop_path; }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginal_titlee() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

}
