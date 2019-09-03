package com.xxm.jetpackdemo.ui.fragment.login


import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.xxm.jetpackdemo.R
import com.xxm.jetpackdemo.databinding.FragmentLoginBinding
import com.xxm.jetpackdemo.viewmodel.CustomViewModelProvider
import com.xxm.jetpackdemo.viewmodel.LoginModel


/**
 * 登录页面
 */
class LoginFragment : Fragment() {
//    lateinit var mCancel: TextView
//    lateinit var mLogin: Button
//    lateinit var mAccount: EditText

    private val loginModel: LoginModel by viewModels{
        CustomViewModelProvider.providerLoginModel(requireContext())
    }
    var isEnable: Boolean = false
    lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater
            , R.layout.fragment_login
            , container
            , false
        )

        /*val binding = FragmentLoginBinding.inflate(
            inflater
            , container
            , false
        )*/

        loginModel.lifecycleOwner = viewLifecycleOwner
        binding.model = loginModel
        binding.isEnable = isEnable
        binding.activity = activity //必须绑定activity才能调用activity的方法
        this.binding = binding
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //登录按钮是否可点击
        loginModel.p.observe(viewLifecycleOwner, Observer {
            binding.isEnable = it.isNotEmpty() && loginModel.n.value!!.isNotEmpty()
        })

        val name = arguments?.getString("name")
        if (TextUtils.isEmpty(name))
            loginModel.n.value = name!!

    }

}
