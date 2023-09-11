/**
 * Colour object with maori name and english name
 * @param name
 * @param englishName
 */
record Colour(String name, String englishName) {
    Colour {
        if (name == null || englishName == null) {
            throw new IllegalArgumentException("Name and hex must not be null");
        }
        if (name.isBlank() || englishName.isBlank()) {
            throw new IllegalArgumentException("Name and hex must not be blank");
        }
        if (name.isEmpty() || englishName.isEmpty()) {
            throw new IllegalArgumentException("Name and hex must not be empty");
        }
    }

    public String toString() {
        return "Colour: " + name + ", : " + englishName;
    }
}
