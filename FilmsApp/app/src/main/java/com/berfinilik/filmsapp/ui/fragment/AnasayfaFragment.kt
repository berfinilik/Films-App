package com.berfinilik.filmsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.berfinilik.filmsapp.R
import com.berfinilik.filmsapp.data.entity.Filmler
import com.berfinilik.filmsapp.databinding.FragmentAnasayfaBinding
import com.berfinilik.filmsapp.ui.adapter.FilmlerAdapter


class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding =FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.toolbarAnasayfa.title="Filmler"

        binding.filmRv.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)


        val filmlerListesi = ArrayList<Filmler>()
        val f1 = Filmler(1,"Django","django",24)
        val f2 = Filmler(2,"Interstellar","interstellar",32)
        val f3 = Filmler(3,"Inception","inception",16)
        val f4 = Filmler(4,"The Hateful Eight","thehatefuleight",28)
        val f5 = Filmler(5,"The Pianist","thepianist",18)
        val f6 = Filmler(6,"Once Upon A Tıme In Anatolıa","anadoluda",10)
        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)
        filmlerListesi.add(f5)
        filmlerListesi.add(f6)

        //listemiz hazır artık adapterda gösterebiliriz

        val filmlerAdapter=FilmlerAdapter(requireContext(),filmlerListesi)
        binding.filmRv.adapter=filmlerAdapter




        return binding.root
    }
}