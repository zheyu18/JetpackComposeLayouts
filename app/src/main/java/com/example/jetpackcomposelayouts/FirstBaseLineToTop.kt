package com.example.jetpackcomposelayouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposelayouts.ui.theme.JetpackComposeLayoutsTheme

/**
 * Email 3301360040@qq.com
 * Created by ZheYu on 2022/6/1.
 * Description:
 */

fun Modifier.firstBaseLineToTop(
    firstBaseLineToTop: Dp
) = this.then(
    layout { measurable, constraints ->
        //测量元素
        val placeable = measurable.measure(constraints)
        // 测量之后，获取元素的基线值
        val firstBaseLine = placeable[FirstBaseline]
        val placeableY = firstBaseLineToTop.roundToPx() - firstBaseLine
        val height = placeable.height + placeableY
        layout(placeable.width, height) {
            placeable.placeRelative(0, placeableY)
        }
    }
)


@Composable
fun TextWithPaddingToBaseLine() {
    JetpackComposeLayoutsTheme {
        Text(
            text = "Hi There",
            Modifier
//                .padding(24.dp)
                .firstBaseLineToTop(24.dp)
                .background(Color.Red)
        )
    }
}