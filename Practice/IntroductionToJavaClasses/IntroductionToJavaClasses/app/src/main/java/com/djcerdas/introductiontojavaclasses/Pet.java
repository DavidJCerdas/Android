package com.djcerdas.introductiontojavaclasses;

public class Pet {
    private static int ID = 0;

    public String name;
    public int age;
    public float weight;
    // Final because the idea is to set it once, and stay like that
    public final boolean isDog;

    /**
     *
     * @param nameConstructor : The name of the Pet.
     * @param ageConstructor  : The age in years for the Pet.
     * @param weightConstructor : Weight in Kg for the Pet.
     * @param isDogConstructor  : true or false, to confirm the Pet is a Dog.
     */
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
        ID++;
    }

    public static int getId(){
        return ID;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isDog() {
        return isDog;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int geTAGe(){
        return this.age;
    }
    public void seTAGe(int age){
        this.age = age;
    }

}
