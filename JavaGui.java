import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// class JavaGui implements ActionListener{
//     public JFrame frame;
//     public JLabel label;
//     public JButton button;
//     boolean status = true;


//     public JavaGui() {
//         frame = new JFrame("GUI class");
//         frame.setBackground(Color.MAGENTA);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setLocationRelativeTo(null);
//         frame.setResizable(true);
//         // frame.setSize(new Dimension(300, 500));
//         // Different type of layout
//         // Grid Layout
//         // Flow Layout
//         // Border Layouut
//         frame.setLayout(new FlowLayout());
//         label =  new JLabel("This is java class");
//         frame.add(label);
//         button =  new JButton("Change Text");
//         button.addActionListener(this);
//         frame.add(button);
//         frame.setVisible(true);
//         frame.pack();
//     }

//     public void actionPerformed(ActionEvent e) {
//         if(status) {
//             label.setText("The label text was updated.");
//             status = false;
//         }else {
//             label.setText("This is java class.");
//             status = true;
//         }
//     }

//     public static void main(String[] args) {
//         JavaGui jg = new JavaGui();
//     }
// }

class JavaGui implements ActionListener{
    public JFrame frame;
    public JPanel panel1, panel2;
    public JTextField screen1, screen2;
    public JButton plus, minus, multiply, divide, equal;
    public JLabel label, result;
    public String operator;
    public double value1, value2;

    public JavaGui() {
        frame = new JFrame("GUI class");
        frame.setBackground(Color.MAGENTA);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        panel1 = new JPanel(new FlowLayout());
        panel2 = new JPanel(new FlowLayout());
        screen1 = new JTextField(10);
        panel1.add(screen1);
        label = new JLabel("+");
        panel1.add(label);
        screen2 = new JTextField(10);
        panel1.add(screen2);
        result = new JLabel("=");
        panel1.add(result);

        plus = new JButton("+");
        plus.addActionListener(this);
        panel2.add(plus);
        minus = new JButton("-");
        minus.addActionListener(this);
        panel2.add(minus);
        multiply = new JButton("*");
        multiply.addActionListener(this);
        panel2.add(multiply);
        divide = new JButton("/");
        divide.addActionListener(this);
        panel2.add(divide);
        equal = new JButton("=");
        equal.addActionListener(this);
        panel2.add(equal);
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.pack();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("=")) {
            try {
                value1 = Double.parseDouble(screen1.getText());
                value2 = Double.parseDouble(screen2.getText());
            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Illegal operation, enter only number");
            }
            if(operator.equals("+")) {
                result.setText((value1 + value2) + "");
            }else if(operator.equals("-")){
                result.setText((value1 - value2) + "");
            }else if(operator.equals("*")){
                result.setText((value1 * value2) + "");
            }else if(operator.equals("/")){
                result.setText((value1 / value2) + "");
            }
        }else {
            operator = e.getActionCommand();
            label.setText(operator);
        }
    }

    public static void main(String[] args) {
        JavaGui jg = new JavaGui();
    }
}