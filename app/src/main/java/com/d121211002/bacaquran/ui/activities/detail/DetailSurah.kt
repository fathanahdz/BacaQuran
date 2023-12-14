package com.d121211002.bacaquran.ui.activities.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.d121211002.bacaquran.data.models.Ayah
import com.d121211002.bacaquran.data.models.Number
import com.d121211002.bacaquran.data.models.Surah
import com.d121211002.bacaquran.data.models.Tafsir
import com.d121211002.bacaquran.DetailSurahState
import com.d121211002.bacaquran.ui.viewmodel.BacaQuranViewModel
import com.d121211002.bacaquran.ui.activities.main.ErrorScreen
import com.d121211002.bacaquran.ui.activities.main.LoadingScreen

@Composable
fun DetailSurahScreen(
    detailSurahState: DetailSurahState,
    retryAction: () -> Unit,
    viewModel: BacaQuranViewModel,
    navigation:() -> Unit,
    modifier: Modifier = Modifier,

    ){
    Column (
        Modifier
            .background(color = Color(0xFF1A4D2E))
            .padding(24.dp)
            .fillMaxWidth()
            .fillMaxHeight()){
        when (detailSurahState){
            is DetailSurahState.Success -> {
                detailSurah(surah = detailSurahState.surah)
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(content = {
                    items(detailSurahState.surah.ayahs.size){
                            index ->
                                detailAyat(ayah = detailSurahState.surah.ayahs[index]                                    
                                )
                            Spacer(modifier = Modifier.height(16.dp))
                    }
                })
            }
            is DetailSurahState.Loading -> LoadingScreen(modifier.fillMaxSize())
            is DetailSurahState.Error -> ErrorScreen(retryAction)
        }
    }
}


@Composable
fun detailSurah(surah: Surah){
    Column (
        Modifier
            .fillMaxWidth()
            .padding(8.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(text = surah.name?:"",
            Modifier.fillMaxWidth(),

            fontSize = 32.sp,
            lineHeight = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFAF3E3),
        )
        Row (
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

        ){
            Text(text = surah.translation?:"",
                fontSize = 16.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFAF3E3),
            )
            Text(text = "|",
                fontSize = 16.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFAF3E3),
            )
            Text(text = surah.revelation?:"",
                fontSize = 16.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFAF3E3),
            )
            Text(text = "|",
                fontSize = 16.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFAF3E3),
            )
            Text(text = "${surah.numberOfAyahs} ayat",
                fontSize = 16.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFAF3E3),
            )}
    }
}

@Composable
fun detailAyat(ayah: Ayah){
    Row {
        nomorAyat(number = ayah.number)
        Spacer(modifier = Modifier.width(8.dp))
        isiAyat(
            bunyiAyat = ayah.arab,
            artiAyat = ayah.translation,
            tafsir = ayah.tafsir,
        )
    }
}
@Composable
fun nomorAyat(number: Number?){
    Row(
        Modifier
            .width(36.dp)
            .height(52.dp)
            .fillMaxSize()
            .border(
                BorderStroke(2.dp, Color.Transparent),
                shape = RoundedCornerShape(12.dp),
            )

            .background(
                color = Color(0xFFFAF3E3),
                shape = RoundedCornerShape(
                    topStart = CornerSize(0.dp),
                    topEnd = CornerSize(12.dp),
                    bottomEnd = CornerSize(0.dp),
                    bottomStart = CornerSize(12.dp)
                )
            ),
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Text(text = number?.inSurah.toString()?:"",
            Modifier
                .width(32.dp),

            fontSize = 16.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFF000000),

            textAlign = TextAlign.Center,
        )
    }
}


@Composable
fun isiAyat(bunyiAyat: String?, artiAyat: String?, tafsir: Tafsir?){
    Column(
        Modifier
            .fillMaxWidth()
            .border(
                BorderStroke(2.dp, Color.Transparent),
                shape = RoundedCornerShape(16.dp),
            )

            .background(
                color = Color(0xFFFAF3E3),
                shape = RoundedCornerShape(
                    topStart = CornerSize(0.dp),
                    topEnd = CornerSize(16.dp),
                    bottomEnd = CornerSize(0.dp),
                    bottomStart = CornerSize(16.dp)
                )
            )
            .padding(start = 8.dp, top = 12.dp, end = 8.dp, bottom = 12.dp),

        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = bunyiAyat?:"",
            Modifier.align(Alignment.End),
            fontSize = 20.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF000000),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = artiAyat?:"",

            fontSize = 16.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF000000),
        )
        Text(
            text = "Tafsir Kemenag:",
            fontSize = 16.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF000000),
        )
        Text(
            text = tafsir?.kemenag?.short.toString(),
            fontSize = 12.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF000000),
            textAlign = TextAlign.Justify,
        )
    }
}

