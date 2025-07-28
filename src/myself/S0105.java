package myself;
/*
        5. 스탑워치 타이머 (Advanced)

        목표:
    •	시작, 정지 버튼으로 시간 측정
	•	javax.swing.Timer 사용
	•	시간 포맷 출력 (mm:ss)
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class S0105 extends JFrame {
        JButton btn, btn2, btn3, btn4; //시작, 멈춤, 리셋, 기록
        JLabel l;
        JPanel p=new JPanel();
        float n;

    public S0105(){
        super("스톱워치");

        l=new JLabel("준비!", SwingConstants.CENTER);
        l.setFont(new Font("",Font.BOLD,14));
        this.add(l, BorderLayout.CENTER);

        btn=new JButton("▶");
        btn2=new JButton("∥");
        btn3=new JButton("리셋");
        btn4=new JButton("랩");

        this.p.add(btn);
        this.p.add(btn2);
        this.p.add(btn4);
        this.p.add(btn3);
        this.add(p, BorderLayout.NORTH);

        JTextArea rec=new JTextArea();
        rec.setEditable(false); //false인 이유는, 직접 글 못 쓰게 하려고 설정.
        this.add(new JScrollPane(rec),BorderLayout.SOUTH);
        //└─ JTextArea를 스크롤 가능한 창으로 감싸서 윈도우 창에 붙이기.
        //⇒ 자바의 BorderLayout은 한 위치에 하나의 컴포넌트만 가능.
        rec.setRows(5); //기록창에 보여줄 줄이 몇 개일지
        //rec.setPreferredSize(new Dimension(250,100)); //⇒ 크기 제한. JPanel로 만드는게 좋음.
        //rec.setLineWrap(true); //⇒ 자동 줄바꿈

        ActionListener time=((e)->{
           n++;
           String Str=String.format("%.2f",n/100.0);
           l.setText(Str);
        });
        Timer timer=new Timer(10,time);
        btn.addActionListener((e)->{
            timer.start();
        });
        btn2.addActionListener((e)->{
            timer.stop();
        });
        btn3.addActionListener((e)->{
            n=0;
            timer.stop();
            l.setText("준비!");
            rec.setText(""); //기록창 청소~
        });
        btn4.addActionListener((e)->{
            String Rec=String.format("%.2f",n/100.0);
            rec.append(Rec+"\n");
        });


        this.setBounds(800,300,300,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    public static void main(String[] args) {
        new S0105();
    }
}
