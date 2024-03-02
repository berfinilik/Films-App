package com.berfinilik.filmsapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.berfinilik.filmsapp.R
import com.berfinilik.filmsapp.data.entity.Filmler
import com.berfinilik.filmsapp.databinding.CardTasarimBinding
import com.berfinilik.filmsapp.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

//cardtasarımı tutuyor görsel nesnelere erişmemizi saglayacak

//3 tane metot var recyclerviewla çalışmak için

class FilmlerAdapter(var mContext:Context,var filmlerListesi:List<Filmler>)
    :RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(var tasarim:CardTasarimBinding):RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding:CardTasarimBinding=DataBindingUtil.inflate(LayoutInflater.from(mContext),
            R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(binding)

    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        //holder kartın üzerindeki görsel nesnelere erişmek için position ise indexle erişmek içindir
        val film=filmlerListesi.get(position)
        val t=holder.tasarim
        t.imageViewFilm.setImageResource(
            mContext.resources.getIdentifier(film.resim,"drawable",mContext.packageName))

        t.filmNesnesi=film

        t.cardviewFilm.setOnClickListener {
            val gecis=AnasayfaFragmentDirections.detayGecis(film=film)//hangisini seçersem o filmi bana vericek
            Navigation.findNavController(it).navigate(gecis)

        }

        t.buttonSepet.setOnClickListener {
            Snackbar.make(it,"${film.ad} sepete eklendi.",Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }

}