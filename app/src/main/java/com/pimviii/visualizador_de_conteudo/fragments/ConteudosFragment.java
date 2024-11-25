package com.pimviii.visualizador_de_conteudo.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pimviii.visualizador_de_conteudo.MainActivity;
import com.pimviii.visualizador_de_conteudo.R;
import com.pimviii.visualizador_de_conteudo.adapter.ConteudoAdapter;
import com.pimviii.visualizador_de_conteudo.models.Conteudo;
import com.pimviii.visualizador_de_conteudo.models.Playlist;
import com.pimviii.visualizador_de_conteudo.network.ApiClient;
import com.pimviii.visualizador_de_conteudo.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

    public class ConteudosFragment extends Fragment {
        private RecyclerView recyclerView;
        private Spinner spinner;
        private ConteudoAdapter conteudoAdapter;
        private ApiService apiService;

        public ConteudosFragment() { }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_conteudos, container, false);

            recyclerView = view.findViewById(R.id.recyclerViewConteudos);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            spinner = recyclerView.findViewById(R.id.playlistSpinner);

            apiService = ApiClient.getClient().create(ApiService.class);
            fetchConteudosAndPlaylists();

            return view;
        }

        private void fetchConteudosAndPlaylists() {
            apiService.getConteudos().enqueue(new Callback<List<Conteudo>>() {
                @Override
                public void onResponse(Call<List<Conteudo>> call, Response<List<Conteudo>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        List<Conteudo> conteudos = response.body();


                        apiService.getPlaylists().enqueue(new Callback<List<Playlist>>() {
                            @Override
                            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                                if (response.isSuccessful() && response.body() != null) {
                                    List<Playlist> playlists = response.body();

                                    conteudoAdapter = new ConteudoAdapter(getContext(), conteudos, playlists);
                                    recyclerView.setAdapter(conteudoAdapter);
                                }
                            }

                            @Override
                            public void onFailure(Call<List<Playlist>> call, Throwable t) {
                                Log.i("erro", t.getMessage());
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<List<Conteudo>> call, Throwable t) {
                    Log.i("erro", t.getMessage());
                }
            });
        }
    }