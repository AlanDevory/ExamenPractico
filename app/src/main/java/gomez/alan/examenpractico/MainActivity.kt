package gomez.alan.examenpractico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import gomez.alan.examenpractico.juegoadapter.juegoadapter
import gomez.alan.examenpractico.modelo.juegos

class MainActivity : AppCompatActivity() {
    lateinit var myRecycler: RecyclerView
    lateinit var btn_c:Button
    lateinit var btn_list:Button
    lateinit var listj:ArrayList<juegos>
    lateinit var juegoadapter: juegoadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_c = findViewById(R.id.Btn_Creador)
        btn_c.setOnClickListener { val intentCread = Intent(this,presentacion::class.java)
            startActivity(intentCread)

        }
        btn_list = findViewById(R.id.Btn_games)
        btn_list.setOnClickListener { val intentlist = Intent(this,lista_juegos::class.java)
            startActivity(intentlist)

        }


            myRecycler = findViewById(R.id.recylerV)
            myRecycler.adapter = juegoadapter
            myRecycler.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }
    fun getPersonajes(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://www.freetogame.com/api/games?platform=pc"

        val objectRequest = JsonObjectRequest(
            Request.Method.GET,url,null,
            /* Response.Listener */{ result ->

            val juegosJson = result.getJSONArray(null)
            for(indice in 0..juegosJson.length()-1){
                val juegosIndJson = juegosJson.getJSONObject(indice)
                val juego = juegos(juegosIndJson.getString("title"),juegosIndJson.getString("thumbnail"),juegosIndJson.getString("platform"),juegosIndJson.getString("genre"))
                listj.add(juego)
            }
                juegoadapter.notifyDataSetChanged()
        },
        /* Response.ErrorListener*/{
            Log.e("PersonajesAPI","Error")
        }
        )
        queue.add(objectRequest)
    }
    }
