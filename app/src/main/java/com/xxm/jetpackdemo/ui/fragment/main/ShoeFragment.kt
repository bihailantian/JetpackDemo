package com.xxm.jetpackdemo.ui.fragment.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.xxm.jetpackdemo.databinding.FragmentShoeBinding
import com.xxm.jetpackdemo.ui.adapter.ShoeAdapter
import com.xxm.jetpackdemo.viewmodel.CustomViewModelProvider
import com.xxm.jetpackdemo.viewmodel.ShoeModel


/**
 * A simple [Fragment] subclass.
 *
 */
class ShoeFragment : Fragment() {


    // by viewModels 需要依赖 "androidx.navigation:navigation-ui-ktx:$rootProject.navigationVersion"
    private val viewModel: ShoeModel by viewModels {
        CustomViewModelProvider.providerShoeModel(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeBinding = FragmentShoeBinding.inflate(inflater, container, false)
        context ?: return binding.root

        // RecyclerView 的适配器 ShoeAdapter
        val adapter = ShoeAdapter()
        binding.recycler.adapter = adapter
        onSubscribeUi(adapter)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    /**
     * 鞋子数据更新的通知
     */
    private fun onSubscribeUi(adapter: ShoeAdapter) {
        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter.submitList(it)
            }
        })
    }


}
