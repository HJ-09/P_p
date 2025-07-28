package myself;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class A19 extends JFrame {
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem fileOpen;
    JMenuItem fileSave;
    JMenuItem exit;
    JFileChooser fc;
    JTextArea ta;

    public A19(){
        super("헤지스 메모장");

        fc=new JFileChooser();
        ta=new JTextArea();
        this.add(ta, BorderLayout.CENTER);

        menuBar=new JMenuBar();
        menu=new JMenu("파일(F)");

        fileOpen=new JMenuItem("열기(O)...");
        fileOpen.addActionListener((e)->{
            int state=fc.showOpenDialog(A19.this); //
            if(state==JFileChooser.APPROVE_OPTION){
                File selectedFile = fc.getSelectedFile();
                System.out.println(selectedFile.getName());
                try(FileReader fileReader=new FileReader(selectedFile);
                BufferedReader bufferedReader=new BufferedReader(fileReader);
                ){
                    String str="";
                    StringBuilder sb=new StringBuilder();
                    while ((str=bufferedReader.readLine())!=null){
                        sb.append(str+"\n");
                    }
                    ta.setText(sb.toString());
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        fileSave=new JMenuItem("저장(S)");
        fileSave.addActionListener((e)->{
            int state=fc.showOpenDialog(A19.this);
            if(state==JFileChooser.APPROVE_OPTION){
                File file=fc.getSelectedFile();
                try(FileWriter fileWriter=new FileWriter(file);
                    BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
                ){
                    String txt=ta.getText();
                    bufferedWriter.write(txt);
                    System.out.println("저장완료");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        menu.add(fileOpen);
        menu.add(fileSave);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);




        this.setBounds(800,300,400,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new A19();
    }
}
