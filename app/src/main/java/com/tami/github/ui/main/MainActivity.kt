package com.tami.github.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.tami.github.data.GithubRepository
import com.tami.github.entity.UserItemEntity
import com.tami.github.ui.theme.GithubTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserItem(
                        userItemEntity = UserItemEntity(
                            "https://avatars.githubusercontent.com/u/45057577?v=4",
                            "",
                            "",
                            "",
                            "",
                            "",
                            "",
                            0,
                            "가나다라마바사",
                            "",
                            "",
                            "",
                            "",
                            100.toDouble(),
                            true,
                            "",
                            "",
                            "",
                            ""
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GithubTheme {
        Greeting("Android")
    }
}