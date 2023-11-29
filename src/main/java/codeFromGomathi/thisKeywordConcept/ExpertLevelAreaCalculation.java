package codeFromGomathi.thisKeywordConcept;

import org.openqa.selenium.devtools.v85.cachestorage.model.Header;

public class ExpertLevelAreaCalculation {

    static double pi=3.14;
    double area;
    double d;
    double Total;

    ExpertLevelAreaCalculation(){
        this(1.5,1.5);//passing the value for two parameterized constructor here and invoking this() keyword in the current class constructor
        System.out.println("Default constructor");
    }

    ExpertLevelAreaCalculation(double a, double b){
        this(1.2,1.3,1.4); //passing the value for three parameterized constructor here
        double c;
        c=a*b; //Calculating radius here
        area=c*pi;//Calculating the area
      System.out.println("Area of circle"+area);

    }

    ExpertLevelAreaCalculation(double length,double width,double height){
        d=length*width*height;//Calculating volume
        System.out.println("Area of volume"+d);
    }

    void getTotal(){
        Total=area+d;
        System.out.println("Total area of circle+volume"+Total);
    }

    public static void main(String[] args) {
        ExpertLevelAreaCalculation elac= new ExpertLevelAreaCalculation();
        elac.getTotal();

    }
}
