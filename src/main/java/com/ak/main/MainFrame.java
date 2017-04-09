package com.ak.main;

import javafx.scene.control.*;
import javafx.scene.control.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ewcia on 16.03.17.
 */
public class MainFrame extends JFrame implements ActionListener{
    private static enum PLAYER{X, O};
    private List<JButton> buttons;
    private Container container;
    private int counter;

    public MainFrame(String name){
        buttons=new ArrayList<JButton>();
        container=getContentPane();
        counter=0;
        for(int i=1; i<10; i++){
            JButton b=new JButton("");
            b.addActionListener(this);
            buttons.add(b);
            container.add(b);
        }

        setLayout(new GridLayout(3, 3));
        setMinimumSize(new Dimension(340, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //metoda zwraca true, gdy podany jako argument gracz wygrał
    private boolean checkWinner(PLAYER player){
        String p=player.name();
        buttons.get(1).getText();
        boolean isWin=false;

        for (int i=0; i<3; i++){
            JButton b=buttons.get(i);
            if(buttons.get(i).getText().equals(p)&&buttons.get(i+3).getText().equals(p)&&buttons.get(i+6).getText().equals(p)){
                isWin=true;
            }
            }



        if(buttons.get(0).getText().equals(p)&&buttons.get(4).getText().equals(p)&&buttons.get(8).getText().equals(p)){
            isWin=true;
        }
        if(buttons.get(2).getText().equals(p)&&buttons.get(4).getText().equals(p)&&buttons.get(6).getText().equals(p)){
            isWin=true;
        }

        return isWin;
    }

    //ta metoda jest związana z obsługą zdarzenia związanym z dowolną kontrolką
    public void actionPerformed(ActionEvent e) {
        //pobranie referencji na kontrolkę związaną ze zdarzeniem
        JButton button=(JButton)e.getSource();
        if(counter%2==0){
        button.setText("O");}
        else {button.setText("X");}
        counter++;

        if(checkWinner(PLAYER.O)){
            JOptionPane.showMessageDialog(this,"Gracz O wygrał!");
            System.exit(0);
        }else{
            if(checkWinner(PLAYER.X)){
                JOptionPane.showMessageDialog(this,"Gracz X wygrał!");
                System.exit(0);
            }
            if(counter==9){
                JOptionPane.showMessageDialog(this,"Remis!");
                System.exit(0);
            }
        }
    }
}
