package myself;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class A19_1 extends JFrame {
    JMenuBar menuBar;
    JMenu F, E, O, V, H;
    JMenuItem fileOpen;
    JMenuItem fileSave, fileSave1;
    JMenuItem copy;
    JMenuItem paste;

    JFileChooser fc;
    JTextArea ta;

    File currentFile=null;

    public A19_1(){
        super("헤지스 메모장 ver.2");

        fc=new JFileChooser();
        ta=new JTextArea();
        this.add(ta, BorderLayout.CENTER);

        menuBar=new JMenuBar();
        F=new JMenu("파일(F)");
        E=new JMenu("편집(E)");
        O=new JMenu("서식(O)");
        V=new JMenu("보기(V)");
        H=new JMenu("도움말(H)");

        fileOpen=new JMenuItem("열기(O)...");
        fileOpen.addActionListener((e)->{
            int state=fc.showOpenDialog(A19_1.this);
            if(state==JFileChooser.APPROVE_OPTION){
                File file=fc.getSelectedFile();
                try (FileReader fr=new FileReader(file);
                    BufferedReader br=new BufferedReader(fr);
                ){
                    String str="";
                    StringBuilder sb=new StringBuilder();
                    while((str=br.readLine())!=null){
                        sb.append(str+'\n');
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        fileSave=new JMenuItem("저장(S)");
        fileSave.addActionListener((e)->{
            try {
                if(currentFile==null){
                int state = fc.showSaveDialog(A19_1.this);
                if(state==JFileChooser.APPROVE_OPTION){
                    currentFile=fc.getSelectedFile();
                } else {
                    return;
                }
            }
            try (FileWriter fw=new FileWriter(currentFile);
                BufferedWriter bw=new BufferedWriter(fw);
            ){
                String txt=ta.getText();
                bw.write(txt);
                System.out.println("저장 완료");
            }
            }catch (IOException e1){
                throw new RuntimeException();
            }
        });

        fileSave1=new JMenuItem("다른 이름으로 저장(A)");
        fileSave1.addActionListener((e)->{
            int state=fc.showSaveDialog(A19_1.this);
            if(state==JFileChooser.APPROVE_OPTION){
                File file1=fc.getSelectedFile();
                try(FileWriter fw1=new FileWriter(file1);
                    BufferedWriter bw1=new BufferedWriter(fw1);
                ){
                    String txt1=ta.getText();
                    bw1.write(txt1);
                    System.out.println("다른 이름으로 저장 완료");
                } catch (IOException e1){
                    throw new RuntimeException(e1);
                }
            }
        });

        copy=new JMenuItem("복사(C)");
        paste=new JMenuItem("붙여넣기(P)");

        F.add(fileOpen);
        F.add(fileSave);
        F.add(fileSave1);
        E.add(copy);
        E.add(paste);
        menuBar.add(F);
        menuBar.add(E);
        this.setJMenuBar(menuBar);




        this.setBounds(800,300,400,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new A19_1();
    }
}
