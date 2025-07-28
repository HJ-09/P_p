import java.util.Arrays;

class Student{
    String name;
    int id;
    int grade;

    public Student(String name, int id, int grade){
        this.name=name;
        this.id=id;
        this.grade=grade;
    }
    void printInfo(){
        System.out.println("이름 :"+name+","+"id :"+id+"학번 :"+grade);
    }
}

/*public class Main {
    public static void main(String[] args) {

        Student s = new Student("홍길동", 10101, 3);

        Student student1=new Student("김철수",2105478,3);
       String name1="김철수";
        int id1=2105478;
        int grade1=3;

        String name2="나수미";
        int id2=2304862;
        int grade2=2;

        student1.printInfo();
*/








/*class Rec{
    int width;
    int height;

    public Rec(int width, int height){
        this.width=width;
        this.height=height;

    }
        int getArea(){
            return width*height;
        }
        int gerPerimeter(){
            return 2*(width+height);
        }


}*/

class C{
   int a,b,c,d;
   C(){
       this(5);
   }
   C(int k){
       a=k;
       b=k;
       c=k;
       d=k;
   }
}

public class Main {

    public static void main(String[] args) {

    C z=new C();

        System.out.println(z.a);
        System.out.println(z.b);
        System.out.println(z.c);
        System.out.println(z.d);



    /*Rec rec=new Rec(5,8);*/


        /*rec.getArea();
        System.out.println(rec.getArea());
        System.out.println(rec.gerPerimeter());*/



        System.out.println();

        int[][]a=new int[2][3];
        System.out.println(a.length);
        System.out.println(a[0].length);

        //String str="안녕하세요";

        //byte[] array=str.getBytes();
        //System.out.println(Arrays.toString(array));


        String str="내 이름은 [홍길동]입니다. 나이는 [15]살 입니다";
        String name;
        int age;

        int start1=str.indexOf("[");
        int end1=str.indexOf("]");
        name=str.substring(start1+1,end1);

        int start2=str.lastIndexOf("[");
        int end2=str.lastIndexOf("]");
        age=Integer.parseInt(str.substring(start2+1,end2));

        System.out.println(name);
        System.out.println(age);



    }
}
