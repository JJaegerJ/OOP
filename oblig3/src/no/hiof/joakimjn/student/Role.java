package no.hiof.joakimjn.student;

public class Role  {

    private String characterFirstName;
    private String characterLastName;
    private Person actor;

    public Role(String characterFirstName, String characterLastName, Person actor) {
        this.characterFirstName = characterFirstName;
        this.characterLastName = characterLastName;
        this.actor = actor;
    }


    public String getCharacterFirstName() {
        return characterFirstName;
    }

    public void setCharacterFirstName(String characterFirstName) {
        this.characterFirstName = characterFirstName;
    }

    public String getCharacterLastName() {
        return characterLastName;
    }

    public void setCharacterLastName(String characterLastName) {
        this.characterLastName = characterLastName;
    }

    public Person getActor() {
        return actor;
    }

    public void setActor(Person actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Rolle: " + characterFirstName + " " + characterLastName + ". Skuespiller: " + actor+ "\n";
    }

}
