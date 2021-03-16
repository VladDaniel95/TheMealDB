package com.example.proiect_piu.rest_API

import com.example.proiect_piu.model.model_API.IngredientRequest
import com.example.proiect_piu.model.model_API.IngredientResponse
import com.example.proiect_piu.model.model_API.IngredientResponseList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface IngredientApi {
    @GET( "api/json/v1/1/search.php/" )
    @Headers( "Content-Type: application/json" )
    fun ingredientApi(@Query("s") sth : String): Call<IngredientResponseList>



    companion object{
        private val httpInterceptor = HttpLoggingInterceptor().apply() {
            // there are different logging levels that provide a various amount of detail
            // we will use the most detailed one
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        private val httpClient = OkHttpClient.Builder().apply()
        {
            // add the interceptor to the newly created HTTP client
            this.addInterceptor ( httpInterceptor )
        }.build()
        fun create(): IngredientApi{
            val retrofit = Retrofit.Builder()
                .baseUrl ( " https://www.themealdb.com/" )
                .addConverterFactory ( GsonConverterFactory.create() )
                .client ( httpClient )
                .build()
            return retrofit.create(IngredientApi::class.java)
        }

    }
}