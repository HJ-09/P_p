package myself;
/*
4. 1~50 랜덤 숫자 맞추기 게임 (Higher)

목표:
	•	텍스트 입력창에 수를 입력하여 “정답 숫자”를 맞추는 간단한 미니게임
	•	정답에 도달하면 “축하합니다!” 표시
	*   기회 3번 (도전)
	*   게임 다시 시작(도전)

* 힌트1 랜덤 수  : Random rand = new Random();
int answer = rand.nextInt(50) + 1;  // 1~50 사이의 정수
* 힌트2 입력창 : JTextField inputField = new JTextField(10);  // 입력 필드 생성
* 힌트3 입력창 엔터 이벤트 : addActionListener()
* 힌트4 입력받은 문자열을 수로 형변환 : Integer.parsInt()

*/


import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class S0104 extends JFrame {
    private JLabel l;
    private JButton staBtn, endBtn, entBtn;
    private JPanel p, p2;
    private int num;
    Random rand = new Random();
    int answer = rand.nextInt(50)+1;
    JTextField inputField=new JTextField(10);
    private int tries=0;

    private void checkGuess(){
        String userInput=inputField.getText();
            try {
                int guess = Integer.parseInt(userInput);
                tries++;

                if(guess==answer){
                    l.setText("정답입니다!🎉");
                    inputField.setEnabled(false); //입력창 비활성화
                    entBtn.setEnabled(false); //입력 버튼도 비활성화
                    inputField.setText(""); //입력창 초기화
                    return;
                }
                 if(tries>=3){
                    l.setText("실패! 정답은 "+answer);
                    inputField.setEnabled(false); //입력창 비활성화
                    entBtn.setEnabled(false); //입력 버튼도 비활성화
                     inputField.setText(""); //입력창 초기화
                    return;
                }
            int re=3-tries;
            String hint=guess<answer ? "더 큰 수를 입력하세요":"더 작은 수를 입력하세요";
                inputField.setText(""); //입력창 초기화
            l.setText("<html>"+hint+"<br><font size='3'>(남은 기회 : "+re+")</html>");

            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this,"숫자만 입력하세요.");
                inputField.setText(""); //입력창 초기화
            }
    }

    S0104(){
        super("랜덤게임!");
        this.staBtn=new JButton("시작");
        this.endBtn=new JButton("종료");
        this.entBtn=new JButton("입력");
        this.l=new JLabel(num+"",SwingConstants.CENTER);
        this.l.setFont(new Font("맑은고딕",Font.BOLD,20));

        this.p=new JPanel();
        this.p.add(staBtn);
        this.p.add(endBtn);
        this.add(p, BorderLayout.NORTH);
        this.p2=new JPanel();
        this.add(p2,BorderLayout.SOUTH);
        this.p2.add(inputField,BorderLayout.SOUTH);
        this.p2.add(entBtn);
        this.add(l);

        l.setText("<html><div align='center'>1~50까지의<br>숫자를 입력하세요</html>");

        this.inputField.addActionListener((e)->{checkGuess();});
        this.entBtn.addActionListener((e)->{checkGuess();});
        this.endBtn.addActionListener((e)->{dispose();});

        this.staBtn.addActionListener((e)->{
            tries=0;
            answer = rand.nextInt(50)+1;
            inputField.setEnabled(true); //입력창 비활성화
            entBtn.setEnabled(true); //입력 버튼도 비활성화
            inputField.setText(""); //입력창 초기화
            l.setText("<html><div align='center'>1~50까지의<br>숫자를 입력하세요</html>");
        });



        this.setBounds(1000,300,300,300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }


    public static void main(String[] args) {
        new S0104();
    }
}
