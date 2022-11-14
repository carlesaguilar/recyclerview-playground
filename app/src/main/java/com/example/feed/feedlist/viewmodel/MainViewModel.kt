package com.example.feed.feedlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feed.feedlist.model.FeedItem
import com.example.feed.feedlist.model.Image
import com.example.feed.feedlist.view.state.MainState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _mainState = MutableStateFlow<MainState>(MainState.Loading)
    val mainState = _mainState.asStateFlow()

    private val itemsText = listOf(
        FeedItem.TextFeedItem(
            id = 1,
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent feugiat est ut risus molestie aliquet. Quisque consectetur hendrerit augue, id volutpat erat molestie sit amet."
        ),
        FeedItem.TextFeedItem(
            id = 1,
            text = "Etiam diam tellus, blandit vitae urna sed, fringilla tristique elit. Aenean ornare ex massa, molestie suscipit metus mollis at. Etiam ac luctus tellus, in sagittis tortor."
        ),
    )

    private val itemsImages = listOf(
        FeedItem.ImagesFeedItem(
            listOf(
                Image(
                    id = 2,
                    image = "https://loremflickr.com/320/240?random=1"
                ),
                Image(
                    id = 2,
                    image = "https://loremflickr.com/320/240?random=2"
                ),
                Image(
                    id = 3,
                    image = "https://loremflickr.com/320/240?random=3"
                ),
                Image(
                    id = 4,
                    image = "https://loremflickr.com/320/240?random=4"
                ),
            )
        ),
    )

    private val itemsImagesAndText = listOf(
        FeedItem.ImageAndTextFeedItem(
            id = 3,
            image = "https://loremflickr.com/320/240?random=5",
            text = "Nam id nibh quis nibh feugiat consequat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed congue vel sem quis fringilla. Etiam sodales, urna ac fringilla elementum, ante velit suscipit massa, ut porttitor justo nisi vel leo."
        ),
        FeedItem.ImageAndTextFeedItem(
            id = 3,
            image = "https://loremflickr.com/320/240?random=6",
            text = "Fusce cursus posuere ultrices. Phasellus augue magna, consequat eu est ac, posuere molestie quam. Proin non est purus. Quisque et dolor metus."
        ),
    )

    fun retrieveData() {
        viewModelScope.launch {
            delay(1000)
            _mainState.emit(MainState.FeedItems(items = itemsText))
            delay(1000)
            _mainState.emit(MainState.FeedItems(items = itemsImages))
            delay(1000)
            _mainState.emit(MainState.FeedItems(items = itemsImagesAndText))
        }
    }
}
