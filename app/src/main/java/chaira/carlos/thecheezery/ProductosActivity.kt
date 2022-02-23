package chaira.carlos.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class ProductosActivity : AppCompatActivity() {

    var coldDrinks = ArrayList<Producto>()
    var hotDrinks = ArrayList<Producto>()
    var sweets = ArrayList<Producto>()
    var salties = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos_layout)

        var tipo:String?=intent.getStringExtra("tipo")
        agregarProductos(tipo)

        var imgTipo: ImageView = findViewById(R.id.imgTipo)
        when(tipo){
            "cold" -> {imgTipo.setImageResource(R.drawable.colddrinks)}
            "hot" -> {imgTipo.setImageResource(R.drawable.hotdrinks)}
            "sweet" -> {imgTipo.setImageResource(R.drawable.sweets)}
            "saltie" -> {imgTipo.setImageResource(R.drawable.salties)}
        }

        var listview: ListView = findViewById(R.id.listview) as ListView
        lateinit var adaptador: AdaptadorProductos
        when(tipo){
            "cold" -> {adaptador = AdaptadorProductos(this, coldDrinks)}
            "hot" -> {adaptador = AdaptadorProductos(this, hotDrinks)}
            "sweet" -> {adaptador = AdaptadorProductos(this, sweets)}
            "saltie" -> {adaptador = AdaptadorProductos(this, salties)}
        }
        listview.adapter = adaptador

    }

    fun agregarProductos(tipo:String?){
        when(tipo){
            "cold" -> {
                coldDrinks.add(Producto("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.0))
                coldDrinks.add(Producto("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.0))
                coldDrinks.add(Producto("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.0))
                coldDrinks.add(Producto("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.0))
                coldDrinks.add(Producto("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.0))
                coldDrinks.add(Producto("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.0))
            }
            "hot" -> {
                hotDrinks.add(Producto("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6.0))
                hotDrinks.add(Producto("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5.0))
                hotDrinks.add(Producto("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4.0))
                hotDrinks.add(Producto("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6.0))
                hotDrinks.add(Producto("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7.0))
                hotDrinks.add(Producto("American coffee", R.drawable.americano, "Espresso with hot water", 2.0))

            }
            "sweet" -> {
                sweets.add(Producto("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped with cheese topping and blueberries.", 6.0))
                sweets.add(Producto("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries", 3.0))
                sweets.add(Producto("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemon flavored filling", 4.0))
                sweets.add(Producto("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6.0))
                sweets.add(Producto("Cherry cheesecake", R.drawable. strawberrycheesecake, "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7.0))
                sweets.add(Producto("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6.0))
            }
            "saltie" -> {
                salties.add(Producto("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6.0))
                salties.add(Producto("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5.0))
                salties.add(Producto("Panini", R.drawable.hampanini, "Sandwich made with Italian bread  served warmed by grilling.", 4.0))
                salties.add(Producto("Philly cheese steak", R.drawable. phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6.0))
                salties.add(Producto("Nachos", R.drawable. nachos, "Tortilla chips layered with beef and   melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.",  7.0))
            }

        }

    }

    private class AdaptadorProductos:BaseAdapter{
        var productos = ArrayList<Producto>()
        var contexto: Context? = null

        constructor(contexto:Context, productos: ArrayList<Producto>){
            this.productos=productos
            this.contexto=contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var prod = productos[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.producto_view, null)

            var imagen = vista.findViewById(R.id.producto_img) as ImageView
            var nombre =  vista.findViewById(R.id.producto_nombre) as TextView
            var desc = vista.findViewById(R.id.producto_desc) as TextView
            var precio = vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.nombre)
            desc.setText(prod.desc)
            precio.setText("$${prod.precio}")

            return vista
        }

    }

}