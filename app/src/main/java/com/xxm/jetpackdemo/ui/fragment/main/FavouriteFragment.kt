package com.xxm.jetpackdemo.ui.fragment.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.xxm.jetpackdemo.databinding.FragmentFavouriteBinding
import com.xxm.jetpackdemo.ui.adapter.FavouriteAdapter
import com.xxm.jetpackdemo.viewmodel.CustomViewModelProvider
import com.xxm.jetpackdemo.viewmodel.FavouriteModel

/**
 * 收藏页面
 *
 */
class FavouriteFragment : Fragment() {

    private val viewModel: FavouriteModel by viewModels {
        CustomViewModelProvider.providerFavouriteModel(requireContext())
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        context?:return binding.root
        val adapter = FavouriteAdapter(context!!)
        binding.recycler.adapter = adapter

        onSubscribeUi(adapter)
        return binding.root
    }

    /**
     * 鞋子数据更新的通知
     */
    private fun onSubscribeUi(adapter: FavouriteAdapter) {
        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter.submitList(it)
            }
        })
    }

}
