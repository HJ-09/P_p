package myselfGpt;

import javax.swing.*;
import java.awt.*;

class Count extends JFrame{
    private int num;
    private JLabel la;
    private JButton btn1, btn10, btn100, btn0;
    //└─ private. 캡슐화 원칙에 따라 외부에서의 접근 막기

    public Count(){
        super("카운터 앱");
        //JFrame super=new JFrame("카운터 앱")
        //Count this=new Count()
        //└─ this.setTitle("카운터 앱"); 써도 됌.

        this.setLayout(new BorderLayout());
        //JFrame 상속해서 레이아웃 매니저 설정 기본값이 BorderLayout으로 되어있긴 하지만, 명시적으로 써주는게 좋음.

        la=new JLabel(this.num+"", SwingConstants.CENTER);
        la.setFont(new Font("나눔고딕",Font.BOLD,25));

        this.btn1=new JButton("+1");
        this.btn10=new JButton("+10");
        this.btn100=new JButton("+100");
        this.btn0=new JButton("리셋");
        //└─ 내꺼를 설정할거니까 super안되고 this만 됨.

        // 람다식으로 표현 ↓
        btn1.addActionListener(e -> {
            num+=1;
            la.setText(num+"");
        });
        btn10.addActionListener(e ->{
            num+=10;
            la.setText(num+"");
        });
        btn100.addActionListener(e -> {
            num+=100;
            la.setText(num+"");
        });
        btn0.addActionListener(e -> {
            num=0;
            la.setText(num+"");
        });


        //JPanel의 기본 Layout은 FlowLayout임. 그래서 따로 setLayout(new FlowLayout()) 안 하고 new JPanel()만 해도 자동으로 FlowLayout 방식으로 배치가 됨.
        JPanel pan=new JPanel();
        pan.add(btn1);
        pan.add(btn10);
        pan.add(btn100);

        JPanel pan2=new JPanel();
        pan2.add(btn0);

        //super.add(this.la); ─┐
        super.add(la, BorderLayout.CENTER);
        this.add(pan, BorderLayout.NORTH);
        this.add(pan2, BorderLayout.SOUTH);
        //└─add 앞에 있는건 기존에 있는거에 더해주는 개념이라서 super 써도 되고, this 써도 됨!

        this.setBounds(2000,0,300,300);
        this.setVisible(true);
        //this.setDefaultCloseOperation(2); //↓ 상수 사용 권장
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        }
    }

public class S0102_gpt {//250717 수업 실습 S01Swing 2번 문제
    //카운터 앱

    public static void main(String[] args) {

        new Count();
    }
}
