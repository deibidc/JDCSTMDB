package com.deibidc.jdcstmdb.modelo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by David Campos on 10/09/2021.
 */

public class RetroPlaying {

    @SerializedName("results")
    @Expose
    private List<RetroResponsePlaying> response = null;

    public List<RetroResponsePlaying> getResponse() {
        return response;
    }

    public void setResponse(List<RetroResponsePlaying> response) {
        this.response = response;
    }

}

