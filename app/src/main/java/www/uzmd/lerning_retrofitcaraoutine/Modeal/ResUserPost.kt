package www.uzmd.lerning_retrofitcaraoutine.Modeal

import com.google.gson.annotations.SerializedName

data class ResUserPost(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("res_id")
	val resId: Int? = null,

	@field:SerializedName("mess")
	val mess: String? = null
)


