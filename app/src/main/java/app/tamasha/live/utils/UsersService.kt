package app.tamasha.live.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class UserService {

    private val BASE_URL = "https://mocki.io/v1/"
    fun getUsersService(): UserApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }
}