import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class cowsandbulls {

    // Objects
    static JTextField guessField = new JTextField();
    static JTextArea Dispalytxt = new JTextArea();
    static JFrame frame;

    static JButton b1;

    // var
    // int CompterGuess = 2345;
    int[] ar={(int) (Math.random() * (2 - 1 + 1) + 1),(int) (Math.random() * (4 - 3 + 1) + 3),
            (int) (Math.random() * (7 - 5 + 1) + 5),(int) (Math.random() * (9 - 8 + 1) + 8)};
    
    int dit = (int) (Math.random() * (3 - 0 + 1));
    int CompterGuess = dit*1000+((dit+1)%4)*100+((dit+1)%4)*10+((dit+1)%4);
    

    cowsandbulls() {
        frame = new JFrame("Cows and Bulls");
        System.out.println(CompterGuess);
        b1 = new JButton(new AbstractAction("Check") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gString = guessField.getText();
                int gnum = Integer.parseInt(gString);
                int num1 = gnum;
                int Cows=0,Bulls=0,num1pos=0,num2pos=0;
                
                if (num1 > 999 && num1 < 10000) {
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
                        Dispalytxt.setText(Cows +"C"+ Bulls+"B");
                        
                    }else {
                        Dispalytxt.setText("Number should be greater than 999 \n \tand only 4 digit");
                    }

            }
        });

        b1.setBounds(100, 100, 100, 30);
        frame.add(b1);

        guessField.setBounds(100, 10, 100, 30);
        frame.add(guessField);

        Dispalytxt.setBounds(23, 50, 250, 40);
        Dispalytxt.setEditable(false);
        frame.add(Dispalytxt);


        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new cowsandbulls();

    }
}