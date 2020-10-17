package Action_Item;

public class Assignment_2 {
    public static void main(String[] args) {
        String[] city = new String[4];
        city[0] = "brooklyn";
        city[1] = "manhattan";
        city[2] = "queens";
        city[3] = "Staten Island";

        for (int i = 0; i < city.length; i++){
          if (city[i] == "brooklyn"){
              System.out.println("my city is " + city[0]);
          }if (city[i] == "manhattan"){
              System.out.println("my city is " + city[1]);
            }//end of if
        }// end of for
    }//end of main method
}//end of java method
