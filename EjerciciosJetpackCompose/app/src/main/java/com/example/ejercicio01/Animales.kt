package com.example.ejercicio01

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun listaAnimales(){
    ItemList(
        arca = listOf(
            Animal("Perro", "Animal domestico, mamifero, canido de cuatro patas"),
            Animal("Gato", "Animal doméstico, mamífero, felino de cuatro patas, ágil y de comportamiento independiente"),
            Animal("Caballo", "Mamífero herbívoro de gran tamaño, utilizado para la monta y el trabajo, con pezuñas y largas crines"),
            Animal("Elefante", "Mamífero terrestre de gran tamaño, con trompa larga y colmillos de marfil, conocido por su inteligencia"),
            Animal("Águila", "Ave rapaz de gran envergadura, con vista aguda y garras afiladas, capaz de volar a grandes alturas"),
            Animal("Tiburón", "Pez cartilaginoso, depredador marino con dientes afilados y cuerpo diseñado para la caza")
        )
    )
}

@Composable
fun ItemList(arca: List<Animal>) {
    LazyColumn {
        items (arca){
            arca -> ArcaView(animal = arca)
        }
    }
}

@Composable
fun ArcaView(animal: Animal){
    var isExpanded by remember { mutableStateOf(false) }
    Card(
        Modifier.fillMaxSize().padding(8.dp).clickable { isExpanded = !isExpanded }
    ) {
        Row(
            Modifier.fillMaxSize().padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Crossfade(targetState = isExpanded, label = "") { expanded ->
                if (expanded) {
                    Column {
                        Text(
                            text = animal.nombre + ": ",
                            Modifier.fillMaxSize()
                        )
                        Spacer(
                            Modifier.size(10.dp)
                        )
                        Text(
                            text = animal.descripcion,
                            Modifier.fillMaxSize()
                        )
                    }
                } else {
                    Text(
                        text = animal.nombre,
                        Modifier.fillMaxSize()
                    )
                }


            }
        }
    }
}
