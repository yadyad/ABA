package furhatos.app.quiz.flow

import furhatos.app.quiz.Decease
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state

val state1: State = state(parent = Parent) {
    onEntry {
        print("hello")
        furhat.ask("I’m Furhat, your virtual healthcare assistant. What is your emergency?")
    }

    onResponse<Decease> {
        goto(state2)
    }
}

val state2: State = state(parent = Parent) {
    onEntry {
        furhat.say("hello")
    }
}