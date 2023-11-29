package codeFromGomathi.customDataType.BasicLevel.Exercise.Level2.Example2;

public class Calculation {

    Delays gear(String gear, String moc){
        VariableDeclartion.gear=gear;
        VariableDeclartion.modelOfCar=moc;
        time();
        return new Delays();
    }
    void time(){
        int speed=VariableDeclartion.speed;
        int distance= VariableDeclartion.distance;
        String gear= VariableDeclartion.gear;
        String moc=VariableDeclartion.modelOfCar;

        if(moc == "Tesla" && gear=="six"){
            VariableDeclartion.time=distance/speed;
        }
        if(moc == "Tesla" && gear=="three"){
            VariableDeclartion.time=distance/speed;
        }
        if(moc == "BMW" && gear=="four"){
            VariableDeclartion.time=distance/speed;
        }
        if(moc == "BMW" && gear=="five"){
            VariableDeclartion.time=distance/speed;
        }
        if(moc =="audi" && gear=="five"){
            VariableDeclartion.time=distance/speed;

        }
        if(moc == "audi" && gear=="four"){
            VariableDeclartion.time=distance/speed;

        }
    }
}
