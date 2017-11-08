package br.com.example.testfinder.add_address;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import br.com.example.testfinder.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/*
* Foi utilizado o butterKnife para a efetuar o binding e de views e criar event listeners de maneira simples
*Toda a logica presente foi passada para a classe Presenter(AddAddressPresenter)
*Porem, a implementação dos metodos usados pelo presenter permaneceram aqui
* È importante notar o uso da interface view(AddAdressView) para obrigar a utilizar alguns metodos presentes na interface
* */
public class AddAddressActivity extends AppCompatActivity implements AddAddressView {

    @BindView(R.id.edt_address) TextView edtAddress;

    AddAddressPresenter addPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        ButterKnife.bind(this);

        addPresenter = new AddAddressPresenter(this);

    }

    @OnClick(R.id.btn_add)
    public void addAdress(){
        addPresenter.adicionaEnd(edtAddress);
    }

    public void verificaEnd(){
        Toast.makeText(AddAddressActivity.this, "Digite o endereço que deseja adicionar", Toast.LENGTH_SHORT).show();
    }
    public void retornaParaMain(){
        Intent resultIntent = new Intent();
        resultIntent.putExtra("movie_name", edtAddress.getText().toString());
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }


}