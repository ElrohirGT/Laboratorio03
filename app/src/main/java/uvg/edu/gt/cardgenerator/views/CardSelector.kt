package uvg.edu.gt.cardgenerator.views
import uvg.edu.gt.cardgenerator.R.drawable;
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uvg.edu.gt.cardgenerator.Screen

@Composable
fun cardSelectorView(navController: NavController, celebrationType : String){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = celebrationType,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            fontSize = 32.sp)
        when(celebrationType){
            "Birthday" -> {
                val birthdayImg = listOf<Int>(drawable.birthday1, drawable.birthday2, drawable.birthday3, drawable.birthday4, drawable.birthday5)
                imageGrid(images = birthdayImg, navController)
            }
            "Christmas" -> {
                val christmasImg = listOf<Int>(drawable.christmas1, drawable.christmas2, drawable.christmas3, drawable.christmas4)
                imageGrid(images = christmasImg, navController)
            }
            "NewYear" -> {
                val newYearImg = listOf<Int>(drawable.newyear1, drawable.newyear2, drawable.newyear3)
                imageGrid(images = newYearImg, navController)
            }
            "Halloween" -> {
                val halloweenImg = listOf<Int>(drawable.halloween1, drawable.halloween2, drawable.halloween3, drawable.halloween4, drawable.halloween4)
                imageGrid(images = halloweenImg, navController)
            }
            "FatherDay" -> {
                val fatherImg = listOf<Int>(drawable.father1, drawable.father2, drawable.father3, drawable.father4)
                imageGrid(images = fatherImg, navController)
            }
            "Love" -> {
                val fatherImg = listOf<Int>(drawable.love1, drawable.love2, drawable.love3, drawable.love4, drawable.love5)
                imageGrid(images = fatherImg, navController)
            }
        }
    }
}

@Composable
fun imageGrid(images: List<Int>, navController: NavController){
    LazyVerticalGrid(contentPadding = PaddingValues(4.dp),
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth()){
        items(images) { imgID ->
            Button(
                modifier = Modifier.height(200.dp),
                onClick = { navController.navigate(Screen.CardGeneratorScreen.route + "/$imgID")}) {
                Image(painter = painterResource(id = imgID),
                    contentDescription = "image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop)
            }
        }
    }

}