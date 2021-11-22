package com.example.projet_photoflickr.ui.liste

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projet_photoflickr.R

class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.list_fragment, container, false)
        val recyclerView = layout.findViewById<RecyclerView>(R.id.recyclerview)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        recyclerView.layoutManager = GridLayoutManager(requireActivity(),2)

        viewModel.photosLiveData.observe(requireActivity(), { photos ->

            recyclerView.adapter = MyAdapter(photos){position ->

            }
        })

        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}