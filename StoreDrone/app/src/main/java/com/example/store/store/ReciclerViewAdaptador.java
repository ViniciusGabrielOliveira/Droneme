package com.example.store.store;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.widget.Toast.LENGTH_SHORT;

public class ReciclerViewAdaptador extends RecyclerView.Adapter<ReciclerViewAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView modelo, marca, valor;
        ImageView imgDrone;

        public ViewHolder(View itemView){
            super(itemView);

            modelo = (TextView) itemView.findViewById(R.id.tvModelo);
            marca = (TextView) itemView.findViewById(R.id.tvMarca);
            valor = (TextView) itemView.findViewById(R.id.tvValor);
            imgDrone = (ImageView) itemView.findViewById(R.id.imgDrone);
        }

    }


    Context mContext;
    LayoutInflater inflater;
    List<DroneAndroid> droneAndroidLista;
    ArrayList<DroneAndroid> arrayList;

    public ReciclerViewAdaptador(Context context, List<DroneAndroid> droneAndroidLista) {
        mContext = context;
        this.droneAndroidLista = droneAndroidLista;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<DroneAndroid>();
        this.arrayList.addAll(droneAndroidLista);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetalhesActivity.class);
                intent.putExtra("actionBarTitle", droneAndroidLista.get(viewType).getEspec().getModelo());
                intent.putExtra("contentTV", droneAndroidLista.get(viewType).getEspec().toString());
                mContext.startActivity(intent);
            }
        });


        return viewHolder;
    }



    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.modelo.setText(droneAndroidLista.get(position).getEspec().getModelo());
        holder.marca.setText(droneAndroidLista.get(position).getEspec().getMarca());
        holder.valor.setText(droneAndroidLista.get(position).getEspec().getValor());
        holder.imgDrone.setImageDrawable(LoadImageFromWebOperations(droneAndroidLista.get(position).getEspec().getImgDrone()));

    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        droneAndroidLista.clear();
        if (charText.length()==0){
            Toast.makeText(mContext, "vazio", Toast.LENGTH_SHORT).show();
            droneAndroidLista.addAll(arrayList);
        }
        else {
            for (DroneAndroid drone : arrayList){
                if (drone.getEspec().getModelo().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    droneAndroidLista.add(drone);
                }
            }
        }
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return droneAndroidLista.size();
    }
}
