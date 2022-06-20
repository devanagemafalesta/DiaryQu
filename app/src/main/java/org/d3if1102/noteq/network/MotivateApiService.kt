package org.d3if1102.noteq.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

    private const val BASE_URL = "https://raw.githubusercontent.com/" +
            "indraazimi/galeri-hewan/static-api/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    interface MotivateApiService {
        @GET("static-api.json")
        suspend fun getMotivate(): String
    }
    object MotivateApi {
        val service: MotivateApiService by lazy {
            retrofit.create(MotivateApiService::class.java)
        }
    }
