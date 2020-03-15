import Perso.Personnage;
import Perso.SortAcqui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Fenetre extends JFrame {
    private Panneau contentPane = new Panneau();
    private ArrayList<JButton> listSortHelper = new ArrayList<>();
    private JButton retourALaFiche = new JButton("Retour");

    Fenetre(){
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        this.setContentPane(contentPane);
        this.add(retourALaFiche);
        retourALaFiche.setVisible(false);
        retourALaFiche.setBounds(50,50,150,30);
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setLayout(null);
        basicFrame();
        this.setVisible(true);
        this.setTitle("FICHE DE PERSONNAGE :   " + contentPane.perso.nom);
        initialiseAction();
    }



    public void editFrame(){

    }

    public void basicFrame(){
        contentPane.mode = 'b';
        Outil.enabledAll(listSortHelper);
    }

    public static void main(String[] args){
        Fenetre f = new Fenetre();
    }

    private void initialiseAction() {
        //Action sur chaque Bouton HELP de chaque Sort Actif
        ArrayList<SortAcqui> sorts = contentPane.perso.sortAcquis;
        for (int i=0; i<contentPane.perso.sortAcquis.size() ; i++){
            final JButton j = new JButton("?");
            j.setActionCommand(sorts.get(i).nom);
            j.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    SortAcqui s = Outil.getSortByNom(contentPane.perso.sortAcquis,j.getActionCommand());
                    contentPane.helpSort = s;
                    contentPane.mode = 'h';
                    Fenetre.this.repaint();
                    Outil.disabledAll(listSortHelper);
                    retourALaFiche.setVisible(true);
                }
            });
            listSortHelper.add(j);
            j.setBounds(300,480+(i*50),15,25);
            this.add(j);
        }

        //Action du bouton Retour qui reviens vers la fiche de perso
        retourALaFiche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Fenetre.this.basicFrame();
                retourALaFiche.setVisible(false);
                Fenetre.this.repaint();
            }
        });
    }
}
