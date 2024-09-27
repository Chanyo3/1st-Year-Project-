import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class Student {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    private String name;
    private String age;
    private String idNumber;
    public Student(String name, String age, String idNUmber){
        this.name = name;
        this.age = age;
        this.idNumber = idNUmber;
    }
}

public class MainFunction{
    public MainFunction(){
        JFrame frame = null;
        try {
            //Frame
            frame = new JFrame("Student Information");
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setBounds(300, 180, 700, 400);
            frame.setResizable(false);
            //Panel
            JPanel panel = new JPanel();
            panel.setBounds(5, 5, 690, 390);
            frame.add(panel);
            panel.setVisible(true);
            panel.setLayout(null);
            //Label
            JLabel label = new JLabel();
            label.setText("Student Information");
            label.setBounds(250, 0, 200, 50);
            label.setFont(new Font("Georgia", Font.PLAIN, 20));
            label.setVisible(true);
            panel.add(label);
            //Button to insert
            JButton insertButton = new JButton();
            insertButton.setBounds(240, 280, 100, 50);
            insertButton.setText("Input");
            insertButton.setFont(new Font("Georgia", Font.PLAIN, 20));
            panel.add(insertButton);
            insertButton.setVisible(true);
            //Delete Button
            JButton deleteButton = new JButton();
            deleteButton.setBounds(350, 280, 100, 50);
            deleteButton.setText("Delete");
            deleteButton.setFont(new Font("Georgia", Font.PLAIN, 20));
            panel.add(deleteButton);
            deleteButton.setVisible(true);
            //Data for student
            String[] columnName = {"No.","Student Name","Age","ID Number"};
            DefaultTableModel model = new DefaultTableModel(columnName, 0);
            model.addRow(new String[]{"1","Yohance", "19", "2310517"});
            //Table to display data
            JTable table = new JTable(model) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table.setRowHeight(25);
            table.setFont(new Font("Georgia", Font.PLAIN, 16));
            table.setVisible(true);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(1).setPreferredWidth(327);
            table.getColumnModel().getColumn(2).setPreferredWidth(80);
            table.getColumnModel().getColumn(3).setPreferredWidth(200);
            DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
            cellRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
            table.getTableHeader().setResizingAllowed(false);
            table.getTableHeader().setBackground(Color.white);
            table.getTableHeader().setFont(new Font("Georgia", Font.PLAIN, 16));
            table.getTableHeader().setReorderingAllowed(false);
            //insert button function
            insertButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String name = "";
                    while(true){
                        name = JOptionPane.showInputDialog("Input name");
                        if(name.equalsIgnoreCase("")){
                            JOptionPane.showMessageDialog(null,"Input name");
                            continue;
                        }
                        break;
                    }
                    String age="";
                    while(true){
                        age = JOptionPane.showInputDialog("Input age");
                        try{
                            if(age.equalsIgnoreCase("")){
                                JOptionPane.showMessageDialog(null,"Input age");
                                continue;
                            }
                            int intAge = Integer.parseInt(age);
                            break;
                        }
                        catch(NumberFormatException error){
                            JOptionPane.showMessageDialog(null,"Input number for age");
                        }
                    }
                    String idNumber="";
                    while(true){
                        idNumber = JOptionPane.showInputDialog("Input given ID Number");
                        try{
                            if(idNumber.equalsIgnoreCase("")){
                                JOptionPane.showMessageDialog(null,"Input given ID Number");
                                continue;
                            }
                            int intIdNumber = Integer.parseInt(idNumber);
                            break;
                        }
                        catch(NumberFormatException error){
                            JOptionPane.showMessageDialog(null,"Input number for ID Number");
                        }
                    }
                    int studentNumber = table.getRowCount()+1;
                    String stringStudentNumber = Integer.toString(studentNumber);
                    String[] newRow={stringStudentNumber,name, age, idNumber};
                    model.addRow(newRow);
                }
            });
            deleteButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    int row;
                    String stringRow = "";
                    while(true){
                        try{
                            if(table.getRowCount() == 0){
                                JOptionPane.showMessageDialog(null, "Table data is empty");
                                break;
                            }
                            stringRow = JOptionPane.showInputDialog("Input row number to delete");
                            if(Integer.parseInt(stringRow) > table.getRowCount()){
                                JOptionPane.showMessageDialog(null,"Input number less than the numbers of row");
                                continue;
                            }
                            else if(Integer.parseInt(stringRow) < 1){
                                JOptionPane.showMessageDialog(null,"Input number greater than the numbers of row");
                                continue;
                            }
                            row = Integer.parseInt(stringRow);
                            model.removeRow(Integer.parseInt(stringRow)-1);
                            break;
                        }
                        catch(NumberFormatException  error){
                            if(stringRow.equalsIgnoreCase("")){
                                JOptionPane.showMessageDialog(null,"Input row number");
                                continue;
                            }
                            JOptionPane.showMessageDialog(null,"Input number for row");
                        }
                    }
                }
            });
            //Java scroll pane to display table
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(17, 50, 660, 230);
            frame.add(scrollPane);
            scrollPane.setVisible(true);
            scrollPane.setFont(new Font("Georgia", Font.PLAIN, 20));
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Frame did not run");
            frame.dispose();
        }
    }
    public static void main(String[]args) {
        try{
            new MainFunction();
        }
        catch(Exception error){
            JOptionPane.showMessageDialog("Error, run again");
        }
    }
}
