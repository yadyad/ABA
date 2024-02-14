package furhatos.app.quiz.flow

import furhatos.app.quiz.Contact
import furhatos.app.quiz.Decease
import furhatos.app.quiz.Nervous
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.nlu.common.PersonName

var userName = ""
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
        furhat.ask("The doctor will be here shortly. I require your details. I ensure that I will maintain the" +
                " confidentiality and security of your personal information. What is your name?")
    }

    onResponse<PersonName> {
        userName += it.intent.value
        goto(state3)
    }
}

val state3: State = state(parent = Parent) {
    onEntry {
        furhat.ask( userName + "Place your insurance card on the side table to your left for us to collect your information.")
    }

    onResponse<Nervous> {
        goto(state4)
    }
}

val state4: State = state(parent = Parent) {
    onEntry {
        furhat.ask("We will establish contact with your loved ones so that they can comfort you. Give us the name and phone number of your emergency contact.")
    }

    onResponse<Contact> {
        furhat.say("Thank you. The doctor will be with you shortly. I am here to assist you.")
    }
}