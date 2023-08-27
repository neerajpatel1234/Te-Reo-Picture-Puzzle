record Word(String name, String definition) {
    Word {
        if (name == null || definition == null) {
            throw new IllegalArgumentException("Word and definition must not be null");
        }
        if (name.isBlank() || definition.isBlank()) {
            throw new IllegalArgumentException("Word and definition must not be blank");
        }
        if (name.isEmpty() || definition.isEmpty()) {
            throw new IllegalArgumentException("Word and definition must not be empty");
        }
    }


    public String toString() {
        return "Word: " + name + ", Def: " + definition;
    }

}
