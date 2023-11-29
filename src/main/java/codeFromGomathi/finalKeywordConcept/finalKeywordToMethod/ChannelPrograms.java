package codeFromGomathi.finalKeywordConcept.finalKeywordToMethod;

public class ChannelPrograms extends Television  {

//If we apply Final keyword in-front of the method then the method can't be overridden and will not get suggestion while invoking methods from parent class


    @Override
    void SunMusicProgram() {
        super.SunMusicProgram();
    }

    @Override
    void sunNewsProgram() {
        super.sunNewsProgram();
    }

   void sunTVProgram(){

   }
}
