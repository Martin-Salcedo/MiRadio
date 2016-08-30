package com.example.martinsalcedo.miradio.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.martinsalcedo.miradio.R;
import com.example.martinsalcedo.miradio.domain.Artist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by martinsalcedo on 11/08/16.
 */

public class HipedArtistsAdater extends RecyclerView.Adapter<HipedArtistsAdater.HipedArtistViewHolder> {

    private static final String TAG = HipedArtistsAdater.class.getSimpleName();

    //se crea un ArrayList para obtener los datos del api y manipularlos
    ArrayList<Artist> artists;

    Context context;//se obtiene el contexto de la actividad
//se crea el contructor para que se tenga comunicacion con la actividad
    public HipedArtistsAdater(Context context) {
        this.context = context;
        this.artists = new ArrayList<>();
    }

    @Override
    public HipedArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //se crea la vista el cual va inflar la vista, y el cual se le pasa tambien el
        //ViewGroup el cual indica donde se va a mostrar la vista
        //el ultimo parametro se indica
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_hiped_artist, parent, false);
//regresa un objeto tipo hipedArtistHolder el cual creamos
        return new HipedArtistViewHolder(itemView);
    }

//    Metodo para conectar la vista con los datos
    @Override
    public void onBindViewHolder(HipedArtistViewHolder holder, int position) {
        Artist currentArtist = artists.get(position);//se ejecuta cada vez que se obtiene de los daots
//        Log.d(TAG, currentArtist.getNombre());
        Log.d(TAG, String.valueOf(currentArtist.getNombre()));
        holder.setArtisName(currentArtist.getNombre());

//        setear la imagen

        if (currentArtist.getMediumImage() != null){
            holder.setArtistImage(currentArtist.getMediumImage());
        }else{
            holder.setArtistDefaultImage();
        }
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void addAll(@NonNull ArrayList<Artist> artists){

        if (artists == null)
            throw new NullPointerException("La lista no puede ir vacia");

        this.artists.addAll(artists);
        notifyItemRangeInserted(getItemCount() -1, artists.size());

    }

    public class HipedArtistViewHolder extends RecyclerView.ViewHolder{

        //atributos del ViewHolder
        TextView artistName;
        ImageView imageArtist;

        public HipedArtistViewHolder(View itemView) {
            super(itemView);

            artistName = (TextView) itemView.findViewById(R.id.txt_name);
            imageArtist = (ImageView) itemView.findViewById(R.id.img_artist);

        }
//se crea un metodo para modificar el contenido
        public void setArtisName(String name){
            artistName.setText(name);
        }

        public void setArtistImage(String url){
            Picasso.with(context)
                    .load(url)
                    .placeholder(R.drawable.artist_hiped).into(imageArtist);
        }

        public void setArtistDefaultImage(){
            Picasso.with(context).load(R.drawable.artist_hiped).into(imageArtist);
        }
    }

}
