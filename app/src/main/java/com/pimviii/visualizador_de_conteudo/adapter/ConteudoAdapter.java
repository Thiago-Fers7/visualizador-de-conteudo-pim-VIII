package com.pimviii.visualizador_de_conteudo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pimviii.visualizador_de_conteudo.R;
import com.pimviii.visualizador_de_conteudo.models.Conteudo;
import com.pimviii.visualizador_de_conteudo.models.Playlist;

import java.util.List;

public class ConteudoAdapter extends RecyclerView.Adapter<ConteudoAdapter.ConteudoViewHolder> {

    private Context context;
    private List<Conteudo> conteudos;
    private List<Playlist> playlists;

    public ConteudoAdapter(Context context, List<Conteudo> conteudos, List<Playlist> playlists) {
        this.context = context;
        this.conteudos = conteudos;
        this.playlists = playlists;
    }

    @Override
    public ConteudoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_conteudo, parent, false);
        return new ConteudoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ConteudoViewHolder holder, int position) {
        Conteudo conteudo = conteudos.get(position);
        holder.titulo.setText(conteudo.getTitulo());
        holder.tipo.setText(conteudo.getTipo());

        // Personalizar o adapter do Spinner para mostrar o nome da playlist
        ArrayAdapter<Playlist> adapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item, playlists) {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView textView = (TextView) view;
                Playlist playlist = (Playlist) getItem(position);
                if (playlist != null) {
                    // Exibe o nome da playlist ou qualquer outro campo relevante
                    textView.setText(playlist.getNome());  // Supondo que você tenha um método getNome() na classe Playlist
                }
                return view;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view;
                Playlist playlist = (Playlist) getItem(position);
                if (playlist != null) {
                    // Exibe o nome da playlist na seleção do Spinner
                    textView.setText(playlist.getNome());  // Supondo que você tenha um método getNome() na classe Playlist
                }
                return view;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.playlistSpinner.setAdapter(adapter);
    }


    @Override
    public int getItemCount() {
        return conteudos.size();
    }

    public static class ConteudoViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView tipo;
        Spinner playlistSpinner;

        public ConteudoViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo);
            tipo = itemView.findViewById(R.id.tipo);
            playlistSpinner = itemView.findViewById(R.id.playlistSpinner);
        }
    }
}