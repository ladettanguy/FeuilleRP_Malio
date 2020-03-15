import Perso.Personnage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Fenetre extends JFrame {
    private Panneau contentPane = new Panneau();

    Fenetre(){
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(false);
        this.setContentPane(contentPane);
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setLayout(null);
        basicFrame();
        this.setVisible(true);
    }

    public void editFrame(){

    }

    public void basicFrame(){
        contentPane.mode = 'b';
    }

    public static void main(String[] args){
        Fenetre f = new Fenetre();
    }
}