package com.rms.model;



public enum Category {
    LIGHTING(1), AIR_CONDITIONING(2), DOORS(3), PROJECTOR(4), OTHER(5);

    private final int type;

<<<<<<< HEAD
    private Category(int type){
=======
    private Category(int type) {
>>>>>>> bf13305cb8d678afde3c5962db86bee7571ffa02
        this.type = type;
    }

    public int getValue() {
        return type;
    }
}