import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImagingOpException;
//import javax.swing.JOptionPane;
import javax.swing.plaf.DimensionUIResource;

import java.util.Random;
import java.security.SecureRandom;

public class mapa extends JPanel implements ActionListener{
    private int rx;
    private int ry; 
    ClaseMadre [][] tableroLogico= new ClaseMadre[50][50];
    ClaseMadre objective;
    JFrame ventana;
    agentes arrayAgentes[]=new agentes[21];
    Objetos arrayObjetos[]= new Objetos[15];

    JButton buttonNext;
    JButton buttonArray [][] = new JButton [50][50];

    JPanel panelBotones;
    JPanel panelBoton;
    int numObjs=5;
    int numAme=5;
    int numRec=5;

    //Color hormigaR= new Color()
    
    public mapa(){
        ventana= new JFrame("Proyecto");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearMapa();
        CrearHormigas();
        CrearLosObjetos();
        //Interactuar();
        //ventana.setPreferredSize(new DimensionUIResource(600, 900));
        ventana.pack();
        ventana.setVisible(true);
    }


    public void crearMapa(){
        panelBotones = new JPanel();
        panelBoton= new JPanel();
        for(int i=0;i<50;i++)
        {
            for(int j=0;j<50;j++)
            {
                // coloca imagen a todos vacio
                buttonArray[i][j] = new JButton();
                //añade al panel el boton;
                panelBotones.add(buttonArray[i][j]);
                buttonArray[i][j].setBackground(Color.WHITE);
                buttonArray[i][j].setBounds(18*i+8, 18*j+8, 50, 50);
                panelBotones.setLayout(new GridLayout(50, 50));
                buttonArray[i][j].setActionCommand(i+","+j);//i+","+j
            }
        }
        buttonNext= new JButton("Siguiente");
        buttonNext.addActionListener(this);
        panelBoton.add(buttonNext);
        ventana.add(panelBoton, BorderLayout.EAST);
        ventana.add(panelBotones, BorderLayout.CENTER);           
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Interactuar();
        
    }


    public int [] alrededores(int x, int y){
        int num[]={-1,-1};
        if(tableroLogico[x+2][y]!=null && x+2<49 && y<49){
            int num1[]={x+2,y};
            return num1;
        }
        else if(tableroLogico[x][y+2]!=null && x+2<49 && y<49){
            int num2[]={x,y+2};
            return num2;
        }
        if(tableroLogico[x-2][y]!=null && x+2<49 && y<49){
            int num1[]={x+2,y};
            return num1;
        }
        else if(tableroLogico[x][y-2]!=null && x+2<49 && y<49){
            int num2[]={x,y+2};
            return num2;
        }
        return num;
    }

    public void Interactuar(){
        for (int i=0; i<tableroLogico.length; i++){
            for (int j=0; j<tableroLogico.length; j++){
                if(tableroLogico[i][j]!=null){
                    if(tableroLogico[i][j].moverSe()){
                        int [] cordenadas=alrededores(i, j);
                        if(cordenadas[0]!=-1){
                            if(((Object)tableroLogico[cordenadas[0]][cordenadas[0]]).getClass().getSimpleName()=="Amenaza"){
                                int[] nu = tableroLogico[i][j].reaccion(cordenadas[0], cordenadas[1], i, j);
                                nuevaPosicion(i, j, nu[0], nu[1]);
                            }
                            else if(((Object)tableroLogico[cordenadas[0]][cordenadas[0]]).getClass().getSimpleName()=="Recursos"){
                                int[] nu = tableroLogico[i][j].reaccion(cordenadas[0], cordenadas[1], i, j);
                                nuevaPosicion(i, j, nu[0], nu[1]);
                            }
                            else if(((Object)tableroLogico[cordenadas[0]][cordenadas[0]]).getClass().getSimpleName()=="Obstaculos"){
                                int[] nu = tableroLogico[i][j].reaccion(cordenadas[0], cordenadas[1], i, j);
                                nuevaPosicion(i, j, nu[0], nu[1]);
                            }    
                        }
                        else{
                            movilizarHormiga(i, j);
                        }
                    }
                }
                
            }
        }
        //return null;
    }



//Funciones de Clase Objetos
    public int[] AsignarPociOb(int x, int y){
        int f=0,c=0,ff=0,cc=0,fff=0,ccc=0,ffff=0,cccc=0;
        if(tableroLogico[x][y]==null && x<49 && y<49){
            f=x;
            c=y;
            if(tableroLogico[x][y+1]==null && x<49 && y<49 && tableroLogico[x+1][y]==null && tableroLogico[x+1][y+1]==null && x+1<49 && y+1<49){
                ff=x;
                cc=y+1;
                fff=x+1;
                ccc=y;
                ffff=x+1;
                cccc=y+1;
            }
            else if(tableroLogico[x][y-1]==null && y-1<=49 && x-1<=0 && x-1<=49 && y-1<=0 &&  tableroLogico[x-1][y-1]==null){
                ff=x;
                cc=y-1;
                fff=x-1;
                ccc=y-1;
                ffff=x-1;
                cccc=y-1;
            }
            else{
                f=-1;
                c=-1;
                ff=-1;
                cc=-1;
                fff=-1;
                ccc=-1;
                ffff=-1;
                cccc=-1;
            }
    
        }
        else{
            f=-1;
            c=-1;
            ff=-1;
            cc=-1;
            fff=-1;
            ccc=-1;
            ffff=-1;
            cccc=-1;
        }

        int [] re={f,c,ff,cc,fff,ccc,ffff,cccc};
        return re;
    }

    public void nuevoObstaculo(int [] lista, int i){
        arrayObjetos[i]= new Obstaculo(lista[0],lista[1], 4, 0);
        tableroLogico[lista[0]][lista[1]]=arrayObjetos[i];
        tableroLogico[lista[2]][lista[3]]=arrayObjetos[i];
        tableroLogico[lista[4]][lista[5]]=arrayObjetos[i];
        tableroLogico[lista[6]][lista[7]]=arrayObjetos[i];
        buttonArray[lista[0]] [lista[1]].setBackground(Color.BLACK);
        buttonArray[lista[2]] [lista[3]].setBackground(Color.BLACK);
        buttonArray[lista[4]] [lista[5]].setBackground(Color.BLACK);
        buttonArray[lista[6]] [lista[7]].setBackground(Color.BLACK);           
    }

    public void nuevoRecurso(int [] lista, int i){
        arrayObjetos[i]= new Recursos(lista[0],lista[1], 4, 0);
        tableroLogico[lista[0]][lista[1]]=arrayObjetos[i];
        tableroLogico[lista[2]][lista[3]]=arrayObjetos[i];
        tableroLogico[lista[4]][lista[5]]=arrayObjetos[i];
        tableroLogico[lista[6]][lista[7]]=arrayObjetos[i];
        buttonArray[lista[0]] [lista[1]].setBackground(Color.GREEN);
        buttonArray[lista[2]] [lista[3]].setBackground(Color.GREEN);
        buttonArray[lista[4]] [lista[5]].setBackground(Color.GREEN);
        buttonArray[lista[6]] [lista[7]].setBackground(Color.GREEN);           
    }

    public void nuevAamenaza(int [] lista, int i){
        arrayObjetos[i]= new Amenazas(lista[0],lista[1], 4, 0);
        tableroLogico[lista[0]][lista[1]]=arrayObjetos[i];
        tableroLogico[lista[2]][lista[3]]=arrayObjetos[i];
        tableroLogico[lista[4]][lista[5]]=arrayObjetos[i];
        tableroLogico[lista[6]][lista[7]]=arrayObjetos[i];
        buttonArray[lista[0]] [lista[1]].setBackground(Color.RED);
        buttonArray[lista[2]] [lista[3]].setBackground(Color.RED);
        buttonArray[lista[4]] [lista[5]].setBackground(Color.RED);
        buttonArray[lista[6]] [lista[7]].setBackground(Color.RED);
    }

    public void CrearLosObjetos(){
        for(int i=0; i<arrayObjetos.length; i++){
            int [] position=randomPosiciones();
            System.out.println("Cordenada x: "+position[0]+"Cordenada y: "+position[1]);
            int []lista= AsignarPociOb(position[0],position[1]);
            while(lista[0]==-1 || lista[5]==-1){
                position=randomPosiciones();
                lista=AsignarPociOb(position[0],position[1]);  
            }
            if(i<=numObjs){
                System.out.println("Cordenada x: "+lista[0]+"Cordenada y: "+lista[1]+"Cordenada x: "+lista[2]+"Cordenada y: "+lista[3]+
                "Cordenada x: "+lista[4]+ "Cordenada y: "+lista[5]+"Cordenada x: "+lista[6]+ "Cordenada y: "+lista[7]);
                //arrayObjetos[i]=new Obstaculo(lista[0], lista[1],lista[2], lista[3],lista[4], lista[5],lista[6], lista[7], 0);
                nuevoObstaculo(lista, i);
                
            }
            else if(i>5 && i<=10){
                System.out.println("Cordenada x: "+lista[0]+"Cordenada y: "+lista[1]+"Cordenada x: "+lista[2]+"Cordenada y: "+lista[3]+
                "Cordenada x: "+lista[4]+ "Cordenada y: "+lista[5]+"Cordenada x: "+lista[6]+ "Cordenada y: "+lista[7]);
                nuevAamenaza(lista, i);
                
            }
            else if(i>10 && i<=15){
                System.out.println("Cordenada x: "+lista[0]+"Cordenada y: "+lista[1]+"Cordenada x: "+lista[2]+"Cordenada y: "+lista[3]+
                "Cordenada x: "+lista[4]+ "Cordenada y: "+lista[5]+"Cordenada x: "+lista[6]+ "Cordenada y: "+lista[7]);
                nuevoRecurso(lista, i);
            }
        }
    }

    public int [] randomPosiciones(){
        Random random=new Random();
        int x= random.nextInt(50);
        int y= random.nextInt(50);
        int [] pos={x,y};
        return pos;
    }


    ///Funciones de Hormigas
    public int [] asignarPosionesH(){
        Random random=new Random();
        int x= random.nextInt(50);
        int y= random.nextInt(50);
        if(VerfificarHormiga(x,y)==false){
            asignarPosionesH();
        }
        int [] pos={x,y};
        return pos;  
    }
 
    public boolean VerfificarHormiga(int x, int y){
        if(tableroLogico[x][y]==null){
            return true;
        }
        return false;
    }

    public void nuevaPosicion(int x, int y, int xN, int yN){
        if(((Object)tableroLogico[x][y]).getClass().getSimpleName()=="Recolector"){
            tableroLogico[xN][yN].setRx(xN);
            tableroLogico[xN][yN].setRy(yN);
            DespintarA(x, y);
            buttonArray[xN][yN].setBackground(Color.GRAY);
        }
        else if(((Object)tableroLogico[x][y]).getClass().getSimpleName()=="Defensor"){
            tableroLogico[xN][yN].setRx(xN);
            tableroLogico[xN][yN].setRy(yN);
            DespintarA(x, y);
            buttonArray[xN][yN].setBackground(Color.DARK_GRAY);
        }
    }

    public void movilizarHormiga(int x, int y){
        System.out.println("x: "+x+" y: "+y);
        if(tableroLogico[x+1][y]!=null && x+1<49 && y<49 && x+1>-1 && y>-1){
            nuevaPosicion(x, y,x+1,y);
        }
        else if(tableroLogico[x][y+1]!=null && x<49 && y+1<49 && x>-1 && y+1>-1){
            nuevaPosicion(x, y,x,y+1);
        }
        else if(tableroLogico[x-1][y]!=null && x-1<49 && y<49 && x-1>-1 && y>-1){
            nuevaPosicion(x, y,x-1,y);
        }
        else if(tableroLogico[x][y-1]!=null && x<49 && y<49&& x>-1 && y-1>-1){
            nuevaPosicion(x, y,x,y-1);
        }
    }
    
    public void CrearHormigas(){
        for(int i=0; i<arrayAgentes.length; i++){
            int [] position=asignarPosionesH();
            
            if(i<=10){
                arrayAgentes[i]=new Recolector(false, position[0], position[1], 1);
                buttonArray[position[0]][position[1]].setBackground(Color.GRAY);
            }
            else if(i>=10 && i<20){
                arrayAgentes[i]=new Defensor(false, position[0], position[1], 1, 10);
                buttonArray[position[0]][position[1]].setBackground(Color.DARK_GRAY);
            }
            else{
                arrayAgentes[i]=new Base(false, 0,0, 1);
                buttonArray[0][0].setBackground(Color.ORANGE);
            }          
        }
        for(int i=0; i<arrayAgentes.length; i++){
            tableroLogico[arrayAgentes[i].getRx()][arrayAgentes[i].getRy()]=arrayAgentes[i];
            System.out.println("Corde nada x: "+arrayAgentes[i].getRx()+" Cordenada y: "+arrayAgentes[i].getRy());
        }

    }
    public void DespintarA(int x, int y){
            buttonArray[x][y].setBackground(Color.WHITE);
    }


    

}
