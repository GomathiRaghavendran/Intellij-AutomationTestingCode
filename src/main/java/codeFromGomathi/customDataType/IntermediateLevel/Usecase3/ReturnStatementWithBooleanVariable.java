package codeFromGomathi.customDataType.IntermediateLevel.Usecase3;

public class ReturnStatementWithBooleanVariable {

    boolean myCountryIsIndia(String myCountry){
            boolean d;
            if (myCountry == "India" || myCountry == "France" || myCountry == "malta" ) {
                d = true;
                System.out.println("My country is:" + myCountry);

            }
            else {
                d = false;
                System.out.println("My Country is:"+ myCountry);

            }return d;
    }

    /** int myCountryIsIndia(String myCountry) {
     int d;
     if (myCountry == "India" || myCountry == "France" || myCountry == "malta")
     {
     d=1;
     System.out.println("My country is:"+myCountry);
     }
     else
     {
     d=0;
     System.out.println("I am from Belgium");
     }
     return d;

     }*/
    public static void main(String[] args) {
        ReturnStatementWithBooleanVariable RSWBD=new ReturnStatementWithBooleanVariable();
       // boolean e=RSWBD.myCountryIsIndia("USA");
        //System.out.println("returnTypeValue:"+ e);
        System.out.println(RSWBD.myCountryIsIndia("USA"));

    }
}


