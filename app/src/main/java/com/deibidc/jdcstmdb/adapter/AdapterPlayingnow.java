package com.deibidc.jdcstmdb.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.deibidc.jdcstmdb.R;
import com.deibidc.jdcstmdb.modelo.RetroPlaying;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by David Campos on 10/09/2021.
 */

public class AdapterPlayingnow extends RecyclerView.Adapter<AdapterPlayingnow.CustomViewHolder> {

    private RetroPlaying dataList;
    private Context context;
    Context contexto;

    public AdapterPlayingnow(Context context, RetroPlaying dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final View mView;

        TextView txtTitle, txtIdMovie;
        private ImageView coverImage;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            contexto = mView.getContext();

            txtIdMovie = mView.findViewById(R.id.idMovie);
            txtTitle = mView.findViewById(R.id.title);
            coverImage = mView.findViewById(R.id.coverImage);
        }
        public void setOnClickListeners(){
            coverImage.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            Toast.makeText(contexto, txtIdMovie.getText(),Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.getResponse().get(position).getOriginal_titlee());
        holder.txtIdMovie.setText(dataList.getResponse().get(position).getId());
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load("https://image.tmdb.org/t/p/original" + dataList.getResponse().get(position).getBackdrop_pathh())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);
        holder.setOnClickListeners();
    }

    @Override
    public int getItemCount() {
        return dataList.getResponse().size();
    }
}
