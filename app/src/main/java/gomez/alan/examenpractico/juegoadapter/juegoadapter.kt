package gomez.alan.examenpractico.juegoadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gomez.alan.examenpractico.R
import gomez.alan.examenpractico.modelo.juegos

class Juegoadapter(val listj: ArrayList<juegos>): RecyclerView.Adapter<Juegoadapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.vista,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Tnombre.text = listj[position].nombre
        Picasso.get().load(listj[position].foto).into(holder.ivPersonaje)
        holder.tvplataforma.text = listj[position].plataforma
        holder.tgenero.text = listj[position].genero
    }

    override fun getItemCount(): Int {
        return  listj.size
    }

    class ViewHolder(vista: View):RecyclerView.ViewHolder(vista){
        val Tnombre: TextView
        val ivPersonaje: ImageView
        val tvplataforma:TextView
        val tgenero:TextView

        init {
            Tnombre = vista.findViewById(R.id.Tnombre)
            ivPersonaje= vista.findViewById(R.id.ivPersonaje)
            tvplataforma= vista.findViewById(R.id.tvplataforma)
            tgenero= vista.findViewById(R.id.tgenero)
        }
    }
}