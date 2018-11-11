package kiva.com.pe.tutorapp.models

import android.os.Bundle
import com.orm.SugarRecord

class Favorite() : SugarRecord(){

    var publicationId: String? = null
    var name: String? = null
    var views: Int? = null
    var course_id: Int? = null
    var tutor_id: Int? = null
    var type_id: Int? = null
    var date: String?= null
    var description: String?= null
    var url: String?= null
    var premium: Int? = null
    companion object {

        fun tutorsIdsAsString(): String {
            return listAll()
                    .joinToString { favorite ->
                        favorite.publicationId!!
                    }
        }

        fun listAll(): List<Favorite>{
            return SugarRecord.listAll(Favorite::class.java)
        }
        fun listFor(publicationId: String):List<Favorite>{
            return SugarRecord.find(Favorite::class.java,
                    "publication_id = ? ", publicationId)
        }

    }
    fun toBundle(): Bundle {
        val bundle = Bundle()
        with(bundle){
            putInt("id",publicationId!!.toInt())
            putString("name",name)
            putInt("views",views!!)
            putInt("course_id",course_id!!)
            putInt("tutor_id",tutor_id!!)
            putInt("type_id",type_id!!)
            putString("date",date)
            putString("description",description)
            putString("url",url)
            putInt("premium",premium!!)

        }
        return bundle
    }


}

