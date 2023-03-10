package com.tami.github.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tami.github.R
import com.tami.github.entity.UserItemEntity
import timber.log.Timber


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    vm: MainViewModel = viewModel()
) {
    Timber.i("Log")
    val userListState = vm.users.observeAsState()

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        userListState.value?.let {
            items(items = it) { entity ->
                UserItem(userItemEntity = entity)
            }
        }
    }
}


@Composable
fun UserItem(
    userItemEntity: UserItemEntity
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),

        ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            AsyncImage(
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
                    .clip(CircleShape),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(userItemEntity.avatar_url)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(id = R.string.avatar_description)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = userItemEntity.login,
                color = Color.Black
            )
        }
    }
}


@Composable
fun UserList() {
    LazyColumn {

    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    Surface {
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
                "?????????????????????",
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