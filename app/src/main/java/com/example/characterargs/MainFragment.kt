package com.example.characterargs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.characterargs.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val characterList = arrayListOf<Character>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
        val adapter = CharacterAdapter(characterList, this::onClick)
        binding.rvCharacter.adapter = adapter
    }

    private fun loadData() {

        characterList.add(Character("Annalise Kitting", 51))
        characterList.add(Character("Wes Gibbins", 22))
        characterList.add(Character("Laurel Castillo", 22))
        characterList.add(Character(" Bonnie Winterbottom"))
        characterList.add(Character("Connor Walsh", 25))
        characterList.add(Character("Asher Millstone", 28))
        characterList.add(Character("Francis Delfino", 32))
        characterList.add(Character("Gabriel Maddox", 20))
        characterList.add(Character("Michaela Pratt", 23))
        characterList.add(Character("Oliver Hampton", 30))
        characterList.add(Character("Tegan Price", 37))
    }

    private fun onClick(position: Int) {

        findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(
            characterList[position].toString()
        ))
    }

}

