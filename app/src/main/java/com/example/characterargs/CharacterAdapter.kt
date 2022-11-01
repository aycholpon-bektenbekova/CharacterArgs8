package com.example.characterargs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.characterargs.databinding.ItemCharacterBinding
import kotlin.reflect.KFunction1

class CharacterAdapter(
    private val characterList: List<Character>,
    val onClick: KFunction1<Int, Unit>
): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = characterList.size

    inner class CharacterViewHolder(private var binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind() {
            val item = characterList[adapterPosition]
            binding.tvName.text = item.name
            binding.tvAge.text = item.age.toString()
        }
    }
}