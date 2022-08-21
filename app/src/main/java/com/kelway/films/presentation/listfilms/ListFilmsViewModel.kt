package com.kelway.films.presentation.listfilms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelway.films.domain.interactor.FilmInteractor
import com.kelway.films.domain.model.Film
import com.kelway.films.utils.Request
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListFilmsViewModel @Inject constructor(private val interactor: FilmInteractor) : ViewModel() {

    private val _listFilms = MutableLiveData<Request<List<Film>>>()
    val listFilms: LiveData<Request<List<Film>>> get() = _listFilms

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val requestResult = interactor.getFilm()

            if (requestResult is Request.Success) {
                _listFilms.postValue(
                    Request.Success(requestResult.data?.sortedBy { film ->
                        film.releaseYear
                    }?.reversed()!!)
                )
            } else {
                _listFilms.postValue(requestResult)
            }
        }
    }
}