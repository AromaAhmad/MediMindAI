package com.aroma.medimindai.ui.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.aroma.medimindai.data.ChatMessage
import kotlinx.coroutines.launch

@Composable
fun ChatScreen() {
    val context = LocalContext.current
    val viewModel: ChatViewModel = viewModel(
        factory = viewModelFactory {
            initializer { ChatViewModel(context.applicationContext as android.app.Application) }
        }
    )

    val messages by viewModel.messages.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    var userInput by remember { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(true) }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(messages) { item ->
                MessageBubble(item)
            }

            if (isLoading) {
                item {
                    Text("AI is thinking...")
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextField(
                value = userInput,
                onValueChange = { userInput = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Type here...") }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                enabled = userInput.isNotBlank() && isButtonEnabled && !isLoading,
                onClick = {
                    isButtonEnabled = false

                    viewModel.sendMessage(userInput)
                    userInput = ""

                    scope.launch {
                        kotlinx.coroutines.delay(1200)
                        isButtonEnabled = true
                    }
                }
            ) {
                Text("Send")
            }
        }
    }
}

@Composable
fun MessageBubble(message: ChatMessage) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement =
            if (message.isUser) Arrangement.End else Arrangement.Start
    ) {

        Card(
            modifier = Modifier.widthIn(max = 280.dp),
            colors = CardDefaults.cardColors(
                containerColor =
                    if (message.isUser)
                        MaterialTheme.colorScheme.primary
                    else
                        MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Text(
                text = message.message,
                modifier = Modifier.padding(12.dp),
                color =
                    if (message.isUser)
                        MaterialTheme.colorScheme.onPrimary
                    else
                        MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}