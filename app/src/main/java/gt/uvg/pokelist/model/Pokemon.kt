package gt.uvg.pokelist.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Pokemon(@Json(name = "name") val name: String) : Parcelable
{

    fun getImageUrlFront(id: Int): String{
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
    }
    fun getImageUrlBack(id: Int): String{
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/$id.png"
    }
    fun getImageUrlShinnyFront(id: Int): String{
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/$id.png"
    }
    fun getImageUrlShinnyBack(id: Int): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/$id.png"
    }
}

data class PokemonResponse(@Json(name = "results")
val result : List<Pokemon>)