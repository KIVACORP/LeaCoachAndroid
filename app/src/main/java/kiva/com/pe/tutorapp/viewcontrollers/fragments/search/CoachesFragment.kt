package kiva.com.pe.tutorapp.viewcontrollers.fragments.search


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidnetworking.error.ANError
import kiva.com.pe.tutorapp.Network.CoachesResponse
import kiva.com.pe.tutorapp.Network.LeacoachAPI

import kiva.com.pe.tutorapp.R
import kiva.com.pe.tutorapp.models.Tutor
import kiva.com.pe.tutorapp.viewcontrollers.adapters.TutorAdapter
import kotlinx.android.synthetic.main.fragment_coaches.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class CoachesFragment : Fragment() {
    private var coaches=ArrayList<Tutor>()

    private lateinit var tutorRecyclerView: RecyclerView
    private lateinit var tutorAdapter: TutorAdapter
    private lateinit var tutorLayoutManager: RecyclerView.LayoutManager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_coaches, container, false)
        tutorAdapter = TutorAdapter(coaches, view.context)
        tutorLayoutManager = GridLayoutManager(view.context, 1) as RecyclerView.LayoutManager
        tutorRecyclerView = view.coachesRecycler
        tutorRecyclerView.adapter = tutorAdapter
        tutorRecyclerView.layoutManager = tutorLayoutManager
        LeacoachAPI.requestCoaches(
                { response -> handleResponse(response) },
                { error -> handleError(error)})
        return view
    }
    private fun handleResponse(response: CoachesResponse?) {
        if ("error".equals(response!!.status, true)) {
            Log.d(LeacoachAPI.tag, response.status)
            return
        }
        coaches = response.tutors!!
        Log.d(LeacoachAPI.tag, "Parsed: Found ${coaches.size} files")
        tutorAdapter.tutor = coaches
        tutorAdapter.notifyDataSetChanged()
    }

    private fun handleError(anError: ANError?) {
        Log.d(tag, anError!!.message)
    }

}
