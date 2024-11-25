package com.pimviii.visualizador_de_conteudo.network;

import com.pimviii.visualizador_de_conteudo.models.Conteudo;
import com.pimviii.visualizador_de_conteudo.models.Playlist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @GET("conteudos")
    Call<List<Conteudo>> getConteudos();

    @GET("playlists")
    Call<List<Playlist>> getPlaylists();

    @POST("playlists")
    Call<Playlist> createPlaylist(@Body Playlist playlist);

    @POST("playlists/{id}")
    Call<Void> addConteudoToPlaylist(@Path("id") int playlistId, @Body Conteudo conteudo);

}