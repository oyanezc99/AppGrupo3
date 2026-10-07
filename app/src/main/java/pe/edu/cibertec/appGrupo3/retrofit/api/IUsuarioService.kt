package pe.edu.cibertec.appGrupo3.retrofit.api

import pe.edu.cibertec.appGrupo3.retrofit.response.ResultUsuario
import retrofit2.Call
import retrofit2.http.GET

interface IUsuarioService {
    @GET("users")
    fun obtenerUsuarios(): Call<ResultUsuario>
}
