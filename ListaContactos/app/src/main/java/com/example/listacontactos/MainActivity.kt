package com.example.listacontactos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val contactos = listOf(
            Contacto("Juan","611123456", foto = 2),
            Contacto("Pedro","611123456", foto = 1),
            Contacto("María","678456123", foto = 0),
            Contacto("Raúl","644789456", foto = 0),
            Contacto("José","693882147", foto = 0),
            Contacto("Miguel","678456123", foto = 0),
            Contacto("Ruben","644789456", foto = 0),
            Contacto("Marta","693882147", foto = 0),
            Contacto("Pablo","644789456", foto = 0),
            Contacto("Elisa","693882147", foto = 0)
        )
        val adapter = ContactosAdapter(contactos)
        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.vistaContacto)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
    }
}