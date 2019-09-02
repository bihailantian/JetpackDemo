package com.xxm.jetpackdemo.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.xxm.jetpackdemo.R


class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val safeArgs: FirstFragmentArgs by navArgs()
        val flowStepNum = safeArgs.flowStepNum

        Toast.makeText(context, "num:" + flowStepNum, Toast.LENGTH_SHORT).show()

        val btnStart: Button = view.findViewById(R.id.btn_next)
        btnStart.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.secondFragment, null)
        }

    }


}
