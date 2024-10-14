package com.example.virtualviewtesttag

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp

class ComposeButtonActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp,
                    )
                    .semantics {
                        testTagsAsResourceId = true
                    },
                verticalArrangement = Arrangement.spacedBy(
                    space = 16.dp,
                    alignment = Alignment.CenterVertically,
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(
                    modifier = Modifier.testTag("COMPOSE_BUTTON_TAG"),
                    onClick = {},
                ) {
                    Text(text = "Compose Buttons")
                }

                Surface(
                    modifier = Modifier
                        .clickable(role = Role.Button) {}
                        .testTag("COMPOSE_ROLE_BUTTON_ROW"),
                    color = Color.Red,
                ) {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = "With Role",
                    )
                }

                Surface(
                    modifier = Modifier
                        .clickable {}
                        .testTag("COMPOSE_NO_ROLE_CLICKABLE_ROW"),
                    color = Color.Gray,
                ) {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = "No Role",
                    )
                }
            }
        }
    }
}
