package br.com.example.testfinder.show_addresses;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.example.testfinder.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressesAdapter extends RecyclerView.Adapter<AddressesAdapter.ViewHolder>{

    private List<String> addressesList;
    OnRecyclerViewSelected onRecyclerViewSelected;

    //Construtor para receber a lista
    AddressesAdapter(List<String> addressesList){
        this.addressesList = addressesList;
    }

    //Infla o layout XML
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_list_item, parent, false);
        return new ViewHolder(v);
    }

    //Seta os dados na lista
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvAddress.setText(addressesList.get(position));
    }

    //Retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return addressesList.size();
    }

    //Mapeamento dos componentes da View
    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_address) TextView tvAddress;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        //SetaClick
        @OnClick(R.id.address_item)
        void onItemClick(View view){
            if(onRecyclerViewSelected != null){
                onRecyclerViewSelected.onClick(view, getAdapterPosition(),tvAddress.getText().toString());

            }
        }
    }

    public void setOnRecyclerViewSelected(OnRecyclerViewSelected onRecyclerViewSelected){
        this.onRecyclerViewSelected = onRecyclerViewSelected;
    }


}