package br.com.fiap.challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.challenge.ui.theme.ChallengeTheme

class CaixaEntrada : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0XFFFACFCE)),
                    color = Color.Gray
                ) {
//                    Pesquisar()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Pesquisar() {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF024873))
            .fillMaxHeight()
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
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            value = "Digite o assunto do email",
            onValueChange = {},
        )


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 3.dp)
                .height(65.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0477BF)),
//                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            shape = RoundedCornerShape(0.dp),
            border = BorderStroke(1.dp, Color(0xFF024873))
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 5.dp),
                text = "KABUM",
                color = Color.White,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(horizontal = 9.dp),
                text = "Compra negada",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp)
                .height(65.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0477BF)),
//                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            shape = RoundedCornerShape(0.dp),
            border = BorderStroke(1.dp, Color(0xFF024873))
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 5.dp),
                text = "KABUM",
                color = Color.White,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(horizontal = 9.dp),
                text = "Compra negada",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp)
                .height(65.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0477BF)),
//                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            shape = RoundedCornerShape(0.dp),
            border = BorderStroke(1.dp, Color(0xFF024873))
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 5.dp),
                text = "KABUM",
                color = Color.White,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(horizontal = 9.dp),
                text = "Compra negada",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp)
                .height(65.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0477BF)),
//                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            shape = RoundedCornerShape(0.dp),
            border = BorderStroke(1.dp, Color(0xFF024873))
        ) {

        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp)
                .height(65.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0477BF)),
//                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            shape = RoundedCornerShape(0.dp),
            border = BorderStroke(1.dp, Color(0xFF024873))
        ) {

        }


    }


}








