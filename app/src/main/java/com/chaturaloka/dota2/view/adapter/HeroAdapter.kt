package com.chaturaloka.dota2.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chaturaloka.dota2.databinding.HeroListItemBinding
import com.chaturaloka.dota2.service.model.Hero


class HeroAdapter : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    private var heroList: List<Hero>

    init {
        heroList = arrayListOf()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HeroListItemBinding.inflate(inflater)
        return HeroViewHolder(binding)
    }

    override fun getItemCount(): Int = heroList.size

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) = holder.bind(heroList[position])

    inner class HeroViewHolder(private val itemBinding: HeroListItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Hero) {
            Log.d("HeroViewHolder", "bind (line 32): ${item.localized_name}")
            with(itemBinding) {
                if (item.localized_name != null) {
                    heroName.text = item.localized_name
                } else {
                    heroName.text = "---"
                }
            }
        }
    }

    fun setHeroList(heros: List<Hero>) {
        heroList = heros
        notifyItemChanged(0, heros.size)
    }
}