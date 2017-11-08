package br.com.example.testfinder.show_addresses;

/**
 * Created by frankson on 08/11/17.
 */

public class ShowAddressPresenter {

    ShowAddressView showAddressView;

    ShowAddressPresenter(ShowAddressView showAddressView){
        this.showAddressView = showAddressView;
    }

    public void validaMapa(String endereco){

        showAddressView.showMap(endereco);

    }
}
