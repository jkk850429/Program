/*
* File Name: Car.java
* ID:103213025
* Author:李柏均
* Since:2015/4/9
* Toolkit:Notepad++
*/
import java.util.Scanner;
public class Car {  
    String id;   //宣告變數.字串
    int x;
    int y;
    public Car(String id,int x,int y) {  // a constructure car
        this.id = id;
        this.x = x;
        this.y = y;
    }
    public void east(int offset) {   //函數使車子向東
        x += offset;
    }
    public void west(int offset) {   //函數使車子向西
        x -= offset;
    }
    public void north(int offset) {  //函數使車子向北
        y += offset;
    }
    public void south(int offset) {  //函數使車子向南
        y -= offset;
    }
    public void print() {    //印出車的品牌以及其坐標
        System.out.println(id + " " + x + " " + y);
    }
    public static void main(String[] argv) {
        Car[] allCars = new Car[1000]; //宣告陣列allCars[]
        int numCar=0;     //先給定車子的數量一開始為0
        Scanner input = new Scanner(System.in);
        while (true) {
            String command = input.next(); 
            if(command.equals("new")) {  //若輸入字串為new 則新增一台車 並輸入其品牌和座標
                allCars[numCar++] = new Car(input.next(),input.nextInt(),input.nextInt());
            }else if(command.equals("end")) {  //若輸入字串end 則程式終止
                break;
            }else{  //其他情形則(若輸入車的品牌)
                String id = input.next();
                int i;
                for(i = 0;i < numCar;i++) {  //以迴圈判斷車的名稱和其座標
                    if(allCars[i].id.equals(id))
                        break;
                }
                if(command.equals("east")) {    //若輸入字串east則車子向東
                    allCars[i].east(input.nextInt());
                }else if(command.equals("west")) {    //若輸入west則車子向西
                    allCars[i].west(input.nextInt());
                }else if(command.equals("north")) {    //若輸入north則車子向北
                    allCars[i].north(input.nextInt());
                }else if(command.equals("south")) {    //若輸入south則車子向南
                    allCars[i].south(input.nextInt());
                }else if(command.equals("destroy")) {   //若輸入destroy則清空陣列allCars
                    allCars[i]=null;
                }
            }
        }
        for(int i = 0;i < numCar;i++) {
            if(allCars[i] != null) {
                //印出所有車子名稱與座標
                allCars[i].print();
            }
        }
        for(int i = 0;i < numCar;i++) {  //設定迴圈計算每台車跑的距離
            for(int j = i + 1;j < numCar;j++) {
                if(allCars[i] != null && allCars[j] != null) {  //陣列不是空的才執行
                    double distance;
                    //兩車間距離的公式
                    distance=Math.sqrt((double)(Math.pow(allCars[i].x - allCars[j].x,2))+(double)(Math.pow(allCars[i].y - allCars[j].y,2)));
                    System.out.println(allCars[i].id + " to " + allCars[j].id + " " + distance);
                }
            }
        }
    }
}