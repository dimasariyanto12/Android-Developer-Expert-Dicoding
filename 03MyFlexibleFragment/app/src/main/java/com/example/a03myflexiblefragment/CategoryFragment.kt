package com.example.a03myflexiblefragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager

/**
 * A simple [Fragment] subclass.
 */
class CategoryFragment : Fragment(),View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDetailCategory: Button =view.findViewById(R.id.btn_detail_category)
        btnDetailCategory.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id==R.id.btn_detail_category){
            val mDetailCategoryFragment=DetailCategoryFragment()

            val mBundle=Bundle()
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME,"LifeStyle")
            val description="Kategori ini akan bersisi produk-produk lifestyle"

            mDetailCategoryFragment.arguments=mBundle
            mDetailCategoryFragment.description=description

            /*
            Methdod addToBack akan menambahkan fragment ke backstack
            Behaviour dari back button akan cek fragment dari backstak,
            jika ada fragment di dalam backstak maka fragment yang akan di close/remve
            jika tidak ada fragment di dalam backstack maka activity yang akan di close/finish

             */
            val mFragmentManager= fragmentManager as FragmentManager
            mFragmentManager
                .beginTransaction()
                .replace(R.id.frame_container,mDetailCategoryFragment,DetailCategoryFragment::class.java.simpleName)
                .addToBackStack(null)
                .commit()

        }
    }


}
