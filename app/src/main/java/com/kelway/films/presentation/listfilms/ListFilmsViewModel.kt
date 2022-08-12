package com.kelway.films.presentation.listfilms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelway.films.domain.interactor.FilmInteractor
import com.kelway.films.domain.model.Film
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListFilmsViewModel @Inject constructor(private val interactor: FilmInteractor) : ViewModel() {

    private val _listFilms = MutableLiveData<List<Film>>()
    val listFilms: LiveData<List<Film>> get() = _listFilms

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _listFilms.postValue(interactor.getFilm()
                .sortedBy { film ->
                    film.releaseYear
                }.reversed()
            )
        }
    }
}