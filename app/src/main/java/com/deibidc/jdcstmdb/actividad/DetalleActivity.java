package com.deibidc.jdcstmdb.actividad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.deibidc.jdcstmdb.R;
import com.deibidc.jdcstmdb.adapter.AdapterPopular;
import com.deibidc.jdcstmdb.adapter.AdapterVideos;
import com.deibidc.jdcstmdb.conexion.GetDataService;
import com.deibidc.jdcstmdb.conexion.GetDataServiceVideo;
import com.deibidc.jdcstmdb.conexion.RetrofitClientPopular;
import com.deibidc.jdcstmdb.conexion.RetrofitClientVideo;
import com.deibidc.jdcstmdb.modelo.RetroPopular;
import com.deibidc.jdcstmdb.modelo.RetroVideo;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleActivity extends AppCompatActivity {

    private AdapterVideos adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;
    ImageView poster;
    TextView body_text;
    String posterOk, overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        poster = (ImageView) findViewById(R.id.img_poster);
        body_text = (TextView) findViewById(R.id.body_text);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            posterOk = extras.getString("poster");
            overview = extras.getString("overview");
        }
        getIntent().putExtra("","");

        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttp3Downloader(this));
        builder.build().load("https://image.tmdb.org/t/p/original" + posterOk)
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(poster);

        body_text.setText(overview);

        /*progressDoalog = new ProgressDialog(DetalleActivity.this);
        progressDoalog.setMessage("Cargando....");
        progressDoalog.setCancelable(false);
        progressDoalog.show();

        GetDataServiceVideo service = RetrofitClientVideo.getRetrofitInstance().create(GetDataServiceVideo.class);

        String api_key = "5cc36b3d2f9dd23114c2a67f842d8b64";
        String language = "en-US";
        String page = "1";

        Call<RetroVideo> call = service.getAllVideos(api_key, language);
        call.enqueue(new Callback<RetroVideo>() {

            @Override
            public void onResponse(Call<RetroVideo> call, Response<RetroVideo> response) {
                progressDoalog.dismiss();
                Log.e("Resp", ">" + response.toString());
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<RetroVideo> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(DetalleActivity.this, "Lo sentimos, hubo un error...Por favor intenta mas tarde!", Toast.LENGTH_SHORT).show();
                Log.e("Log",">" + t.toString());
            }
        });*/
    }

    private void generateDataList(RetroVideo videosList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new AdapterVideos(this,videosList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(DetalleActivity.this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}