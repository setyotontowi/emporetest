package com.test.empore.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.empore.App
import com.test.empore.data.model.News
import com.test.empore.databinding.FragmentHomeBinding
import com.test.empore.ui.NewsViewModel
import com.test.empore.ui.activity.NewsActivity
import com.test.empore.ui.adapter.NewsAdapter
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory
    private val newsViewModel: NewsViewModel by viewModels { vmFactory }
    private lateinit var binding: FragmentHomeBinding
    private val news :MutableList<News> = ArrayList()
    private lateinit var newsAdapter: NewsAdapter
    private val TAG = "HomeFragment"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.application as App).appComponent.inject(this)

        initObserver()
        initAdapter()

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
            newsViewModel.insert(it)
        }
    }

    private fun initObserver() {
        newsViewModel.get("top-headlines", "id")
        newsViewModel.news.observe(viewLifecycleOwner, {
            news.clear()
            news.addAll(it.articles)
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
         *
         * @return A new instance of fragment HomeFragment.
         */
        @JvmStatic
        fun newInstance() = HomeFragment()

    }
}