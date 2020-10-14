package com.providence.rickandmorty_api_kotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.providence.rickandmorty_api_kotlin.model.Cocktail
import com.providence.rickandmorty_api_kotlin.model.ListCocktail
import com.providence.rickandmorty_api_kotlin.webservice.api.Webservice
import kotlinx.android.synthetic.main.fragment_cocktail_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A fragment representing a list of Items.
 */
class CocktailFragment : Fragment() {
    private lateinit var webservice: Webservice
    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cocktail_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchCocktails()
    }
    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            CocktailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    private fun fetchCocktails() {
        Log.i("1003", "Enter the fetchCocktails")

        var adapter: MyItemRecyclerViewAdapter? = null
        webservice = Webservice()

        val call: Call<ListCocktail?>? = webservice.getService()?.getCocktail()
        call?.enqueue(object : Callback<ListCocktail?> {

            override fun onResponse(call: Call<ListCocktail?>, response: Response<ListCocktail?>) {
                Log.i("1003", Integer.toString(response.code()))

                if (response.body() != null) {
                    adapter = MyItemRecyclerViewAdapter(response.body()?.getCocktails() as List<Cocktail>)
                    list.adapter = adapter
                }
            }

            override fun onFailure(call: Call<ListCocktail?>, t: Throwable) {
                t.message?.let { Log.i("1003", it) }
            }
        })
    }
}