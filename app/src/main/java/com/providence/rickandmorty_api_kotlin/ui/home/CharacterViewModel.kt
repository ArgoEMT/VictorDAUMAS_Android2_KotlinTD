package com.providence.rickandmorty_api_kotlin.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharacterViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the characters fragment"
    }
    val text: LiveData<String> = _text
}