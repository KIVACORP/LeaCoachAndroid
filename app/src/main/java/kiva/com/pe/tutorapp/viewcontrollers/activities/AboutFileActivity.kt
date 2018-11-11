package kiva.com.pe.tutorapp.viewcontrollers.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import kiva.com.pe.tutorapp.R
import kiva.com.pe.tutorapp.models.Favorite
import kiva.com.pe.tutorapp.models.Files
import kiva.com.pe.tutorapp.viewcontrollers.adapters.FavoritosAdapter

import kotlinx.android.synthetic.main.activity_about_file.*

class AboutFileActivity : AppCompatActivity() {

    var files: Favorite? = null
    var isFavorite: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_file)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->

            isFavorite
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()



        }
    }

}
