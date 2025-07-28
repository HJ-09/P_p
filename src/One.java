class Stue{
    int 학번;
    String 이름;
    int 번호;

    public Stue(int 학번, String 이름, int 번호){
        this.학번=학번;
        this.이름=이름;
        this.번호=번호;

        //System.out.println(this.toString());
        //System.out.println("학번/이름/번호 :"+this.학번+this.이름+this.번호); //이거는 toString 배우기 전에 쓴거라서 기억에서 지워도 돼
    }

    @Override
    public String toString() {
        return "학번/이름/번호 :"+this.학번+","+this.이름+","+this.번호;
    }
}


public class One {
    public static void main(String[] args) {
        Stue stue = new Stue(4578913, "김홀스", 13);
        System.out.println(stue); //toString() 재지정하고서 객체명 적으면 출력완료
    }
}