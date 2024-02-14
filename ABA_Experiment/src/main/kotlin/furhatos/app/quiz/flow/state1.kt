package furhatos.app.quiz.flow

import furhatos.app.quiz.*
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.nlu.common.PersonName

var userName = ""
val intro: State = state(parent = Parent) {
    onEntry {
        print("hello")
        furhat.ask("I’m Furhat, your virtual healthcare assistant. What is your emergency?")
    }

    onResponse<Decease> {
        goto(requestName)
    }
}

val requestName: State = state(parent = Parent) {
    onEntry {
        furhat.ask("The doctor will be here shortly. I require your details. I ensure that I will maintain the" +
                " confidentiality and security of your personal information. What is your name?")
    }

    onResponse<PersonName> {
        userName += it.intent.value
        goto(requestInformation)
    }
}

val requestInformation: State = state(parent = Parent) {
    onEntry {
        furhat.ask( userName + "Place your insurance card on the side table to your left for us to collect your information.")
    }

    onResponse<Nervous> {
        goto(requestContact)
    }
}

val requestContact: State = state(parent = Parent) {
    onEntry {
        furhat.ask("We will establish contact with your loved ones so that they can comfort you. Give us the name and phone number of your emergency contact.")
    }

    onResponse<Contact> {
        goto(requestPainLevel)
       // furhat.say("Thank you. The doctor will be with you shortly. I am here to assist you.")
    }
}

val requestPainLevel: State = state(parent = Parent)  {
    onEntry {
        furhat.ask("On a scale of 1 to 10, with 10 representing the most discomfort and 1 indicating the least , please provide your current level of pain")
    }
    onResponse<PainLevel> {
        goto(requestAllergies)
    }
}

val requestAllergies:State = state(parent = Parent){
    onEntry {
        furhat.ask("Could you please share any allergies or medical conditions you have?")
    }

    onResponse<Allergies> {
        furhat.say("Thank you. The doctor will be with you shortly. I am here to assist you.")
    }
}

