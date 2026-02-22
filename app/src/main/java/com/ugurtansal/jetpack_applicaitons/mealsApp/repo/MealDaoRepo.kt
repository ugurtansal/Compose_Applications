package com.ugurtansal.jetpack_applicaitons.mealsApp.repo

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.MutableLiveData
import com.ugurtansal.jetpack_applicaitons.mealsApp.entity.Meal

class MealDaoRepo {
    var mealList= MutableLiveData<List<Meal>>()

    init {
        mealList= MutableLiveData()
    }

    fun getMealList(): MutableLiveData<List<Meal>>{
        return mealList
    }

    fun getMeals(){
       val list= mutableStateListOf<Meal>(
            Meal(1, "Köfte", "kofte", 15),
            Meal(2, "Ayran", "ayran", 20),
            Meal(3, "Fanta", "fanta", 25),
            Meal(4, "Makarna", "makarna", 25),
            Meal(5, "Kadayıf", "kadayif", 25),
            Meal(6, "Baklava", "baklava", 25)
        )

        mealList.value=list
    }


}