package com.example.calculator.presentation.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.presentation.mainscreen.common.CalculatorButton
import com.example.calculator.ui.theme.LightGray
import com.example.calculator.ui.theme.MediumGray
import com.example.calculator.ui.theme.Orange

@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    onAction: (CalculatorEvent) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2


            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
            ) {
                CalculatorButton(
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(2f)
                        .weight(2f), symbol = "AC",
                    onClick = {
                        onAction(CalculatorEvent.Clear)
                    }
                )

                CalculatorButton(
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f), symbol = "Del",
                    onClick = {
                        onAction(CalculatorEvent.Delete)
                    }
                )

                CalculatorButton(
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f), symbol = "/",
                    onClick = {
                        onAction(CalculatorEvent.Operation(CalculatorOperation.Divide))
                    }
                )


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
            ) {
                CalculatorButton(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f), symbol = "7",
                    onClick = {
                        onAction(CalculatorEvent.Number(7))
                    }
                )

                CalculatorButton(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f), symbol = "8",
                    onClick = {
                        onAction(CalculatorEvent.Number(8))
                    }
                )

                CalculatorButton(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f), symbol = "9",
                    onClick = {
                        onAction(CalculatorEvent.Number(9))
                    }
                )

                CalculatorButton(
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f), symbol = "x",
                    onClick = {
                        onAction(CalculatorEvent.Operation(CalculatorOperation.Multiply))
                    }
                )


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
            ) {
                CalculatorButton(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f), symbol = "4",
                    onClick = {
                        onAction(CalculatorEvent.Number(4))
                    }
                )

                CalculatorButton(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f), symbol = "5",
                    onClick = {
                        onAction(CalculatorEvent.Number(5))
                    }
                )

                CalculatorButton(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f), symbol = "6",
                    onClick = {
                        onAction(CalculatorEvent.Number(6))
                    }
                )

                CalculatorButton(
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f), symbol = "-",
                    onClick = {
                        onAction(CalculatorEvent.Operation(CalculatorOperation.Minus))
                    }
                )

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
            ) {
                CalculatorButton(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f), symbol = "1",
                    onClick = {
                        onAction(CalculatorEvent.Number(1))
                    }
                )

                CalculatorButton(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f), symbol = "2",
                    onClick = {
                        onAction(CalculatorEvent.Number(2))
                    }
                )

                CalculatorButton(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f), symbol = "3",
                    onClick = {
                        onAction(CalculatorEvent.Number(3))
                    }
                )

                CalculatorButton(
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f), symbol = "+",
                    onClick = {
                        onAction(CalculatorEvent.Operation(CalculatorOperation.Plus))
                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
            ) {
                CalculatorButton(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(2f)
                        .weight(2f), symbol = "0",
                    onClick = {
                        onAction(CalculatorEvent.Number(0))
                    }
                )

                CalculatorButton(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f), symbol = ".",
                    onClick = {
                        onAction(CalculatorEvent.Decimal)
                    }
                )

                CalculatorButton(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f), symbol = "=",
                    onClick = {
                        onAction(CalculatorEvent.Calculate)
                    }
                )

            }
        }
    }

}