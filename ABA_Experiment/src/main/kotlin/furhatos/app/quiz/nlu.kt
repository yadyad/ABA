package furhatos.app.quiz

import furhatos.app.quiz.questions.QuestionSet
import furhatos.nlu.EnumEntity
import furhatos.nlu.EnumItem
import furhatos.nlu.Intent
import furhatos.util.Language

class DontKnow : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
                "I don't know",
                "don't know",
                "no idea",
                "I have no idea"
        )
    }
}

class RequestRules : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
                "what are the rules",
                "how does it work"
        )
    }
}

class RequestRepeatQuestion : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
                "what was the question",
                "can you repeat the question",
                "what was the question again"
        )
    }
}

class RequestRepeatOptions : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
                "what are the options",
                "can you repeat the options",
                "what was the options"
        )
    }
}

class AnswerOption : EnumEntity {

    var correct : Boolean = false

    // Every entity and intent needs an empty constructor.
    constructor() {
    }

    // Since we are overwriting the value, we need to use this custom constructor
    constructor(correct : Boolean, value : String) {
        this.correct = correct
        this.value = value
    }

    override fun getEnumItems(lang: Language): List<EnumItem> {
        return QuestionSet.current.options
    }

}

class Nervous : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "nervous",
            "happen",
            "what"
        )
    }
}

class Decease : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "stairs",
            "I fell down the stairs and my hand is in a lot of pain.",
            "hand",
            "pain"
        )
    }
}

class Contact : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "emergency",
            "My emergency contact is Sadie, and her number is +49 1482929548.",
            "contact",
            "number"
        )
    }
}


class PainLevel : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "current",
            "My current pain level is 5",
            "level"
        )
    }
}

class Allergies : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "known",
            "I don't have any known allergies.",
            "allergies"
        )
    }
}
