package com.example.cimacorner.presentation.components



import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cimacorner.ui.theme.DarkComponentColor1
import com.example.cimacorner.ui.theme.DarkComponentColor2
import com.example.cimacorner.ui.theme.RedComponentColor1

@Composable
fun animatedShimmer(): Brush {
    val shimmerColors = listOf(
        DarkComponentColor2.copy(alpha = 0.6f),
        RedComponentColor1.copy(alpha = 0.2f),
        DarkComponentColor2.copy(alpha = 0.6f),

    )

    val transition = rememberInfiniteTransition(label = "")
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    return Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )


}

@Composable
fun ShimmerGridMovies() {

    val brush = animatedShimmer()
    LazyVerticalGrid(
        // Set the number of columns in the grid
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(2.dp)
    ) {
        items(10){ movie ->
            ShimmerImageCard(brush = brush)
        }
    }
}

@Composable
fun ShimmerImageCard(brush: Brush) {

    Spacer(
        modifier = Modifier
            .height(280.dp)
            .width(240.dp)
            .padding(8.dp)
            .shadow(
                elevation = 16.dp,
                spotColor = DarkComponentColor2,
                shape = RoundedCornerShape(16.dp)
            )
            .background(DarkComponentColor1)
            .background(brush)

    )

}




@Composable
@Preview(showBackground = true)
fun ShimmerGridItemPreview() {
    ShimmerGridMovies()
}

