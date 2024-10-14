package com.example.jetpack_login

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack.R

@Preview
@Composable
fun ListaContactos() {
    ItemList(
        itemContacto = listOf(
            Contacto("María", "611234567", 0),
            Contacto("Carlos", "611345678", 1),
            Contacto("Ana", "611456789", 0),
            Contacto("Luis", "611567890", 1),
            Contacto("Sofía", "611678901", 0),
            Contacto("Miguel", "611789012", 1),
            Contacto("Laura", "611890123", 0),
            Contacto("Pablo", "611901234", 1),
            Contacto("Elena", "611012345", 0),
            Contacto("Andrés", "611123457", 1),
            Contacto("Carmen", "611234568", 0),
            Contacto("David", "611345679", 1),
            Contacto("Lucía", "611456780", 0),
            Contacto("Raúl", "611567891", 1),
            Contacto("Natalia", "611678902", 0),
            Contacto("Javier", "611789013", 1)
        )
    )
}

@Composable
fun ItemList(itemContacto: List<Contacto>) {
    LazyColumn {	// produce una lista de desplazamiento vertical,
        items(itemContacto) { itemContacto ->
            ContactoView(contacto = itemContacto)
        }
    }
}

private fun realizarLlamada(context: Context, numero: String) {
    val intent = Intent(Intent.ACTION_DIAL).apply {
        data = Uri.parse("tel:$numero")
    }
    context.startActivity(intent)
}

@Composable
fun ContactoView(contacto: Contacto) {
    val context = LocalContext.current
    var isExpanded by remember { mutableStateOf(false) }
    val foto = if (contacto.imagen == 0) R.drawable.mujel else R.drawable.onvre

    Card(
        Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isExpanded = !isExpanded }
    ) {
        Row(
            modifier = Modifier.padding(5.dp)
        ) {
            Image(
                painter = painterResource(foto),
                contentDescription = "",
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 8.dp)
            )
            Column {

                Crossfade(targetState = isExpanded) { expanded ->
                    if (expanded) {
                        Column {
                            Text(
                                text = contacto.nombre,
                                fontSize = 24.sp,
                            )

                            Text(
                                text = contacto.tlfno,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .padding(top = 8.dp)
                                    .clickable { realizarLlamada(context, contacto.tlfno) }
                            )
                        }
                    } else {
                        Text(
                            text = contacto.nombre.take(1),
                            fontSize = 20.sp,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        }
    }
}