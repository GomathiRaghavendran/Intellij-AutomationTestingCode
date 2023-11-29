package codeFromGomathi.collectionsFramework;

import java.util.HashMap;

public class HashMapConcept {


    public static void main(String[] args) {

        HashMap<String,Integer> age = new HashMap<String,Integer>();
        age.put("Grandma",99);
        age.put("Grandpa",106);
        int age1 = age.get("Grandpa");
        System.out.println(age1);

        HashMap<Integer,String> run= new HashMap<>();
        run.put(125,"MSD");
        run.put(100,"Jaddu");
        String CrickterName=run.get(125);
        System.out.println(CrickterName);
    }
}
