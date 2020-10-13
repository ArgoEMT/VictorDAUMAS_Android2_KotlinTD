package com.providence.rickandmorty_api_kotlin.ui.slideshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.firebase.ui.auth.AuthUI
import com.providence.rickandmorty_api_kotlin.DrawerActivity
import com.providence.rickandmorty_api_kotlin.LoginActivity
import com.providence.rickandmorty_api_kotlin.R


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