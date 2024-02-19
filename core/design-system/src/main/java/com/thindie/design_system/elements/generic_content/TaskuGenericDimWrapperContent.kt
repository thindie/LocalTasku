package com.thindie.design_system.elements.generic_content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.round
import androidx.compose.ui.zIndex

import com.thindie.design_system.elements.dim_wrapper.dimwrapperstate.DimState
import com.thindie.design_system.elements.dim_wrapper.dimwrapperstate.Scrim


private const val MIDDLE_LAYER = 2f
private const val LOW_LAYER = 1f
private const val TOP_LAYER = 3f

@Composable
fun TaskuGenericDimWrapperContent(
    modifier: Modifier = Modifier,
    dimState: DimState,
    dimWrappedContent: @Composable () -> Unit,
) {


    //scrim
    Box(
        modifier = modifier
            .zIndex(MIDDLE_LAYER)
            .fillMaxSize()
    ) {
        Scrim(
            color = Color.Black,
            onDismissRequest = dimState::onDismissRequest,
            visible = dimState.shouldDim,
            modifier = modifier.zIndex(LOW_LAYER)
        )
    }

    //content
    Box(
        modifier = modifier
            .zIndex(1f)
            .wrapContentSize()
    ) {
        dimWrappedContent()
    }


//topLevelContent
    if (dimState.shouldDim) {
        Box(modifier = Modifier
            .wrapContentSize()
            .offset { dimState.selectedContentOffset.round() }
            .zIndex(TOP_LAYER)
            .then(modifier)) {
            dimState.contentOnTopOfDimmed.invoke()
        }
    }
}

/*

@Preview(showBackground = true)
@Preview(device = Devices.PIXEL_2)
@Preview(device = Devices.PIXEL_4_XL)
@Composable
fun TaskuDimSomePreviewDark() {
    TaskuTheme(darkTheme = true) {

        val dimState: DimState = rememberDimmingState()

        TaskuGenericDimWrapperContent(dimState = dimState) {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                repeat(5) {
                    val cardState = rememberTaskuCardState(customizeAble = fakeCustomizable)
                    val mediator = rememberGenericDimMediator(state = dimState)
                    if (dimState.shouldDim.not()) cardState.onMinimizeTask()
                    mediator {
                        TaskuCard(
                            modifier = Modifier.onGloballyPositioned {
                                mediator.setOffset(it.positionInRoot())
                            },
                            cardState = cardState,
                            onTaskExpanded = mediator::mediate,
                            onTaskHided = dimState::onDismissRequest
                        )
                    }()
                }
            }
        }
    }
}
*/





