package gomez.alan.examenpractico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import gomez.alan.examenpractico.juegoadapter.Juegoadapter
import gomez.alan.examenpractico.modelo.juegos

class lista_juegos : AppCompatActivity() {
    lateinit var myRecycler: RecyclerView
    lateinit var listj: ArrayList<juegos>
    lateinit var juegoadapter: Juegoadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_juegos)

        val btn: Button = findViewById(R.id.Btn_lista)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity:: class.java)
            startActivity(intent)
        }
        listj = ArrayList<juegos>()
        juegoadapter = Juegoadapter(listj)
        myRecycler = findViewById(R.id.recylerV)
        myRecycler.adapter = juegoadapter
        getJuegos()
        myRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    fun getJuegos() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://www.freetogame.com/api/games?platform=pc"

        val objectRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            Response.Listener { result ->
                for (indice in 0..result.length() - 1) {
                    val juegosJson = result.getJSONObject(indice)
                    val juego =
                        juegos(juegosJson.getString("title"),
                            juegosJson.getString("thumbnail"),
                            juegosJson.getString("short_description"),
                            juegosJson.getString("genre")
                        )
                    listj.add(juego)
                }
                juegoadapter.notifyDataSetChanged()
            },
            Response.ErrorListener{
                Log.e("JuegosAPI", "Error")
            }
        )
        queue.add(objectRequest)
    }
}