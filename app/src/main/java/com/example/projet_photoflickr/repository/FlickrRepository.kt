package com.example.projet_photoflickr.repository

import com.example.projet_photoflickr.model.SearchResult
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class FlickrRepository {
    suspend fun getPhotos(): SearchResult {
        val url = "https://www.flickr.com"
        val retrofit = Retrofit.Builder().baseUrl(url)
            .addConverterFactory(MoshiConverterFactory.create()).build()
        val service = retrofit.create(FlickrAPI::class.java)
        return service.getInterestingPhotos(
            "flickr.interestingness.getList",
            "34b3c6c1b435ac9b6b4206e3ca8bc32d",
            "20"
        )
    }
}