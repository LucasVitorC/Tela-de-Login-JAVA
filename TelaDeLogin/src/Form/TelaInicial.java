package Form;

import Dao.UsuarioDAO;
import Model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


@SuppressWarnings("serial")
public class TelaInicial extends javax.swing.JFrame{
	private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JButton btnEntrar;
    private JButton btnCadastrar;
    
    public TelaInicial() {
        setTitle("Login");
        setSize(500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        JLabel lblLogin= new JLabel("Login: ");
        lblLogin.setBounds(10,10,100,25);
        add(lblLogin);
        
        txtLogin = new JTextField();
        txtLogin.setBounds(110,10,280,25);
        add(txtLogin);
        
        JLabel lblSenha= new JLabel("Senha: ");
        lblSenha.setBounds(10,45,100,25);
        add(lblSenha);
        
        txtSenha = new JPasswordField();
        txtSenha.setBounds(110,45,280,25);
        add(txtSenha);
        
        btnEntrar= new JButton("Entrar");
        btnEntrar.setBounds(110,80,130,25);
        btnEntrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String login= txtLogin.getText();
                String senha= new String(txtSenha.getPassword());
                UsuarioDAO dao=new UsuarioDAO();
                try{
                    Usuario usuario = dao.encontreLoginESenha(login, senha);
                    if(usuario!=null){
                        JOptionPane.showMessageDialog(null, "Acesso autorizado!");
                    }else{
                        JOptionPane.showMessageDialog(null, "Acesso negado!");
                    }
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
        add(btnEntrar);
        btnCadastrar= new JButton("Cadastrar Novo Usuário");
        btnCadastrar.setBounds(250,80,140,25);
        btnCadastrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new NovoUsuario().setVisible(true);
            }
        });
        add(btnCadastrar);
        
    }

    
    @SuppressWarnings("unused")
	private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

   
	
}
