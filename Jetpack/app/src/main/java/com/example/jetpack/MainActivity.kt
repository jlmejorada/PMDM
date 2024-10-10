package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack.ui.theme.JetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackTheme {
                if (login)
                ItemList(
                    itemContacto = listOf(
                        Contacto("Juan", "611123456", 1),
                        Contacto("María", "678456123", 0),
                        Contacto("Raúl", "644789456", 1),
                        Contacto("Ana", "693882147", 0)
                    )

                )

            }
        }
    }
}

@Composable
fun ItemList(itemContacto: List<Contacto>) {
    LazyColumn {    // produce una lista de desplazamiento vertical,
        items(itemContacto) { itemContacto ->
            ContactoView(contacto = itemContacto)
        }
    }
}


@Composable
fun ContactoView(contacto: Contacto) {
    var foto = R.drawable.onvre
    if (contacto.imagen == 0) {
        foto = R.drawable.mujel
    }
    Card(Modifier.fillMaxWidth()) {
        Row {
            Column {
                Image(
                    painter = painterResource(id = foto),
                    contentDescription = "Foto contacto",
                    Modifier.height(100.dp)
                )
            }
            Column {
                Text(
                    text = contacto.nombre, fontSize = 24.sp, modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = contacto.tlfno, fontSize = 24.sp, modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}
