package br.com.example.testfinder.main;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;

/**
 * Created by frankson on 08/11/17.
 */


/*
* A classe Presenter foi criado para atender o requisito 4, o Presenter lida com toda a parte logica
* É importante notar a utilização do view para a chamada dos metodos que ficaram no Model(MainActivity)
*
* */
public class MainPresenter {

    //Declaração da interface para acessar os metodos
    private MainView mainview;
    //código utilizado para adicionar novos endereços
    private final int RC_ADD_ADDRESS = 123;
    //lista de endereços
    private ArrayList<String> lstAddresses = new ArrayList<>();

    //Contrutor recebendo a mainview como parametro
    MainPresenter(MainView mainview){
        this.mainview = mainview;
    }

    //verifica se há endereços cadastrados antes executar a activity
    public void showAdresses(){
        if(lstAddresses.size() <= 0){
            mainview.showActivityAdressError();
        }else{
            mainview.showActivityAdress(lstAddresses);
        }
    }
    //Chamado pelo mainActivity adiciona um novo endereço a lista
    public void addAdressInList(int requestCode, int resultCode, Intent data){
        //captura o resultado da tela de cadastro de endereços e adiciona na lista
        if(requestCode == RC_ADD_ADDRESS && resultCode == Activity.RESULT_OK) {
            lstAddresses.add(data.getStringExtra("movie_name"));
        }
    }





}
