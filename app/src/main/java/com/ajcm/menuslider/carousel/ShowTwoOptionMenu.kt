package com.ajcm.menuslider.carousel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.ajcm.menuslider.model.ShowTowOptions

@Composable
fun ShowTwoOptionMenu(
    option: ShowTowOptions
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(option.backgroundColor),
        contentAlignment = Alignment.Center
    ) {

        Image(
            imageVector = ImageVector.vectorResource(id = option.stroke.imgRes),
            contentDescription = "",
            colorFilter = ColorFilter.tint(option.strokeTint),
            modifier = Modifier.fillMaxSize()
        )

        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                imageVector = ImageVector.vectorResource(id = option.image),
                contentDescription = "",
                colorFilter = ColorFilter.tint(option.strokeTint),
                modifier = Modifier
                    .padding(end = 20.dp)
                    .fillMaxHeight(0.8f)
                    .fillMaxWidth(0.3f)
                    .background(Color.Black)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .fillMaxHeight(0.8f)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.4f)
                        .background(MaterialTheme.colorScheme.tertiary)
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.2f)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(MaterialTheme.colorScheme.tertiary)
                )
            }

        }
    }

}
