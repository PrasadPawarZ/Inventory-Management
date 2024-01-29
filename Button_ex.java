import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*/*<applet code="Button_ex" NAME="Laboratory_Management_System" width = 1260 height = 720>
</applet>
*/

public class Button_ex extends Applet implements ActionListener {

    int[] arry_item = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    Data_store dawa[] = new Data_store[10];

    Font f1 = new Font("TimesRoman", Font.PLAIN, 46),
            f2 = new Font("Arial", Font.PLAIN, 18),
            f3 = new Font("Arial", Font.PLAIN, 14);;

    TextField t1, t2, t3, t4, t5;

    public static int init_pointer = 1, temp_no = 0, temp = 0, temp2 = 0;
    public String temp1 = "";

    String user_name, pass_word, msg = "";
    Button b1;

    public void init() {
        b1 = new Button("Login");
        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();
        t4 = new TextField();
        t5 = new TextField();
        add(b1);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();

        if (str.equals("Login")) {
            if (user_name.equals("A") && pass_word.equals("12")) {
                init_pointer = 2;
            } else {
                init_pointer = 1;
                msg = "Incorrect Username/Password";
            }
        } else if (str.equals("Enter")) {
            switch (temp_no) {
                case 1:
                    init_pointer = 3;
                    break;
                case 2:
                    init_pointer = 4;
                    break;
                case 3:
                    init_pointer = 6;
                    break;
                case 4:
                    init_pointer = 7;
                    break;
                case 5:
                    init_pointer = 8;
                    break;
                default:
                    break;
            }
        } else if (str.equals("Add")) {
            msg = "";

            if (temp != 0) {
                if (temp2 != 0) {
                    for (int i = 0; i < 10; i++) {
                        if (arry_item[i] == 0) {
                            try {
                                dawa[i].accpt(temp_no, temp1, temp, temp2);
                                arry_item[i] = 1;
                                init_pointer = 2;
                                break;
                            } catch (NullPointerException e) {
                            }
                            break;
                        }
                    }
                } else {
                    msg = "Enter Valid Details";
                }
            } else {
                msg = "Enter Valid Details";
            }
        } else if (str.equals("Remove")) {

            int e = 0;
            for (int j = 0; j < 10; j++) {

                if (arry_item[j] == 0) {
                    e++;
                }
            }
            if (e != 10) {
                for (int i = 0; i < 10; i++) {
                    if (temp_no != 0) {
                        if (temp_no == (dawa[i].id)) {
                            arry_item[i] = 0;
                            dawa[i].remove();
                            init_pointer = 5;
                            msg = "Remove successfully";
                            break;
                        }
                        if (i == 9) {
                            msg = "No such Element Found";
                            init_pointer = 5;
                        }
                    }
                }
            } else {
                msg = "No Elements in Lab";
                init_pointer = 5;
            }
        } else if (str.equals("Continue")) {
            init_pointer = 2;
        } else if (str.equals("Update")) {
            int e = 0;

            for (int j = 0; j < 10; j++) {

                if (arry_item[j] == 0) {
                    e++;
                }
            }
            if (e != 10) {
                for (int z = 0; z < 10; z++) {
                    if (temp_no != 0) {
                        if (temp_no == (dawa[z].id)) {
                            dawa[z].name = temp1;
                            dawa[z].price = temp;
                            dawa[z].n = temp2;
                            dawa[z].tp = temp * temp2;
                            init_pointer = 2;
                            break;
                        }
                        if (z == 9) {
                            msg = "No such Element Found";
                            init_pointer = 5;
                        }
                    }
                }
            } else {
                msg = "No Elements in Lab";
                init_pointer = 5;
            }
        } else {
            msg = "Error Encounter";
            init_pointer = 5;
        }
        repaint();
    }

    public void paint(Graphics g) {

        switch (init_pointer) {
            case 1:
                for (int i = 0; i < 10; i++) {
                    dawa[i] = new Data_store(); // initliaze the obj
                    dawa[i].id = 0;
                    dawa[i].name = "a";
                    dawa[i].price = 0;
                    dawa[i].n = 0;
                    dawa[i].tp = 0;
                }
                g.clearRect(00, 00, 1260, 720);

                t3.setVisible(false);
                t4.setVisible(false);
                t5.setVisible(false);

                g.setColor(Color.DARK_GRAY);
                g.fillRect(0, 00, 1290, 790);

                g.setColor(Color.RED);
                g.fillRect(0, 00, 1290, 150);

                g.setColor(Color.GRAY);
                g.fillRect(100, 100, 1100, 420);

                g.setColor(Color.BLACK);

                g.setFont(f1);
                g.drawString("Enter Login Details", 510, 200);

                user_name = t1.getText();
                pass_word = t2.getText();
                g.setFont(f2);
                b1.setLabel("Login");
                b1.setBounds(650, 380, 50, 30);

                t1.setBounds(700, 280, 90, 20);
                t2.setBounds(700, 330, 90, 20);
                g.drawString("Enter Username:", 560, 293);
                g.drawString("Enter Password:", 560, 343);

                g.setFont(f3);
                g.setColor(Color.BLUE);
                g.drawString(msg, 580, 450);
                break;
            case 2:
                g.clearRect(00, 00, 1260, 720);
                temp_no = 0;
                msg = "";

                b1.setVisible(true);
                t1.setVisible(true);

                t2.setVisible(false);
                t3.setVisible(false);
                t4.setVisible(false);
                t5.setVisible(false);

                g.setColor(Color.DARK_GRAY);
                g.fillRect(0, 00, 1290, 790);

                g.setColor(Color.RED);
                g.fillRect(0, 00, 1290, 150);

                g.setColor(Color.GRAY);
                g.fillRect(100, 100, 1100, 420);

                g.setColor(Color.BLACK);

                t1.setText("");

                b1.setLabel("Enter");
                g.setFont(f1);
                g.drawString("Menu", 610, 80);
                g.setFont(f3);
                g.drawString("1.Add item to laboratory", 580, 200);
                g.drawString("2.Remove item to laboratory", 580, 230);
                g.drawString("3.Display item to laboratory", 580, 260);
                g.drawString("4.Update item to laboratory", 580, 290);
                g.drawString("5.Exit", 580, 320);

                g.drawString("Choice", 580, 350);
                t1.setBounds(640, 340, 90, 20);
                try {
                    temp_no = Integer.parseInt(t1.getText());
                } catch (NumberFormatException e) {
                }
                b1.setBounds(640, 390, 50, 30);
                break;
            case 3:
                g.clearRect(00, 00, 1260, 720);
                t5.setVisible(false);

                temp = 0;
                temp2 = 0;
                temp1 = "";

                t2.setVisible(true);
                t3.setVisible(true);
                t4.setVisible(true);

                g.setColor(Color.DARK_GRAY);
                g.fillRect(0, 00, 1290, 790);

                g.setColor(Color.RED);
                g.fillRect(0, 00, 1290, 150);

                g.setColor(Color.GRAY);
                g.fillRect(100, 100, 1100, 420);

                g.setColor(Color.BLACK);

                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");

                g.setFont(f1);
                g.drawString("Add Item Details", 500, 150);
                g.setFont(f3);

                b1.setLabel("Add");
                g.drawString("Enter Item Id", 510, 273);
                g.drawString("Enter Item Name", 510, 303);
                g.drawString("Enter Item Price", 510, 333);
                g.drawString("Enter Item Quantity", 510, 363);

                t1.setBounds(640, 260, 90, 20);
                t2.setBounds(640, 290, 90, 20);
                t3.setBounds(640, 320, 90, 20);
                t4.setBounds(640, 350, 90, 20);

                b1.setBounds(600, 410, 50, 30);
                temp1 = t2.getText();

                try {
                    temp_no = Integer.parseInt(t1.getText());
                    temp = Integer.parseInt(t3.getText());
                    temp2 = Integer.parseInt(t4.getText());
                } catch (NumberFormatException e) {
                    msg = "Enter Data";
                }

                g.setFont(f3);
                g.setColor(Color.BLUE);
                g.drawString(msg, 590, 480);

                break;
            case 4:
                g.clearRect(00, 00, 1260, 720);
                temp_no = 0;

                t2.setVisible(false);
                t3.setVisible(false);
                t4.setVisible(false);
                t5.setVisible(false);

                g.setColor(Color.DARK_GRAY);
                g.fillRect(0, 00, 1290, 790);

                g.setColor(Color.RED);
                g.fillRect(0, 00, 1290, 150);

                g.setColor(Color.GRAY);
                g.fillRect(100, 100, 1100, 420);

                g.setColor(Color.BLACK);

                t1.setText("");

                g.setFont(f1);
                g.drawString("Enter Item Id to Remove", 470, 190);
                g.setFont(f3);

                b1.setLabel("Remove");
                g.drawString("Enter Item Id", 560, 303);
                b1.setBounds(630, 350, 60, 30);
                t1.setBounds(660, 290, 90, 20);

                try {
                    temp_no = Integer.parseInt(t1.getText());
                } catch (NumberFormatException e) {
                }

                break;
            case 5:
                b1.setVisible(false);
                t1.setVisible(false);
                t2.setVisible(false);
                t3.setVisible(false);
                t4.setVisible(false);
                t5.setVisible(false);

                for (long i = 3; i >= 1; i--) {
                    try {
                        g.clearRect(00, 00, 1260, 720);

                        g.setColor(Color.DARK_GRAY);
                        g.fillRect(0, 00, 1290, 790);

                        g.setColor(Color.RED);
                        g.fillRect(0, 00, 1290, 150);

                        g.setColor(Color.GRAY);
                        g.fillRect(100, 100, 1100, 420);

                        g.setColor(Color.BLACK);

                        g.setFont(f1);
                        g.drawString(msg, 470, 250);
                        g.drawString("Wait", 600, 350);
                        g.drawString(String.valueOf(i), 630, 420);
                        Thread.sleep(3000 / 3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                init_pointer = 2;
                repaint();

                break;
            case 6:
                g.clearRect(00, 00, 1260, 720);

                t1.setVisible(false);
                t2.setVisible(false);
                t3.setVisible(false);
                t4.setVisible(false);
                t5.setVisible(false);

                g.setColor(Color.DARK_GRAY);
                g.fillRect(0, 00, 1290, 790);

                g.setColor(Color.RED);
                g.fillRect(0, 00, 1290, 150);

                g.setColor(Color.GRAY);
                g.fillRect(100, 120, 1050, 550);

                g.setColor(Color.BLACK);

                g.setFont(f1);
                g.drawString("Items in Lab", 550, 50);
                g.setFont(f2);
                g.drawString("Sr No", 125, 145);
                g.drawString("ID No", 235, 145);
                g.drawString("Name of item", 345, 145);
                g.drawString("Price per piece", 675, 145);
                g.drawString("Quantity", 865, 145);
                g.drawString("Total Price", 1005, 145);
                g.setFont(f3);
                b1.setLabel("Continue");
                b1.setBounds(620, 680, 70, 30);

                g.drawLine(100, 120, 100, 670);
                g.drawLine(100, 120, 1150, 120);
                g.drawLine(1150, 120, 1150, 670);
                g.drawLine(100, 670, 1150, 670);

                g.drawLine(100, 170, 1150, 170);
                g.drawLine(100, 220, 1150, 220);
                g.drawLine(100, 270, 1150, 270);
                g.drawLine(100, 320, 1150, 320);
                g.drawLine(100, 370, 1150, 370);
                g.drawLine(100, 420, 1150, 420);
                g.drawLine(100, 470, 1150, 470);
                g.drawLine(100, 520, 1150, 520);
                g.drawLine(100, 570, 1150, 570);
                g.drawLine(100, 620, 1150, 620);
                g.drawLine(100, 670, 1150, 670);

                g.drawLine(210, 120, 210, 670);
                g.drawLine(320, 120, 320, 670);
                g.drawLine(650, 120, 650, 670);
                g.drawLine(840, 120, 840, 670);
                g.drawLine(980, 120, 980, 670);

                int id = 0;
                String name = "";
                int price = 0;
                int Quantity = 0;
                int total = 0;
                int x1 = 125, x2 = 235, x3 = 345, x4 = 675, x5 = 865, x6 = 1005;
                int y = 195;
                for (int i = 0; i < 10; i++) {

                    id = dawa[i].id;
                    name = dawa[i].name;
                    price = dawa[i].price;
                    Quantity = dawa[i].n;
                    total = dawa[i].tp;

                    g.drawString(String.valueOf(i + 1), x1, y);
                    if (id == 0) {
                        g.drawString("null", x2, y);
                    } else {
                        g.drawString(String.valueOf(id), x2, y);
                    }
                    if (name.equals("a")) {
                        g.drawString("null", x3, y);
                    } else {
                        g.drawString(name, x3, y);
                    }
                    if (price == 0) {
                        g.drawString("null", x4, y);
                    } else {
                        g.drawString(String.valueOf(price), x4, y);
                    }
                    if (id == 0) {
                        g.drawString("null", x5, y);
                    } else {
                        g.drawString(String.valueOf(Quantity), x5, y);
                    }
                    if (total == 0) {
                        g.drawString("null", x6, y);
                    } else {
                        g.drawString(String.valueOf(total), x6, y);
                    }

                    y = y + 50;
                }
                break;
            case 7:
                g.clearRect(00, 00, 1260, 720);
                temp_no = 0;

                t5.setVisible(false);
                t2.setVisible(true);
                t3.setVisible(true);
                t4.setVisible(true);

                g.setColor(Color.DARK_GRAY);
                g.fillRect(0, 00, 1290, 790);

                g.setColor(Color.RED);
                g.fillRect(0, 00, 1290, 150);

                g.setColor(Color.GRAY);
                g.fillRect(100, 100, 1100, 420);

                g.setColor(Color.BLACK);

                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");

                b1.setLabel("Update");

                g.setFont(f1);
                g.drawString("Update Item Details", 480, 150);
                g.setFont(f3);

                g.drawString("Item Id", 510, 273);
                g.drawString("Enter Item Name", 510, 303);
                g.drawString("Enter Item Price", 510, 333);
                g.drawString("Enter Item Quantity", 510, 363);

                t1.setBounds(640, 260, 90, 20);
                t2.setBounds(640, 290, 90, 20);
                t3.setBounds(640, 320, 90, 20);
                t4.setBounds(640, 350, 90, 20);

                b1.setBounds(620, 400, 50, 30);
                temp1 = t2.getText();

                try {
                    temp_no = Integer.parseInt(t1.getText());
                    temp = Integer.parseInt(t3.getText());
                    temp2 = Integer.parseInt(t4.getText());
                } catch (NumberFormatException e) {
                    msg = "";
                }
                g.setFont(f3);
                g.setColor(Color.BLUE);
                g.drawString("ID can't be changed", 570, 470);
                break;
            case 8:
                g.dispose();
                

            default:
                break;
        }
    }
    public void stop(){
        destroy();
    }
    public void destroy(){try {
        System.exit(0);
    } catch (Exception e) {
    }}
}

class Data_store {

    int id;
    String name;
    int price;
    int n;
    int tp;

    public void accpt(int a, String b, int c, int d) {
        id = a;
        name = b;
        price = c;
        n = d;
        tp = c * d;
    }

    void remove() {
        id = 0;
        name = "a";
        price = 0;
        n = 0;
        tp = 0;
    }
}
