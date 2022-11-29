package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private var _binding : FragmentDetailBinding? = null;
    private val args : DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val currentPokemon = args.currentPokemon
        val pokemonId = args.pokemonId

        _binding!!.pokemonNameTextView.text = currentPokemon.name

        Picasso.get().load(currentPokemon.getImageUrlFront(pokemonId)).into(_binding!!.imageView2)
        Picasso.get().load(currentPokemon.getImageUrlBack(pokemonId)).into(_binding!!.imageView3)
        Picasso.get().load(currentPokemon.getImageUrlShinnyFront(pokemonId)).into(_binding!!.imageView4)
        Picasso.get().load(currentPokemon.getImageUrlShinnyBack(pokemonId)).into(_binding!!.imageView5)

        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}