package chaira.carlos.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnCold: Button = findViewById(R.id.btnColdDrinks)
        btnCold.setOnClickListener{
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("tipo","cold")
            startActivity(intent)
        }
        var btnHot: Button = findViewById(R.id.btnHotDrinks)
        btnHot.setOnClickListener{
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("tipo","hot")
            startActivity(intent)
        }
        var btnSweets: Button = findViewById(R.id.btnSweets)
        btnSweets.setOnClickListener{
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("tipo","sweet")
            startActivity(intent)
        }
        var bntSalties: Button = findViewById(R.id.btnSalties)
        bntSalties.setOnClickListener{
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("tipo","saltie")
            startActivity(intent)
        }
    }
}