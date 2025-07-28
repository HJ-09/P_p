package myselfGpt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class S0101_gpt {//250717 수업 실습 S01Swing 1번 문제
    //숫자 증가 게임

    public static void main(String[] args) {

        final int[] num={0};
        //static선언을 최소로 하는게 좋은데 main 안에 쓰게되면 지역변수가 되어서 익명클래스에서 사용할 수가 없음.
        //근데 또 초기화를 안 하면 쓸 수가 없어서 모양이 이럼.
        JLabel l;

        //틀 만들기
        JFrame f=new JFrame("숫자 증가 게임");
        f.setBounds(0,0,500,500);

        //라벨 만들기
        l=new JLabel(num[0]+"", SwingConstants.CENTER);
        l.setFont(new Font("궁서체",Font.BOLD,30));
        f.add(l,BorderLayout.CENTER);

        //버튼 2개 만들기
        JButton btn=new JButton("클릭");
        JButton btn2=new JButton("리셋");

        //버튼 위치
        JPanel bp=new JPanel();
        bp.add(btn);
        bp.add(btn2);
        f.add(bp, BorderLayout.NORTH);

        //
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num[0]++;
                l.setText(num[0]+"");
                final int Goal=100; //숫자는 빼두기
                if(num[0]>=Goal){
                    JOptionPane.showMessageDialog(null,"완료");
                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num[0]=0;
                l.setText("0");
            }
        });

        f.setDefaultCloseOperation(2); //창 끄면 자동종료
        f.setVisible(true); //보여지게 하기

    }

}
