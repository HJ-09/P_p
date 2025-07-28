package myself;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class S0101 {//250717 수업 실습 S01Swing 1번 문제
    //숫자 증가 게임

    static int num;
    static JLabel l;

/*    static class BtnHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ++num;
            l.setText(num+"");

        }
    }*/

    public static void main(String[] args) {

        //틀 만들기
        JFrame f=new JFrame("숫자 증가 게임");
        f.setBounds(0,0,500,500);

        //라벨 만들기
        l=new JLabel(num+"", SwingConstants.CENTER);
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
                num++;
                l.setText(num+"");
                if(num>=100){
                    JOptionPane.showMessageDialog(null,"완료");
                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num=0;
                l.setText("0");
            }
        });


 /*       JPanel p=new JPanel(new BorderLayout());
        p.add(btn);
        p.add(btn2);
        //p.setLayout(new BorderLayout());
        f.add(p,BorderLayout.NORTH);*/


        //f.add(btn,BorderLayout.NORTH);


        f.setDefaultCloseOperation(2); //창 끄면 자동종료
        f.setVisible(true); //보여지게 하기

    }

}
