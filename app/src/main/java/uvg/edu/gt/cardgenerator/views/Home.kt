package uvg.edu.gt.cardgenerator.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uvg.edu.gt.cardgenerator.Screen
import uvg.edu.gt.cardgenerator.ui.theme.CardGeneratorTheme

@Composable
fun homeView(navController : NavController){
    val celebrationTypes by remember { mutableStateOf(
        listOf("Birthday", "Love", "Christmas", "NewYear", "Halloween", "FatherDay"))  }
    CardGeneratorTheme {
        Column (
            modifier = Modifier.fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row( modifier = Modifier.fillMaxWidth()){
                Text(text = "Select a Celebration",
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 32.sp)
            }
            Column {
                celebrationTypes.forEach() { celebration ->
                    Button( modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            navController.navigate(Screen.CardSelectorScreen.route + "/$celebration")}) {
                        Text(text = celebration)
                    }
                }
            }
        }
    }
}