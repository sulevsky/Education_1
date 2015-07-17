package com.courses.io.serializationgamesaving;

import java.io.Serializable;

/**
 * IMPORTANT implement Serializable
 */

public class CharacterType implements Serializable {
    private String typeName;
    private String skinColor;

    public CharacterType(String typeName, String scinColor) {
        this.typeName = typeName;
        this.skinColor = scinColor;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    @Override
    public String toString() {
        return "CharacterType{" +
                "typeName='" + typeName + '\'' +
                ", skinColor='" + skinColor + '\'' +
                '}';
    }
}
