package com.example.odev6

import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.odev6.model.Place
import com.example.odev6.ui.theme.main_color
import com.example.odev6.ui.theme.selective_color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(modifier: Modifier = Modifier) {
    val hostel_list = remember { mutableStateListOf<Place>() }

    LaunchedEffect(key1 = true) {
        val place1 = Place("Hostel Roma", 2130, 5.7f, "A peaceful place", "A peaceful place", false,4,2,"hostel_roma", 700)
        val place2 = Place("Joyful Guest House", 1130, 8.6f, "A peaceful place", "A wonderful place", false,2,1, "joyful",  569)
        val place3 = Place("Toffa Place In Rome", 2120, 6.8f, "Çift Kişilik veya İki Yataklı Oda - Özel Banyolu", "A peaceful place", false,2,1,"toffa",234)
        val place4 = Place("Imperial Suite Guest House", 2340, 8.5f, "Çift Kişilik veya İki Yataklı Oda", "WaA A peaceful  placerning", false,2,1,"imperial",345)
        val place5 = Place("Sonder Montevecchio", 2220, 8.5f, "A peaceful place", "Warning", false,3,2,"sonder",345)
        val place6 = Place("Binario Zero", 220, 8.1f, "A peaceful place", "Warning", false,3,2,"binario", 324)
        hostel_list.add(place1)
        hostel_list.add(place2)
        hostel_list.add(place3)
        hostel_list.add(place4)
        hostel_list.add(place5)
        hostel_list.add(place6)
    }
    Scaffold(
        topBar = {
            CustomTopBar()
        }
    ) { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues)) {

            Column(modifier = Modifier.fillMaxSize()) {
                Text(text = "1455 tesis", modifier = Modifier.padding(horizontal = 14.dp, vertical = 7.dp))
                LazyColumn {
                    items(hostel_list.count()) {
                        val place = hostel_list[it]

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(horizontal = 13.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(1f),
                                verticalArrangement = Arrangement.Center
                            ) {

                                val activity = (LocalContext.current as Activity)

                                Image( bitmap = ImageBitmap.imageResource(
                                    id = activity.resources.getIdentifier(place.picture,"drawable",activity.packageName)),
                                    contentDescription =" ",
                                    modifier = Modifier
                                        .size(120.dp, 180.dp)
                                        .clip(RoundedCornerShape(8.dp)) // Görselin köşelerini yuvarlamak için
                                        .background(Color.LightGray), // Arka plan rengi
                                        contentScale = ContentScale.Crop
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(2f),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.End
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        modifier = Modifier.align(Alignment.CenterVertically),
                                        text = place.name,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp,
                                    )
                                    IconButton(onClick = { }) {
                                        Icon(Icons.Default.FavoriteBorder, contentDescription = " ")
                                    }
                                }

                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Text(
                                        text = place.rate.toString(),
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier
                                            .background(
                                                main_color,
                                                shape = RoundedCornerShape(
                                                    bottomEnd = 6.dp,
                                                    topEnd = 6.dp,
                                                    topStart = 6.dp
                                                )
                                            )
                                            .padding(4.dp)
                                    )
                                    Text(
                                        text =
                                        if (place.totalReview>300){
                                         "Yeterli ${place.totalReview} değerlendirme"

                                        }
                                        else{
                                        "Yetersiz 300 veya daha az değerlendirme"

                                        },
                                        modifier = Modifier
                                            .padding(start = 10.dp)
                                            .align(Alignment.CenterVertically)
                                    )
                                }

                                Text(text = place.warning, modifier = Modifier.align(Alignment.Start))
                                Text(text = "Fiyat şunun için 1 gece 2 yetişkin",
                                    fontWeight = FontWeight.Bold,
                                    modifier= Modifier.align(Alignment.End)
                                    )
                                Text(text = "${place.bedroom_count} yatak")
                                Text(text = "${place.bath_count} banyo")
                                Text(
                                    text = "${place.price} ₺",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 19.sp
                                )

                            }
                        }
                        HorizontalDivider(
                            color = Color.Gray.copy(alpha = 0.3f),
                            thickness = 1.dp,
                            modifier = Modifier.fillMaxWidth()
                        )

                    }

                }
            }


        }

    }
}

@Composable
fun CustomTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(main_color) // Blue background
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 36.dp)
                    .background(main_color) // Blue background
            )
            Spacer(modifier = Modifier.height(40.dp)) // Space between top part and buttons

            FilterBar()
        }
    }

    Surface(
        color = Color.White, // Yellow background,
        border = BorderStroke(4.dp, selective_color),
        shape = RoundedCornerShape(8.dp),
        // elevation = 8.dp,
        modifier = Modifier
            //      .align(Alignment.TopCenter)
            .padding(horizontal = 16.dp)
            .offset(y = 55.dp) // Position the text section to overlap
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp),
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "arrow back",
                        )
                }

                Text(
                    text = "Roma Şehir Merkezi : 30 Ağu - 31 Ağu",
                    color = Color.Black,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Composable
fun FilterBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp)
            .height(70.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clickable {},
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.size(35.dp, height = 25.dp),
                        painter = painterResource(id = R.drawable.swap),
                        contentDescription = ""
                    )
                    Text(text = "Sırala")
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clickable {},
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.size(30.dp, height = 20.dp),
                        painter = painterResource(id = R.drawable.filter),
                        contentDescription = ""
                    )
                    Text(text = "Filrele")
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clickable {},
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.size(30.dp, height = 20.dp),
                        painter = painterResource(id = R.drawable.map),
                        contentDescription = ""
                    )
                    Text(text = "Harita")
                }
            }

        }
    }
    HorizontalDivider(
        color = Color.Gray.copy(alpha = 0.3f),
        thickness = 0.4.dp,
        modifier = Modifier.fillMaxWidth()
    )
}


//            TextButton(onClick = { /* Handle Sort click */ }) {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Icon(
//                        imageVector = Icons.Default.LocationOn,
//                        contentDescription = "Sort"
//                    )
//                    Text(text = "Sırala", color = Color.Black)
//                }
//            }
//            TextButton(onClick = { /* Handle Filter click */ }) {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Icon(
//                        imageVector = Icons.Default.AccountBox,
//                        contentDescription = "Filter"
//                    )
//                    Text(text = "Filtrele", color = Color.Black)
//                }
//            }
//            TextButton(onClick = { /* Handle Map click */ }) {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = "Map")
//                    Text(text = "Harita", color = Color.Black)
//                }
//            }


