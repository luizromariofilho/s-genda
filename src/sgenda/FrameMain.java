package sgenda;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rmi.PhoneBookEntry;
import rmi.PhoneBookServerInterface;

/**
 *
 * @author Luiz
 */
public class FrameMain extends javax.swing.JFrame {

    private PhoneBookServerInterface stub;
    private Status status;
    private List<PhoneBookEntry> list = new ArrayList<>();
    private PhoneTableModel phoneTableModel = new PhoneTableModel();
    private PhoneBookEntry phoneBookEntry;

    public FrameMain() {

        String host = null;//(args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            stub = (PhoneBookServerInterface) registry.lookup("ServerInterface");

            // Simular primeiros itens
            PhoneBookEntry entry1 = new PhoneBookEntry("Danilo", "Lopes", "88091386");
            PhoneBookEntry entry2 = new PhoneBookEntry("Danilo2", "Lopes", "88091381");
            PhoneBookEntry entry3 = new PhoneBookEntry("Danilo3", "Lopes", "88091382");

            stub.addEntry(entry1);
            stub.addEntry(entry2);
            stub.addEntry(entry3);

            initComponents();
            setStatus(Status.NEW);
            
            loadTable();
        } catch (RemoteException | NotBoundException e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    private void loadTable() throws RemoteException {
        list = stub.getPhoneBook();
        phoneTableModel = new PhoneTableModel(list);
        this.tblPhones.setModel(phoneTableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSobrenome = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        fmtTelefone = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhones = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("S-Genda - Stenio's Agenda RMI");
        setName("FrameMain"); // NOI18N
        setResizable(false);

        jLabel1.setText("Nome");

        jLabel2.setText("Sobrenome");

        jLabel3.setText("Telefone");

        tblPhones.setModel(phoneTableModel);
        tblPhones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPhones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhonesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhones);
        tblPhones.setColumnModel(tblPhones.getColumnModel());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnDelete.setText("Excluir");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setText("Salvar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Editar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnNew.setText("Novo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(fmtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fmtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (onSave()) {
            save(this.phoneBookEntry);
            setStatus(Status.NEW);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        this.phoneBookEntry = new PhoneBookEntry();
        setStatus(Status.UPDATE);
        clearFields();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        populateFields(this.phoneBookEntry);
        this.txtNome.setEnabled(true);
        this.txtSobrenome.setEnabled(true);
        this.fmtTelefone.setEnabled(true);
        this.btnSave.setEnabled(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblPhonesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhonesMouseClicked
        try {
            setStatus(Status.SELECT);
            this.phoneBookEntry = stub.getPhoneBook().get(tblPhones.getSelectedRow());
        } catch (RemoteException ex) {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblPhonesMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Deseja remover o número " + this.phoneBookEntry.getTelefone());
        if (showConfirmDialog == JOptionPane.YES_OPTION) {
            try {
                stub.deleteEntry(this.phoneBookEntry);
                loadTable();
                setStatus(Status.NEW);
            } catch (RemoteException ex) {
                Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void managerStatus() {
        switch (this.status) {
            case NEW:
                this.btnDelete.setEnabled(false);
                this.btnUpdate.setEnabled(false);
                this.btnSave.setEnabled(false);
                this.txtNome.setEnabled(false);
                this.txtSobrenome.setEnabled(false);
                this.fmtTelefone.setEnabled(false);
                clearFields();
                break;
            case UPDATE:
                this.btnSave.setEnabled(true);
                this.txtNome.setEnabled(true);
                this.txtSobrenome.setEnabled(true);
                this.fmtTelefone.setEnabled(true);
                break;
            case SELECT:
                this.btnDelete.setEnabled(true);
                this.btnUpdate.setEnabled(true);
                break;
        }
    }

    private void setStatus(Status status) {
        this.status = status;
        managerStatus();
    }

    private Boolean onSave() {
        if (validateFields()) {
            return Boolean.TRUE;
        } else {
            JOptionPane.showMessageDialog(null, "Campos inválidos.", "titulo", JOptionPane.ERROR_MESSAGE);
            return Boolean.FALSE;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JFormattedTextField fmtTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPhones;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSobrenome;
    // End of variables declaration//GEN-END:variables

    private boolean validateFields() {
        return !(txtNome.getText() == null || txtNome.getText().isEmpty()
                || txtSobrenome.getText() == null || txtSobrenome.getText().isEmpty()
                || fmtTelefone.getText() == null || fmtTelefone.getText().isEmpty());
    }

    private void save(PhoneBookEntry phoneBookEntry) {
        populateObject(phoneBookEntry);
        try {
            if (phoneBookEntry.getId() == 0) {
                stub.addEntry(phoneBookEntry);
            } else {
                stub.modifyEntry(phoneBookEntry);
            }
            loadTable();
        } catch (RemoteException ex) {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        setStatus(Status.NEW);
        clearFields();
    }

    private void populateObject(PhoneBookEntry phoneBookEntry) {
        phoneBookEntry.setNome(txtNome.getText());
        phoneBookEntry.setSobrenome(txtSobrenome.getText());
        phoneBookEntry.setTelefone(fmtTelefone.getText());
    }

    private void clearFields() {
        phoneBookEntry = new PhoneBookEntry();
        populateFields(phoneBookEntry);
    }

    private void populateFields(PhoneBookEntry phoneBookEntry) {
        txtNome.setText(phoneBookEntry.getNome());
        txtSobrenome.setText(phoneBookEntry.getSobrenome());
        fmtTelefone.setText(phoneBookEntry.getTelefone());
    }

}
