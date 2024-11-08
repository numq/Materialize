package generation

import kotlinx.coroutines.flow.StateFlow
import scheme.Scheme

sealed interface GenerationEvent {
    data class Error(val exception: Exception) : GenerationEvent

    data class SchemeUpdates(val schemeFlow: StateFlow<Scheme>) : GenerationEvent
}