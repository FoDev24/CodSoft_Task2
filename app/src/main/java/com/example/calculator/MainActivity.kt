package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.presentation.mainscreen.Calculator
import com.example.calculator.presentation.mainscreen.CalculatorViewModel
import com.example.calculator.ui.theme.CalculatorTheme
import com.example.calculator.ui.theme.MediumGray
import com.example.calculator.util.Const.Companion.BUTTON_SPACING

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                Calculator(state = state, onAction = {event->
                    viewModel.onEvent(event)
                } ,
                buttonSpacing = BUTTON_SPACING ,
                modifier = Modifier
                    .fillMaxSize()
                    .background(MediumGray)
                    .padding(16.dp) )
            }
        }
    }
}

