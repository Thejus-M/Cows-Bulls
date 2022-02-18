import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class cowsandbulls {

    // Objects
    static JTextField guessField = new JTextField();
    static JTextArea Dispalytxt = new JTextArea();
    JTextField life = new JTextField();
    static JFrame frame;
    int lifeval = 15;
    static JButton CheckButton;
    static JButton Replay;


    
    
    // var
    // int CompterGuess = 2345;
    int ran1=(int) (Math.random() * (2 - 1 + 1) + 1) ;
    int ran2=(int) (Math.random() * (4 - 3 + 1) + 3) ;
    int ran3=(int) (Math.random() * (7 - 5 + 1) + 5) ;
    int ran4=(int) (Math.random() * (9 - 8 + 1) + 8) ;
    int CompterGuess = ran1*1000+ran2*100+ran3*10+ran4;
    int height=30,q=0;
    
    cowsandbulls() {
        frame = new JFrame("Cows and Bulls");
        System.out.println(CompterGuess);
        
        CheckButton = new JButton(new AbstractAction("Check") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gString = guessField.getText();
                int gnum = Integer.parseInt(gString);
                int num1 = gnum;
                int Cows=0,Bulls=0,num1pos=0,num2pos=0;
                if (lifeval>0) {
                    if (num1 > 999 && num1 < 10000) {
                        q++;
                        while (num1 > 0) {
                            int lastnum1 = num1 % 10;
                            num1pos = num1pos + 1;
                            
                            num1 = num1 / 10;
                            
                            int num2 = CompterGuess;
                            num2pos=0;
                            while (num2 > 0) {
                                int lastnum2 = num2 % 10;
                                num2pos = num2pos + 1;
                                num2 = num2/10;
                                if (num1pos == num2pos) {
                                    if (lastnum1 == lastnum2) {
                                        Bulls = Bulls + 1;
                                        // System.out.println("Bulls+lastnum1+lastnum2+num1pos+num2pos+num1+num2 \n "+
                                        // Bulls+" "+lastnum1+" "+lastnum2+" "+num1pos+" "+num2pos+" "+num1+" "+num2);
                                    }
                                }else{
                                    if (lastnum1 == lastnum2) {
                                        Cows = Cows + 1;
                                        // System.out.println("COWS+lastnum1+lastnum2+num1pos+num2pos+num1+num2 \n "+
                                        // Cows+" "+lastnum1+" "+lastnum2+" "+num1pos+" "+num2pos+" "+num1+" "+num2);
                                    }
                                }
                                }
                            }
                            // Dispalytxt.setText("Cows : " + Cows + " Bulls : "+Bulls);
                            String textfull = Dispalytxt.getText() +"\n"+q+")\t"+Cows +"C"+ Bulls+"B"+" ------------\t"+gnum;
                            Dispalytxt.setText(textfull);
                            Dispalytxt.setBounds(23, 100, 250, height);
                            height += 15;
                            if (Bulls == 4 && Cows == 0) {
                                JOptionPane.showMessageDialog(frame, "You WIN !!\n Your score is "+lifeval,
                                       "SUCCESS", JOptionPane.YES_OPTION);
                                CheckButton.setVisible(false);
                                Replay.setVisible(true);
                            }
                            life.setText(" Life : "+--lifeval);
                            
                        }else {
                            JOptionPane.showMessageDialog(frame, "Number should be greater than 999 \n \tand only 4 digit",
                                       "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You have no LIFE Left \n the number was "+CompterGuess,
                                       "ERROR", JOptionPane.ERROR_MESSAGE);
                    CheckButton.setVisible(false);
                    Replay.setVisible(true);
                }
                
                
                
            }
        });

        Replay = new JButton(new AbstractAction("Play Again") {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ran1=(int) (Math.random() * (2 - 1 + 1) + 1) ;
                ran2=(int) (Math.random() * (4 - 3 + 1) + 3) ;
                ran3=(int) (Math.random() * (7 - 5 + 1) + 5) ;
                ran4=(int) (Math.random() * (9 - 8 + 1) + 8) ;
                CompterGuess = ran1*1000+ran2*100+ran3*10+ran4;
                System.out.println(CompterGuess);
                height=30;q=0;lifeval=15;
                String textfull="Slno."+"\tC&B"+"\tGuess No.";
                life.setText(" Life : 15");
                Dispalytxt.setText(textfull);
                CheckButton.setVisible(true);
                Replay.setVisible(false);
                
                
            }
        });
        
        
        CheckButton.setBounds(175, 50, 100, 30);
        frame.add(CheckButton);

        Replay.setBounds(175, 50, 100, 30);
        Replay.setVisible(false);
        frame.add(Replay);
        
        guessField.setBounds(20, 50, 100, 30);
        frame.add(guessField);
        
        Dispalytxt.setBounds(20, 100, 250, 40);
        Dispalytxt.setEditable(false);
        String textfull="Slno."+"\tC&B"+"\tGuess No.";
        Dispalytxt.setText(textfull);
        frame.add(Dispalytxt);

        life.setBounds(20, 10, 90, 30);
        life.setEditable(false);
        life.setText(" Life : 15");
        life.setBackground(Color.GRAY);
        frame.add(life);

        frame.setSize(300, 390);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        // frame.setBackground(Color.BLUE);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new cowsandbulls();

    }
}
