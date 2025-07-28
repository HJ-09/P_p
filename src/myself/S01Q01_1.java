package myself;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class S01Q01_1 extends JFrame {
    JButton btn, btn2; //증가, 리셋
    JLabel l;
    JPanel p;
    int num;

     class btnH implements ActionListener{

         @Override
         public void actionPerformed(ActionEvent e) {
             Object o=e.getSource();
            if(o==btn){
                num++;
                if(num>30){
                    num=0;
                    JOptionPane.showMessageDialog(null,"완료");
                    l.setText(num+"");
                }
            }else if(o==btn2){
                num=0;
            }
                l.setText(num+"");
         }
     }

    public S01Q01_1(){
        super("숫자게임");
        l=new JLabel("클릭", SwingConstants.CENTER);
        l.setFont(new Font("",Font.BOLD,14));
        btn=new JButton("▲ 1");
        btn2=new JButton("리셋");


        p=new JPanel();
        this.p.add(btn);
        this.p.add(btn2);
        this.add(p, BorderLayout.NORTH);
        this.add(l, BorderLayout.CENTER);


        btnH hand=new btnH();
        btn.addActionListener(hand);
        btn2.addActionListener(hand);

        l.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int d = e.getWheelRotation();
                if (d < 0 && num < 30) {
                    num++;
                    l.setText(num+"");
                } else {
                    l.setText("더 이상 증가할 수 없습니다.");
                }
            }
        });

        super.setBounds(800,300,300,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new S01Q01_1();
    }
}
