import java.util.*;

public class Plant {
  String type;
  String pSize;
  float price;
  int number;
  public Plant(){

  }
  public Plant(String type, float price,String size, int num){
      this.type=type;
      this.price=price;
      this.pSize=size;
      this.number=num;
  }
  public String toString(){
    return "\nPlant type: "+type+"\n"+
            "Plant size: "+pSize+"\n"+
            "Price: "+price+"\n"+
            "Number in stock: "+number;
  }
}
// class PlantList{
//     ArrayList<Plant> plants = new ArrayList<Plant>();
//     void addPlant(){
        
//     }
//     void listPlant(){

//     }
//     void updateList(){

//     }

// }
class shopping{

    
    public static void main(String[] args) {
        ArrayList<Plant> plants = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        plants.add(new Plant("rose",2,"Small",10));
        plants.add(new Plant("rose",5,"Mediem",10));
        plants.add(new Plant("rose",10,"Large",10));

        plants.add(new Plant("orange",20,"Medium",5));
        plants.add(new Plant("orange",10,"Small",5));
        plants.add(new Plant("orange",40,"Large",5));

        plants.add(new Plant("banana",5,"small",6));
        plants.add(new Plant("banana",10,"Medium",6));
        plants.add(new Plant("banana",50,"Large",2));

        plants.add(new Plant("apple", 30, "small", 4));
        plants.add(new Plant("apple",100,"Medium",8));
        plants.add(new Plant("apple",150,"Large",8));

        plants.add(new Plant("sunflower",15,"Medium",9));

        System.out.println("\tPlant List");
        
        for(int i=0;i<plants.size();i++){
            System.out.println(plants.get(i).toString());
        }

        System.out.print("Choose type you want: ");
        String type= sc.nextLine();
        System.out.println("Choose size: ");
        String size = sc.nextLine();
        System.out.print("Enter amount you want: ");
        int amount = sc.nextInt();

        float beforeDis;
        for(int i=0;i<plants.size();i++){
            if(plants.get(i).type.equals(type) && plants.get(i).pSize.equals(size)){
                plants.get(i).number-=amount;
                 beforeDis = plants.get(i).price*amount;
                break;
            }
        };

        // if(beforeDis>5 && beforeDis<100){

        // }

    
        


    }

}
