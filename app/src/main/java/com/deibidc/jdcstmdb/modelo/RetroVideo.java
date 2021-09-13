package com.deibidc.jdcstmdb.modelo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by David Campos on 10/09/2021.
 */

public class RetroVideo {

    @SerializedName("results")
    @Expose
    private List<RetroResponseVideo> response = null;

    public List<RetroResponseVideo> getResponse() {
        return response;
    }

    public void setResponse(List<RetroResponseVideo> response) {
        this.response = response;
    }

}

