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
import gomez.alan.examenpractico.juegoadapter.Juegoadapter
import gomez.alan.examenpractico.modelo.juegos

class MainActivity : AppCompatActivity() {
    lateinit var btn_c: Button
    lateinit var btn_list: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_c = findViewById(R.id.Btn_Creador)
        btn_c.setOnClickListener {
            val intentCread = Intent(this, presentacion::class.java)
            startActivity(intentCread)

        }
        btn_list = findViewById(R.id.Btn_games)
        btn_list.setOnClickListener {
            val intentlist = Intent(this, lista_juegos::class.java)
            startActivity(intentlist)

        }

    }


}