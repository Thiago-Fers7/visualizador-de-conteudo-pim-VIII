package com.pimviii.visualizador_de_conteudo.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.pimviii.visualizador_de_conteudo.MainActivity;
import com.pimviii.visualizador_de_conteudo.fragments.PlaylistsFragment;
import com.pimviii.visualizador_de_conteudo.fragments.ConteudosFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(MainActivity mainActivity) {
        super(mainActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new ConteudosFragment(); // Fragment de Conteúdos
        }
        return new PlaylistsFragment(); // Fragment de Playlists
    }

    @Override
    public int getItemCount() {
        return 2; // Duas abas: Conteúdos e Playlists
    }
}