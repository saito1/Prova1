package br.com.example.testfinder.show_addresses;

import android.view.View;

/**
 * Created by frankson on 08/11/17.
 */

public interface ShowAddressView {
    public void showMap(String endereco);
    void OnClick(View view, int position, String endereco);
}
