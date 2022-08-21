package com.kelway.films.presentation.listfilms

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.films.R
import com.kelway.films.databinding.FragmentListFilmsBinding
import com.kelway.films.presentation.FilmsApplication
import com.kelway.films.presentation.listener.ClickListenerFilm
import com.kelway.films.presentation.listfilms.recycler.ListFilmsAdapter
import com.kelway.films.utils.RequestStatus
import com.kelway.films.utils.showDialog
import javax.inject.Inject

class ListFilmsFragment : Fragment(R.layout.fragment_list_films) {
    private val binding by viewBinding<FragmentListFilmsBinding>()

    private val clickListenerFilm = object : ClickListenerFilm {
        override fun action(message: String) {
            requireActivity().showDialog(message)
        }
    }

    @Inject
    lateinit var listFilmsViewModel: ListFilmsViewModel
    private val adapter by lazy { ListFilmsAdapter(clickListenerFilm) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FilmsApplication.appComponent?.inject(this)
        initView()
    }

    private fun initView() {
        binding.recycler.adapter = adapter
        listFilmsViewModel.listFilms.observe(viewLifecycleOwner) { listFilms ->
            when (listFilms) {
                is RequestStatus.Success -> adapter.submitItem(listFilms.data)
                is RequestStatus.Error -> requireActivity().showDialog(listFilms.message)
            }
        }
    }
}