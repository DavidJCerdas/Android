package com.djcerdas.introductiontojavaclasses;

public class Pet {
    public String name;
    public int age;
    public float weight;
    public boolean isDog;

    public Pet(String nameConstructor,int ageConstructor, float weightConstructor, boolean isDogConstructor){
        /**
         * The same as :
         *  mAge = age;
         *  mWeight = weight;
         *  mIsDog = isDog;
        */
        this.name = nameConstructor;
        this.age = ageConstructor;
        this.weight = weightConstructor;
        this.isDog =  isDogConstructor;
    }
}
