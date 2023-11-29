package codeFromVenu.loopConditions.forLoop.intermediate;

public class TeamInformation {


    String teamNames[] = {"For Int","Rubel","Franc Queen","Mexican Peso","Ringgit Roses"};
    String  forIntTeam[] = {"Kiruthika","Madhu","Dona","Padma","Savitha","Elizabeth"};
    String  rubelTeam[] ={"Anusha","Fatema","Manisha","Santhi","Sapna","Priya","Gomathi"};
    String francTeam[] ={"Kavitha","Vandhana","Thenmozhi","Bhargavi","Sia","Pavithra","Menaka"};
    String ringgItTeam[] ={"Bhavita","Devika","Priyanka S","Aruna","Nandana","Sneha","Haritha"};
    String mexicanPesoTeam[] = {"Madhavi","Divya","Garima","Ankita","Shilpa","Elipse"};

    String  teamName;

    String getNameOfTheTeam(String  name){

        for(int iamNotI = 0; iamNotI<francTeam.length;iamNotI++){
            if(name == francTeam[iamNotI]) {
                teamName = teamNames[2];
                break;
            }

        }
        for(int iamNotI = 0; iamNotI<ringgItTeam.length;iamNotI++){
            if(name == ringgItTeam[iamNotI]) {
                teamName = teamNames[4];
                break;
            }

        }

        for(int iamNotI = 0; iamNotI<rubelTeam.length;iamNotI++){
            if(name == rubelTeam[iamNotI]) {
                teamName = teamNames[1];
                break;
            }
        }

        for(int iamNotI = 0; iamNotI<mexicanPesoTeam.length;iamNotI++){
            if(name == mexicanPesoTeam[iamNotI]) {
                teamName = teamNames[3];
                break;
            }
        }

        for(int iamNotI = 0; iamNotI<forIntTeam.length;iamNotI++){
            if(name == forIntTeam[iamNotI]) {
                teamName = teamNames[0];
                break;
            }
        }


        return teamName;
    }















}
