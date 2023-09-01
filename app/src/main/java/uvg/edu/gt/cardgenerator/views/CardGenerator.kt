package uvg.edu.gt.cardgenerator.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import uvg.edu.gt.cardgenerator.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun cardGeneratorView(navController: NavController, imageID: Int){
    var name by remember { mutableStateOf("") }
    var msg by remember { mutableStateOf("") }
    Column ( modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Name and Lastname", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it }
        )
        Text(text = "Message", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = msg,
            onValueChange = { msg = it }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button( modifier = Modifier.fillMaxWidth(),
            onClick = { /*TODO*/ }) {
            Text(text = "Generate", fontSize = 20.sp)
        }
        ConstraintLayout ( modifier = Modifier
            .fillMaxWidth()){
            // Create references for the composables to constrain
            val (img, text) = createRefs()
            Image(painter = painterResource(id = imageID),
                contentDescription = "image",
                modifier = Modifier
                    .constrainAs(img) {centerHorizontallyTo(parent)},
                contentScale = ContentScale.Crop)
            Text(text = name + "\n" + msg, color = Color.White, textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(text){
                    centerHorizontallyTo(parent)
                    centerVerticallyTo(parent)})

        }
    }
}