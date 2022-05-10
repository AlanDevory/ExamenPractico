package gomez.alan.examenpractico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class lista_juegos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_juegos)

        val btn: Button = findViewById(R.id.Btn_lista)
        btn.setOnClickListener {

            val intent: Intent = Intent(this, MainActivity:: class.java)
            startActivity(intent)

        }


    }
}