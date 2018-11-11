package kiva.com.pe.tutorapp.Network

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener

class LeacoachAPI{
	//Ivan estuvo aqui
    companion object {
        private val BASE_URL: String = "http://leacoachbe.somee.com/leacoach"

        val publications = "$BASE_URL/v1/publications"
        val coaches = "$BASE_URL/v1/tutors"

        val tag = "LEACOACH"

        fun requestPublications( responseHandler: (PublicationsResponse?) -> Unit, errorHandler: (ANError?) -> Unit  ) {
            AndroidNetworking.get(LeacoachAPI.publications)
                    .setPriority(Priority.LOW)
                    .setTag(tag)
                    .build()
                    .getAsObject(PublicationsResponse::class.java, object : ParsedRequestListener<PublicationsResponse> {
                        override fun onResponse(response: PublicationsResponse?) {
                            responseHandler(response)
                        }

                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }

                    })
        }

        fun requestCoaches( responseHandler: (CoachesResponse?) -> Unit, errorHandler: (ANError?) -> Unit  ) {
            AndroidNetworking.get(LeacoachAPI.coaches)
                    .setPriority(Priority.LOW)
                    .setTag(tag)
                    .build()
                    .getAsObject(CoachesResponse::class.java, object : ParsedRequestListener<CoachesResponse> {
                        override fun onResponse(response: CoachesResponse?) {
                            responseHandler(response)
                        }

                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }

                    })
        }


    }

}