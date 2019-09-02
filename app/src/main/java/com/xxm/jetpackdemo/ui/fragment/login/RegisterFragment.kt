package com.xxm.jetpackdemo.ui.fragment.login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.xxm.jetpackdemo.R


/**
 * 注册页面
 */
class RegisterFragment : Fragment() {
    lateinit var mCancel: TextView
    lateinit var mRegister: Button
    lateinit var mEmailEt: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mCancel = view.findViewById(R.id.txt_cancel)
        mRegister = view.findViewById(R.id.btn_register)
        mEmailEt = view.findViewById(R.id.et_email)

        mRegister.setOnClickListener {
            Toast.makeText(context,"Register", Toast.LENGTH_SHORT).show()
        }

        mCancel.setOnClickListener {
            activity?.onBackPressed()
        }

        val safeArgs:RegisterFragmentArgs by navArgs()
        val email = safeArgs.email
        mEmailEt.setText(email)


    }
}
