package kiva.com.pe.tutorapp.models

import android.os.Bundle

data class Files(
        val id: Int,
        val name: String,
        val views: Int,
        val course_id: Int,
        val tutor_id: Int,
        val type_id: Int,
        val date: String?,
        val description: String?,
        val url: String?,
        val premium: Int
){
    companion object {
        fun from(bundle: Bundle):Files{

            return Files(
                    bundle.getInt("id"),
                    bundle.getString("name"),
                    bundle.getInt("views"),
                    bundle.getInt("course_id"),
                    bundle.getInt("tutor_id"),
                    bundle.getInt("type_id"),
                    bundle.getString("date"),
                    bundle.getString("description"),
                    bundle.getString("url"),
                    bundle.getInt("premium")

                    )
        }
    }
    fun toBundle(): Bundle {
        val bundle = Bundle()
        with(bundle){
            putInt("id",id)
            putString("name",name)
            putInt("views",views)
            putInt("course_id",course_id)
            putInt("tutor_id",tutor_id)
            putInt("type_id",type_id)
            putString("date",date)
            putString("description",description)
            putString("url",url)
            putInt("premium",premium)

        }
        return bundle
    }



}