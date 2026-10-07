package pe.edu.cibertec.appGrupo3.retrofit

import okhttp3.OkHttpClient
import pe.edu.cibertec.appGrupo3.retrofit.api.IUsuarioService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ClienteUsuarioRetrofit {
    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitUsuarioService: IUsuarioService by lazy {
        buildRetrofit().create(IUsuarioService::class.java)
    }
}
