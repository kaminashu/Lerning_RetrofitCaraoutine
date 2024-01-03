package www.uzmd.lerning_retrofitcaraoutine.internet

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiCellent {
const val BASE_URL="https://turbotaxi.uz/"
fun getRetrofit():Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
}
}