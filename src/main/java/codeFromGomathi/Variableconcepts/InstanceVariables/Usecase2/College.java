package codeFromGomathi.Variableconcepts.InstanceVariables.Usecase2;

public class College {
    String Studentname="Abbas";
    int roll_no=100;
    static String department="EEE";
    static String collegename="CIT";

    static void studentdetails(){
        College C=new College();
        C.Studentname="Arjun";
        C.roll_no=101;
        department="ECE";
        collegename="MIT";
        System.out.println("Name of the student:"+C.Studentname);
        System.out.println("Rollno:"+C.roll_no);
        System.out.println("Name of the Department:"+department);
        System.out.println("Name of the college:"+collegename);
    }
    void basicdetails(){
        System.out.println("Name of the student:"+Studentname);
        System.out.println("Rollno:"+roll_no);
        System.out.println("Name of the Department:"+department);
        System.out.println("Name of the college:"+collegename);
    }

    public static void main(String[] args) {
        studentdetails();
    College C1=new College();
    C1.basicdetails();

}
}