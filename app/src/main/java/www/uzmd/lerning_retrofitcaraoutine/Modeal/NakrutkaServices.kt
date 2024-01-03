package www.uzmd.lerning_retrofitcaraoutine.Modeal

import com.google.gson.annotations.SerializedName

data class NakrutkaServices(

	@field:SerializedName("bot_name")
	val botName: String? = null,

	@field:SerializedName("narx")
	val narx: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("reyting")
	val reyting: String? = null,

	@field:SerializedName("info")
	val info: String? = null
)