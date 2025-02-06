package com.project.framework

sealed class FatalError {
    data object E_STUCK : FatalError()
    data object E_OVERHANG : FatalError()
    data object E_TSTALLED : FatalError()
    data object E_COLLISION : FatalError()
    data object E_ESTOP : FatalError()
}
