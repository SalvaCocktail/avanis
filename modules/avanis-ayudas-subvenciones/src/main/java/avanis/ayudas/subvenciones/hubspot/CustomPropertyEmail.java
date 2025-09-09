package avanis.ayudas.subvenciones.hubspot;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class CustomPropertyEmail {
    String name;
    String value;

    public CustomPropertyEmail(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public CustomPropertyEmail() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
