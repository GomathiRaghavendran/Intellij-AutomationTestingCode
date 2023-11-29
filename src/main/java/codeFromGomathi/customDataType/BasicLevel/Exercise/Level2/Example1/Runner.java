package codeFromGomathi.customDataType.BasicLevel.Exercise.Level2.Example1;

public class Runner {
    public static void main(String[] args) {
        ModeOfTransport mot=new ModeOfTransport();
        /*TravellingTime tt=new TravellingTime();
        //Calculating traveltime by bus
       mot.usingBus("Brussels","Bruge","Bus",20);
           tt.calculatingJourneyTime();
           tt.detailsOfJourney().Traffic(true);
      //Calculating traveltime by train
        mot.usingTrain("Brussels","Bruge","Train",30);
        tt.calculatingJourneyTime();;
        tt.detailsOfJourney().delayed(true);
        //Calculating traveltime by car
        mot.usingTrain("Brussels","Bruge","Car",50);
        tt.calculatingJourneyTime();
        tt.detailsOfJourney();  */
        /**One line code- positive scenario
        mot.usingBus("Brussels","Bruge","Bus",20).detailsOfJourney(true,false).Traffic();
        mot.usingTrain("Brussels","Bruge","Train",30).detailsOfJourney(false,true).delayed();
        mot.usingCar("Brussels","Bruge","Car",50).detailsOfJourney(false,false);
        //One line code- negative scenario1
        mot.usingBus("Brussels","Bruge","Bus",20).detailsOfJourney(false,true).Traffic();
        mot.usingTrain("Brussels","Bruge","Train",30).detailsOfJourney(true,false).delayed();
        mot.usingCar("Brussels","Bruge","Car",50).detailsOfJourney(true,true);     **/
        //One line code-negative scenario2
        mot.usingBus("Brussels","Bruge","Bus",10).detailsOfJourney(true,false).Traffic();
        mot.usingTrain("Brussels","bruge","Train",30).detailsOfJourney(false,true).delayed();
        mot.usingCar("Brussels","Bruge","car",50).detailsOfJourney(false,false);
    }
}
