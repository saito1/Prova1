package br.com.example.testfinder.show_addresses;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.example.testfinder.R;
import butterknife.BindView;
import butterknife.ButterKnife;

//Foi utilizado o butterKnife para a efetuar o binding e de views de maneira simples

public class ShowAddressesActivity extends AppCompatActivity implements  ShowAddressView{

    @BindView(R.id.rv_addresses) RecyclerView rvAddresses;

    ShowAddressPresenter showAddressPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_addresses);
        ButterKnife.bind(this);

        showAddressPresenter = new ShowAddressPresenter(this);

        //captura a lista enviada pela MainActivity
        ArrayList<String> lstAddresses = getIntent().getStringArrayListExtra("addresses_list");
        //instancia um AddressesAdapter passando a lista de endereços
        AddressesAdapter addressesAdapter = new AddressesAdapter(lstAddresses);

        //seta o adapter no Recycler View
        rvAddresses.setAdapter(addressesAdapter);

        //cria o gerenciador de layouts
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //seta o gerenciador de layouts no Recycler View
        rvAddresses.setLayoutManager(layoutManager);
    }

    public void showMap(String endereco){
        Intent intentMapa = new Intent(Intent.ACTION_VIEW);
        intentMapa.setData(Uri.parse("geo:0,0?q=" + endereco));
        if(intentMapa.resolveActivity(getPackageManager()) != null) {
            startActivity(intentMapa);
        }else {
            Toast toast = Toast.makeText(ShowAddressesActivity.this, "Impossível abrir o recurso", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    @Override
    public void OnClick(View view, int position, String endereco){
        showAddressPresenter.validaMapa(endereco);
    }


}