package codeFromVenu.thisKeywordConcept;

public class ExpertLevelSomeExpressConcept {

/*
    ExpertLevelSomeExpressConcept(){
        System.out.println("Please!!! check your receipt properly before you leave the shop");
    }


    ExpertLevelSomeExpressConcept(int priceOfFirstItem, int priceOfSecondItem){
        this();
        int sum;
        sum = priceOfFirstItem + priceOfSecondItem;
        System.out.println("Here is your final bill: "+sum);

    }

 */

    // static int  hiddenServiceCharge = 20;
    int  finalbill;

    ExpertLevelSomeExpressConcept(){
        this(20);

        //System.out.println("Please!!! check your receipt properly before you leave the shop");
    }


    ExpertLevelSomeExpressConcept(int priceOfFirstItem, int priceOfSecondItem){
        this();
        int sum;
        sum = priceOfFirstItem + priceOfSecondItem;
        finalbill = finalbill + sum;
    }


    ExpertLevelSomeExpressConcept(int extraAmount){
        finalbill = finalbill + extraAmount;
    }


    void  getFinalBill(){
        System.out.println("Here is your final bill "+finalbill );
    }




    void method1(){
        System.out.println("Hello, I'm from method 1");
    }









}
