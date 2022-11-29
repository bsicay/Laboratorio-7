package gt.uvg.pokelist.view

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.databinding.ActivityMainBinding
import gt.uvg.pokelist.databinding.FragmentMainBinding
import gt.uvg.pokelist.model.ApiClient
import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.model.PokemonResponse
import retrofit2.Call
import retrofit2.Response


class MainFragment: Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var _binding:  FragmentMainBinding? = null;


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater,container, false)

        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val client = ApiClient.apiService.fetchPokemons()

        client.enqueue(object : retrofit2.Callback<PokemonResponse> {

            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {

                if (response.isSuccessful) {

                    val result = response.body()?.result

                    result?.let{

                        recyclerView = _binding!!.recyclerView
                        recyclerView.layoutManager = GridLayoutManager(context, 2)
                        recyclerView.adapter = PokemonListAdapter(result)

                    }


                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {

            }
        })


    }


}