package morpion;

import java.util.Scanner;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Morpion{

    private int taille;
    private int nbAlignes;
    private int [][] grille=null;
    private int joueurCourant;
    private int joueurGagnant=0;
    private int numTour=0;

    Morpion(String json){
	setEtat(json);
    }
    Morpion(int taille, int nbAlignes, int joueurCourant){
	this.taille=taille;
	this.nbAlignes=nbAlignes;
	this.grille= new int[taille][taille];
	for (int i=0;i<taille;i++)
	    for (int j=0;j<taille;j++)
		grille[i][j]=0;
	this.joueurCourant=joueurCourant;
	this.numTour=0;
    }
    public String getEtat(){
	JSONObject res=new JSONObject();
	res.put("joueurCourant",joueurCourant);
	res.put("joueurGagnant",joueurGagnant);
	res.put("taille",taille);
	res.put("nbAlignes",nbAlignes);
	res.put("numTour",numTour);
	JSONArray gr=new JSONArray();
	for (int i=0;i<taille;i++){
	    JSONArray li=new JSONArray();
	    for (int j=0;j<taille;j++){
		li.add(grille[i][j]);
	    }
	    gr.add(li);
	}
	res.put("grille",gr);
	return res.toString();
    }

    public void setEtat(String json){

	JSONParser p= new JSONParser();
	try{
	    JSONObject res=(JSONObject)p.parse(json);
	    this.joueurCourant=((Long)res.get("joueurCourant")).intValue();
	    this.joueurGagnant=((Long)res.get("joueurGagnant")).intValue();
	    this.nbAlignes=((Long)res.get("nbAlignes")).intValue();
	    this.taille=((Long)res.get("taille")).intValue();
	    this.numTour=((Long)res.get("numTour")).intValue();

	    this.grille=new int[taille][taille];
	    JSONArray gr=(JSONArray)res.get("grille");
	    for (int i=0;i<taille;i++){
		JSONArray li=(JSONArray)gr.get(i);
		for (int j=0;j<taille;j++){
		    grille[i][j]=((Long)li.get(j)).intValue();
		}
	    }
	}catch (ParseException e) {
	    System.out.println(e);
	}
    }

    public int getJoueurCourant(){
	return joueurCourant;
    }
    public int getJoueurGagnant(){
	return joueurGagnant;
    }
    public int getProchainJoueur(){
	if (joueurCourant==1)
	    return 2;
	return 1;
    }

    public int getTaille(){
	return taille;
    }

    public int getNumTour(){
	return numTour;
    }

    public int getVal(int i, int j){
	return grille[i][j];
    }

    public void setVal(int i, int j,int val){
	grille[i][j]=val;
    }

    public void jouer(int lin, int col){
	grille[lin][col]=joueurCourant;
	numTour++;
	if (this.alignement())
	    this.joueurGagnant=joueurCourant;
	else
	    joueurCourant=getProchainJoueur();
    }

    public boolean coupOK(int lin, int col){
	return lin>=0 && lin<taille && col>=0 && col<taille && grille[lin][col]==0;
    }

    private boolean alignementHorizontal(){
	boolean trouve=false;
	for (int i=0; (i<taille && ! trouve); i++){
	    int nb=1;
	    for (int j=1;(j<taille && ! trouve);j++){
		if (grille[i][j]==joueurCourant && grille[i][j]==grille[i][j-1]){
		    nb++;
		}
		if (nb>=nbAlignes)
		    trouve=true;
	    }
	}
	return trouve;
    }

    private boolean alignementVertical(){
	boolean trouve=false;
	for (int i=0; (i<taille && ! trouve); i++){
	    int nb=1;
	    for (int j=1;(j<taille && ! trouve);j++){
		if (grille[j][i]==joueurCourant && grille[j][i]==grille[j-1][i]){
		    nb++;
		}
		if (nb>=nbAlignes)
		    trouve=true;
	    }
	}
	return trouve;
    }

    private boolean alignementDiagonal1(){
	boolean trouve=false;
	for (int k=0;( k<taille && ! trouve); k++){
	    int nb=1;
	    for (int j=1, i=k+1;(i<taille && ! trouve);j++,i++){
		if (grille[i][j]==joueurCourant && grille[i][j]==grille[i-1][j-1]){
		    nb++;
		}
		if (nb>=nbAlignes)
		    trouve=true;
	    }
	}
	return trouve;
    }

    private boolean alignementDiagonal2(){
	boolean trouve=false;
	for (int k=0; (k<taille && ! trouve); k++){
	    int nb=1;
	    for (int i=1,  j=k+1;(j<taille && ! trouve);j++,i++){
		if (grille[i][j]==joueurCourant && grille[i][j]==grille[i-1][j-1]){
		    nb++;
		}
		if (nb>=nbAlignes)
		    trouve=true;
	    }
	}
	return trouve;
    }

    private boolean alignementDiagonal3(){
	boolean trouve=false;
	for (int k=0; (k<taille && ! trouve); k++){
	    int nb=1;
	    for (int j=taille-2-k,  i=1;(i<taille &&j >=0 && ! trouve);j--,i++){
		if (grille[i][j]==joueurCourant && grille[i][j]==grille[i-1][j+1]){
		    nb++;
		}
		if (nb>=nbAlignes)
		    trouve=true;
	    }
	}
	return trouve;
    }

    private boolean alignementDiagonal4(){
	boolean trouve=false;
	for (int k=0; (k<taille && ! trouve); k++){
	    int nb=1;
	    for (int i=taille-2,  j=k+1;(j<taille && i>=0 && ! trouve);j++,i--){
		if (grille[i][j]==joueurCourant && grille[i][j]==grille[i+1][j-1]){
		    nb++;
		}
		if (nb>=nbAlignes)
		    trouve=true;
	    }
	}
	return trouve;
    }

    public boolean alignement(){
	boolean res=alignementHorizontal() || alignementVertical() ||
	    alignementDiagonal1() || alignementDiagonal2() ||
	    alignementDiagonal3() || alignementDiagonal4();
	return res;
    }

    public void afficher(){
	System.out.println();
	System.out.println("Joueur courant: "+joueurCourant);
	System.out.println();
	for (int i=0;i<taille;i++){
	    for (int j=0;j<taille;j++)
		System.out.print(grille[i][j]+" ");
	    System.out.println();
	}
	System.out.println();
    }


    int saisieInt(String prompt, int valMin, Integer valMax){
	Scanner	sc = new Scanner(System.in);
	System.out.print(prompt+' ');
	boolean ok=false;
	int resInt=0;
	while (! ok){
	    String res= sc.nextLine();
	    try{
		resInt=Integer.parseInt(res);
		if (resInt>=valMin && resInt<=valMax)
		    ok=true;
		else
		    System.out.println("L'entier doit être compris entre "+valMin+" et "+valMax);
	    }catch(Exception e){
		System.out.println(res+" n'est pas un nombre entier");
		System.out.print(prompt+' ');
	    }
	}
	return resInt;
    }
    public static void main(String[] args){
	Morpion m=new Morpion(5,3,1);
	m.setEtat("{\"grille\":[[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,2],[0,0,0,1,0]], \"joueurCourant\":1, \"joueurGagnant\":0, \"taille\":5}");
	int cpt=0;
	while (!m.alignement()&& cpt++<10){
	    m.afficher();
	    int lin=m.saisieInt("Entrez la ligne", 0, m.getTaille()-1);
	    int col=m.saisieInt("Entrez la colonne", 0, m.getTaille()-1);
	    if (m.coupOK(lin,col))
		m.jouer(lin,col);
	    else
		System.out.println("Coup non valide");
	}

	m.afficher();
	System.out.println("Le gagnant est le joueur "+m.getProchainJoueur());

    }
}
