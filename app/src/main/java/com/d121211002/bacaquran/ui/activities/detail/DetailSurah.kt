package com.d121211002.bacaquran.ui.activities.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.d121211002.bacaquran.data.models.detail.Surah
import com.d121211002.bacaquran.ui.BacaQuranUiState
import com.d121211002.bacaquran.ui.activities.BacaQuranViewModel
import kotlinx.serialization.json.JsonNull.content

@Composable
fun DetailSurahScreen(
    surah: Surah,
    bacaQuranUiState: BacaQuranUiState,
    retryAction: () -> Unit,
){
    Column (
        Modifier
            .background(color = Color(0xFF1A4D2E))
            .padding(24.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {detailSurah(
        name = surah.name,
        translation = surah.translation,
        revelation = surah.revelation,
        numberOfAyahs = surah.numberOfAyahs
    )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(content = {
            items(surah.ayahs.size){
                    index ->
                        detailAyat(
                            arab = surah.ayahs[index].arab,
                            number = surah.ayahs[index].number?.inSurah,
                            translation = surah.ayahs[index].translation,
                            tafsir = surah.ayahs[index].tafsir
                        )
            }
        })
    }
}


@Composable
fun detailSurah(name: String?, translation:String?, revelation: String?, numberOfAyahs: Int?){
    Column (
        Modifier.fillMaxWidth(),
        ){
        Text(text = name?:"",
            Modifier.fillMaxWidth(),

            fontSize = 20.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFAF3E3),
        )
        Row (
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.Top,
        ){
            Text(text = translation?:"",
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFAF3E3),
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(text = "|",
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFAF3E3),
            )
            Text(text = revelation?:"",
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFAF3E3),
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(text = "|",
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFAF3E3),
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(text = "$numberOfAyahs ayat",
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFAF3E3),
            )}
    }
}

@Composable
fun detailAyat(arab: String?, number: Int?, translation: String?, tafsir: String?){
    Row {
        nomorAyat(number = number)
        Spacer(modifier = Modifier.width(8.dp))
        isiAyat(
            bunyiAyat = arab,
            artiAyat = translation,
            tafsir = tafsir,
        )
    }
}
@Composable
fun nomorAyat(number: Int?){
    Row(
        Modifier
            .width(36.dp)
            .height(24.dp)
            .background(color = Color(0xFFFAF3E3), shape = RoundedCornerShape(size = 0.dp)),
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Text(text = "$number ayat",
            Modifier
                .width(17.dp)
                .height(12.dp),

            fontSize = 10.sp,
            lineHeight = 12.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFF000000),

            textAlign = TextAlign.Center,
        )
    }
}


@Composable
fun isiAyat(bunyiAyat: String?, artiAyat: String?, tafsir: String?){
    Column(
        Modifier
            .fillMaxWidth()
            .border(
                width = 0.5.dp,
                color = Color(0xFFFAF3E3),
            )

            .background(color = Color(0xFFFAF3E3), shape = RoundedCornerShape(size = 0.dp))
            .padding(start = 8.dp, top = 12.dp, end = 8.dp, bottom = 12.dp),

        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = bunyiAyat?:"",

            fontSize = 14.sp,
            lineHeight = 16.8.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
        )
        Text(
            text = artiAyat?:"",

            fontSize = 10.sp,
            lineHeight = 12.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
        )
        Text(
            text = "Tafsir Kemenag:",
            fontSize = 10.sp,
            lineHeight = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF000000),
        )
        Text(
            text = tafsir?:"",
            fontSize = 8.sp,
            lineHeight = 12.sp,
            fontWeight = FontWeight(700),
            color = Color(0xFF000000),
            textAlign = TextAlign.Justify,
        )
    }
}

//@Preview
//@Composable
//fun tabPreview(){
//    DetailSurahScreen()
//}