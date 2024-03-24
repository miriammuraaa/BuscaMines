package com.example.buscamines

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class MainActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    /*butons*/
    lateinit var BTMLOGIN: Button
    lateinit var BTMREGISTRO: Button
    var user: FirebaseUser? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        user = auth.currentUser

        var BTMLOGIN = findViewById<Button>(R.id.BTMLOGIN)
        var BTMREGISTRO = findViewById<Button>(R.id.BTMREGISTRO)

        BTMLOGIN.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        BTMREGISTRO.setOnClickListener {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
        /*font*/
        val tf = Typeface.createFromAsset(assets,"fonts/Fredoka-Medium.ttf")

        /*botons*/
        BTMLOGIN=findViewById(R.id.BTMLOGIN)
        BTMREGISTRO=findViewById(R.id.BTMREGISTRO)

        /*botons*/
        BTMLOGIN.setTypeface(tf)
        BTMREGISTRO.setTypeface(tf)
    }

    // Aquest mètode s'executarà quan s'obri el menu
    override fun onStart() {
        usuariLogejat()
        super.onStart()
    }
    private fun usuariLogejat() {
        if (user !=null)
        {
            val intent= Intent(this, Menu::class.java)
            startActivity(intent)
            finish()
        }
    }


}
