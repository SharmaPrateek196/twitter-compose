package com.example.androiddevchallenge.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.IntrinsicMeasurable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.composables.image.CircularImage
import com.example.androiddevchallenge.ui.composables.image.TweetImage
import com.example.androiddevchallenge.ui.composables.text.UserHandleText
import com.example.androiddevchallenge.ui.composables.text.UserNameBold
import com.example.androiddevchallenge.ui.composables.tweet.Comment
import com.example.androiddevchallenge.ui.composables.tweet.Like
import com.example.androiddevchallenge.ui.composables.tweet.Retweet
import com.example.androiddevchallenge.ui.composables.tweet.Share
import com.example.androiddevchallenge.ui.theme.*

@Composable
fun Tweet(
    tweeterName: String,
    handleName: String,
    timeTweeted: String,
    isVerified: Boolean,
    userImageResource: Int,
    hasImage: Boolean,
    imageResource: Int = 0,
    hasVideo: Boolean,
    videoUrl: String? = null,
    totalComments: String,
    totalRetweets: String,
    totalLikes: String,
    modifier: Modifier
) {

    Surface {
        Row(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
                .height(IntrinsicSize.Max)
        ) {
            CircularImage(
                imageResource = userImageResource,
                modifier = modifier,
                imageViewSize = 45
            )
            Spacer(
                modifier = Modifier
                    .width(8.dp)
                    .fillMaxHeight()
            )
            Column(
                modifier = Modifier.height(
                    IntrinsicSize.Max
                )
            ) {
                Row(Modifier.height(IntrinsicSize.Max)) {
                    UserNameBold(name = tweeterName, fontSize = usernameSize)
                    if(isVerified) {
                        Image(
                            painter = painterResource(R.drawable.ic_verified_tick),
                            contentDescription = null,
                            Modifier.padding(3.dp)
                        )
                    }
                    UserHandleText(
                        handleName = handleName,
                        fontSize = userHandleSize,
                        modifier = Modifier.padding(start = 3.dp)
                    )
                    Text(
                        text = timeTweeted,
                        color = grey,
                        fontSize = timeTextSize,
                        modifier = Modifier.padding(start = 3.dp)
                    )
                    Row(
                        Modifier.fillMaxSize(32f),
                        horizontalArrangement = Arrangement.End
                    ) {
                        More(modifier = Modifier.padding(start = 4.dp, top = 4.dp, bottom = 4.dp))
                        Spacer(Modifier.width(4.dp))
                    }
                }
                Text(
                    text = "An essay is nothing but a piece of content which is written from the perception of writer or author. Essays are similar to a story, pamphlet, thesis, etc. The best thing about Essay is you can use any type of language – formal or informal.",
                    fontSize = tweetTextSize
                )
                if (hasImage) {
                    Spacer(modifier = Modifier.height(4.dp))
                    TweetImage(
                        imageResource = imageResource,
                        modifier = Modifier.height(95.dp)
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Comment(totalComments)
                    Retweet(totalRetweets)
                    Like(totalLikes)
                    Share()
                }
            }
        }
    }

}

@Preview
@Composable
fun TweetItemPreview() {
    Tweet(
        "Prateek Sharma",
        "@prateekharmaofficial",
        "7h",
        true,
        R.drawable.my_pic,
        true,
        R.drawable.my_pic,
        false,
        "",
        "125",
        "6,534",
        "541",
        Modifier
    )
}