package gui;
import javax.swing.JOptionPane;
 
public class SaidaNomeJOptionPane {
 
    public static void main(String[] args) {
         
        String nome = JOptionPane.showInputDialog("Digite o nome: ");
        String sobreNome = JOptionPane.showInputDialog("Digite o sobrenome: ");
         
        String nomeCompleto = nome + " " + sobreNome;
     
        JOptionPane.showMessageDialog(null, "Nome Completo: "+nomeCompleto,"Informação",JOptionPane.INFORMATION_MESSAGE);
 
    }
}