package kiva.com.pe.tutorapp.viewcontrollers.fragments


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup

import kiva.com.pe.tutorapp.R
import kiva.com.pe.tutorapp.models.Tutor
import kiva.com.pe.tutorapp.viewcontrollers.adapters.TutorAdapter
import kiva.com.pe.tutorapp.viewcontrollers.adapters.ViewPagerAdapter
import kiva.com.pe.tutorapp.viewcontrollers.fragments.search.CoachesFragment
import kiva.com.pe.tutorapp.viewcontrollers.fragments.search.FilesFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SearchFragment : Fragment() {





    @SuppressLint("ResourceAsColor", "ResourceType")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val  view = inflater.inflate(R.layout.fragment_search, container, false)

        var tabLayout = view.findViewById<TabLayout>(R.id.tabView)

        var viewPager = view.findViewById<ViewPager>(R.id.viewPager)
        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)


        return view
    }
    private fun setupViewPager(pager: ViewPager?) {
        val adapter = ViewPagerAdapter(childFragmentManager)

        val f1 = CoachesFragment()
        adapter.addFragment(f1, "Coaches")

        val f2 = FilesFragment()
        adapter.addFragment(f2, "Files")



        pager?.adapter = adapter
    }




}

 