package com.providence.rickandmorty_api_kotlin.ui.slideshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.firebase.ui.auth.AuthUI
import com.providence.rickandmorty_api_kotlin.ui.activity.LoginActivity


class SlideshowFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logOut()
    }

    private fun logOut()
    {
        this.context?.let {
            AuthUI.getInstance()
                .signOut(it)
                .addOnCompleteListener { // user is now signed out
                    val intent = Intent(activity, LoginActivity::class.java)
                    startActivity(intent)
                }
        }
    }
}