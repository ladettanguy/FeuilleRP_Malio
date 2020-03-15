import Perso.Personnage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Panneau extends JPanel {

    private int rayon;
    public char mode;
    public static Personnage perso = new Personnage("Malio");

    protected void paintComponent(Graphics g){
        try {
            switch (mode) {
                case 'b':
                    fichePerso(g);
                    break;
                case 'e':

                    break;
            }
        }
        catch (Exception e){}
    }

    public void fichePerso(Graphics g) throws IOException {
        g.setFont(new Font("Serif", Font.ROMAN_BASELINE, 30));
        g.setColor(Color.BLUE);

        //Nom Du Personnage
        g.drawImage(ImageIO.read(new File("img\\Nom.png")),20,20,100,30,null);
        g.drawString(perso.nom,140,45);

        //Sexe du Personnage
        g.drawImage(ImageIO.read(new File("img\\Sexe.png")),240,20,100,30,null);
        g.drawString(perso.sexe,350,45);

        //Kamas du Personnage
        g.drawImage(ImageIO.read(new File("img\\Kamas.png")),380,20,100,30,null);
        g.drawString(""+perso.kamas+"k",490,45);

        //Classe du Personnage
        g.drawImage(ImageIO.read(new File("img\\Classe.png")),590,20,100,30,null);
        g.drawString(perso.classe.toString(),700,45);

        //XP actuel du joueur
        g.drawImage(ImageIO.read(new File("img\\XP.png")),380,20,100,30,null);
        g.drawString(""+perso.kamas+"k",490,45);


    }
}