/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ap.todoapp;

//import be.ap.todolist.BLL.Controller;
//import be.ap.todolist.BLL.Todo;

import edu.ap.todoapp.models.Todo;
import edu.ap.todoapp.repos.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Jasper
 */
@Service
public class UI extends javax.swing.JFrame {

    TodoRepository todoRepository;
    private List<Todo> todos;

    private Todo todoBeingEdited;
    @Autowired
    public UI(TodoRepository todoRepository) {

        this.todoRepository = todoRepository;

        initComponents();
        this.showTable();

        btnAddTodoItem.addActionListener(

                e -> {
                    if (this.todoBeingEdited == null){

                        Todo todo = new Todo(txtBeschrijving.getText(), chkStatus.isSelected());
                        todoRepository.save(todo);
                        this.showTable();
                    }
                    else {
                        todoBeingEdited.setBeschrijving(txtBeschrijving.getText());
                        todoBeingEdited.setStatus(chkStatus.isSelected());
                        todoRepository.save(todoBeingEdited);

                        this.showTable();
                    }

                }
        );
        btnNewTodoItem.addActionListener(
                e -> {
                    todoBeingEdited = null;
                    txtBeschrijving.setText("");
                    chkStatus.setSelected(false);
                }
        );
        btnEditTodoItem.addActionListener(
                e -> {
                    todoBeingEdited = (Todo)jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0);
                    txtBeschrijving.setText(todoBeingEdited.getBeschrijving());
                    chkStatus.setSelected(todoBeingEdited.isStatus());
                }
        );
        btnDeleteTodoItem.addActionListener(
                e -> {
                    Todo todo = (Todo)jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0);
                    todoRepository.delete(todo);
                    this.showTable();
                }
        );
    }

    private void showTable() {

        todos = todoRepository.findAll();

        jTable1.setModel(new DefaultTableModel(getRows(), getCols()));
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));
    }

    private void showErrorDialog(String message) {
        this.showErrorDialog(message, "Error");
    }

    private void showErrorDialog(String message, String title) {
        JOptionPane.showMessageDialog(this,
                message,
                title,
                JOptionPane.ERROR_MESSAGE);
    }

    private void showSQLExceptionMsgBox() {
        this.showErrorDialog("db error");
    }

    private void showIOExceptionMsgBox() {
        this.showErrorDialog("io error");
    }

    private void showClassNotFoundMsgBox() {
        this.showErrorDialog("class not found error");
    }

    private Object[] getCols() {
        Object[] columns = {"object", "Beschrijving", "Status"};
        return columns;
    }

    private Object[][] getRows() {
        Object[][] data = new Object[todos.size()][2];
        int i = 0;

        for (Todo t : todos) {
            data[i] = new Object[]{
                    t,
                    t.getBeschrijving(),
                    t.isStatus() ? "Finished" : "Unfinished",
            };
            i++;
        }
        return data;
    }

    private void initComponents() {

        btnNewTodoItem = new javax.swing.JButton();
        btnAddTodoItem = new javax.swing.JButton();
        txtBeschrijving = new javax.swing.JTextField();
        chkStatus = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEditTodoItem = new javax.swing.JButton();
        btnDeleteTodoItem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNewTodoItem.setText("New");
        btnAddTodoItem.setText("Save");
        btnEditTodoItem.setText("Edit");
        btnDeleteTodoItem.setText("Delete");

        btnAddTodoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        chkStatus.setText("done");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtBeschrijving, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(chkStatus))
                                        .addComponent(btnAddTodoItem)
                                        .addComponent(btnNewTodoItem)
                                        .addComponent(btnEditTodoItem)
                                        .addComponent(btnDeleteTodoItem))

                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(222, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(10, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNewTodoItem)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditTodoItem)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteTodoItem)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtBeschrijving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(chkStatus))
                                .addGap(18, 18, 18)
                                .addComponent(btnAddTodoItem)
                                .addGap(27, 27, 27)


                        )
        );
        jTable1.getTableHeader().setReorderingAllowed(false);
        pack();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }

    private javax.swing.JButton btnNewTodoItem;
    private javax.swing.JButton btnAddTodoItem;
    private javax.swing.JButton btnEditTodoItem;
    private javax.swing.JButton btnDeleteTodoItem;
    private javax.swing.JCheckBox chkStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBeschrijving;
}
