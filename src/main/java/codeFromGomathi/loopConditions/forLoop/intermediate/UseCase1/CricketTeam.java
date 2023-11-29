package codeFromGomathi.loopConditions.forLoop.intermediate.UseCase1;

public class CricketTeam {


    String teamNames[] = {"CSK", "GT", "MI", "KKR", "DC"};
    String CSK[] = {"MS Dhoni", "Ruturaj Gaikwad", "Devon Conway", "Shivam Dube", "Ajinkya Rahane", "Ambati Rayudu", "Ravindra Jadeja", "Moeen Ali", "Deepak Chahar", "Tushar Deshpande", "Matheesh Pathirana"};
    String GT[] = {"Hardik Pandya", "Shubman Gill", "David Miller", "Abhinav Manohar", "Rahul Tewatia", "Rashid Khan", "Sai Sudharsan", "Darshan Nalkhande", "Dasun Shanaka", "Jayant yadhav", "Srikar Bharat"};
    String MI[] = {"Rohit Sharma", "Sandeep Warrier", "Suryakumar Yadav", "Ishan Kishan", "Dewald Brevis", "Tilak Varma", "Jofra Archer", "Tim David", "Mohd Arshad Khan", "Ramandeep Singh", "Hrithik Shokeen", "Arjun Tendulkar"};
    String KKR[] = {"Sheryas Iyer", "Nitish Rana", "Rahmanullah Gurbaz", "Andre Russel", "Sunil Narine", "Shardul Thakur", "Lockie Ferguson", "Umesh Yadhav", "Tim Southee", "Harshit rana", "Varun Chakravarthy", "Anukul Roy", "Rinku Singh"};

    String DC[] = {"Abishek Porel", "Aman Hakim Khan", "Axar Patel", "Kamlesh Nagarkoti", "Lalit Yadav", "Mitchell Marsh", "Praveen Dubey", "Priyam Garg", "Ripal Patel", "Sarfaraz Khan", "Vicky Ostwal", "Yash Dhull"};

    String teamName;

    String getTheNameOfTheTeam(String name) {
        for (int i = 0; i < CSK.length; i++) {
           // System.out.println("Total team members are:"+CSK.length);//To get the length of the array
            if (name == CSK[i]) {
                teamName = teamNames[0];
                break;
            }
        }
        for (int i = 0; i < GT.length; i++) {
            if (name == GT[i]) {
                teamName = teamNames[1];
                break;
            }
        }
        for (int i = 0; i < MI.length; i++) {
            if (name == MI[i]) {
                teamName = teamNames[2];
                break;
            }
        }
        for (int i = 0; i < KKR.length; i++) {
            if (name == KKR[i]) {
                teamName = teamNames[3];
                break;
            }
        }
        for (int i = 0; i < DC.length; i++) {
            if (name == DC[i]) {
                teamName = teamNames[4];
                break;
            }
        }
        return teamName;
    }
}
