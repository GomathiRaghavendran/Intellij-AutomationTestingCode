package codeFromGomathi.customDataType.BasicLevel.Exercise.Level2.Example1;

public class TravellingTime {
    TrafficJam detailsOfJourney(boolean istraff,boolean isdelayed) {
        Metadata.isTraffic=istraff;
        Metadata.isDelayed=isdelayed;
        calculatingJourneyTime();
        return new TrafficJam();
    }
       void calculatingJourneyTime()
    {

        String vh=Metadata.vehicles;
        String src=Metadata.source;
        String dt=Metadata.destination;
        int tc=Metadata.ticketCost;

        if(vh=="Bus" && src=="Brussels" && dt=="Bruge" && tc==20)
        {
            Metadata.travelTime=180;

        }
        if(vh=="Train" && src=="Brussels" && dt=="Bruge" && tc==30)
        {
            Metadata.travelTime=90;

        }
        if(vh=="Car" && src=="Brussels" && dt=="Bruge" && tc==50)

        {
            Metadata.travelTime=60;
            System.out.println("Travel time to Bruge by car is "+ Metadata.travelTime +" Minutes");
        }

    }

}
