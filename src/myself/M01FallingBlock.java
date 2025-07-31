package myself;

/*
    ✅ 기본 기능:
    파란 블럭: 내가 조종하는 캐릭터

    빨간 블럭: 위에서 아래로 떨어짐

    맞으면 "Game Over" 표시

    피하면 점수 올라감

    ✅ 추가 기능:
    ArrayList로 장애물 여러 개 만들기

    속도 점점 증가

    "스페이스" 누르면 다시 시작
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class M01FallingBlock extends JFrame {
    Timer timer;
    final int width=500;
    final int height=500;
    int keyCode;
    Block block1;
    Block block2;

    static class Block{
        int x;
        int y;
        int width=30;
        int height=30;
        Color color;

        public Block(int x, int y, Color color){
            this.x=x;
            this.y=y;
            this.color=color;
        }

        public Block(int x, int y, int width, int height, Color color){
            this.x=x;
            this.y=y;
            this.width=width;
            this.height=height;
            this.color=color;
        }
    }

    class MyCanvas extends Canvas{

        public MyCanvas(){
            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()){
                        case KeyEvent.VK_RIGHT -> block1.x+=10;
                        case KeyEvent.VK_LEFT -> block1.x-=10;
                    }
                    MyCanvas.this.repaint();
                }
            });
        }
        @Override
        public void paint(Graphics g){
            for(Block block:blocks){
                g.setColor(block.color);
                g.fillRect(block.x,block.y,block.width,block.height);
            }
        }
    }

    private Canvas canvas;
    private java.util.List<Block> blocks=new ArrayList<>();

    public M01FallingBlock(){
        super("장애물 피하기");


        block1=new Block(width/2-25, height-70,new Color(26, 82, 217, 163));
        block2=new Block(width/2-25,0,new Color(255,0,0));
        blocks.add(block1);
        blocks.add(block2);

        canvas=new MyCanvas();
        canvas.setBackground(Color.GRAY);
        this.add(canvas);


        timer=new Timer(100,(e)->{
                block2.y+=5;
                canvas.repaint();
        });
        timer.start();
        canvas.setFocusable(true);

        this.setBounds(800,300,width,height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            M01FallingBlock frame=new M01FallingBlock();
            frame.setVisible(true);
        });
    }
}
