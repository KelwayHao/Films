package com.kelway.films.presentation.listfilms.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kelway.films.R
import com.kelway.films.databinding.ItemFilmBinding
import com.kelway.films.domain.model.Film
import com.kelway.films.presentation.listener.ClickListenerFilm
import com.kelway.films.utils.toDirectorNameWithInitials

class ListFilmsViewHolder(
    private val binding: ItemFilmBinding,
    private val clickListenerFilm: ClickListenerFilm
) : RecyclerView.ViewHolder(binding.cardView) {
    companion object {
        fun newInstance(parent: ViewGroup, clickListenerFilm: ClickListenerFilm) =
            ListFilmsViewHolder(
                ItemFilmBinding.bind(
                    LayoutInflater.from(parent.context)
                        .inflate(
                            R.layout.item_film,
                            parent,
                            false
                        )
                ),
                clickListenerFilm
            )
    }

    fun bindItem(item: Film) {
        val context = itemView.context
        with(item) {
            binding.titleFilm.text =
                context.getString(R.string.title_film, title, releaseYear)
            binding.directorFilm.text = directorName.toDirectorNameWithInitials()
            binding.listActorFilm.text = actors.joinToString { actor ->
                actor.actorName
            }
            itemView.setOnClickListener {
                clickListenerFilm.action(context.getString(R.string.message_click_film, title))
            }
        }
    }
}