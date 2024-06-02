package Form;

import Dao.UsuarioDAO;
import Model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


@SuppressWarnings("serial")
public class NovoUsuario extends javax.swing.JFrame {
	private JTextField txtNome;
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JTextField txtEmail;
    private JButton btnSalvar;
    
    public NovoUsuario() {
        setTitle("Novo Usuario");
        setSize(500,270);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        
        JLabel lblNome= new JLabel("Nome: ");
        lblNome.setBounds(10,10,100,25);
        add(lblNome);
        
        txtNome = new JTextField();
        txtNome.setBounds(110,10,220,25);
        add(txtNome);
        
        JLabel lblLogin= new JLabel("Login: ");
        lblLogin.setBounds(10,45,100,25);
        add(lblLogin);
        
        txtLogin = new JTextField();
        txtLogin.setBounds(110,45,220,25);
        add(txtLogin);
        
        JLabel lblSenha= new JLabel("Senha: ");
        lblSenha.setBounds(10,80,100,25);
        add(lblSenha);
        
        txtSenha = new JPasswordField();
        txtSenha.setBounds(110,80,220,25);
        add(txtSenha);
        
        JLabel lblEmail= new JLabel("Email: ");
        lblEmail.setBounds(10,115,100,25);
        add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(110,115,220,25);
        add(txtEmail);
        
        btnSalvar= new JButton("Salvar");
        btnSalvar.setBounds(110,160,100,30);
        btnSalvar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Usuario usuario = new Usuario();
                usuario.setNome(txtNome.getText());
                usuario.setLogin(txtLogin.getText());
                usuario.setSenha(new String(txtSenha.getPassword()));
                usuario.setEmail(txtEmail.getText());
                
                UsuarioDAO dao = new UsuarioDAO();
                try{
                    if(dao.insert(usuario)){
                    JOptionPane.showMessageDialog(null,"Cadastro Efetuado com Sucesso!");
                    dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"Erro ao Cadastrar");
                    }
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
        
        
        add(btnSalvar);
        
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
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoUsuario().setVisible(true);
            }
        });
    }

    
    
}
