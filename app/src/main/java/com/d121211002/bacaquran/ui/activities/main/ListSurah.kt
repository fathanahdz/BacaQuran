package com.d121211002.bacaquran.ui.activities.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.d121211002.bacaquran.R
import com.d121211002.bacaquran.data.models.detail.SurahsItem
import java.time.format.TextStyle

@Composable
fun ListSurahScreen(surahs: List<SurahsItem>, navigation: ()->Unit){

    Column(
        Modifier
            .background(color = Color(0xFF1A4D2E))
            .padding(24.dp)
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Text(
            text = "Surah",
                fontSize = 36.sp,
                lineHeight = 28.8.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFAF3E3),
                textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(content = {
            items(surahs.size){
                index ->
                    Surah(
                        nomorSurah = surahs[index].number,
                        namaSurah = surahs[index].name,
                        artiSurah = surahs[index].translation,
                        revelation = surahs[index].revelation,
                        jumlahAyat = surahs[index].numberOfAyahs,
                        navigation = navigation
                    )
                Spacer(modifier = Modifier.height(8.dp))
            }
        })
    }
}

@Composable
fun topAppBar(){
    Row(){
        Text(text = "BacaQuran",
            )
    }
}

@Composable
fun NomorSurah(nomorSurah: Int?){
    Row(
        Modifier
            .width(32.dp)
            .height(24.dp)
            .background(color = Color(0xFFFAF3E3), shape = RoundedCornerShape(size = 0.dp)),
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Text(text = nomorSurah?.toString() ?: "",
            Modifier
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
fun InfoSurah(namaSurah: String?, artiSurah:String?, revelation:String?, jumlahAyat: Int?){
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
    ){
        Text(
            text = namaSurah?:"",

            fontSize = 14.sp,
            lineHeight = 16.8.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
        )
        Text(
            text = artiSurah?:"",

            fontSize = 10.sp,
            lineHeight = 12.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
            )
        Row (

        ){
            Text(text = revelation?:"",
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                )
            Spacer(modifier = Modifier.width(2.dp))
            Text(text = "|",
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                )
            Spacer(modifier = Modifier.width(2.dp))
            Text(text = "$jumlahAyat ayat",
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                )

        }
    }
}

@Composable
fun Surah(nomorSurah: Int?,namaSurah: String?,artiSurah: String?, revelation: String?, jumlahAyat: Int?, navigation: () -> Unit){

    Row (
        Modifier.fillMaxWidth().clickable {
            navigation()
        }
    ){
        NomorSurah(nomorSurah = nomorSurah )
        Spacer(modifier = Modifier.width(8.dp))
        InfoSurah(namaSurah = namaSurah, artiSurah = artiSurah, revelation = revelation, jumlahAyat = jumlahAyat)
    }


}



