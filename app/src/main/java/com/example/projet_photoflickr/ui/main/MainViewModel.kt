package com.example.projet_photoflickr.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projet_photoflickr.model.Photo
import com.example.projet_photoflickr.model.Photos
import kotlinx.coroutines.launch
import com.example.projet_photoflickr.repository.FlickrRepository
import java.lang.Exception
import kotlin.math.log

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val photoLiveData = MutableLiveData<Photo>()
    var listPhotos = listOf<Photo>()
    var cpt = 0

    init {
        viewModelScope.launch {
            Log.v("test", "before")

            try {
                listPhotos = FlickrRepository().getPhotos().photos.photo
                Log.v("test", "work")
                photoLiveData.value = listPhotos[0]


            }catch (e:Exception){
                Log.v("test", "erreur")
            }
        }
    }

    fun nextPhoto(){
        cpt+=1
        photoLiveData.setValue(listPhotos[cpt])
        if(cpt==listPhotos.size-1){
            cpt=0
        }
    }

}
