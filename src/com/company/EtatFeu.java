package com.company;

/**
 * Created by axeleroy on 10/12/2014.
 */
public enum EtatFeu {
    VERT,
    ROUGE;

    public EtatFeu oposite() {
        if (this.equals(VERT)) {
            return ROUGE;
        } else {
            return VERT;
        }
    }
}
