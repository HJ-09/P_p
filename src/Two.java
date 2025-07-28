class Students{
    String name;
    int id;
    float grade; //성적

    Students(String name, int id, float grade){
        this.name=name;
        this.id=id;
        this.grade=grade;
        System.out.println("학번"+" "+id+","+" "+name+"님의 성적은"+" "+grade+" "+"입니다.");
    }
}


class Rec{
    int width;
    int height;

    Rec(int width, int height){
        this.width=width;
        this.height=height;
        }
        int getArea(){
            return width*height;
    }
        int getPerimeter(){
            return 2*(width+height);
    }
}

class A{
    A(int x){}
}
class B extends A{
    B(int x){
      super(x);
        System.out.println(x);
    }
}

public class Two {
    public static void main(String[] args) {
    Students students1=new Students("김철수",1820547,4.0f);
    Students students2=new Students("김지희",1926578,3.8f);
    Students students3=new Students("나명수",2024693,3.5f);

    Rec rec=new Rec(5,9);
    System.out.println(rec.getArea());
    System.out.println(rec.getPerimeter());

    new B(5);


    }
}
