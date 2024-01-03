package www.uzmd.lerning_retrofitcaraoutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import www.uzmd.lerning_retrofitcaraoutine.Modeal.AuthUser
import www.uzmd.lerning_retrofitcaraoutine.Modeal.NakrutkaServices
import www.uzmd.lerning_retrofitcaraoutine.Modeal.Post
import www.uzmd.lerning_retrofitcaraoutine.Modeal.ResUserPost
import www.uzmd.lerning_retrofitcaraoutine.databinding.ActivityMainBinding
import www.uzmd.lerning_retrofitcaraoutine.internet.AperServices
import www.uzmd.lerning_retrofitcaraoutine.internet.ApiCellent

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val network = ApiCellent.getRetrofit().create(AperServices::class.java)
    val scope = CoroutineScope(Dispatchers.IO)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            binding.progressBar.isVisible = true
        /*    try {
                val all = getNetvork()
                scope.async(Dispatchers.Main) { setTextFunc(all.get(3).botName.toString()) }
                binding.progressBar.isVisible = false
            } catch (e: Exception) {
                Log.d("log", "onCreate: $e")  // bu joy ma`lumot kelmay qolganda ishlaydi
            }*/



        }
        val post=Post(AuthUser("bek_vil","uz","bek_vil"))

    network.postMy(post).enqueue(object : Callback<ResUserPost> {
        override fun onResponse(call: Call<ResUserPost>, response: Response<ResUserPost>) {
            val mess=response.body()?.mess
            Log.d("TAG", "onResponse: $mess")
        }

        override fun onFailure(call: Call<ResUserPost>, t: Throwable) {

        }
    })

    }

    private fun setTextFunc(message: String) {
        binding.world.text = message
    }

    /*
    * Async faqat launch ni ichinda yoki scop . dep chaqirsa ishlarkan 1 marta hato qilding ahmaq boshqa hato ga o`rin yoq
    * async{} parallel ravishda ishlaydi await() javob qaytaradi
    *
    *
    * */
    private suspend fun getNetvork(): List<NakrutkaServices> {
        return scope.async { network.getAll() }.await()
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }

    /**
     * Extend olganda shu methot yaratiladi faqat cantruktorda bob qalmasin ahamyat bar
     *
     **/

}