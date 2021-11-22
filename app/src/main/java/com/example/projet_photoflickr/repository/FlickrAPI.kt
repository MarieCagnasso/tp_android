package com.example.projet_photoflickr.repository

import com.example.projet_photoflickr.model.SearchResult
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrAPI {
    @GET("/services/rest?format=json&nojsoncallback=1")
    suspend fun getInterestingPhotos(@Query("method") method : String,
                                     @Query("api_key") key: String,
                                     @Query("per_page") perpage: String) : SearchResult
}