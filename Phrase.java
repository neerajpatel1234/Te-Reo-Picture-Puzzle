/**
 * A Phrase object with the Moari phrase and the English translation
 * @param phrase
 * @param englishPhrase
 */
record Phrase(String phrase, String englishPhrase) {
    Phrase {
        if (phrase == null || englishPhrase == null) {
            throw new IllegalArgumentException("Phrase and englishPhrase must not be null");
        }
        if (phrase.isBlank() || englishPhrase.isBlank()) {
            throw new IllegalArgumentException("Phrase and englishPhrase must not be blank");
        }
        if (phrase.isEmpty() || englishPhrase.isEmpty()) {
            throw new IllegalArgumentException("Phrase and englishPhrase must not be empty");
        }
    }

    public String toString() {
        return "Phrase: " + phrase + ", : " + englishPhrase;
    }
}