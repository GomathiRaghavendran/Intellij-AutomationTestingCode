package codeFromVenu.thisKeywordConcept;

public class IntermediateLevelConstructorConcept {

    void method1(){
        System.out.println("Hello, I'm from method 1");

    }

    void method2(){
        this.method1();
        System.out.println("Hello, I'm from method 2");
    }
}
