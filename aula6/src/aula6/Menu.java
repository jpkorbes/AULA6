/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula6;

import java.util.Scanner;

/**
 *
 * @author ads
 */
public class Menu {
    public int menuItem;
    public Produto produto;
    public Produto[] ListaProduto;
    Scanner imput = new Scanner(System.in);
    
    public void criaMenu(){
        System.out.println("Digite uma das opções"
                + "\n 1) - Cadastrar novo"
                + "\n 2) - Listar "
                + "\n 3) - Buscar "
                + "\n 4) - Editar "
                + "\n 5) - Excluir"
                + "\n 0) - sair "
                + "\n =>");
        menuItem = imput.nextInt();
        getExecutar();
    }
        
     public void getExecutar(){
         switch (menuItem){
             case 1:
                 Cadastrar();
                 break;
             case 2:
                 Listar();
                 criaMenu();
                 break;
             case 3:
                 produto = buscar ();
                 if(produto == null) {
                     System.out.println("Produto não exite");
                     } else {
                     imprimirProduto();
                 }   
                 criaMenu();
                 break;
             case 4:
                 break;
             case 0:
                 break;
                 
                 
                 
                 
         }
     }
     public void Cadastrar(){
         System.out.println("Quantos produtos deseja cadastrar");
         int qtde = imput.nextInt();
         ListaProduto = new Produto[qtde];
         for(int x =0; x < qtde; x++){
             ListaProduto[x] = InformacoesProdutos (x + 1);
             
         }
         this.criaMenu();
     }
     
     public void imprimirProduto(){
         System.out.println(
                 "\n Cod" + produto.Cod +
                 "\n Descricao" + produto.Descricao +
                 "\n Valor" + produto.valor +
                 "\n Quantidade" + produto.quantidade); 
                 
     }
     
     public void Editar(){
         this.Listar();
         produto = this.buscar();
         Produto pro = InformacoesProdutos(produto.Cod);
         ListaProduto[pro.Cod -1] = pro;
         this.criaMenu();
     }
     public void Excluir(){
         
         
     }
     public Produto InformacoesProdutos (int valor){
         Produto produto = new Produto();
         produto.Cod = valor;
         System.out.println("Digite a descrição: ");
         produto.Descricao = imput.next();
         System.out.println("Digite uma quantidade: ");
         produto.quantidade = imput.nextInt();
         System.out.println("Digite um valor inteiro: ");
         produto.valor = imput.nextDouble();
         return produto;
         
        
     }
     public Produto buscar () {
         System.out.println(" Digite o codigo ");
         int pesquisa = imput.nextInt();
         for(int x =0; x < ListaProduto.length; x++){
             if (ListaProduto[x].Cod == pesquisa){
                 return ListaProduto[x];
                 
             }
                 
          }
        return null;
     }
     
     public void Listar(){
         for(int x = 0; x < ListaProduto.length; x++){
             System.out.println("++++++++++++++++");
             System.out.println(
                     "\nCod: " + ListaProduto[x].Cod +
                     "\nDescricao: " + ListaProduto[x].Descricao + 
                     "\nValor:  " + ListaProduto[x].valor +
                     "\nQuantidade: " + ListaProduto[x].quantidade
        );
                     
      }
         System.out.println("");
     }
             
        
        
    }