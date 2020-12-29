import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Main  {


    public static void main(String[] args) throws IOException {

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        JFrame frame = new JFrame("Hide It!");
        frame.setLayout(null);
        frame.setSize(screen);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new Encrypt(frame);

        frame.setVisible(true);
    }
}

class Encrypt {

    final BufferedImage[] image = {ImageIO.read(new File("images.png"))};;

    static int getBinary(char chr) {
        switch (chr) {
            case 'a': return 10000001;
            case 'b': return 10000010;
            case 'c': return 10000011;
            case 'd': return 10000100;
            case 'e': return 10000101;
            case 'f': return 10000110;
            case 'g': return 10000111;
            case 'h': return 10001000;
            case 'i': return 10001001;
            case 'j': return 10001010;
            case 'k': return 10001011;
            case 'l': return 10001100;
            case 'm': return 10001101;
            case 'n': return 10001110;
            case 'o': return 10001111;
            case 'p': return 10010000;
            case 'q': return 10010001;
            case 'r': return 10010010;
            case 's': return 10010011;
            case 't': return 10010100;
            case 'u': return 10010101;
            case 'v': return 10010110;
            case 'w': return 10010111;
            case 'x': return 10011000;
            case 'y': return 10011010;
            case 'z': return 10011011;

            case '0': return 10011100;
            case '1': return 10011101;
            case '2': return 10011110;
            case '3': return 10011111;
            case '4': return 10100000;
            case '5': return 10100001;
            case '6': return 10100010;
            case '7': return 10100011;
            case '8': return 10100100;
            case '9': return 10100101;
            case ' ': return 10100110;
            case '.': return 10100111;

            case '*': return 10101010;
            case '#': return 10101011;
        }

        return 0;
    }

    static char getCharacter(int num) {
        switch (num) {
            case 10000001 : return 'a';
            case 10000010 : return 'b';
            case 10000011 : return 'c';
            case 10000100 : return 'd';
            case 10000101 : return 'e';
            case 10000110 : return 'f';
            case 10000111 : return 'g';
            case 10001000 : return 'h';
            case 10001001 : return 'i';
            case 10001010 : return 'j';
            case 10001011 : return 'k';
            case 10001100 : return 'l';
            case 10001101 : return 'm';
            case 10001110 : return 'n';
            case 10001111 : return 'o';
            case 10010000 : return 'p';
            case 10010001 : return 'q';
            case 10010010 : return 'r';
            case 10010011 : return 's';
            case 10010100 : return 't';
            case 10010101 : return 'u';
            case 10010110 : return 'v';
            case 10010111 : return 'w';
            case 10011000 : return 'x';
            case 10011010 : return 'y';
            case 10011011 : return 'z';

            case 10011100 : return '0';
            case 10011101 : return '1';
            case 10011110 : return '2';
            case 10011111 : return '3';
            case 10100000 : return '4';
            case 10100001 : return '5';
            case 10100010 : return '6';
            case 10100011 : return '7';
            case 10100100 : return '8';
            case 10100101 : return '9';
            case 10100110 : return ' ';
            case 10100111 : return '.';

            case 10101010 : return '*';
            case 10101011 : return '#';
        }

        return '-';
    }

    public Encrypt(JFrame frame) throws IOException {

        JLabel[] label = {new JLabel()};
        label[0] = new JLabel("", JLabel.CENTER);
        label[0].setBounds( frame.getWidth() / 2 - (frame.getWidth() / 4), 100, frame.getWidth() / 2, frame.getHeight() / 2);
        label[0].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        label[0].setIcon(new ImageIcon(image[0]));
        FileDialog fileDialog = new FileDialog(frame);
        JButton file = new OptionButton("Choose Image", label[0].getX(), label[0].getHeight() + 175);
        String[] path = new String[1];
        file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileDialog.setVisible(true);
                path[0] = fileDialog.getDirectory() + fileDialog.getFile();
                try {

                    File inputFile = new File(path[0]);
                    image[0] = ImageIO.read(inputFile);
                    BufferedImage outputImage = image[0];
                    if (image[0].getWidth() > (frame.getWidth() / 2) && image[0].getHeight() > (frame.getHeight()/2)) {
                        int height = (int) (image[0].getHeight() / 2.25);
                        int width = (int) (image[0].getWidth() / 2.25);
                        outputImage = ResizeImage.resize(image[0], height, width);
                    }

                    label[0].setIcon(new ImageIcon(outputImage));
                    frame.repaint();
                } catch (IOException exception) {
                }
            }
        });

        JButton encrypt = new OptionButton("Encrypt", file.getX() + file.getWidth() + 180, label[0].getHeight() + 175);
        encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (path[0] == null) {
                    JOptionPane.showMessageDialog(frame, "Please choose image first.");
                } else {
                    getInfomation(frame, image[0]);
                }
            }
        });

        JButton decrypt = new OptionButton("Decrypt", encrypt.getX() + encrypt.getWidth() + 180, label[0].getHeight() + 175);
        decrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (path[0] == null) {
                    JOptionPane.showMessageDialog(frame, "Please choose image first.");
                } else {
                    getDecryptInfomation(frame, image[0]);
                }
            }
        });

        frame.add(file);
        frame.add(encrypt);
        frame.add(decrypt);
        frame.add(label[0]);
    }

    public void getInfomation(JFrame frame, BufferedImage image) {

        final String[] data = {""};

        JDialog dialog = new JDialog(frame, "Information");
        dialog.setSize(500, 700);
        dialog.setLocationRelativeTo(frame);
        dialog.setLayout(null);

        JLabel label1 = new JLabel("Enter Key", JLabel.CENTER);
        label1.setBounds(100, 50, 300, 30);
        JTextField textField1 = new JPasswordField();
        textField1.setBounds(100, 100, 300, 30);
        JLabel label3 = new JLabel("Confirm Key", JLabel.CENTER);
        label3.setBounds(100, 150, 300, 30);
        JTextField textField3 = new JPasswordField();
        textField3.setBounds(100, 200, 300, 30);
        JLabel label2 = new JLabel("Enter Information", JLabel.CENTER);
        label2.setBounds(100, 250, 300, 30);
        JTextArea textField2 = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textField2);
        scrollPane.setBounds(100, 300, 300, 200);
        textField2.setLineWrap(true);
        JButton button1 = new JButton("Submit");
        button1.setBounds(100,  550, 300, 40);

        dialog.add(label1);
        dialog.add(label2);
        dialog.add(label3);
        dialog.add(textField1);
        dialog.add(scrollPane);
        dialog.add(textField3);
        dialog.add(button1);
        dialog.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                if (textField1.getText().equals("") || textField2.getText().equals("") || textField3.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, "Enter all information.");
                } else if (!textField1.getText().equals(textField3.getText())) {
                    JOptionPane.showMessageDialog(frame, "Key does not match.");
                } else {
                    data[0] = "#" + textField1.getText().toLowerCase() + "#" + textField2.getText().toLowerCase() + "*";
                    encryptData(dialog, frame, image, data[0]);
                }
            }
        });
    }

    void encryptData(JDialog dialog, JFrame frame, BufferedImage imageIO, String data) {

        for (int i = 0, k = 0; i < imageIO.getWidth(); i++) {
            for (int j = 0; j < imageIO.getHeight(); j += 4, k += 1) {

                if (k == data.length())
                    break;

                int charNumber = getBinary(data.charAt(k));
                String numString = String.valueOf(charNumber);

                String num = "111111" + numString.substring(0, 2);

                int p = imageIO.getRGB(i, j);
                int a = Integer.parseInt(num, 2);
                int r = (p>>16) & 0xff;
                int g = (p>>8) & 0xff;
                int b = p & 0xff;

                p = (a<<24) | (r<<16) | (g<<8) | b;
                imageIO.setRGB(i, j, p);

                num = "111111" + numString.substring(2, 4);

                p = imageIO.getRGB(i, j+1);
                a = Integer.parseInt(num, 2);
                r = (p>>16) & 0xff;
                g = (p>>8) & 0xff;
                b = p & 0xff;

                p = (a<<24) | (r<<16) | (g<<8) | b;
                imageIO.setRGB(i, j+1, p);

                num = "111111" + numString.substring(4, 6);

                p = imageIO.getRGB(i, j+2);
                a = Integer.parseInt(num, 2);
                r = (p>>16) & 0xff;
                g = (p>>8) & 0xff;
                b = p & 0xff;

                p = (a<<24) | (r<<16) | (g<<8) | b;
                imageIO.setRGB(i, j+2, p);

                num = "111111" + numString.substring(6, 8);

                p = imageIO.getRGB(i, j+3);
                a = Integer.parseInt(num, 2);
                r = (p>>16) & 0xff;
                g = (p>>8) & 0xff;
                b = p & 0xff;

                p = (a<<24) | (r<<16) | (g<<8) | b;
                imageIO.setRGB(i, j+3, p);
            }

            if (k == data.length())
                break;

        }

        dialog.getContentPane().removeAll();
        dialog.setTitle("Download Image");
        dialog.setSize(500, 200);
        dialog.setLocationRelativeTo(frame);
        JLabel label1 = new JLabel("Your image is ready to download", JLabel.CENTER);
        label1.setBounds(100, 25, 300, 30);
        JButton button1 = new JButton("Download Image");
        button1.setBounds(150,  75, 200, 40);
        dialog.add(label1);
        dialog.add(button1);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FileDialog fileDialog = new FileDialog(new Frame(), "Save", FileDialog.SAVE);
                fileDialog.setFilenameFilter(new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        return name.endsWith(".png");
                    }
                });
                fileDialog.setFile("untitled.png");
                fileDialog.setVisible(true);
                try {
                    ImageIO.write(imageIO, "png", new File(fileDialog.getDirectory() + fileDialog.getFile()));
                } catch (IOException ex) {
                }
                dialog.setVisible(false);
                JOptionPane.showMessageDialog(frame, "Image saved successfully.");
                try {
                    image[0] = ImageIO.read(new File("src/images.png"));
                } catch (IOException ex) {
                }
            }
        });
    }

    public void getDecryptInfomation(JFrame frame, BufferedImage imageIO) {

        final String[] data = {""};

        String message = "";
        String decryptkey = "";
        int countHash = 0, flag = 0;

        for (int i = 0, k = 0; i < imageIO.getWidth(); i++) {

            String a1 = "", a2 = "", a3 = "", a4 = "";

            for (int j = 0; j < imageIO.getHeight(); j++, k += 4) {

                int p = imageIO.getRGB(i, k);
                a1 = String.valueOf((p >> 24) & 0xff);

                p = imageIO.getRGB(i, k + 1);
                a2 = String.valueOf((p >> 24) & 0xff);

                p = imageIO.getRGB(i, k + 2);
                a3 = String.valueOf((p >> 24) & 0xff);

                p = imageIO.getRGB(0, k + 3);
                a4 = String.valueOf((p >> 24) & 0xff);

                if (i == 0 && j == 0 && !(a1.equalsIgnoreCase("254") && a2.equalsIgnoreCase("254") && a3.equalsIgnoreCase("254") && a4.equalsIgnoreCase("255"))) {
                    flag = 1;
                    break;
                }

                if (a1.equalsIgnoreCase("254") && a2.equalsIgnoreCase("254") && a3.equalsIgnoreCase("254") && a4.equalsIgnoreCase("254")) {
                    break;
                }

                String temp = Integer.toBinaryString(Integer.valueOf(a1)).substring(6, 8) + Integer.toBinaryString(Integer.valueOf(a2)).substring(6, 8) + Integer.toBinaryString(Integer.valueOf(a3)).substring(6, 8) + Integer.toBinaryString(Integer.valueOf(a4)).substring(6, 8);

                if (a1.equalsIgnoreCase("254") && a2.equalsIgnoreCase("254") && a3.equalsIgnoreCase("254") && a4.equalsIgnoreCase("255")) {
                    countHash += 1;
                    continue;
                }

                if (countHash < 2) {
                    decryptkey += getCharacter(Integer.valueOf(temp));
                    continue;
                }

                message += getCharacter(Integer.valueOf(temp));
            }

            if (a1.equalsIgnoreCase("254") && a2.equalsIgnoreCase("254") && a3.equalsIgnoreCase("254") && a4.equalsIgnoreCase("254")) {
                break;
            }

            if (flag == 1) {
                break;
            }

        }

        if (flag == 1) {
            JOptionPane.showMessageDialog(frame, "No message found in this image.");
            return;
        }

        JDialog dialog = new JDialog(frame, "Information");
        dialog.setSize(500, 250);
        dialog.setLocationRelativeTo(frame);
        dialog.setLayout(null);

        JLabel label1 = new JLabel("Enter Key", JLabel.CENTER);
        label1.setBounds(100, 25, 300, 30);
        JTextField textField1 = new JPasswordField();
        textField1.setBounds(100, 75, 300, 30);
        JButton button1 = new JButton("Submit");
        button1.setBounds(100,  125, 300, 40);

        dialog.add(label1);
        dialog.add(textField1);
        dialog.add(button1);
        dialog.setVisible(true);

        String finalDecryptkey = decryptkey;
        String finalMessage = message;
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                if (textField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, "Please enter key.");
                } else {
                    if (textField1.getText().equals(finalDecryptkey)) {
                        dialog.getContentPane().removeAll();
                        dialog.setSize(500, 300);
                        dialog.setTitle("Secret Information");
                        JTextArea textField = new JTextArea();
                        textField.setLineWrap(true);
                        textField.setText(finalMessage);
                        JScrollPane scrollPane = new JScrollPane(textField);
                        scrollPane.setBounds(100, 25, 300, 200);
                        dialog.add(scrollPane);
                        dialog.repaint();
                        try {
                            image[0] = ImageIO.read(new File("src/images.png"));
                            frame.repaint();
                        } catch (IOException ex) {
                        }
                    } else {
                        dialog.setVisible(false);
                        JOptionPane.showMessageDialog(frame, "Wrong Key.");
                    }
                }
            }
        });
    }
}

class Tabs extends JLabel {

    public Tabs(String name) {

        super(name);
        setPreferredSize(new Dimension(200, 30));
        setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        setForeground(Color.WHITE);
    }
}

class ResizeImage {

    public static BufferedImage resize(BufferedImage img, int height, int width) {

        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

}

class OptionButton extends JButton {

    public OptionButton(String name, int x, int y) {

        super(name);
        setSize(200, 50);
        setLocation(x, y);
        setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
    }
}
