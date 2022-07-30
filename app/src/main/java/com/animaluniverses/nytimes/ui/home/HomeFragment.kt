package com.animaluniverses.nytimes.ui.home

import androidx.navigation.fragment.findNavController
import com.animaluniverses.nytimes.base.BaseFragment
import com.animaluniverses.nytimes.databinding.FragmentHomeBinding
import com.animaluniverses.nytimes.ui.adapters.ArticleAdapter
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    val homeViewModel:HomeViewModel  by inject()

    private val articleAdapter by lazy {
        ArticleAdapter{
            val action = HomeFragmentDirections.actionHomeFragmentToArticleDetailsFragment(it)
            findNavController().navigate( action)
        }
    }

    override fun onBind() {
        binding.articlesRV.adapter = articleAdapter
        homeViewModel.fetchArticlesList()

        homeViewModel.loading.observe(viewLifecycleOwner){
            loading(it)
        }

        homeViewModel.articles.observe(viewLifecycleOwner){
                articleAdapter.submitList(it)
        }


    }
}