package com.deibidc.jdcstmdb.modelo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by David Campos on 10/09/2021.
 */

public class RetroPopular {

    @SerializedName("results")
    @Expose
    private List<RetroResponse> response = null;

    public List<RetroResponse> getResponse() {
        return response;
    }

    public void setResponse(List<RetroResponse> response) {
        this.response = response;
    }

}

