package furhatos.app.quiz.flow

import furhatos.app.attentiongrabber.gestures.MySmile
import furhatos.app.attentiongrabber.gestures.TripleBlink
import furhatos.app.quiz.*
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.gestures.Gesture
import furhatos.gestures.Gestures
import furhatos.nlu.common.PersonName

var userName = ""
val intro: State = state(parent = Parent) {
    onEntry {
        furhat.ask("I’m your virtual healthcare assistant. What is your emergency?")

    }

    onResponse<Decease> {
        goto(requestName)
    }
}

val requestName: State = state(parent = Parent) {
    onEntry {
        furhat.ask("Acknowledged. The doctor will arrive shortly. I require your details to proceed. I assure you of " +
                "the confidentiality and security of your personal information. What is your name?")
    }

    onResponse<PersonName> {
        goto(requestInformation)
    }
}

val requestInformation: State = state(parent = Parent) {
    onEntry {
        furhat.ask( "Place your insurance card on the side table to your left for us to collect your information.")

    }

    onResponse<Insurance> {
        goto(processedInsurance)
    }
}

val processedInsurance : State = state(parent = Parent ) {
    onEntry {
        furhat.ask( "Your insurance details have been processed.")

    }

    onResponse<Nervous> {
        goto(requestContact)
    }
}

val requestContact: State = state(parent = Parent) {
    onEntry {
        furhat.ask("Provide the name and phone number of your emergency contact, we will contact them.")
    }

    onResponse<Contact> {
        goto(requestPainLevel)
    }
}

val requestPainLevel: State = state(parent = Parent)  {
    onEntry {
        furhat.ask("On a scale of 1 to 10, with 10 representing the most discomfort and 1 indicating the least, provide your current level of pain")
    }
    onResponse<PainLevel> {
        goto(requestAllergies)
    }
}

val requestAllergies:State = state(parent = Parent){
    onEntry {
        furhat.ask("Share any allergies or medical conditions you have.")
    }

    onResponse<Allergies> {
        furhat.say("Acknowledged. The doctor will be with you shortly.")
        furhat.gesture(Gestures.CloseEyes(duration = 4.0))
    }
}

