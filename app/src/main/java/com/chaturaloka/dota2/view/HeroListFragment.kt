package com.chaturaloka.dota2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chaturaloka.dota2.R
import com.chaturaloka.dota2.databinding.HeroesListFragmentBinding
import com.chaturaloka.dota2.service.model.Hero
import com.chaturaloka.dota2.view.adapter.HeroAdapter
import com.chaturaloka.dota2.viewmodel.HeroListViewModel


class HeroListFragment : Fragment() {

    private lateinit var heroAdapter: HeroAdapter

    companion object {
        val TAG: String? = HeroListFragment.toString()
    }

    private lateinit var listViewModel: HeroListViewModel
    private lateinit var factory: HeroListViewModel.Factory
    private lateinit var binding: HeroesListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.heroes_list_fragment, container, false)
        heroAdapter = HeroAdapter()
        binding.heroList.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.heroList.adapter = heroAdapter
        binding.isLoading = true

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        factory = HeroListViewModel.Factory(activity!!.application)

        listViewModel = ViewModelProviders.of(this, factory).get(HeroListViewModel::class.java)

        observeViewModel(listViewModel)
    }

    private fun observeViewModel(listViewModel: HeroListViewModel) {
        // Update the list when the data changes
        listViewModel.getHeroObservable()?.observe(this,
            Observer<List<Hero>> { Heros ->
                if (Heros != null) {
                    binding.isLoading = false
                    heroAdapter.setHeroList(Heros)
                }
            })
    }

    /*private val HeroClickCallback = object : HeroClickCallback() {
        fun onClick(Hero: Hero) {
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                (activity as MainActivity).show(Hero)
            }
        }
    }*/
}
