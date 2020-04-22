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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setDog(boolean dog) {
        isDog = dog;
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

    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age = age;
    }



}
