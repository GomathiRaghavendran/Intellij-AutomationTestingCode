package codeFromGomathi.customDataType.BasicLevel.Exercise.Level2.Example2;

public class Runner {
    public static void main(String[] args) {

        typesOfCar tc = new typesOfCar();
        Calculation cl= new Calculation();
        Delays ds=new Delays();
       //Three-Tesla
        tc.teslaCardetails(60,2400);
        cl.gear("three", "Tesla");
        cl.time();
        ds.traffic(true);
        //four-Tesla
        tc.teslaCardetails(100,200);
        cl.gear("six", "Tesla");
        cl.time();
        ds.traffic(true);
        // four-BMW
        tc.bmwCardetails(50,3000);
        cl.gear("four", "BMW");
        cl.time();
        ds.traffic(true);
        //five-BMW
        tc.bmwCardetails(120,4800);
        cl.gear("five", "BMW");
        cl.time();
        ds.traffic(true);

        //Audi-five
        tc.audiCardetails(120,2400);
        cl.gear("five","Audi");
        cl.time();
        ds.traffic(true);
        //Audi-four
        tc.audiCardetails(90,3600);
        cl.gear("four","audi");
        cl.time();
        ds.traffic(true);
    }
}
