
//S24_실습 ①
/*class Animal{
    String name="동물";

}

class Cat extends Animal{
    String name="고양이";
    public void printNames() {
        System.out.println(this.name);
        System.out.println(super.name);
    }
}

public class Three {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.printNames();
    }
}*/

//S24_실습 ②
/*
class Member{
    String name;
    Member(String name){
        this.name=name;
        System.out.println("이름: "+name);
    }
}

class Student1 extends Member{
    String school;
    Student1(String name, String school){
        super(name); //super.name=name; 이거 안되네 왜지? 원래 안되는건가?ㅋㅋㅋ
        this.school=school;
        System.out.println("학교: "+school);
    }
}

public class Three {
    public static void main(String[] args) {
        //Student1 stu = new Student1();
        new Student1("홍길동","코스모고등학교");
    }
}*/

//S24_실습 ③
/*  >>내가 한거<<
class Book{
    String title="누가 내 머리에 똥 쌌어?";
    String author="베르너 홀츠바르트";

    public String toString(){
        return "제목 : "+this.title+", 저자 : "+this.author;
    }
}


public class Three {
    public static void main(String[] args) {
        Book book=new Book();
        System.out.println(book);
    }
}
*/

//>>지피티 보충사항<<
/*
class Book{
    private final String title;
    private final String author;

    Book(String title, String author){
        this.title=title;
        this.author=author;
    }
    @Override
    public String toString(){
        return "제목 : "+this.title+", 저자 : "+this.author;
    }
}

class 슈퍼{
    int a;

    슈퍼(int a){
    this.a=a;
}
}

public class Three {
    public static void main(String[] args) {
        Book book=new Book("누가 내 머리에 똥 쌌어?","베르너 홀츠바르트");
        System.out.println(book);
    }
}*/


//S24_실습 ④
class User{
    String id;

    User(String id){
        this.id=id;

    }
}


public class Three {
    public static void main(String[] args) {
    User user1=new User(null);
    User user2=new User(null);

    user1.id="Hi";
    user2.id="Hi";

        System.out.println(user1.equals(user2));
        System.out.println(user1.id.equals(user2.id));



    }
}