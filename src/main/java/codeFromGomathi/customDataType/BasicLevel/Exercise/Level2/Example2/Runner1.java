package codeFromGomathi.customDataType.BasicLevel.Exercise.Level2.Example2;

public class Runner1 {
    public static void main(String[] args) {
        typesOfCar tc = new typesOfCar();
        //Tesla-three
        tc.teslaCardetails(80,8000).gear("three", "Tesla").traffic(true);
        //Tesla-six
        tc.teslaCardetails(160,32000).gear("three", "Tesla").traffic(true);
    }
}
