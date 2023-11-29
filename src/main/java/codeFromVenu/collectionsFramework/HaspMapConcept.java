package codeFromVenu.collectionsFramework;

import java.util.HashMap;

public class HaspMapConcept {

    public static void main(String[] args) {

        HashMap<String,Integer> age = new HashMap<String,Integer>();
        System.setProperty("Gopal","22");
        age.put("Venu",99);
        age.put("Manisha",106);
        age.put("Kavitha",18);
        age.put("Divya",8);
        int ageOfThePerson = age.get("Kavitha");
        System.out.println(ageOfThePerson);
        System.out.println(System.getProperty("Gopal"));



    }
}
