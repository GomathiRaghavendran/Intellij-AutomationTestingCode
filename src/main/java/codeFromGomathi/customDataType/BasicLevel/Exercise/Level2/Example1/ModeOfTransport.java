package codeFromGomathi.customDataType.BasicLevel.Exercise.Level2.Example1;



public class ModeOfTransport {
    TravellingTime usingBus(String src, String dt, String vh, int tc)
    {
        Metadata.source=src;
        Metadata.destination=dt;
        Metadata.vehicles=vh;
        Metadata.ticketCost=tc;
        return new TravellingTime();
    }
TravellingTime usingTrain(String src, String dt,String vh,int tc)
{
    Metadata.source=src;
    Metadata.destination=dt;
    Metadata.vehicles=vh;
    Metadata.ticketCost=tc;
    return new TravellingTime();
}
TravellingTime usingCar(String src, String dt,String vh,int tc)

{
    Metadata.source=src;
    Metadata.destination=dt;
    Metadata.vehicles=vh;
    Metadata.ticketCost=tc;
    return new TravellingTime();
}

}



