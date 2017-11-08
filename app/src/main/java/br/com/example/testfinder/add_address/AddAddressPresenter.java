package br.com.example.testfinder.add_address;

import android.widget.TextView;

/**
 * Created by frankson on 08/11/17.
 */

/*
* A classe Presenter foi criado para atender o requisito 4, o Presenter lida com toda a parte logica
* É importante notar a utilização do view para a chamada dos metodos que ficaram no Model(AddAddressActivity)
*
* */
public class AddAddressPresenter {
    //Declaração da interface para acessar os metodos
    private AddAddressView addView;

    //Contrutor recebendo a addView como parametro
    AddAddressPresenter(AddAddressView addView){
        this.addView = addView;
    }

    public void adicionaEnd(TextView edtAddress){
        //verifica se há um endereço digitado
        if (edtAddress.getText().toString().isEmpty()){
            addView.verificaEnd();
        }else {
            //retorna o endereço para a MainActivity
            addView.retornaParaMain();
        }
    }
}
