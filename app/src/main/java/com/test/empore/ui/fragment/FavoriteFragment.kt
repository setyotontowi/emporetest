package com.test.empore.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.empore.App
import com.test.empore.R
import com.test.empore.data.model.News
import com.test.empore.databinding.FragmentFavoriteBinding
import com.test.empore.ui.NewsViewModel
import com.test.empore.ui.activity.NewsActivity
import com.test.empore.ui.adapter.NewsAdapter
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoriteFragment : Fragment() {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory
    private val newsViewModel: NewsViewModel by viewModels { vmFactory }
    private lateinit var binding: FragmentFavoriteBinding
    private val news :MutableList<News> = ArrayList()
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.application as App).appComponent.inject(this)

        initAdapter()
        initObserver()
    }

    private fun initAdapter() {
        newsAdapter = NewsAdapter(requireContext(), news)
        binding.news.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL, false)
        binding.news.adapter = newsAdapter

        newsAdapter.cardListener = {
            val intent = Intent(context, NewsActivity::class.java)
            intent.putExtra("URL", it.url)
            startActivity(intent)
        }

        newsAdapter.favListener = {
            it.favorite = !it.favorite
            newsViewModel.update(it)
        }
    }

    private fun initObserver() {
        newsViewModel.getFavorites()
        newsViewModel.localNews.observe(viewLifecycleOwner, {
            news.clear()
            news.addAll(it)
            newsAdapter.notifyDataSetChanged()
            binding.placeholder.stopShimmerAnimation()
            binding.placeholder.visibility = View.GONE
            binding.news.visibility = View.VISIBLE
        })
    }

    override fun onResume() {
        super.onResume()
        binding.placeholder.startShimmerAnimation()
    }

    override fun onPause() {
        super.onPause()
        binding.placeholder.stopShimmerAnimation()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment FavoriteFragment.
         */

        @JvmStatic
        fun newInstance() = FavoriteFragment()

    }
}