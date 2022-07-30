package com.animaluniverses.nytimes.ui.home

import androidx.navigation.fragment.navArgs
import com.animaluniverses.nytimes.base.BaseFragment
import com.animaluniverses.nytimes.databinding.FragmentArticleDetailsBinding


class ArticleDetailsFragment : BaseFragment<FragmentArticleDetailsBinding>(FragmentArticleDetailsBinding::inflate) {
    val article : ArticleDetailsFragmentArgs by navArgs()
    override fun onBind() {
        article.article.let {
          binding.article = it
        }

    }

}