package codeFromGomathi.Polymorphism.UseCase;

import jdk.nashorn.api.tree.SimpleTreeVisitorES5_1;

public class Runner {
    public static void main(String[] args) {


        MyParentsLocation MPL= new MyLocation();

        MyLocation ml=(MyLocation) MPL;
        ml.locationInfo();

        MyParentsLocation MPL1= new MySisterLocation();
        MySisterLocation msl=(MySisterLocation) MPL1;
       msl.locationInfo();


    }
}
