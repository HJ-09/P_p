//S25_실습
class Person{
    String name;
    int age;
    String address; //사는곳
    int num; //전화번호
    int grade;

    void showInfo(){
        System.out.println("이름 : "+name);
        System.out.println("나이 : "+age);
        System.out.println("거주지 : "+address);
        System.out.println("전화번호 : "+num);
        System.out.println("학년 : "+grade);
    }
}

class Student2 extends Person{
    String name;
    int grade;
    String address;
}

class Teacher extends Person{
    String name;
    int age;
    String address;

    void teach(){
        System.out.println("수업 중입니다.");
    }
}



public class Four {
    public static void main(String[] args) {


        Person p1=new Student2();
        p1.name="혜지";
        p1.age=20;
        p1.address="서울 중랑구";

        Person p2=new Teacher();
        p2.name="강홍구";
        p2.age=57;
        p2.address="서울 도봉구";

        p1.showInfo();
        System.out.println();
        p2.showInfo();

        if(p2 instanceof Teacher){
            Teacher t=(Teacher)p2;
            t.teach();
        }




    }
}
