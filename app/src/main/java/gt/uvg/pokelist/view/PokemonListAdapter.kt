package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.R
import gt.uvg.pokelist.databinding.ActivityMainBinding
import gt.uvg.pokelist.databinding.ItemPokemonViewBinding
import gt.uvg.pokelist.model.Pokemon

class PokemonListAdapter(private val pokemonList: List<Pokemon>) : RecyclerView.Adapter<PokemonListAdapter.PokemonListHolder>() {

    inner class PokemonListHolder(val itemBinding: ItemPokemonViewBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        val pokemonName = itemBinding.pokemonName2;
        val pokemonImage = itemBinding.pokemonPhoto2;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListHolder {
        val binding = ItemPokemonViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonListHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonListHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.pokemonName.text = pokemon.name;
        Picasso.get().load(pokemon.getImageUrlFront(position+1)).into(holder.pokemonImage);

        holder.itemView.setOnClickListener {
                Navigation.findNavController(holder.itemView).navigate(
                    MainFragmentDirections.actionMainFragmentToDetailFragment(pokemon, position+1)
                )
        }
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}