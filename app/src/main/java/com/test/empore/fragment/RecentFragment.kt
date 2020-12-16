package com.test.empore.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.empore.R

/**
 * A simple [Fragment] subclass.
 * Use the [RecentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recent, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment RecentFragment.
         */
        @JvmStatic
        fun newInstance() = RecentFragment()

    }
}