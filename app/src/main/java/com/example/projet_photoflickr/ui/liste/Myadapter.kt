package com.example.projet_photoflickr.ui.liste

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projet_photoflickr.R
import com.example.projet_photoflickr.model.Photo

class MyAdapter (val photos : List<Photo>,val callback: (kotlin.Int) -> kotlin.Unit) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    // un ViewHolder permet de stocker la vue de chaque item de la liste
    class MyViewHolder(val v: android.widget.GridLayout) : RecyclerView.ViewHolder(v)


    // appelé quand le ViewHolder doit être créé (probablement parce que l'item devient visible)
    // on crée (inflate) le layout "user" et on le place dans le ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.photo,parent,false)
        val holder = MyViewHolder(layout as android.widget.GridLayout)
        Log.v("debug", "my adaptater")

        return holder
    }

    // appelé quand le recycerview a besoin de connaître la taille de la liste qu'il doit afficher
    override fun getItemCount(): Int = photos.size


    // appelé quand on doit peupler le ViewHolder avec le contenu de l'élément numéro "position"
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position:Int) {
        val imageView = holder.v.findViewById<ImageView>(R.id.photoCard)
        val photo = photos[position]
        val url = "https://farm" + photo.farm + ".staticflickr.com/" + photo.server + "/" + photo.id+"_"+photo.secret + ".jpg"
        Log.d("ADebugTag", "Value url: " + url);

        Glide.with(holder.v.context).load(url).into(imageView);

        imageView.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToFullFragment(url)
            Navigation.findNavController(holder.v).navigate(action)
        }
    }
}