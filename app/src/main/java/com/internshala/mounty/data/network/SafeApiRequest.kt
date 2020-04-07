package com.internshala.mounty.data.network

import com.internshala.mounty.util.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

abstract class SafeApiRequest{
    suspend fun <T:Any> apiRequest(call : suspend() -> Response<T>): T {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val error = response.errorBody()?.string()
            val status_message = StringBuilder()
            error?.let {
                try {
                    status_message.append(JSONObject(it).getString("status_message"))
                } catch (e: JSONException) {
                    status_message.append("\n")
                }
            }
            status_message.append("Error Code: ${response.code()}")
            throw ApiException(status_message.toString())
        }
    }
}