package com.animaluniverses.nytimes.ui.home

import androidx.navigation.fragment.navArgs
import com.animaluniverses.nytimes.base.BaseFragment
import com.animaluniverses.nytimes.databinding.FragmentArticleDetailsBinding
import com.animaluniverses.nytimes.loadImageUrl


class ArticleDetailsFragment : BaseFragment<FragmentArticleDetailsBinding>(FragmentArticleDetailsBinding::inflate) {
    val article : ArticleDetailsFragmentArgs by navArgs()
    override fun onBind() {
        article.article.let {
            binding.txtTitle.text = it.title
            binding.txtPublishedDate.text = binding.txtPublishedDate.text.toString().plus(" ").plus(it.published_date)
            binding.txtByline.text = it.byline
            binding.txtSection.text = it.section
            binding.txtDescription.text = it.description

            if(!it.subsection.isNullOrEmpty()){
                binding.txtSubsection.text = "/".plus(it.subsection)
            }

            it.media?.forEach { media ->
                media.metadata?.forEach { mediaMetaData ->
                    binding.imgPoster.loadImageUrl(mediaMetaData.url)
                    binding.txtCaption.text= media.caption
                }
            }
        }

    }

}