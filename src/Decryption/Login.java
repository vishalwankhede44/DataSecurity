package decryption;


import java.awt.Color;
import java.awt.event.InputEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author The Programmer
 */
public class Login extends JFrame {

    /**
     * Creates new form Login
     */
    Statement st;
    public Login()  {
        try{
        initComponents();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cryptography","root","");  
        st=con.createStatement();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null,e);
           
        }
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        exit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ok = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        sp = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(239, 182));
        setMinimumSize(new java.awt.Dimension(888, 404));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(54, 33, 89));
        jPanel2.setLayout(null);

        password.setBackground(new java.awt.Color(54, 33, 89));
        password.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setAlignmentY(0.0F);
        password.setAutoscrolls(false);
        password.setBorder(null);
        password.setCaretColor(Color.WHITE);
        password.setEchoChar('\u25CF');
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel2.add(password);
        password.setBounds(20, 220, 270, 30);

        jLabel2.setBackground(new java.awt.Color(31, 33, 35));
        jLabel2.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 255));
        jLabel2.setText("Password");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 180, 105, 24);

        uname.setBackground(new java.awt.Color(54, 33, 89));
        uname.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        uname.setForeground(new java.awt.Color(255, 255, 255));
        uname.setAlignmentY(0.0F);
        uname.setBorder(null);
        uname.setCaretColor(Color.WHITE);
        uname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                unameKeyTyped(evt);
            }
        });
        jPanel2.add(uname);
        uname.setBounds(20, 140, 270, 30);

        exit.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(102, 153, 255));
        exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit.setIcon(new javax.swing.ImageIcon("D:\\FinalProject\\DataSecurity\\Images\\exit_logo.jpg")); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitMouseReleased(evt);
            }
        });
        jPanel2.add(exit);
        exit.setBounds(310, 10, 20, 20);

        jLabel1.setBackground(new java.awt.Color(31, 33, 35));
        jLabel1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("Username");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 100, 105, 28);

        ok.setBackground(new java.awt.Color(102, 153, 255));
        ok.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ok.setForeground(new java.awt.Color(255, 255, 255));
        ok.setText("LOGIN");
        ok.setBorder(null);
        ok.setBorderPainted(false);
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        jPanel2.add(ok);
        ok.setBounds(20, 270, 290, 35);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(20, 170, 290, 2);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(20, 250, 290, 10);

        sp.setIcon(new javax.swing.ImageIcon("D:\\FinalProject\\DataSecurity\\Images\\showpass.jpg")); // NOI18N
        sp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spMouseClicked(evt);
            }
        });
        jPanel2.add(sp);
        sp.setBounds(290, 230, 24, 20);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(550, 0, 340, 410);

        jLabel3.setIcon(new javax.swing.ImageIcon("D:\\FinalProject\\DataSecurity\\Images\\logcrypt.png")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 550, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
       String p=new String(password.getPassword());
       String u=uname.getText();
        boolean b=false;
        try {
            ResultSet rs=st.executeQuery("select * from user"); 
            while(rs.next())
            {
                if(u.equalsIgnoreCase(rs.getString("Username"))&&p.equals(rs.getString("Password")))
                {
                    new Decrypt(u).setVisible(true);
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(null,"Login successful");
                    b=true;
                       JOptionPane.showMessageDialog(null,"Click on Open to open a encrypted text");
                    break;
                }
            }
            if(!b)
                JOptionPane.showMessageDialog(null,"Invalid Username or Password");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }//GEN-LAST:event_okActionPerformed

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
      if((evt.getModifiers()&InputEvent.BUTTON1_MASK)!=0)
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void unameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unameKeyTyped
     char c=evt.getKeyChar();
     if(Character.isLowerCase(c))
     {
        c=Character.toUpperCase(c);
        evt.setKeyChar(c);
     }
     
   
    }//GEN-LAST:event_unameKeyTyped

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
       if((evt.getModifiers()&InputEvent.BUTTON1_MASK)!=0)
          System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_exitMousePressed

    private void exitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseReleased
        if((evt.getModifiers()&InputEvent.BUTTON1_MASK)!=0)
            System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_exitMouseReleased
    
    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
       exit.setIcon(new ImageIcon("D:\\FinalProject\\DataSecurity\\Images\\exit_glow.jpg"));
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
       exit.setIcon(new ImageIcon("D:\\FinalProject\\DataSecurity\\Images\\exit_logo.jpg"));
    }//GEN-LAST:event_exitMouseExited
    boolean spb=false;
    
    private void spMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spMouseClicked
        if((evt.getModifiers()&InputEvent.BUTTON1_MASK)!=0)
        {
          if(!spb)
         {
             password.setEchoChar((char)0);
          sp.setIcon(new javax.swing.ImageIcon("D:\\FinalProject\\DataSecurity\\Images\\hidepass.jpg"));
         }
         else
         {
            password.setEchoChar('\u25CF');
           sp.setIcon(new javax.swing.ImageIcon("D:\\FinalProject\\DataSecurity\\Images\\showpass.jpg"));  
         }
         spb=!spb;
        }
        
    }//GEN-LAST:event_spMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login l;
               
                    l = new Login();
                    l.setVisible(true);
               
                
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton ok;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel sp;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}