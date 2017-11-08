package br.com.example.testfinder.main;

import java.util.ArrayList;

/**
 * Created by frankson on 08/11/17.
 */

public interface MainView {
    //criação do metodo showAdress para mostrar os endereços
    void showActivityAdress(ArrayList<String> lstAddress);
    void showActivityAdressError();
}
