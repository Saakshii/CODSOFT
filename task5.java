package codsoft;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class Student_Registration extends javax.swing.JFrame implements ActionListener {

    JFrame jFrame;
    JLabel jLabel_S1,jLabel_S2,jLabel_S3;
    JButton jButtonfirst, jButtonnext, jButtonprev, jButtonlast, jButtonnew, jButtoninsert, jButtonupdate, jButtondelete,jButtoncourse;
    JTextField jTextField_S1,jTextField_S2,jTextField_S3;



    Connection con;
    ResultSet rs;
    Statement st;
    Student_Registration () {
        jFrame = new JFrame();
        jFrame.setBounds(20, 20, 500, 500);
        jLabel_S1 = new JLabel();
        jLabel_S1.setText("SID");
        jLabel_S1.setBounds(30, 30, 90, 30);
        jLabel_S2 = new JLabel();
        jLabel_S2.setText("Name");
        jLabel_S2.setBounds(30, 80, 90, 30);
        jLabel_S3 = new JLabel();
        jLabel_S3.setText("Course");
        jLabel_S3.setBounds(30, 130, 90, 30);


        jTextField_S1 = new JTextField();
        jTextField_S1.setBounds(140, 30, 120, 30);
        jTextField_S2 = new JTextField();
        jTextField_S2.setBounds(140, 80, 120, 30);
        jTextField_S3 = new JTextField();
        jTextField_S3.setBounds(140, 130, 120, 30);


        jButtonfirst = new JButton();
        jButtonfirst.setText("First");
        jButtonfirst.setBounds(20, 210, 70, 20);

        jButtonnext = new JButton();
        jButtonnext.setText("Next");
        jButtonnext.setBounds(100, 210, 70, 20);

        jButtonprev = new JButton();
        jButtonprev.setText("Prev");
        jButtonprev.setBounds(180, 210, 80, 20);

        jButtonlast = new JButton();
        jButtonlast.setText("Last");
        jButtonlast.setBounds(270, 210, 80, 20);

        jButtonnew = new JButton();
        jButtonnew.setText("New");
        jButtonnew.setBounds(20, 250, 70, 20);

        jButtoninsert = new JButton();
        jButtoninsert.setText("Insert");
        jButtoninsert.setBounds(100, 250, 70, 20);

        jButtonupdate = new JButton();
        jButtonupdate.setText("Update");
        jButtonupdate.setBounds(180, 250, 80, 20);

        jButtondelete = new JButton();
        jButtondelete.setText("Delete");
        jButtondelete.setBounds(270, 250, 80, 20);

        jButtoncourse = new JButton();
        jButtoncourse.setText("Show Course");
        jButtoncourse.setBounds(100, 290, 200, 20);

        jFrame.add(jLabel_S1);
        jFrame.add(jLabel_S2);
        jFrame.add(jLabel_S3);

        jFrame.add(jTextField_S1);
        jFrame.add(jTextField_S2);
        jFrame.add(jTextField_S3);

        jFrame.add(jButtonfirst);
        jFrame.add(jButtonnext);
        jFrame.add(jButtonprev);
        jFrame.add(jButtonlast);
        jFrame.add(jButtonnew);
        jFrame.add(jButtoninsert);
        jFrame.add(jButtonupdate);
        jFrame.add(jButtondelete);
        jFrame.add(jButtoncourse);

        jFrame.setLayout(null);
        jFrame.setVisible(true);

        jButtonfirst.addActionListener(this);
        jButtonnext.addActionListener(this);
        jButtonprev.addActionListener(this);
        jButtonlast.addActionListener(this);
        jButtondelete.addActionListener(this);
        jButtonnew.addActionListener(this);
        jButtoninsert.addActionListener(this);
        jButtonupdate.addActionListener(this);
        jButtoncourse.addActionListener(this);
        connectToDB();
    }

    public void connectToDB()
    {
        try
        {
            //step 1 Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //step2 : establish the connection
            con = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/student_course_registration?useTimezone=true&serverTimezone=UTC",
                            "root",
                            "");
            getData();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void getData()
    {
        try
        {
            //Step3 create statement obj
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );

            //Step 4: fire the sql query to database
            rs = st.executeQuery("select * from student");
            if(rs.next() == true)
            {
                showData();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void getData1()
    {
        try
        {
            Connection con = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/student_course_registration?useTimezone=true&serverTimezone=UTC",
                            "root",
                            "");
            //Step3 create statement obj
            Statement st1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );

            //Step 4: fire the sql query to database
           String query = "select * from course";
           ResultSet rs1 = st1.executeQuery(query);
           StringBuilder data = new StringBuilder();

            while(rs1.next() == true)
            {
                String course_name=rs1.getString("course_name");
                String course_code = rs1.getString("course_code");
                String course_title = rs1.getString("course_title");
                String course_description = rs1.getString("course_description");
                int course_capacity = rs1.getInt("course_capacity");
                data.append("Course Name: ").append(course_name).append("Course Code: ").append(course_code).append("Course Title: ").append(course_title).append("Course Description: ").append(course_description).append("Capacity: ").append(course_capacity).append("\n");
            }
            JOptionPane.showMessageDialog(null,data.toString(),"Data from Xampp",JOptionPane.INFORMATION_MESSAGE);
            rs1.close();
            st1.close();
            con.close();



        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void showData()
    {
        try
        {
            jTextField_S1.setText(rs.getString(1));
            jTextField_S2.setText(rs.getString(2));
            jTextField_S3.setText(rs.getString(3));

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }



    public void clearALL()
    {
        jTextField_S1.setText("");
        jTextField_S2.setText("");
        jTextField_S3.setText("");

    }
    public void insertData()
    {
        try
        {
            int student_id;
            String name,course_name;
            student_id = Integer.parseInt(jTextField_S1.getText());
            name = jTextField_S2.getText();
            course_name = jTextField_S3.getText();
            String q = "insert into student values(" + student_id + ",'" + name + "','" + course_name + "');" ;
//                    System.out.println(q);
            int n = st.executeUpdate(q);
            if(n > 0)
            {
                JOptionPane.showMessageDialog(jFrame,"Data inserted SuccessFully");
                getData();
            }
            else
            {
                JOptionPane.showMessageDialog(jFrame,"Data insertion error ");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


    public void updateData()
    {
        try
        {
            int student_id;
            String name,course_name;
            student_id = Integer.parseInt(jTextField_S1.getText());
            name = jTextField_S2.getText();
            course_name = jTextField_S3.getText();
            String u = "update student set name= '"+name+"', course_name= '"+course_name+"' where student_id= "+student_id +";" ;
            System.out.println(u);
            int n = st.executeUpdate(u);
            if(n > 0)
            {
                JOptionPane.showMessageDialog(jFrame,"Data Updated SuccessFully");
                getData();
            }
            else
            {
                JOptionPane.showMessageDialog(jFrame,"Data updation error ");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void deleteData()
    {
        try
        {
            int student_id;
            student_id = Integer.parseInt(jTextField_S1.getText());
            String d = "delete from student where student_id= "+student_id +";" ;
            System.out.println(d);
            int n = st.executeUpdate(d);
            if(n > 0)
            {
                JOptionPane.showMessageDialog(jFrame,"Data deleted SuccessFully");
                getData();
            }
            else
            {
                JOptionPane.showMessageDialog(jFrame,"data delete error ");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try
        {
            if(e.getSource() == jButtonfirst)
            {
                if(rs.first() == true)
                {
                    showData();
                }
            }
            else if(e.getSource() == jButtonprev)
            {
                if(rs.previous() == true)
                {
                    showData();
                }
                else
                {
                    JOptionPane.showMessageDialog(jFrame,"First record ");
                }
            }
            else if(e.getSource() == jButtonnext)
            {
                if(rs.next() == true)
                {
                    showData();
                }
                else
                {
                    JOptionPane.showMessageDialog(jFrame,"Last record ");
                }
            }
            else if(e.getSource() == jButtonlast)
            {
                if(rs.last() == true)
                {
                    showData();
                }
            }
            else if(e.getSource() == jButtonnew)
            {
                clearALL();
            }
            else if(e.getSource() == jButtoninsert)
            {
                insertData();
            }
            else if(e.getSource() == jButtonupdate)
            {
                updateData();
            }
            else if(e.getSource() == jButtondelete)
            {
                deleteData();
            }
            else if(e.getSource() == jButtoncourse)
            {
                getData1();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
public class task5{
    public static void main(String[] args) {
        Student_Registration s = new Student_Registration();
    }
}
