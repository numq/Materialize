package generation

import feature.Feature
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

class GenerationFeature(reducer: GenerationReducer) : Feature<GenerationCommand, GenerationState, GenerationEvent>(
    initialState = GenerationState.Loading, reducer = reducer
) {
    private var schemeJob: Job? = null

    init {
        events.onStart {
            execute(GenerationCommand.InitializeScheme)
        }.onEach { event ->
            when (event) {
                is GenerationEvent.Error -> println(event.exception.localizedMessage)

                is GenerationEvent.SchemeUpdates -> {
                    schemeJob?.cancel()
                    schemeJob = event.schemeFlow.onEach { scheme ->
                        execute(GenerationCommand.UpdateScheme(scheme))
                    }.launchIn(featureScope)
                }
            }
        }.launchIn(featureScope)
    }
}