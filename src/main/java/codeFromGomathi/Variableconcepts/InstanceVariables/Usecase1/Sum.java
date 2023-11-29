package codeFromGomathi.Variableconcepts.InstanceVariables.Usecase1;

import codeFromGomathi.Variableconcepts.StaticVariables.Usecase2.StaticVariables;

public class Sum {
    static int a =100;
    static int b=10;

    public static void add(){
        int c=a+b;
        System.out.println(c);
    }
    public void mul(){
        int c=a*b;
        Sum.add();
        System.out.println(c);
    }

    public static void main(String[] args) {
    Sum.add();
    Sum s= new Sum();
    s.mul();
    }
}
