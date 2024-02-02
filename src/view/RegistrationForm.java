package view;

import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JDialog {
    private JTextField tfName;
    private JTextField tfEmail;
    private JTextField tfPhoneNumber;
    private JTextField tfAdress;
    private JPasswordField tfPassword;
    private JPasswordField tfConfirmPassword;
    private JButton btnRegister;
    private JButton btnCancel;
    private JPanel registerPanel;

    public RegistrationForm(JFrame parent){
        super(parent);
        setTitle("Criar um novo registro de usuário");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(650, 474));
        setModal(true);
        setLocationRelativeTo(parent);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             dispose();
            }
        });

        setVisible(true);
    }

    private void registerUser() {
        String name = tfName.getText();
        String email = tfEmail.getText();
        String phone = tfPhoneNumber.getText();
        String adress = tfAdress.getText();
        String password = String.valueOf(tfPassword.getPassword());
        String confirmPassword = String.valueOf(tfConfirmPassword.getPassword());

        if ( name.isEmpty() || email.isEmpty() || phone.isEmpty() || adress.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                   "Por favor preencha todos os campos",
                    "Tente novamente",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!password.equals(confirmPassword)){
            JOptionPane.showMessageDialog(this,
                    "Por favor verifique: campos senha e confirmar senha devem ser identicos.",
                    "Tente novamente",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        user = addUserToDatabase(name, email, phone, adress, password);
        if (user != null){
            dispose();
        }
    }
    public User user;
    public User addUserToDatabase(String name, String email, String phone, String adress, String password){
        User user = null;
        final String DB_URL = "jdbc:mysql://localhost";
        return user;
    }


    public static void main(String[] args) {
        RegistrationForm myForm = new RegistrationForm(null);
    }
}
