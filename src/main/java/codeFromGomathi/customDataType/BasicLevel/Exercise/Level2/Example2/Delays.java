package codeFromGomathi.customDataType.BasicLevel.Exercise.Level2.Example2;

public class Delays {
    void traffic(boolean isTraffic){
        VariableDeclartion.isTraffic= isTraffic;
        if(isTraffic){
            VariableDeclartion.time=VariableDeclartion.time*30;
        }
        System.out.println("time ="+ VariableDeclartion.time +"minutes");
        VariableDeclartion.time=0;

    }
}
