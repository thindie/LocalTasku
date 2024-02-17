package com.thindie.design_system.elements.dim_wrapper.dimwrapperstate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.geometry.Offset
import com.thindie.design_system.elements.dim_wrapper.dimwrapperstate.DimMediator
import com.thindie.design_system.elements.dim_wrapper.dimwrapperstate.DimState

@Stable
internal class TaskuCardDimMediator(private val state: DimState) : DimMediator {

    private var offset = Offset.Zero
    private var content = @Composable {}

    override fun mediate() {
        state.setSelectedContentPosition(offset)
        state.setTopContent(content)
        state.onTriggerDim()
    }


    override fun setOffset(offset: Offset) {
        this.offset = offset
    }

    override operator fun invoke(content: @Composable () -> Unit): @Composable () -> Unit {
        this.content = content
        return content
    }

    override fun dismissDim() {
        state.onDismissRequest()
    }
}