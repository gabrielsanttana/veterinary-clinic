/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import controller.Controller;
import java.util.List;
import model.ClienteDAO;

/**
 *
 * @author vilela
 */
public class ClinicaVeterinaria implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Dados Atualizados!!");
        System.out.println(arg);
    }
    
    public void listaClientes(){
        List clientes = Controller.getAllClientes();
        for (Object cliente : clientes){
            System.out.println(cliente);
        }
    }
    
    public void menuPrincipal(){
        Scanner in = new Scanner(System.in);
        Controller.setObserver(this);
        while (true){
            System.out.println("1- Insere Cliente");
            System.out.println("2- Lista Clientes");
            System.out.println("3- Encerra");
            int opcao = in.nextInt();
            switch (opcao){
                case 1:
                    Controller.addCliente("Plinio Vilela", "endereco", "(19)98787-9988", "15675-900");
                    break;
                case 2:
                    listaClientes();
                    break;
                case 3:
                    return;
            }
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ClinicaVeterinaria().menuPrincipal();
    }
    
}
