package com.deibidc.jdcstmdb.modelo;

import com.google.gson.annotations.SerializedName;

public class RetroResponseVideo {

    @SerializedName("name")
    private String name;
    @SerializedName("key")
    private String key;


    public RetroResponseVideo(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setId(String key) {
        this.key = key;
    }

}
