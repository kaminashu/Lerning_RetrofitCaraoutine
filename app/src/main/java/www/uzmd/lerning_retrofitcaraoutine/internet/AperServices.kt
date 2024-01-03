package www.uzmd.lerning_retrofitcaraoutine.internet

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import www.uzmd.lerning_retrofitcaraoutine.Modeal.NakrutkaServices
import www.uzmd.lerning_retrofitcaraoutine.Modeal.Post
import www.uzmd.lerning_retrofitcaraoutine.Modeal.ResUserPost

interface AperServices {
    @GET("showBots.php")
   suspend fun getAll(): List<NakrutkaServices>
   @POST("Panohim/")
    fun postMy(@Body post: Post):Call<ResUserPost>
}