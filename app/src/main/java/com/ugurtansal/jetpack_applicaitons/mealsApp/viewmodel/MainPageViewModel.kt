package com.ugurtansal.jetpack_applicaitons.mealsApp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.ugurtansal.jetpack_applicaitons.mealsApp.entity.Meal
import com.ugurtansal.jetpack_applicaitons.mealsApp.repo.MealDaoRepo

class MainPageViewModel {
    val mRepo= MealDaoRepo()
    var mealsList= MutableLiveData<List<Meal>>()

    init{
        getMeals()
        mealsList=mRepo.getMealsList()
    }

    fun getMeals(){
        mRepo.getMeals()
    }
}