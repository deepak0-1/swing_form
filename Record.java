import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Record extends JFrame implements ActionListener
{

    private static DAO db = new DAO();

    JLabel label_id = new JLabel("ID");
    JTextField txt_id = new JTextField();

    JLabel label_name = new JLabel("Name");
    JTextField txt_name = new JTextField();

    JLabel label_age = new JLabel("Age");
    JTextField txt_age = new JTextField();

    JLabel label_salary = new JLabel("Salary");
    JTextField txt_salary= new JTextField();

    JLabel label_address=new JLabel("Address");
    JTextArea txt_address=new JTextArea();

    Record(){

        JPanel panl_records = new JPanel(new GridLayout(5,2,10,10));

        panl_records.setBounds(60,110,210,40);

        label_id.setBounds(50,100, 200,30);
        txt_id.setPreferredSize( new Dimension( 150, 15 ) );
        label_name.setBounds(50,100, 200,30);
        txt_name.setPreferredSize( new Dimension( 150, 15 ) );
        label_age.setBounds(50,100, 200,30);
        txt_age.setPreferredSize( new Dimension( 150, 24 ) );
        label_salary.setBounds(70,100,200,30);
        txt_salary.setPreferredSize( new Dimension( 150, 24 ) );
        label_address.setBounds(90,100,200,30);
        txt_address.setPreferredSize( new Dimension( 150, 25 ) );

        panl_records.add(label_id);
        panl_records.add(txt_id);
        panl_records.add(label_name);
        panl_records.add(txt_name);
        panl_records.add(label_age);
        panl_records.add(txt_age);
        panl_records.add(label_salary);
        panl_records.add(txt_salary);
        panl_records.add(label_address);
        panl_records.add(txt_address);

        JPanel panl_buttons = new JPanel(new GridLayout(2,4,5,5));

        JButton b[] = new JButton[8];

        for(int i=0;i<b.length;i++) {
            b[i] = new JButton();
            b[i].setPreferredSize( new Dimension(80,30) );
            b[i].addActionListener(this);
            panl_buttons.add(b[i]);
        }

        b[1].setLabel("Save");
        b[2].setLabel("Delete");
        b[4].setLabel("First");
        b[5].setLabel("Prev");
        b[6].setLabel("Next");
        b[7].setLabel("Last");

//        b[1].addActionListener( ae ->  {
//                    DAO db = new DAO();
//                    String name = txt_name.getText().toString(),
//                            address = txt_address.getText().toString();
//                    int age = Integer.parseInt( txt_age.getText() ),
//                            salary = Integer.parseInt( txt_salary.getText() );
//                    try{
//                        db.insert(name, age, salary, address);
//                    } catch(Exception e) { System.out.println(e); }
//                }
//        );

        add(panl_records);
        add(panl_buttons);
        setSize(400,350);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }



    public static void main(String... abc) {
       Record r= new Record();

    }

//    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println(e.getActionCommand());
        switch (e.getActionCommand()){
            case "Save" :
                            int id = Integer.parseInt(txt_id.getText());
                            String name = txt_name.getText().toString(),
                            address = txt_address.getText().toString();
                            int age = Integer.parseInt( txt_age.getText() ),
                            salary = Integer.parseInt( txt_salary.getText() );
                            db.insert(id,name, age, salary, address);
                            break;
            case "Delete" :
                int id1 = Integer.parseInt(txt_id.getText());
                            db.delete(id1);
                            break;

        }

    }
}