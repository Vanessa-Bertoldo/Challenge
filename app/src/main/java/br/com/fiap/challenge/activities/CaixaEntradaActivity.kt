package br.com.fiap.challenge.activities

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.challenge.components.Rodape

@Composable
fun CaixaEntrada(navController: NavController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF012E40))
            .fillMaxHeight()
            .padding(top = 2.dp)
    ) {


        OutlinedTextField(
            modifier = Modifier

                .fillMaxWidth()
                .height(60.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.White,
                unfocusedBorderColor = Color.White,
                unfocusedLabelColor = Color.White,
                unfocusedLeadingIconColor = Color.White
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search, contentDescription = null
                )
            },
            value = "Digite o assunto do email",
            onValueChange = {},
        )


        CardEmail()
        CardEmail()
        Rodape(navController)

    }


}

@Composable
fun CardEmail() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
            .height(65.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF024959)),
//                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(0.dp),
        border = BorderStroke(1.dp, Color(0xFF024959))
    ) {
        Text(
            modifier = Modifier.padding(start = 5.dp, top = 10.dp),
            text = "KABUM",
            color = Color.White,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(start = 5.dp),
            text = "PROMOÇÃO RELAMPAGO",
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )

    }


}






