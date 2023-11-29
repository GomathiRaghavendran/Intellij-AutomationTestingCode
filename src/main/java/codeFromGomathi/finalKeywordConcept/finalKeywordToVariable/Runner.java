package codeFromGomathi.finalKeywordConcept.finalKeywordToVariable;


public class Runner {

    public static void main(String[] args) {
       Television Tv = new Television();

    //    Tv.nameOfTheProgram = "This value will not be updated,because its declared as Static ";

    // above update  is not accepted as that variable is declared as final
        Tv.SunMusicProgram();

    }
}
