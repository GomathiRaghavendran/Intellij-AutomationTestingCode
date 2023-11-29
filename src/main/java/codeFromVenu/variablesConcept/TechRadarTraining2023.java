package codeFromVenu.variablesConcept;

public class TechRadarTraining2023 {

    // Hello I'm from the update made by Venu
    int javaKnowledgeScale =3;
    int jenkinsKnowledgeScale =3;
    int testAutomationKnowledgeScale =3;

    static String nameOfTutor = "Syed";

    static String  meetingPlatform = "Teams";


    void basicTrainngKnowledge(){
        System.out.println("Java Knowledge scale"+javaKnowledgeScale);
        System.out.println("Jenkins Knowledge scale"+jenkinsKnowledgeScale);
        System.out.println("Test Automatic Knowledge scale"+testAutomationKnowledgeScale);
        System.out.println("Name of the Tutor: "+nameOfTutor);
        System.out.println("Meeting platform: "+meetingPlatform);
    }

    static void coreTrainingInformation(){
        TechRadarTraining2023  trt2023 = new TechRadarTraining2023();
        System.out.println("Java Knowledge scale"+trt2023.javaKnowledgeScale);
        System.out.println("Jenkins Knowledge scale"+trt2023.jenkinsKnowledgeScale);
        System.out.println("Test Automatic Knowledge scale"+trt2023.testAutomationKnowledgeScale);
        System.out.println("Name of the Tutor: "+nameOfTutor);
        System.out.println("Meeting platform: "+meetingPlatform);


    }



}
