package com.ugurtansal.jetpack_applicaitons.contactsApp.viewModelFactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ugurtansal.jetpack_applicaitons.contactsApp.viewmodel.DetailPageViewModel
import com.ugurtansal.jetpack_applicaitons.contactsApp.viewmodel.MainPageViewModel

class DetailPageViewModelFactory (var application: Application) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailPageViewModel(application) as T
    }
}