package com.daiatech.karya.ui.avatar

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private val AvatarGreen = Color(0xFF4EBF87)
private val AvatarSize = 120.dp

/**
 * A circular avatar component with optional active state visuals.
 *
 * In the **inactive** state, the avatar displays a circular image with an accent-colored border.
 *
 * In the **active** state, two additional elements appear:
 * - A blurred glowing ring around the avatar circle.
 * - A speech bubble in the top-start corner containing an animated audio waveform, indicating
 *   that the avatar is currently speaking.
 *
 * The total layout size is `avatarSize + 32.dp` to accommodate the glow ring.
 *
 * @param isActive Whether the avatar is in the active (speaking) state.
 * @param avatarVector The [ImageVector] to display as the avatar image.
 * @param modifier Modifier applied to the outer container.
 * @param accentColor Color used for the avatar border and active glow ring. Defaults to the
 *   Karya green (`#4EBF87`).
 * @param avatarSize Diameter of the avatar circle. Defaults to 120.dp.
 * @param contentDescription Accessibility description for the avatar image. Pass `null` if the
 *   avatar is purely decorative.
 */
@Composable
fun AvatarComponent(
    isActive: Boolean,
    avatarVector: ImageVector,
    modifier: Modifier = Modifier,
    accentColor: Color = AvatarGreen,
    avatarSize: Dp = AvatarSize,
    contentDescription: String? = "Avatar",
) {
    Box(
        modifier = modifier.size(avatarSize + 32.dp),
        contentAlignment = Alignment.Center
    ) {
        if (isActive) {
            Box(
                Modifier
                    .size(avatarSize + 32.dp)
                    .clip(CircleShape)
                    .blur(12.dp)
                    .padding(16.dp)
                    .border(8.dp, accentColor, CircleShape)
            )
        }

        Box(
            Modifier
                .size(avatarSize)
                .background(Color(0xFFD9D9D9), CircleShape)
                .clip(CircleShape)
                .border(2.dp, accentColor, CircleShape)
        )
        Image(
            painter = rememberVectorPainter(avatarVector),
            contentDescription = contentDescription,
            modifier = Modifier
                .size(avatarSize)
                .clip(CircleShape)
        )

        if (isActive) {
            Box(
                Modifier
                    .size(48.dp)
                    .align(Alignment.TopStart)
                    .offset(y = avatarSize / 2 - 32.dp)
            ) {
                Image(
                    imageVector = messageBubble,
                    modifier = Modifier.size(48.dp),
                    contentDescription = null
                )
                AudioBars(
                    barColor = Color(0xFFBBBBBB),
                    modifier = Modifier.height(16.dp).offset(x = 12.dp, y = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun AudioBars(barColor: Color, modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition(label = "audio_bars")
    val h0 by transition.animateFloat(
        initialValue = 0.15f,
        targetValue = 0.35f,
        animationSpec = infiniteRepeatable(
            animation = tween(450, easing = FastOutSlowInEasing, delayMillis = 0),
            repeatMode = RepeatMode.Reverse
        ),
        label = "barH_0"
    )
    val h1 by transition.animateFloat(
        initialValue = 0.5f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(450, easing = FastOutSlowInEasing, delayMillis = 150),
            repeatMode = RepeatMode.Reverse
        ),
        label = "barH_1"
    )
    val h2 by transition.animateFloat(
        initialValue = 0.15f,
        targetValue = 0.35f,
        animationSpec = infiniteRepeatable(
            animation = tween(450, easing = FastOutSlowInEasing, delayMillis = 300),
            repeatMode = RepeatMode.Reverse
        ),
        label = "barH_2"
    )

    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        listOf(h0, h1, h2).forEach { heightFraction ->
            AudioBar(accentColor = barColor, heightFraction = heightFraction)
        }
    }
}

@Composable
private fun AudioBar(accentColor: Color, heightFraction: Float) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(4.dp)
            .height(16.dp)
    ) {
        Box(
            modifier = Modifier
                .width(4.dp)
                .height(16.dp * heightFraction)
                .background(accentColor, RoundedCornerShape(50))
        )
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFE8FAF4)
@Composable
private fun InactivePreview() {
    Surface(color = Color(0xFFE8FAF4)) {
        Box(Modifier.padding(32.dp), contentAlignment = Alignment.Center) {
            AvatarComponent(isActive = false, avatarVector = avatarLogo)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFE8FAF4)
@Composable
private fun ActivePreview() {
    Surface(color = Color(0xFFE8FAF4)) {
        Box(Modifier.padding(32.dp), contentAlignment = Alignment.Center) {
            AvatarComponent(isActive = true, avatarVector = avatarLogo)
        }
    }
}
