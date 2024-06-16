package br.com.fiap.challenge.activities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.challenge.database.repository.EmailRepository
import br.com.fiap.challenge.model.Email


@Composable
fun DetalheEmail(navController: NavController, idEmail: String?) {

    val email = buscarEmailId(idEmail?.toLong())

    Column() {
        Text(
            text = email.nomeAssunto,
            fontSize = 24.sp
        )
        Row {
            Column(Modifier.padding(vertical = 10.dp)) {
                Text(
                    text = email.nomeDestinatario,
                    fontSize = 20.sp
                )
            }
        }
        Row {
            Column() {
                Text(
                    text = email.texto,
                    fontSize = 20.sp
                )
            }
        }
//        Row {
//            Column() {
//                Text(
//                    text = "Próxima reunião dia 15/06/24",
//                    fontSize = 20.sp
//                )
//            }
//        }
    }
}

@Composable
fun buscarEmailId(idEmail: Long?): Email {

    val context = LocalContext.current
    val emailRepository = EmailRepository(context)

   return emailRepository.buscarEmailId(idEmail)
}
