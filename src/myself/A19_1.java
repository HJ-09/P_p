package myself;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;
import java.util.Date;
import java.util.TooManyListenersException;

public class A19_1 extends JFrame {
    JMenuBar menuBar;
    JMenu F, E, O, V, H;
    JMenuItem fileOpen;
    JMenuItem fileSave, fileSave1;
    JMenuItem fileNew; //새로 만들기
    JMenuItem tear;
    JMenuItem copy;
    JMenuItem paste;
    JMenuItem about;

    JFileChooser fc;
    JTextArea ta;

    File currentFile = null;

    public A19_1() {
        super("헤지스 메모장 ver.2");

        fc = new JFileChooser();
        ta = new JTextArea();
        this.add(ta, BorderLayout.CENTER);

        menuBar = new JMenuBar();
        F = new JMenu("파일(F)");
        E = new JMenu("편집(E)");
        O = new JMenu("서식(O)");
        V = new JMenu("보기(V)");
        H = new JMenu("도움말(H)");

        //기능 만들기
        fileNew = new JMenuItem("새로 만들기(N)");
        fileNew.addActionListener((e) -> {
            int result = JOptionPane.showConfirmDialog(this, "새로 여시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                String currentText = ta.getText();
                String savedText = "";
                if (!currentText.equals(savedText)) {
                    int saveResult = JOptionPane.showConfirmDialog(this, "변경 내용을 저장하시겠습니까?");
                    if (saveResult == JOptionPane.YES_OPTION) {
                        int state = fc.showSaveDialog(A19_1.this);
                        if (state == JFileChooser.APPROVE_OPTION) {
                            File file = fc.getSelectedFile();
                            try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
                                bw.write(ta.getText());
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            return;
                        }
                    }
                } else {

                }
                ta.setText("");
            } else {
                //실행할 동작이 없고, 아무 일도 안 일어나기 원하면 그냥 비워둬도 됨.
            }
        });

        fileOpen = new JMenuItem("열기(O)...");
        fileOpen.addActionListener((e) -> {
            int state = fc.showOpenDialog(A19_1.this);
            if (state == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                fc.setCurrentDirectory(file.getParentFile());
                try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
                    String str = "";
                    StringBuilder sb = new StringBuilder();
                    while ((str = br.readLine()) != null) {
                        sb.append(str + '\n'); //내용 읽기
                    }
                    ta.setText(sb.toString()); //열었을 때 보여주는 문장
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        fileSave = new JMenuItem("저장(S)");
        fileSave.addActionListener((e) -> {
            try {
                if (currentFile == null) {
                    int state = fc.showSaveDialog(A19_1.this);
                    if (state == JFileChooser.APPROVE_OPTION) {
                        currentFile = fc.getSelectedFile();
                        fc.setCurrentDirectory(currentFile.getParentFile());
                    } else {
                        return;
                    }
                }
                try (FileWriter fw = new FileWriter(currentFile); BufferedWriter bw = new BufferedWriter(fw);) {
                    String txt = ta.getText();
                    bw.write(txt);
                    System.out.println("저장 완료");
                }
            } catch (IOException e1) {
                throw new RuntimeException();
            }
        });

        fileSave1 = new JMenuItem("다른 이름으로 저장(A)");
        fileSave1.addActionListener((e) -> {
            int state = fc.showSaveDialog(A19_1.this);
            if (state == JFileChooser.APPROVE_OPTION) {
                File file1 = fc.getSelectedFile();
                try (FileWriter fw1 = new FileWriter(file1); BufferedWriter bw1 = new BufferedWriter(fw1);) {
                    String txt1 = ta.getText();
                    bw1.write(txt1);
                    System.out.println("다른 이름으로 저장 완료");
                } catch (IOException e1) {
                    throw new RuntimeException(e1);
                }
            }
        });

        tear=new JMenuItem("잘라내기(T)");
        tear.addActionListener((e)->{
            String selectedText1 = ta.getSelectedText();
            if(selectedText1!=null){
                StringSelection selection1=new StringSelection(selectedText1);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection1, null);

                ta.replaceRange("", ta.getSelectionStart(),ta.getSelectionEnd());
            }
        });

        copy = new JMenuItem("복사(C)");
        copy.addActionListener((e) -> {
            String selectedText = ta.getSelectedText();
            if (selectedText != null) {
                StringSelection selection = new StringSelection(selectedText);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, null);
            }
        });

        paste = new JMenuItem("붙여넣기(P)");
        paste.addActionListener((e)->{
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable contents=clipboard.getContents(null);
            if (contents!=null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)){
                String pasteText= null;
                try {
                    pasteText = (String)contents.getTransferData(DataFlavor.stringFlavor);
                } catch (UnsupportedFlavorException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                ta.insert(pasteText, ta.getCaretPosition());
            }
        });

        about=new JMenuItem("정보(A)");
        about.addActionListener((e)->{
            JOptionPane.showMessageDialog(this,"헤지스 메모장 v0.0입니다.","정보",JOptionPane.INFORMATION_MESSAGE);
        });


        F.add(fileNew);
        F.add(fileOpen);
        F.add(fileSave);
        F.add(fileSave1);
        E.add(tear);
        E.add(copy);
        E.add(paste);
        H.add(about);
        menuBar.add(F);
        menuBar.add(E);
        menuBar.add(O);
        menuBar.add(V);
        menuBar.add(H);
        this.setJMenuBar(menuBar);


        this.setBounds(800, 300, 400, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new A19_1();
    }
}
