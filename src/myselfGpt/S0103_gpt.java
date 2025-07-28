package myselfGpt;
/*
        3. Up/Down 버튼으로 숫자 조작 (Medium)

        목표:
	•	“▲ 증가”, “▼ 감소” 버튼으로 숫자 조절
	•	마우스 휠로도 조작 가능 (보너스) ** Label 에 마우스 휠 이벤트 사용
	•	최대/최소 범위 제한

 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class S0103_gpt extends JFrame { //250717 수업 실습 S01Swing 3번 문제
    private JButton upBtn, downBtn;
    private JLabel l;
    private JPanel pan;
    private int num;

    public S0103_gpt(){
        super("Up/Down");
        this.upBtn=new JButton("Up▲");
        this.downBtn=new JButton("Down▼");
        this.l=new JLabel(String.valueOf(num),SwingConstants.CENTER);
        this.l.setFont(new Font("맑은고딕",Font.BOLD,25));



        this.upBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (num < 30) {
                    num++;
                }
                updateLabel();
            }
        });
        this.downBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (num > -15) {
                    num--;
                }
                updateLabel();
            }
        });

        this.pan=new JPanel();
        this.pan.add(upBtn);
        this.pan.add(downBtn);
        this.add(pan, BorderLayout.NORTH);
        this.add(l);

        l.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int direction=e.getWheelRotation();
                if(direction<0 && num<30){
                    num++;
                }else if(direction>0 && num>-15){
                    num--;
                }
                updateLabel();
            }
        });

        this.setBounds(1000,0,450,450);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void updateLabel(){
        if(num>30 || num <-15){
            l.setText("범위를 벗어났습니다.");
        } else if (num==30 || num==-15){
            l.setText("더 이상 클릭할 수 없습니다.");
        } else {
            l.setText(String.valueOf(num));
        }
    }

    public static void main(String[] args) {
        new S0103_gpt();
    }
}
