package com.chaturaloka.dota2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chaturaloka.dota2.service.model.Hero
import com.chaturaloka.dota2.service.repository.HeroRepository


class HeroListViewModel(
    application: Application
) : AndroidViewModel(application) {

    private var observableHeroList: LiveData<List<Hero>>? = null

    init {
        observableHeroList = HeroRepository().getHeroesList()
    }

    fun getHeroObservable(): LiveData<List<Hero>>? {
        return observableHeroList
    }

    /**
     * A creator is used to inject the Hero ID into the ViewModel
     */
    class Factory(private val application: Application) :
        ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return HeroListViewModel(application) as T
        }
    }
}