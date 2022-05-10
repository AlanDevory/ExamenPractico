package gomez.alan.examenpractico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class presentacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentacion)


        val btn: Button = findViewById(R.id.btn_pres)
        btn.setOnClickListener {

            val intent: Intent = Intent(this, MainActivity:: class.java)
            startActivity(intent)

        }
    }
}