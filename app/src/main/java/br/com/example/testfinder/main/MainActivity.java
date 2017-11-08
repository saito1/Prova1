package br.com.example.testfinder.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.example.testfinder.R;
import br.com.example.testfinder.add_address.AddAddressActivity;
import br.com.example.testfinder.show_addresses.ShowAddressesActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

//Frankson Teotonho de Sousa 619540
//Rafael Bastos Saito 726580

/*
* Foi utilizado o butterKnife para a efetuar o binding e de views e criar event listeners de maneira simples
*Toda a logica presente foi passada para a classe Presenter(MainPresenter)
*Porem, a implementação dos metodos usados pelo presenter permaneceram aqui
* È importante notar o uso da interface view(MainView) para obrigar a utilizar alguns metodos presentes na interface
* */

public class MainActivity extends AppCompatActivity implements MainView {

    //código utilizado para adicionar novos endereços
    private final int RC_ADD_ADDRESS = 123;

    //Chamando o presenter para lidar com a parte logica
    MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainPresenter = new MainPresenter(this);

    }

    public void showActivityAdress(ArrayList<String> lstAddress){
        //abre a ShowAddressActivity enviando a lista de endereços
        Intent openShowAddressActivity = new Intent(MainActivity.this, ShowAddressesActivity.class);
        openShowAddressActivity.putStringArrayListExtra("addresses_list", lstAddress);
        startActivity(openShowAddressActivity);
    }

    public void showActivityAdressError(){
        Toast.makeText(MainActivity.this, "Não há endereços cadastrados", Toast.LENGTH_SHORT).show();
    }

    //Recebe o resultado da activity addAdressActivity e adiciona ele na lista
    //A partir do metodo addAdressInList implementado no mainPresenter
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mainPresenter.addAdressInList(requestCode, resultCode, data);
    }


    //Ao clicar no botão de adicionar o endereço, passa-se para uma nova activity
    //abre a activity para adicionar endereço

    @OnClick(R.id.btn_add_address)
    public void adressAdded(){
        Intent openAddAddressActivity = new Intent(MainActivity.this, AddAddressActivity.class);
        startActivityForResult(openAddAddressActivity, RC_ADD_ADDRESS);

    }

    //abre a activity para exibir os endereços cadastrados
    @OnClick(R.id.btn_show_addresses)
    public void showAdresses(){
        mainPresenter.showAdresses();
    }
}