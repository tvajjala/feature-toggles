package com.tvajjala.toggles.model;

/**
 * from this article toggle types are defined
 * <p>
 * https://martinfowler.com/articles/feature-toggles.html
 */
public enum ToggleType {

    O("OPERATIONAL TOGGLE"),
    P("PERMISSION TOGGLE"),
    R("RELEASE TOGGLE"),
    E("EXPERIMENTAL TOGGLE");

    String type;

    ToggleType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
