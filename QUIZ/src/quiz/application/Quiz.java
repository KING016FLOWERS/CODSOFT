package QUIZ.src.quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class
Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit;
    
    public static int quizTimer = 300;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 750);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("QUIZ/src/icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "What is the size of an int data type in Java?";
        questions[0][1] = "8 bits";
        questions[0][2] = "16 bits";
        questions[0][3] = "32 bits";
        questions[0][4] = "64 bits";

        questions[1][0] = "Which of the following is not a Java keyword?";
        questions[1][1] = "static";
        questions[1][2] = "Boolean";
        questions[1][3] = "break";
        questions[1][4] = "extends";

        questions[2][0] = "What is the default value of a boolean variable in Java?";
        questions[2][1] = "true";
        questions[2][2] = "false";
        questions[2][3] = "0";
        questions[2][4] = "null";

        questions[3][0] = "Which method can be used to find the length of a string in Java?";
        questions[3][1] = "length()";
        questions[3][2] = "size()";
        questions[3][3] = "getSize()";
        questions[3][4] = "lengthOf()";

        questions[4][0] = "Which of these is a superclass of every class in Java?";
        questions[4][1] = "String";
        questions[4][2] = "Object";
        questions[4][3] = "Exception";
        questions[4][4] = "Thread";

        questions[5][0] = "What is the keyword used to inherit a class in Java?";
        questions[5][1] = "implement";
        questions[5][2] = "extends";
        questions[5][3] = "inherits";
        questions[5][4] = "overload";

        questions[6][0] = "What is the Output of this Code: System.out.println(10 + 20 + '30'); ?";
        questions[6][1] = "1030";
        questions[6][2] = "102030";
        questions[6][3] = "3030";
        questions[6][4] = "30";

        questions[7][0] = "Which of the following is used to handle exceptions in Java?";
        questions[7][1] = "catch";
        questions[7][2] = "try";
        questions[7][3] = "throw";
        questions[7][4] = "All of the above";

        questions[8][0] = "Which of the following is not an access modifier in Java?";
        questions[8][1] = "public";
        questions[8][2] = "protected";
        questions[8][3] = "private";
        questions[8][4] = "constant";

        questions[9][0] = "What does the final keyword in Java denote when applied to a variable?";
        questions[9][1] = "The variable's value can be changed.";
        questions[9][2] = "The variable's value cannot be changed.";
        questions[9][3] = "The variable is accessible outside the class.";
        questions[9][4] = "The variable must be null.";


        answers[0][1] = "32 bits";
        answers[1][1] = "Boolean";
        answers[2][1] = "false";
        answers[3][1] = "length()";
        answers[4][1] = "Object";
        answers[5][1] = "extends";
        answers[6][1] = "3030";
        answers[7][1] = "All of the above";
        answers[8][1] = "constant";
        answers[9][1] = "The variable's value cannot be changed.";
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 610, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            handleNextAction();
        } else if (ae.getSource() == submit) {
            submitQuiz();
        }
    }
    
    private void handleNextAction() {
        repaint();
        ans_given = 1;
        useranswers[count][0] = groupoptions.getSelection() == null ? "" : groupoptions.getSelection().getActionCommand();
        
        if (count == 8) {
            next.setEnabled(false);
            submit.setEnabled(true);
        }
        
        count++;
        start(count);
    }
    
    private void submitQuiz() {
        ans_given = 1;
        useranswers[count][0] = groupoptions.getSelection() == null ? "" : groupoptions.getSelection().getActionCommand();
        calculateScore();
        setVisible(false);
        new Score(name, score);
    }
    
    private void calculateScore() {
        for (int i = 0; i < useranswers.length; i++) {
            if (useranswers[i][0].equals(answers[i][1])) {
                score += 10;
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        int minutes = quizTimer / 60;
        int seconds = quizTimer % 60;
        String time = String.format("Time left - %02d:%02d", minutes, seconds); // Format as MM:SS
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        if (quizTimer > 0) { 
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Time's up!!", 1100, 500);
            submitQuiz(); // Automatically submit quiz when time runs out
        }
        
        quizTimer--;
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz("User");
    }
}