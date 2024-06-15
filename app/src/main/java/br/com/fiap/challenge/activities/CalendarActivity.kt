package br.com.fiap.challenge.activities

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.YearMonth

class CalendarActivity : AppCompatActivity() {
//    @RequiresApi(Build.VERSION_CODES.O)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            ChallengeTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    CalendarView()
//                }
//            }
//        }
    }

    @RequiresApi(26)
    @Composable
    fun CalendarView(navController: NavController){
        var currentYearMonth by remember { mutableStateOf(YearMonth.now()) }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { currentYearMonth = currentYearMonth.minusMonths(1) },
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(Icons.Default.ChevronLeft, contentDescription = "Previous Month")
                }
                MonthHeader(currentYearMonth)
                IconButton(
                    onClick = { currentYearMonth = currentYearMonth.plusMonths(1) },
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(Icons.Default.ChevronRight, contentDescription = "Next Month")
                }
            }
            WeekDaysHeader()
            CalendarDays(currentYearMonth)
        }
    }

    @Composable
    fun WeekDaysHeader(){
        val weekDays = listOf("Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab")
        Row(
            Modifier.fillMaxWidth(), horizontalArrangement =
        Arrangement.SpaceAround){
            weekDays.forEach{day ->
                Box(modifier = Modifier.weight(1f), contentAlignment =
                Alignment.Center){
                    BasicText(text = day)
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun CalendarDays(yearMonth: YearMonth) {
        val daysInMonth = yearMonth.lengthOfMonth()
        val firstDayOfMonth = yearMonth.atDay(1).dayOfWeek.value % 7
        val days = (1..daysInMonth).toList()

        var dayIndex = 0

        for (week in 0..5) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                for (dayOfWeek in 0..6) {
                    if (week == 0 && dayOfWeek < firstDayOfMonth || dayIndex >= days.size) {
                        Box(
                            modifier = Modifier.weight(1f).aspectRatio(1f)
                                .align(Alignment.CenterVertically)
                        ) {}
                    } else {
                        Box(
                            modifier = Modifier.weight(1f).aspectRatio(1f)
                                .align(Alignment.CenterVertically)
                        ) {
                            Text(text = days[dayIndex].toString())
                            dayIndex++
                        }
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun MonthHeader(yearMonth: YearMonth) {
        val monthYear = "${yearMonth.month.name.lowercase().replaceFirstChar { it.uppercase() }} ${yearMonth.year}"
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            BasicText(text = monthYear, style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            )
        }
    }

//}