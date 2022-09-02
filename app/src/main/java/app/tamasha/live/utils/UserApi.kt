package app.tamasha.live.utils

import app.tamasha.live.model.UserList
import retrofit2.Response
import retrofit2.http.GET
interface UserApi {
    @GET("61cf7d91-a7f8-405e-b505-67926b759d78")
    suspend fun getUsers(): Response<UserList>
}