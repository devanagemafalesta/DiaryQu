package org.d3if1102.noteq.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if1102.noteq.model.Motivasi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import retrofit2.http.GET

    private const val BASE_URL = "https://raw.githubusercontent.com/" +
            "devanagemafalesta/DiaryQu/static_api/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    interface MotivateApiService {
        @GET("static-api.json")
        suspend fun getMotivate(): List<Motivasi>
    }
    object MotivateApi {
        val service: MotivateApiService by lazy {
            retrofit.create(MotivateApiService::class.java)
        }

        fun getMotivasiUrl(nama:String): String{
            return "$BASE_URL$nama.jpg"
        }
    }
enum class ApiStatus { LOADING, SUCCESS, FAILED }
