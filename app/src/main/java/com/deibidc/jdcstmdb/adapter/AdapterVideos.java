package com.deibidc.jdcstmdb.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.recyclerview.widget.RecyclerView;

import com.deibidc.jdcstmdb.R;
import com.deibidc.jdcstmdb.modelo.RetroVideo;

/**
 * Created by David Campos on 10/09/2021.
 */

public class AdapterVideos extends RecyclerView.Adapter<AdapterVideos.CustomViewHolder>{

    private RetroVideo dataList;
    private Context context;
    Context contexto;

    public AdapterVideos(Context context,RetroVideo dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        private WebView Video;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            Video = mView.findViewById(R.id.Video);
        }

    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_video, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.Video.loadUrl("https://www.youtube.com/watch?v="+dataList.getResponse().get(position).getKey());
    }

    @Override
    public int getItemCount() {
        return dataList.getResponse().size();
    }

}
