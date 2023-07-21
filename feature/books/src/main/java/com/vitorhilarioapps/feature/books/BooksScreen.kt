package com.vitorhilarioapps.feature.books

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BooksScreen() {
    LazyColumn {
        items(FakeData.bookList) { book ->
            BookItem(book)
        }
    }
}

@Composable
fun BookItem(
    book: Book
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxHeight(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = book.tittle, fontWeight = FontWeight.Bold)
        Text(text = book.description)
    }
}