/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encryption;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;

import java.awt.Container;
import java.io.BufferedReader;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import Encryption.ColorE;
/**
 *
 * @author The Programmer
 */
public class Encryption extends javax.swing.JFrame {

    /**
     * Creates new form Encryption
     */
    Container con;
         Statement st,st1,st2;  
         String user;
         Details dialog;
    public Encryption(String us) throws SQLException, ClassNotFoundException {
       initComponents();
         c_user.setText(us);
        dialog = new Details(new javax.swing.JFrame(), true,us);
         user=us;
        setBackground(new Color(0,0,51));
        getMac();
       try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cryptography","root","");  
        st=con.createStatement();
        int id=0;
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         LocalDateTime now = LocalDateTime.now();
       String date=""+dtf.format(now);
        st1=con.createStatement();
        st2=con.createStatement();
        ResultSet rs=st.executeQuery("select UID from user where Username = '"+us+"';");
       
        
         if(rs.next())
         {
             id=rs.getInt("UID");
             System.out.println(1);
             
         }
         System.out.println(2);
         
         ResultSet rs1=st2.executeQuery("select MAC from enc_info where UID = "+id+"");
         
         boolean find=false,NEW=true;
         while(rs1.next())
         {
            NEW=false;
             String mac=rs1.getString("MAC");
             
             if(!(mac.equals(c_mac.getText())))
             {
               find=true;
             }
             else
               find=false;
                 
         }
         if(find)
             st1.execute("insert into enc_info values (null,'"+id+"','"+c_mac.getText()+"','"+c_ip.getText()+"','Encryption','"+date+"')");
         else if(!find&&NEW)
             st1.execute("insert into enc_info values (null,'"+id+"','"+c_mac.getText()+"','"+c_ip.getText()+"','Encryption','"+date+"')");
             
         System.out.println(3);
         
         
         
         
     //   ResultSet rs=st.executeQuery("insert into info "); 
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e);
           e.printStackTrace();
       }
        
    }
    public Encryption() {
        setBackground(new Color(0,0,51));
    }
    public void getMac(){

          InetAddress ip;
           try {
                 ip = InetAddress.getLocalHost();
                 System.out.println("Current IP address : " + ip.getHostAddress());
                 c_ip.setText( ip.getHostAddress());
                 NetworkInterface network = NetworkInterface.getByInetAddress(ip);

                 byte[] mac = network.getHardwareAddress();
 
                

                 StringBuilder sb = new StringBuilder();
                 try{
                 for (int i = 0; i < mac.length; i++) {
                     sb.append(String.format("%02X%s", mac[i], (i < (mac.length - 1)) ? "-" : ""));
                }
                 }
                 catch(Exception eg)
                 {
                     JOptionPane.showMessageDialog(null, "Please connect internet");
                     System.exit(0);
                 }
                 c_mac.setText(sb.toString());
                } catch (UnknownHostException e) {
                         e.printStackTrace();
             } catch (SocketException e){
                  e.printStackTrace();}
          
        
          

}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtb = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        plain = new javax.swing.JTextArea();
        enc = new javax.swing.JButton();
        count = new javax.swing.JLabel();
        c_user2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cipher = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        c_user = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        c_mac = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        c_ip = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jButton7 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jButton8 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        change_color = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Encryption");
        setBackground(new java.awt.Color(214, 217, 223));
        setLocation(new java.awt.Point(245, 10));
        setMaximumSize(new java.awt.Dimension(802, 674));
        setMinimumSize(new java.awt.Dimension(802, 674));
        setPreferredSize(new java.awt.Dimension(802, 674));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jtb.setBackground(new java.awt.Color(50, 64, 149));
        jtb.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jtbStateChanged(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 102, 137));
        jPanel3.setLayout(null);

        plain.setColumns(20);
        plain.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        plain.setRows(5);
        plain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));
        plain.setMargin(new java.awt.Insets(5, 5, 5, 5));
        plain.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                plainKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(plain);
        plain.setLineWrap(true);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(97, 55, 600, 414);

        enc.setBackground(new java.awt.Color(102, 153, 255));
        enc.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        enc.setForeground(new java.awt.Color(255, 255, 255));
        enc.setText("Encrypt");
        enc.setOpaque(false);
        enc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encActionPerformed(evt);
            }
        });
        jPanel3.add(enc);
        enc.setBounds(323, 480, 180, 50);

        count.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        count.setForeground(new java.awt.Color(255, 255, 255));
        count.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        count.setText("0");
        jPanel3.add(count);
        count.setBounds(210, 470, 90, 30);

        c_user2.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        c_user2.setForeground(new java.awt.Color(255, 255, 255));
        c_user2.setText("Total Characters : ");
        jPanel3.add(c_user2);
        c_user2.setBounds(100, 470, 120, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 255));
        jLabel3.setText("Plain Text  ( Normal text )");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(97, 19, 269, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\FinalProject\\DataSecurity\\Images\\swback.jpg")); // NOI18N
        jPanel3.add(jLabel1);
        jLabel1.setBounds(-10, 0, 810, 590);

        jtb.addTab("Plain Text", jPanel3);

        jPanel1.setBackground(new java.awt.Color(0, 102, 137));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 255));
        jLabel2.setText("Cipher Text  ( Encrypted text )");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(97, 19, 317, 30);

        cipher.setColumns(20);
        cipher.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        cipher.setRows(5);
        cipher.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));
        cipher.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jScrollPane2.setViewportView(cipher);
        cipher.setLineWrap(true);
        cipher.setEditable(false);
        //cipher.setEditable(false);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(97, 55, 600, 380);

        jLabel11.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 255, 0));
        jLabel11.setText(" User Name    :");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(100, 460, 110, 30);

        c_user.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        c_user.setForeground(new java.awt.Color(255, 255, 255));
        c_user.setText("Current_user");
        jPanel1.add(c_user);
        c_user.setBounds(220, 460, 120, 30);

        jLabel12.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 255, 0));
        jLabel12.setText("MAC Address :");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(100, 490, 110, 30);

        c_mac.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        c_mac.setForeground(new java.awt.Color(255, 255, 255));
        c_mac.setText("MAC");
        jPanel1.add(c_mac);
        c_mac.setBounds(220, 490, 220, 30);

        jLabel13.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 255, 0));
        jLabel13.setText("IP Address      :");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(100, 520, 110, 30);

        c_ip.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        c_ip.setForeground(new java.awt.Color(255, 255, 255));
        c_ip.setText("IP");
        jPanel1.add(c_ip);
        c_ip.setBounds(220, 520, 120, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon("D:\\FinalProject\\DataSecurity\\Images\\swback.jpg")); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 800, 590);

        jtb.addTab("Cipher text", jPanel1);

        getContentPane().add(jtb);
        jtb.setBounds(0, 42, 800, 620);

        jToolBar1.setBackground(new java.awt.Color(0, 102, 137));
        jToolBar1.setForeground(new java.awt.Color(217, 217, 223));
        jToolBar1.setRollover(true);
        jToolBar1.setOpaque(false);

        jButton3.setIcon(new javax.swing.ImageIcon("D:\\FinalProject\\DataSecurity\\Images\\OPENI.png")); // NOI18N
        jButton3.setToolTipText("Open");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);
        jToolBar1.add(jSeparator4);

        jButton5.setIcon(new javax.swing.ImageIcon("D:\\FinalProject\\DataSecurity\\Images\\saveicon.jpg")); // NOI18N
        jButton5.setToolTipText("Save");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);
        jToolBar1.add(jSeparator5);

        jButton7.setIcon(new javax.swing.ImageIcon("D:\\FinalProject\\DataSecurity\\Images\\gmail_ic.jpg")); // NOI18N
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);
        jToolBar1.add(jSeparator6);

        jButton8.setIcon(new javax.swing.ImageIcon("D:\\FinalProject\\DataSecurity\\Images\\rsz_1log.png")); // NOI18N
        jButton8.setToolTipText("Logs");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);
        jToolBar1.add(jSeparator8);

        change_color.setIcon(new javax.swing.ImageIcon("D:\\FinalProject\\DataSecurity\\Images\\color_ic.png")); // NOI18N
        change_color.setToolTipText("Change Color");
        change_color.setFocusable(false);
        change_color.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        change_color.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        change_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_colorActionPerformed(evt);
            }
        });
        jToolBar1.add(change_color);

        jLabel15.setText("                                                                                                                             ");
        jLabel15.setMaximumSize(new java.awt.Dimension(410, 14));
        jLabel15.setMinimumSize(new java.awt.Dimension(410, 14));
        jLabel15.setPreferredSize(new java.awt.Dimension(430, 14));
        jToolBar1.add(jLabel15);

        jButton6.setIcon(new javax.swing.ImageIcon("D:\\FinalProject\\DataSecurity\\Images\\LOF.jpg")); // NOI18N
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        getContentPane().add(jToolBar1);
        jToolBar1.setBounds(0, 0, 802, 40);
        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void encActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encActionPerformed
        try {
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(128); // The AES key size in number of bits
            SecretKey secKey = generator.generateKey();
            
            String plainText = plain.getText();
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
            byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
            ciphertxt = byteCipherText;
            saveF("Save Encrypted text",byteCipherText);
           
            System.out.println("Encrypted \n"+new String(byteCipherText));
            cipher.setText(new String(byteCipherText));
            jtb.setSelectedIndex(1);

           
       
            
             File file = new File(openF("Open Public Key File"));
            PublicKey puKey =  KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(readContentIntoByteArray(file)));
//            PrivateKey prKey = keyPair.getPrivate();
            
            
//            saveF("Save Private Key",prKey.getEncoded());
            
            
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.PUBLIC_KEY, puKey);
            byte[] encryptedKey = cipher.doFinal(secKey.getEncoded()/*Seceret Key From Step 1*/);
               
           saveF("Save Encrypted Key",encryptedKey);
           
            ColorE ce = new ColorE();
            ce.setVisible(true);
      
           
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_encActionPerformed
    byte[] byteCipherText;
    public String openF(String s)
  {
                FileDialog dlg=new FileDialog(this,s,FileDialog.LOAD);

	
          dlg.setFile("*.txt");
	           dlg.setVisible(true);
//	           System.out.print(""+dlg.getDirectory()+dlg.getFile());
                   return (""+dlg.getDirectory()+dlg.getFile());

  }
 public void saveF(String s,byte[] b)
  {
      
      OutputStream os=null;
        try {
            FileDialog dlg=new FileDialog(this,s,FileDialog.SAVE);
            dlg.setFile("*.txt");
            dlg.setVisible(true);
            //	           System.out.print(""+dlg.getDirectory()+dlg.getFile());
            String FILEPATH = ""+dlg.getDirectory()+dlg.getFile();
            if(!FILEPATH.endsWith(".txt"))
                FILEPATH  =FILEPATH + ".txt";
                    File file = new File(FILEPATH);
            os = new FileOutputStream(file);
            os.write(b);
            os.close(); 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                os.close();
            } catch (IOException ex) {
                Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


  }
  
    private static byte[] readContentIntoByteArray(File file)
   {
      FileInputStream fileInputStream = null;
      byte[] bFile = new byte[(int) file.length()];
      try
      {
         //convert file into array of bytes
         fileInputStream = new FileInputStream(file);
         fileInputStream.read(bFile);
         fileInputStream.close();
//         for (int i = 0; i < bFile.length; i++)
//         {
//            System.out.print((char) bFile[i]);
//         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return bFile;
   }
    public static byte[] encrypt(PublicKey privateKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);  

        return cipher.doFinal(message.getBytes());  
    }
    
    private void jtbStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jtbStateChanged
     
    }//GEN-LAST:event_jtbStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      openM();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        saveF("Save Encrypted Text", ciphertxt);
    }//GEN-LAST:event_jButton5ActionPerformed
 byte []ciphertxt;
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int n=JOptionPane.showConfirmDialog(null,"Are you sure you want to logout?");
        if(n==0)
        {

            try {
                new Login().setVisible(true);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.dispose();

        }

    }//GEN-LAST:event_jButton6ActionPerformed
 long counter=0;
    private void plainKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_plainKeyTyped
         counter++;
         count.setText(""+((plain.getText().length())+1));
         
    }//GEN-LAST:event_plainKeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      Email dialog = new Email(new javax.swing.JFrame(), true);
        dialog.setVisible(true);   
         
    }//GEN-LAST:event_jButton7ActionPerformed
 
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      JOptionPane.showMessageDialog(null, "Click on Logout Button");
    }//GEN-LAST:event_formWindowClosing

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
                 dialog.setVisible(true);
            System.out.println("CH");
       
    }//GEN-LAST:event_jButton8ActionPerformed

    private void change_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_colorActionPerformed
        ColorChooser cc = new ColorChooser(c_user.getText());
        cc.setVisible(true);
    }//GEN-LAST:event_change_colorActionPerformed
    public void saveM()
       {
        
        
        }
 public void openM()
   {
       try{
    FileDialog chooser=new FileDialog(this,"Choose a file",FileDialog.LOAD);
    chooser.setDirectory(".");
    chooser.setFile("*.txt");
 
    chooser.setMultipleMode(false);
    chooser.setVisible(true);
      
       
       //&&file.contains(".txt")
           String file=chooser.getFile();
           if(!file.equals(null))
           {
               try
           {
               String s;
               plain.setText("");
           BufferedReader bf=new BufferedReader(new FileReader(chooser.getDirectory()+chooser.getFile()));
           s=bf.readLine();
           
         
           while(s!=null)
           {
               plain.append(s+"\n\r");
               s=bf.readLine();
                             
           }
           bf.close();
           }
           catch(Exception FN)
           {
               JOptionPane.showMessageDialog(null, "File Not Found");
           }
           }
           else
           {
               JOptionPane.showMessageDialog(null,"You are try to open wrong file");
           }
       }
       catch(Exception eer)
       {
           
       }
       
   } 
    
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
            java.util.logging.Logger.getLogger(Encryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Encryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Encryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Encryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Encryption().setTitle("Encryption");
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel c_ip;
    public javax.swing.JLabel c_mac;
    public javax.swing.JLabel c_user;
    private javax.swing.JLabel c_user2;
    private javax.swing.JButton change_color;
    private javax.swing.JTextArea cipher;
    private javax.swing.JLabel count;
    private javax.swing.JButton enc;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTabbedPane jtb;
    private javax.swing.JTextArea plain;
    // End of variables declaration//GEN-END:variables
}
