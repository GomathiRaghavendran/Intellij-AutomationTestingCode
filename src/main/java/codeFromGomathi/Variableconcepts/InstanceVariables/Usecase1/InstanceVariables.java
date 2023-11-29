package codeFromGomathi.Variableconcepts.InstanceVariables.Usecase1;

public class InstanceVariables {

        String studentName ="Akash";
        int TotalMarks;
        char grades ='A';
        static String presentClass="1styear";
        public void gradeA(){
            System.out.println("Name of the student:"+ studentName);
            System.out.println("Total marks obtained:"+TotalMarks);
            System.out.println("grade of the year:"+grades);
            System.out.println("Year of standard:"+presentClass);
        }
        public String gradeB(){
            System.out.println("Name of the student:"+ studentName);
            System.out.println("Total marks obtained:"+TotalMarks);
            System.out.println("grade of the year:"+grades);
            System.out.println("Year of standard:"+presentClass);
            return studentName;
        }
        public void gradeC(){
            System.out.println("Name of the student:"+ studentName);
            System.out.println("Total marks obtained:"+TotalMarks);
            System.out.println("grade of the year:"+grades);
            System.out.println("Year of standard:"+presentClass);
        }

    }


