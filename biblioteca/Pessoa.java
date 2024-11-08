package lp2g03.biblioteca;

import java.io.Serializable;
import java.util.*;

public class Pessoa implements Serializable{
	private String nome;
	private String sobrenome;
	private GregorianCalendar dataNasc;
	private long numCPF;
	private double peso;
	private double altura;
	static int contador = 0;
	
	
	public Pessoa(String nome, String sobreN, int dia, int mes, int ano){
		//Construtor 1
		set_nome(nome);
		set_sobrenome(sobreN);
		set_data_nascimento(dia, mes, ano);
		contador += 1;
	}

	public Pessoa(String nome, String sobreN, int dia, int mes, int ano, long cpf, float peso, float altura){
		//Construtor 2
		set_nome(nome);
		set_sobrenome(sobreN);
		set_data_nascimento(dia, mes, ano);
		set_cpf(cpf);
		set_peso(peso);
		set_altura(altura);
		contador += 1;
	}
	
	public void set_peso(double peso){
		this.peso = peso;
	}

	public double get_peso(){
		return this.peso;
	}

	public void set_altura(double altura){
		this.altura = altura;
	}
	
	public double get_altura(){
		return this.altura;
	}

	public void set_nome(String nome){
		this.nome = nome;
	}
	
	public String get_nome(){
		return this.nome;
	}

	public void set_sobrenome(String sobrenome){
		this.sobrenome = sobrenome;
	}
	
	public String get_sobrenome(){
		return this.sobrenome;
	}


	public void set_cpf(long CPF){
		this.numCPF = CPF;
	}

	public Long get_cpf()
	{
		return this.numCPF;
	}

	public void set_data_nascimento(int dia, int mes, int ano){
		this.dataNasc = new GregorianCalendar(ano, mes, dia);
	}

	public GregorianCalendar get_data_nascimento()
	{
		return this.dataNasc;
	}
	
	public int get_idade(){
		GregorianCalendar hoje = new GregorianCalendar();
		int idade = hoje.get(hoje.YEAR) - dataNasc.get(dataNasc.YEAR);
		
		if(hoje.get(hoje.MONTH) > dataNasc.get(dataNasc.YEAR)){
			return idade;
		}
		else{
			if(hoje.get(hoje.DAY_OF_MONTH) >= dataNasc.get(dataNasc.DAY_OF_MONTH)){
				return idade;
			}
			else{
				return idade - 1;
			}
		}
	}
	

	public static int numPessoas(){
		return contador;
	}

	public String toString(){
		return "\nNome: " + get_nome() + "\nSobrenome: " + get_sobrenome() + "\nIdade: " + get_idade();
	}
}
		

