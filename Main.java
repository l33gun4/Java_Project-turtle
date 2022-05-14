import java.util.Random;
import java.util.Scanner;

class User{
    String name;
    String car_number;
    int who; //true면 학교 관련인 | false면 외부인
    User(String name, String car_number, int who){
        this.name = name;
        this.car_number = car_number;
        this.who = who;
    }
}

class Student extends User{
    int number;
    String major;
    Student(String name, String car_number, int number, String major, int who){
        super(name, car_number, who);
        this.number = number;
        this.major = major;
    }
}

class Professor extends User{
    int number;
    String major;
    Professor(String name, String car_number, int number, String major, int who){
        super(name, car_number, who);
        this.number = number;
        this.major = major;
    }
}

class Visitor extends User{
    String date;
    Visitor(String name, String car_number, String date, int who){
        super(name, car_number, who);
        this.date = date;
    }
}

class Calc{
    int discount;
    int fee;

    int calcFee(int time){
        if(time>10){
            return this.fee=10000;
        }
        return this.fee=1000*time;
    }

    int calcDiscount(int who){
        if(who==0) {
            return this.discount=this.fee-1000;
        }
        else if(who==1){
            return this.discount=this.fee/2;
        }
        return this.discount=0;
    }

    boolean calcParkingFee(int input){
        if(this.fee==input){
            return true;
        }
        return false;
    }

    void printFee(String car_number){
        System.out.println("차 번호 "+car_number+"의 정산할 금액은 "+(this.fee-this.discount)+"입니다.");
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        Calc calc = new Calc();
        String name, car_number;
        int who, time;

        time = (int)Math.random()*10+1;

        System.out.println("이름, 차번호, 소속을 입력해주세요");
        name = s.next();
        car_number = s.next();
        who = s.nextInt();

        if(who==0){
            System.out.println("학번과 전공을 입력해주세요.");
            Student student = new Student(name, car_number, s.nextInt(), s.next(), who);
        }
        else if(who==1){
            System.out.println("학번과 담당전공을 입력해주세요.");
            Professor professor = new Professor(name, car_number, s.nextInt(), s.next(), who);
        }
        else{
            System.out.println("방문 날짜를 입력해주세요.");
            Visitor visitor = new Visitor(name, car_number, s.next(), who);
        }

        calc.calcFee(time);
        calc.calcDiscount(who);
        calc.printFee(car_number);
        System.out.println("정산할 요금을 입력해주세요.");
        if(calc.calcParkingFee(s.nextInt())==true){
            System.out.println("정산되었습니다.");
        }
    }
}

