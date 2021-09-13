package com.deibidc.jdcstmdb.adapter;


import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.deibidc.jdcstmdb.actividad.DetalleActivity;
import com.deibidc.jdcstmdb.R;
import com.deibidc.jdcstmdb.conexion.RetrofitClientPopular;
import com.deibidc.jdcstmdb.conexion.RetrofitClientVideo;
import com.deibidc.jdcstmdb.modelo.RetroPopular;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

/**
 * Created by David Campos on 10/09/2021.
 */

public class AdapterPopular extends RecyclerView.Adapter<AdapterPopular.CustomViewHolder>{

    private RetroPopular dataList;
    private Context context;
    Context contexto;

    public AdapterPopular(Context context,RetroPopular dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final View mView;

        TextView txtTitle, txtIdMovie, poster, overview;
        private ImageView coverImage;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            contexto = mView.getContext();
            Activity activity = (Activity) contexto;

            poster = mView.findViewById(R.id.poster);
            overview = mView.findViewById(R.id.overview);
            txtIdMovie = mView.findViewById(R.id.idMovie);
            txtTitle = mView.findViewById(R.id.title);
            coverImage = mView.findViewById(R.id.coverImage);
        }

        public void setOnClickListeners(){
            coverImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            RetrofitClientVideo retroClient = new RetrofitClientVideo();
            retroClient.idMovie = txtIdMovie.getText().toString() + "/";

            Intent detalleIntent = new Intent(contexto, DetalleActivity.class);
            detalleIntent.putExtra("poster",poster.getText().toString());
            detalleIntent.putExtra("overview",overview.getText().toString());
            contexto.startActivity(detalleIntent);
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

        holder.txtTitle.setText(dataList.getResponse().get(position).getOriginal_title());
        holder.txtIdMovie.setText(dataList.getResponse().get(position).getId());
        holder.poster.setText(dataList.getResponse().get(position).getPoster());
        holder.overview.setText(dataList.getResponse().get(position).getOverview());
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load("https://image.tmdb.org/t/p/original" + dataList.getResponse().get(position).getBackdrop_path())
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
