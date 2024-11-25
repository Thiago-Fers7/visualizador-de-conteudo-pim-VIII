package com.pimviii.visualizador_de_conteudo;

import static com.pimviii.visualizador_de_conteudo.network.ApiClient.getClient;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pimviii.visualizador_de_conteudo.adapter.ConteudoAdapter;
import com.pimviii.visualizador_de_conteudo.adapter.ViewPagerAdapter;
import com.pimviii.visualizador_de_conteudo.databinding.ActivityMainBinding;
import com.pimviii.visualizador_de_conteudo.models.Conteudo;
import com.pimviii.visualizador_de_conteudo.models.Playlist;
import com.pimviii.visualizador_de_conteudo.network.ApiClient;
import com.pimviii.visualizador_de_conteudo.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ConteudoAdapter conteudoAdapter;
    private RecyclerView recyclerView;
    private  final ArrayList<Conteudo> conteudosList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        // Configure o ViewPager com o Adapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // Conecte o TabLayout com o ViewPager
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Conteúdos");
                            break;
                        case 1:
                            tab.setText("Playlists");
                            break;
                    }
                }
        ).attach();

        // searchConteudos();
    }

//    private void searchConteudos() {
//        ApiService api = getClient().create(ApiService.class);
//
//        api.getConteudos().enqueue(new Callback<List<Conteudo>>() {
//           @Override
//           public void onResponse(Call<List<Conteudo>> call, Response<List<Conteudo>> response) {
//               if (response.isSuccessful()) {
//                   ArrayList<Conteudo> conteudos = (ArrayList<Conteudo>) response.body();
//
//                   if (conteudos != null) {
//                       for (Conteudo conteudo: conteudos) {
//                           int id = conteudo.getId();
//                           String titulo = conteudo.getTitulo();
//                           String tipo = conteudo.getTipo();
//                           int criadorId = conteudo.getCriadorId();
//
//                           conteudosList.add(new Conteudo(id, titulo, tipo, criadorId));
//                       }
//                   } else {
//                       Toast.makeText(MainActivity.this, "Erro ao buscar conteúdos", Toast.LENGTH_SHORT).show();
//                   }
//
//                   RecyclerView recyclerViewConteudos = binding.recyclerViewConteudos;
//                   recyclerViewConteudos.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//                   recyclerViewConteudos.setHasFixedSize(true);
//                   conteudoAdapter = new ConteudoAdapter(conteudosList, MainActivity.this);
//                   recyclerViewConteudos.setAdapter(conteudoAdapter);
//               }
//           }
//
//           @Override
//           public void onFailure(Call<List<Conteudo>> call, Throwable t) {
//               Log.i("teste", t.getMessage());
//               Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//           }
//        });
//    }
}