package codeFromGomathi.customDataType.BasicLevel.Exercise.Level2.Example1;

public class TrafficJam {
    void Traffic()
    {
        if(Metadata.isTraffic==true)
        {
            Metadata.travelTime=Metadata.travelTime+30;
        }
        System.out.println("Travel time to Bruge by bus "+ Metadata.travelTime +" Minutes");
    }
void delayed()
{
    if(Metadata.isDelayed==true)
    {
        Metadata.travelTime=Metadata.travelTime+15;
    }
    System.out.println("Travel time to Bruge by train "+ Metadata.travelTime +" Minutes");
}
}
