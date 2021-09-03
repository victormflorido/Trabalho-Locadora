package locadora;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import pessoa.Usuario;

public class Locacoes implements Serializable{
	static ArrayList<Jogo> Disponiveis= new ArrayList<Jogo>();
	static ArrayList<Jogo> Alugados= new ArrayList<Jogo>();

	public static void locar(){
		FileInputStream fluxo;
		FileInputStream fluxo2;
		FileOutputStream fluxo3;
		FileOutputStream fluxo4;
		int i,num;
		try {
			fluxo= new FileInputStream("dispon.ser");
			ObjectInputStream objarq;
			objarq = new ObjectInputStream(fluxo);
			Disponiveis.clear();
			Disponiveis.addAll((ArrayList<Jogo>)objarq.readObject());
			for(i=0;i<Disponiveis.size();i++) {
				System.out.println(i+": "+Disponiveis.get(i).nome+" "+Disponiveis.get(i).tipo+" "+Disponiveis.get(i).classificao);
			}
			System.out.println("Digite o numero do jogo que voce quer");
			Scanner entrada=new Scanner(System.in);
			num=entrada.nextInt();
			Jogo req= new Jogo();
			req=Disponiveis.get(num);
			Disponiveis.remove(num);
			fluxo2= new FileInputStream("alug.ser");
			ObjectInputStream objarq2;
			objarq2 = new ObjectInputStream(fluxo2);
			Alugados.clear();
			Alugados.addAll((ArrayList<Jogo>)objarq2.readObject());
			Alugados.add(req);
			fluxo3= new FileOutputStream("dispon.ser");
			ObjectOutputStream objarq3;
			objarq3 = new ObjectOutputStream(fluxo3);
			objarq3.writeObject(Disponiveis);
			fluxo4= new FileOutputStream("alug.ser");
			ObjectOutputStream objarq4;
			objarq4 = new ObjectOutputStream(fluxo4);
			objarq4.writeObject(Alugados);
			objarq.close();
			objarq2.close();
			objarq3.close();
			objarq4.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	void devolucao(Jogo j, Usuario u){

	}

	public static void addJogo(Jogo j) {
		FileInputStream fluxo;
		FileOutputStream fluxo2;
		try {
			fluxo= new FileInputStream("dispon.ser");
			ObjectInputStream objarq;
			objarq = new ObjectInputStream(fluxo);
			Disponiveis.clear();
			Disponiveis.addAll((ArrayList<Jogo>)objarq.readObject());
			Disponiveis.add(j);
			fluxo2= new FileOutputStream("dispon.ser");
			ObjectOutputStream objarq2;
			objarq2 = new ObjectOutputStream(fluxo2);
			objarq2.writeObject(Disponiveis);
			System.out.println("Salvo no arquivo");
			objarq.close();
			objarq2.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void criaArquivos() {
		FileOutputStream fluxo;
		FileOutputStream fluxo2;
		try {
			fluxo= new FileOutputStream("dispon.ser");
			ObjectOutputStream objarq;
			objarq = new ObjectOutputStream(fluxo);
			Disponiveis.clear();
			objarq.writeObject(Disponiveis);
			fluxo2= new FileOutputStream("alug.ser");
			ObjectOutputStream objarq2;
			objarq2 = new ObjectOutputStream(fluxo2);
			Alugados.clear();
			objarq2.writeObject(Alugados);
			objarq.close();
			objarq2.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void leDisp() {
		FileInputStream fluxo;
		try {
			fluxo= new FileInputStream("dispon.ser");
			ObjectInputStream objarq;
			objarq = new ObjectInputStream(fluxo);
			Disponiveis=(ArrayList<Jogo>)objarq.readObject();
			System.out.println("Objeto lido\n"+Disponiveis.get(0).nome);
			objarq.close();


		} catch (FileNotFoundException e) {

			e.printStackTrace();
			System.out.println("Passou por aqui");
		}
		catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}


	}
	public static void leAlug() {
		FileInputStream fluxo;
		try {
			fluxo= new FileInputStream("alug.ser");
			ObjectInputStream objarq;
			objarq = new ObjectInputStream(fluxo);
			Disponiveis=(ArrayList<Jogo>)objarq.readObject();
			System.out.println("Objeto lido\n"+Disponiveis.get(0).nome);
			objarq.close();


		} catch (FileNotFoundException e) {

			e.printStackTrace();
			System.out.println("Passou por aqui");
		}
		catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}


	}
	

}
