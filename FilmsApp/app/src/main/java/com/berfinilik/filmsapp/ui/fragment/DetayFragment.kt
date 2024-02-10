package com.berfinilik.filmsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.berfinilik.filmsapp.R
import com.berfinilik.filmsapp.databinding.FragmentAnasayfaBinding
import com.berfinilik.filmsapp.databinding.FragmentDetayBinding

class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetayBinding.inflate(inflater, container, false)

        val bundle:DetayFragmentArgs by navArgs()//gönderilen veriyi aldık
        val film=bundle.film

        binding.toolbarDetay.title=film.ad

        binding.imageView2.setImageResource(
            resources.getIdentifier(film.resim,"drawable",requireContext().packageName))//fragmenttayız zaten o yüzden mContexte gerek yok

        binding.textViewFiyat.text="${film.fiyat} ₺"



        return binding.root
    }
}