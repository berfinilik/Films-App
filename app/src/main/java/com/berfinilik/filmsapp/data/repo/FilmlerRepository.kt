package com.berfinilik.filmsapp.data.repo

import com.berfinilik.filmsapp.data.datasource.FilmlerDataSource
import com.berfinilik.filmsapp.data.entity.Filmler


class FilmlerRepository(var fds:FilmlerDataSource) {

    suspend fun filmleriYukle() : List<Filmler> = fds.filmleriYukle()
}