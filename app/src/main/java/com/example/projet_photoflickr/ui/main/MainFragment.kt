package com.example.projet_photoflickr.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.projet_photoflickr.R
import com.bumptech.glide.Glide
import com.example.projet_photoflickr.model.Photo
import com.example.projet_photoflickr.ui.liste.ListFragmentDirections

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreate(savedInstanceState)
        val layout = inflater.inflate(R.layout.main_fragment, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val imageView = layout.findViewById<ImageView>(R.id.photo)
        val titleView = layout.findViewById<TextView>(R.id.title)
        val btnnext = layout.findViewById<Button>(R.id.btnNext)
        val btlall = layout.findViewById<Button>(R.id.btnAll)



        btnnext.setOnClickListener {
            viewModel.nextPhoto()
        }

        btlall.setOnClickListener {
            Navigation.findNavController(btlall).navigate(R.id.versListeFragment);
        }

        viewModel.photoLiveData.observe(requireActivity(), { photoLiveData ->
            val url = "https://farm" + photoLiveData.farm + ".staticflickr.com/" + photoLiveData.server + "/" + photoLiveData.id+"_"+photoLiveData.secret + ".jpg"
            titleView.text = photoLiveData.title

            Glide.with(layout).load(url).into(imageView);

            imageView.setOnClickListener{
                val action = MainFragmentDirections.actionMainFragmentToFullFragment(url)
                Navigation.findNavController(imageView).navigate(action)
            }
        })






        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}