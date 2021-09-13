package com.deibidc.jdcstmdb.actividad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.deibidc.jdcstmdb.R;
import com.deibidc.jdcstmdb.adapter.AdapterPlayingnow;
import com.deibidc.jdcstmdb.adapter.AdapterPopular;
import com.deibidc.jdcstmdb.conexion.GetDataService;
import com.deibidc.jdcstmdb.conexion.GetDataServicePlaying;
import com.deibidc.jdcstmdb.conexion.RetrofitClientPlaying;
import com.deibidc.jdcstmdb.conexion.RetrofitClientPopular;
import com.deibidc.jdcstmdb.modelo.RetroPlaying;
import com.deibidc.jdcstmdb.modelo.RetroPopular;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by David Campos on 10/09/2021.
 */

public class MainActivity extends AppCompatActivity {

    private AdapterPopular adapter;
    private AdapterPlayingnow adapterPlaying;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Cargando....");
        progressDoalog.setCancelable(false);
        progressDoalog.show();

        GetDataService service = RetrofitClientPopular.getRetrofitInstance().create(GetDataService.class);

        String api_key = "5cc36b3d2f9dd23114c2a67f842d8b64";
        String language = "en-US";
        String page = "1";

        Call<RetroPopular> call = service.getAllPopulares(api_key, language, page);
        call.enqueue(new Callback<RetroPopular>() {

            @Override
            public void onResponse(Call<RetroPopular> call, Response<RetroPopular> response) {
                progressDoalog.dismiss();
                Log.e("Resp", ">" + response.toString());
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<RetroPopular> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Lo sentimos, hubo un error...Por favor intenta mas tarde!", Toast.LENGTH_SHORT).show();
                Log.e("Log",">" + t.toString());
            }
        });
    }

    public void muestraPlayibg(){
        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Cargando....");
        progressDoalog.setCancelable(false);
        progressDoalog.show();

        GetDataServicePlaying servicePlaying = RetrofitClientPlaying.getRetrofitInstance().create(GetDataServicePlaying.class);

        String api_key_playing = "5cc36b3d2f9dd23114c2a67f842d8b64";
        String language_playing = "en-US";
        String page_playing = "1";

        Call<RetroPlaying> callPlaying = servicePlaying.getAllPlaying(api_key_playing, language_playing, page_playing);
        callPlaying.enqueue(new Callback<RetroPlaying>() {

            @Override
            public void onResponse(Call<RetroPlaying> call, Response<RetroPlaying> response) {
                progressDoalog.dismiss();
                Log.e("Resp", ">" + response.toString());
                generateDataListPlaying(response.body());
            }

            @Override
            public void onFailure(Call<RetroPlaying> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Lo sentimos, hubo un error...Por favor intenta mas tarde!", Toast.LENGTH_SHORT).show();
                Log.e("Log",">" + t.toString());
            }
        });
    }

    public void muestraPopulares(){
        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Cargando....");
        progressDoalog.setCancelable(false);
        progressDoalog.show();

        GetDataService service = RetrofitClientPopular.getRetrofitInstance().create(GetDataService.class);

        String api_key = "5cc36b3d2f9dd23114c2a67f842d8b64";
        String language = "en-US";
        String page = "1";

        Call<RetroPopular> call = service.getAllPopulares(api_key, language, page);
        call.enqueue(new Callback<RetroPopular>() {

            @Override
            public void onResponse(Call<RetroPopular> call, Response<RetroPopular> response) {
                progressDoalog.dismiss();
                Log.e("Resp", ">" + response.toString());
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<RetroPopular> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Lo sentimos, hubo un error...Por favor intenta mas tarde!", Toast.LENGTH_SHORT).show();
                Log.e("Log",">" + t.toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.populares:
                muestraPopulares();
                return true;
            case R.id.playing:
                muestraPlayibg();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void generateDataList(RetroPopular popularesList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new AdapterPopular(this,popularesList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void generateDataListPlaying(RetroPlaying playingList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapterPlaying = new AdapterPlayingnow(this,playingList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterPlaying);
    }

}