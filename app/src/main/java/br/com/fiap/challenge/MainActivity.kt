package br.com.fiap.challenge

import EventActivity
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.challenge.activities.CaixaEntrada
import br.com.fiap.challenge.activities.DetalheEmail
import br.com.fiap.challenge.activities.EventoActivity
import br.com.fiap.challenge.activities.NovoEmail
import br.com.fiap.challenge.ui.theme.ChallengeTheme


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChallengeTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight()
                        .background(Color(0xFF012E40))
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home") {
                        composable(route = "home") {
                            CaixaEntrada(navController)
                        }
                        composable(route = "novo-email") {
                            NovoEmail(navController)
                        }
                        composable(route = "calendario") {
                            EventoActivity(navController)
                        }
                        composable(route = "detalhe-email/{idEmail}") {
                            val idEmail = it.arguments?.getString("idEmail")
                            DetalheEmail(navController, idEmail)
                        }
                        composable(route = "event") {
                            EventActivity(navController = navController)
                        }
                    }
                }

            }

        }

    }
}


