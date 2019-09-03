package com.xxm.jetpackdemo.ui.fragment.login


import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.xxm.jetpackdemo.R
import com.xxm.jetpackdemo.databinding.FragmentLoginBinding
import com.xxm.jetpackdemo.viewmodel.LoginModel


/**
 * 登录页面
 */
class LoginFragment : Fragment() {
//    lateinit var mCancel: TextView
//    lateinit var mLogin: Button
//    lateinit var mAccount: EditText

    lateinit var loginModel: LoginModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val binding: FragmentLoginBinding =
//            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        val binding = FragmentLoginBinding.inflate(
            inflater
            , container
            , false
        )


        loginModel = LoginModel("", "", context!!)
        binding.model = loginModel
        binding.activity = activity //必须绑定activity才能调用activity的方法
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        mCancel = view.findViewById(R.id.txt_cancel)
//        mLogin = view.findViewById(R.id.btn_login)
//        mAccount = view.findViewById(R.id.et_account)

//        mLogin.setOnClickListener {
//            val intent = Intent(context, MainActivity::class.java)
//            context!!.startActivity(intent)
//        }
//
//        mCancel.setOnClickListener {
//            activity?.onBackPressed()
//        }

        val name = arguments?.getString("name")
        if (TextUtils.isEmpty(name!!))
            loginModel.n.set(name)

    }

}
