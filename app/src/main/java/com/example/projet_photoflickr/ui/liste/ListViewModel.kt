package com.example.projet_photoflickr.ui.liste

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projet_photoflickr.model.Photo
import com.example.projet_photoflickr.repository.FlickrRepository
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
    val photosLiveData = MutableLiveData<List<Photo>>()

    init {
        viewModelScope.launch {
            try {
                photosLiveData.value = FlickrRepository().getPhotos().photos.photo
                Log.v("debug", "work2")
                Log.d("ADebugTag", "Value: " + photosLiveData.value);

            }catch (e:Exception){
                Log.v("debug", "erreur2")
            }
        }
    }
}