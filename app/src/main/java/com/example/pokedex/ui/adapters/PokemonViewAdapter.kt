package com.example.pokedex.ui.adapters

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.pokedex.R
import com.example.pokedex.databinding.ListItemPokemonBinding
import com.example.pokedex.domain.uimodel.PokemonUi
import com.example.pokedex.ui.utils.getPicUrl
import kotlinx.android.synthetic.main.list_item_pokemon.view.*

class PokemonViewAdapter : PagingDataAdapter<PokemonUi, PokemonViewAdapter.ViewHolder>(
    PokemonUiItemComparator
) {

    var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<ListItemPokemonBinding>(
            inflater, viewType, parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun getItemViewType(position: Int) = R.layout.list_item_pokemon

    inner class ViewHolder(
        private val binding: ListItemPokemonBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        var dominantColor: Int = 0

        fun bind(item: PokemonUi) {
            binding.item = item
            binding.invalidateAll()
            itemView.pokemonItemTitle.text = item.name
            Glide.with(itemView)
                .load(item?.urlId.getPicUrl())
                .transition(DrawableTransitionOptions.withCrossFade())
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        itemView.progress_circular.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {

                        val drawable = resource as BitmapDrawable
                        val bitmap = drawable.bitmap
                        Palette.Builder(bitmap).generate {
                            it?.let { palette ->
                                dominantColor = palette.getDominantColor(
                                    ContextCompat.getColor(
                                        itemView.context,
                                        R.color.white
                                    )
                                )

                                itemView.pokemonItemImage.setBackgroundColor(dominantColor)
                                itemView.card.setCardBackgroundColor(dominantColor)


                            }
                        }
                        itemView.progress_circular.visibility = View.GONE
                        return false
                    }

                })
                .into(itemView.pokemonItemImage)

            onItemClickListener?.let { listener ->
                itemView.setOnClickListener { listener.onItemClick(item.name) }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(id: String)
    }

    object PokemonUiItemComparator : DiffUtil.ItemCallback<PokemonUi>() {
        override fun areItemsTheSame(
            oldItem: PokemonUi,
            newItem: PokemonUi
        ) = oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: PokemonUi,
            newItem: PokemonUi
        ) = oldItem == newItem
    }
}
