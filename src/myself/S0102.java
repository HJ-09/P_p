package myself;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Count extends JFrame{
    private int num=0;
    JLabel la;
    JButton btn1, btn10, btn100, btn0;
    /*class BtnHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            num++;
            la.setText(num+"");
        }
    }*/

    public Count(){
        super("카운터 앱");
        la=new JLabel(this.num+"", SwingConstants.CENTER);
        la.setFont(new Font("나눔고딕",Font.BOLD,25));

        this.btn1=new JButton("+1");
        this.btn10=new JButton("+10");
        this.btn100=new JButton("+100");
        this.btn0=new JButton("리셋");
        //btn1.addActionListener(new BtnHandler());
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num+=1;
                la.setText(num+"");
            }
        });
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num+=10;
                la.setText(num+"");
            }
        });
        btn100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num+=100;
                la.setText(num+"");
            }
        });
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num=0;
                la.setText(num+"");
            }
        });

        JPanel pan=new JPanel();
        pan.add(btn1);
        pan.add(btn10);
        pan.add(btn100);

        JPanel pan2=new JPanel();
        pan2.add(btn0);

        super.add(this.la);
        this.add(pan, BorderLayout.NORTH);
        this.add(pan2, BorderLayout.SOUTH);
        this.setBounds(2000,0,300,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(2);

        }
    }

public class S0102 {//250717 수업 실습 S01Swing 2번 문제
    //카운터 앱

    public static void main(String[] args) {
        Count count=new Count();
    }
}
