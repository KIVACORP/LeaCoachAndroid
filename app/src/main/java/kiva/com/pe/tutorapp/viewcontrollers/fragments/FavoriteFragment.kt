package kiva.com.pe.tutorapp.viewcontrollers.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.androidnetworking.error.ANError
import kiva.com.pe.tutorapp.Network.LeacoachAPI
import kiva.com.pe.tutorapp.Network.PublicationsResponse
import kiva.com.pe.tutorapp.R
import kiva.com.pe.tutorapp.models.Favorite
import kiva.com.pe.tutorapp.models.Files
import kiva.com.pe.tutorapp.viewcontrollers.adapters.FavoritosAdapter
import kiva.com.pe.tutorapp.viewcontrollers.adapters.FilesAdapter
import kotlinx.android.synthetic.main.fragment_favorite.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FavoriteFragment : Fragment() {
    private var files=ArrayList<Favorite>()
    private lateinit var fileRecyclerView: RecyclerView
    private lateinit var fileAdapter: FavoritosAdapter
    private lateinit var fileLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        if (Favorite.tutorsIdsAsString().isEmpty()) {
            return inflater.inflate(R.layout.fragment_favorite_empty, container, false)
        }

        val view = inflater.inflate(R.layout.fragment_favorite, container, false)


        files = ArrayList(Favorite.listAll())

        fileAdapter = FavoritosAdapter(files, view.context)
        fileLayoutManager = GridLayoutManager(view.context, 1) as RecyclerView.LayoutManager
        fileRecyclerView = view.mediaRecycler
        fileRecyclerView.adapter = fileAdapter
        fileRecyclerView.layoutManager = fileLayoutManager


        return view
    }

}
