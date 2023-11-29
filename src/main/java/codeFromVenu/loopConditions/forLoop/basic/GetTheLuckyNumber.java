package codeFromVenu.loopConditions.forLoop.basic;

public class GetTheLuckyNumber {


    private int  krithikaLuckyNumber = 11;
    private int  elipseLuckyNumber = 23;

    private int  shilpaPatilLuckyNumber = 21;

    private int  fatemaLuckyNumber = 9;


    void  giveMeTheNamePlease(String name){

        for (int i =0;i<=100;i++){
            if(i == krithikaLuckyNumber && (name == "Krithika" || name == "krithika")){
                System.out.println("Hey!!!! It's "+i+ " Krithika's lucky number");
                break;
            }

            if(i == elipseLuckyNumber && name == "Elipse"){
                System.out.println("Hey!!!! It's "+i+ " Elipse's lucky number");
                break;
            }



            if(i == shilpaPatilLuckyNumber && name == "Shilpa"){
                System.out.println("Hey!!!! It's "+i+ " Shilpa's lucky number");
                break;
            }

            if(i == fatemaLuckyNumber && name == "Fatema"){
                System.out.println("Hey!!!! It's "+i+ " Fatema's lucky number");
                break;
            }



        }

    }

    public static void main(String[] args) {
        GetTheLuckyNumber  gl = new GetTheLuckyNumber();
        gl.giveMeTheNamePlease("Krithika");
    }



}
