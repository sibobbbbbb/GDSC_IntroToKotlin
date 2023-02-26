import builder.SrvBuilder
import okhttp3.Callback
import okhttp3.Response
import retrofit2.Call
import srv.UserSrv

fun main(){
    val srv = SrvBuilder.buildService(UserSrv::class.java)
    val usersCall = srv.getUsers()

    usersCall.enqueue(object: Callback<Users>) {
        override fun onResponse(call: Call<Users>, response: Response<Users>) {
            if (response.isSuccessful) {
                val userArr = response.body()!!
                userArr.data.forEach {
                    println("user: $it")
                }
            } else {
                println("reason: ${response.message()}")
            }
        }

        override fun onFailure(call: Call<Users>, t: Throwable) {
            println("ERROR: $t")
        }
    }}
    println("finish")

    val userCall = srv.getUser(1)
    userCall.enqueue(object)
            override fun onResponse(call:Call<Users>)

        }        })




