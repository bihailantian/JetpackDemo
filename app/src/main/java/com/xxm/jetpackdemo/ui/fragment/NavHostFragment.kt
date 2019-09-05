package com.xxm.jetpackdemo.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.xxm.jetpackdemo.R


/**
 * Fragment 容器
 */
class NavHostFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav_host, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnStart = view.findViewById<Button>(R.id.btn_next)
        //跳转到firstFragment
        btnStart.setOnClickListener {
            //findNavController().navigate(R.id.firstFragment, null)
        }


        //通过action跳转到firstFragment
        /*view.findViewById<Button>(R.id.btn_change)?.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.next_action, null)
        )*/

        //通过argument(参数)跳转到firstFragment
//        view.findViewById<Button>(R.id.btn_change)?.setOnClickListener {
//            val action = NavHostFragmentDirections.nextAction().setFlowStepNum(5)
//            findNavController().navigate(action)
//        }

    }
}
