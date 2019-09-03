package com.xxm.jetpackdemo.ui.fragment.login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.xxm.jetpackdemo.R
import com.xxm.jetpackdemo.databinding.FragmentRegisterBinding
import com.xxm.jetpackdemo.viewmodel.CustomViewModelProvider
import com.xxm.jetpackdemo.viewmodel.RegisterModel


/**
 * 注册页面
 */
class RegisterFragment : Fragment() {
    /*lateinit var mCancel: TextView
    lateinit var mRegister: Button
    lateinit var mEmailEt: EditText*/

    var isEnable: Boolean = false
    lateinit var binding: FragmentRegisterBinding

    private val registerModel: RegisterModel by viewModels {
        CustomViewModelProvider.providerRegisterModel(requireContext(), findNavController())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentRegisterBinding = DataBindingUtil.inflate(
            inflater
            , R.layout.fragment_register
            , container
            , false
        )
        binding.model = registerModel
        binding.isEnable = isEnable
        binding.activity = activity
        this.binding = binding


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //获取欢迎页面 WelcomeFragment传递过来的页面
        val safeArgs: RegisterFragmentArgs by navArgs()
        val email = safeArgs.email
        binding.model?.mail?.value = email

        registerModel.p.observe(viewLifecycleOwner, Observer {
            binding.isEnable = it.isNotEmpty()
                    && registerModel.n.value!!.isNotEmpty()
                    && registerModel.mail.value!!.isNotEmpty()
        })

        registerModel.n.observe(viewLifecycleOwner, Observer {
            binding.isEnable = it.isNotEmpty()
                    && registerModel.p.value!!.isNotEmpty()
                    && registerModel.mail.value!!.isNotEmpty()
        })

        registerModel.mail.observe(viewLifecycleOwner, Observer {
            binding.isEnable = it.isNotEmpty()
                    && registerModel.n.value!!.isNotEmpty()
                    && registerModel.p.value!!.isNotEmpty()
        })


    }
}
