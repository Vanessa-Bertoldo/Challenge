package br.com.fiap.caixanovoemail

import android.os.Bundle
import android.util.Size
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.caixanovoemail.ui.theme.NovoEmailTheme
import br.com.fiap.caixanovoemail.ui.theme.inter
import br.com.fiap.caixanovoemail.ui.theme.kablammo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NovoEmailTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun NovoEmail() {
    var to by remember { mutableStateOf(value ="")}
    var cc by remember { mutableStateOf(value = "")}
    var cco by remember {mutableStateOf(value = "")}
    var subject by remember { mutableStateOf(value = "")}
    var body by remember { mutableStateOf(value = "")}
   // var attachamentMenuExapanded by remember { mutableStateOf(value = "")}



    Column ( modifier = Modifier.padding(19.dp))
         {
       Text(
       text = "Nova Mensagem ",
       color = Color.Blue,
       fontSize = 19.sp,
       fontWeight = FontWeight.Bold,
       textAlign = TextAlign.Left,
       modifier = Modifier.fillMaxWidth()
       )
                 
             }
       OutlinedTextField(
           value = to,
           onValueChange = { to = it },
           modifier = Modifier.fillMaxWidth(),
           label = { Text(text = "Para") },

       )
       OutlinedTextField(
           value = cc,
           onValueChange = { cc = it},
           modifier = Modifier.fillMaxWidth(),
           label ={ Text(text = "Cc")}
       )
         OutlinedTextField(
             value = cco,
             onValueChange = {cco = it },
             modifier = Modifier.fillMaxWidth(),
             label = { Text(text = "Cco")}
         )
         OutlinedTextField(
             value = subject,
             onValueChange = {subject =it},
             modifier = Modifier.fillMaxWidth(),
             label = { Text(text = "Assunto") }
         )
         OutlinedTextField(
             value = body,
             onValueChange = {body = it},
             modifier = Modifier.fillMaxWidth(),
             label = { Text(text = "Corpo do Email") }

         )}
        // Button(
          //   onClick = {/* envio de email*/ },
            // modifier = Modifier.align(Alignment.End),
         //)// {
             //Text(text = "Enviar")



      //  }
//  Text(
       //    text = "Para",
         //  fontSize = 20.sp,
           //fontWeight = FontWeight.Light,
       //    modifier = Modifier.fillMaxWidth(),
        //   fontFamily = inter,

      // )
       //Text(
       //    text = "Cc",
       //    color = Color.Black,
         //  fontSize = 20.sp,
         //  fontFamily = inter,
      //)
       //Text(
       //    text = "CCO",
       //    fontSize = 20.sp,
      //)

       //Text(
       //text = "Nova Mensagem",
       //color = Color.Black,
       //fontSize = 16.sp,
       //fontWeight = FontWeight.Light,
       //textAlign = TextAlign.Center,
    //   modifier = Modifier.fillMaxWidth(),
         //)

//}}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NovoEmailPreview() {
    NovoEmail()
    }
    

