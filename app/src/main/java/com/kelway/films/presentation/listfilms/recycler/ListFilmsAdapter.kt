package com.kelway.films.presentation.listfilms.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kelway.films.domain.model.Film
import com.kelway.films.presentation.listener.ClickListenerFilm

class ListFilmsAdapter(private val clickListenerFilm: ClickListenerFilm) :
    RecyclerView.Adapter<ListFilmsViewHolder>() {

    private var items: List<Film> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListFilmsViewHolder {
        return ListFilmsViewHolder.newInstance(parent, clickListenerFilm)
    }

    override fun onBindViewHolder(holder: ListFilmsViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun submitItem(listItem: List<Film>) {
        items = listItem
        notifyDataSetChanged()
    }
}