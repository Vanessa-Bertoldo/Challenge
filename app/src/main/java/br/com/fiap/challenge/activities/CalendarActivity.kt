package br.com.fiap.challenge.activities

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.challenge.components.ExpandableCard
import br.com.fiap.challenge.components.TopBar
import br.com.fiap.challenge.database.repository.EmailRepository

@Composable
fun EventoActivity(navController: NavController) {

    val context = LocalContext.current
    val emailRepository = EmailRepository(context)

    Scaffold(
        topBar = {
            Row {
                TopBar("Eventos", true, navController)
            }

        },
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF024959))
                .fillMaxHeight()
                .padding(innerPadding)
                .padding(top = 2.dp)
        ) {

//            Card(
//                colors = CardDefaults.cardColors(
//                    containerColor = Color(0xFF026773),
//                ),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 3.dp),
//                shape = RoundedCornerShape(0.dp),
//                border = BorderStroke(1.dp, Color.White)
//            ) {
//                Text(
//                    text = "Assunto",
//                    modifier = Modifier
//                        .padding(16.dp),
//                    textAlign = TextAlign.Center,
//                    color = Color.White
//                )
//            }

            buscarEventos(emailRepository)

            







        }
    }
}

@Composable
private fun buscarEventos(emailRepository: EmailRepository) {

    var listaEvento = emailRepository.buscarTodosEventos()

    for (i in listaEvento) {
        if(i.dataEvento.isNotEmpty()){
            ExpandableCard(i.nomeAssunto + "- " + i.dataEvento,i.texto)
        }

    }

}
