/*
* File Name: Car.java
* ID:103213025
* Author:���f��
* Since:2015/4/9
* Toolkit:Notepad++
*/
import java.util.Scanner;
public class Car {  
    String id;   //�ŧi�ܼ�.�r��
    int x;
    int y;
    public Car(String id,int x,int y) {  // a constructure car
        this.id = id;
        this.x = x;
        this.y = y;
    }
    public void east(int offset) {   //��ƨϨ��l�V�F
        x += offset;
    }
    public void west(int offset) {   //��ƨϨ��l�V��
        x -= offset;
    }
    public void north(int offset) {  //��ƨϨ��l�V�_
        y += offset;
    }
    public void south(int offset) {  //��ƨϨ��l�V�n
        y -= offset;
    }
    public void print() {    //�L�X�����~�P�H�Ψ䧤��
        System.out.println(id + " " + x + " " + y);
    }
    public static void main(String[] argv) {
        Car[] allCars = new Car[1000]; //�ŧi�}�CallCars[]
        int numCar=0;     //�����w���l���ƶq�@�}�l��0
        Scanner input = new Scanner(System.in);
        while (true) {
            String command = input.next(); 
            if(command.equals("new")) {  //�Y��J�r�ꬰnew �h�s�W�@�x�� �ÿ�J��~�P�M�y��
                allCars[numCar++] = new Car(input.next(),input.nextInt(),input.nextInt());
            }else if(command.equals("end")) {  //�Y��J�r��end �h�{���פ�
                break;
            }else{  //��L���Ϋh(�Y��J�����~�P)
                String id = input.next();
                int i;
                for(i = 0;i < numCar;i++) {  //�H�j��P�_�����W�٩M��y��
                    if(allCars[i].id.equals(id))
                        break;
                }
                if(command.equals("east")) {    //�Y��J�r��east�h���l�V�F
                    allCars[i].east(input.nextInt());
                }else if(command.equals("west")) {    //�Y��Jwest�h���l�V��
                    allCars[i].west(input.nextInt());
                }else if(command.equals("north")) {    //�Y��Jnorth�h���l�V�_
                    allCars[i].north(input.nextInt());
                }else if(command.equals("south")) {    //�Y��Jsouth�h���l�V�n
                    allCars[i].south(input.nextInt());
                }else if(command.equals("destroy")) {   //�Y��Jdestroy�h�M�Ű}�CallCars
                    allCars[i]=null;
                }
            }
        }
        for(int i = 0;i < numCar;i++) {
            if(allCars[i] != null) {
                //�L�X�Ҧ����l�W�ٻP�y��
                allCars[i].print();
            }
        }
        for(int i = 0;i < numCar;i++) {  //�]�w�j��p��C�x���]���Z��
            for(int j = i + 1;j < numCar;j++) {
                if(allCars[i] != null && allCars[j] != null) {  //�}�C���O�Ū��~����
                    double distance;
                    //�⨮���Z��������
                    distance=Math.sqrt((double)(Math.pow(allCars[i].x - allCars[j].x,2))+(double)(Math.pow(allCars[i].y - allCars[j].y,2)));
                    System.out.println(allCars[i].id + " to " + allCars[j].id + " " + distance);
                }
            }
        }
    }
}