package kiva.com.pe.tutorapp.models

import android.os.Bundle


data class Tutor(
        val id: Int,
        val name: String?,
        val email: String?
        //add url tutor please!
){
    companion object {
        fun from(bundle: Bundle):Tutor{

            return Tutor(
                    bundle.getInt("id"),
                    bundle.getString("name"),
                    bundle.getString("email")

                    )
        }
    }
    fun toBundle(): Bundle {
        val bundle = Bundle()
        with(bundle){
            putInt("id",id)
            putString("name",name)
            putString("email",email)

        }
        return bundle
    }
}

























