package jdk8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Auther: qiucy
 * @Date: 2019-06-18 23:08
 * @Description:
 */
public class SwingTest {
    public static void main(String[] args) {
        JFrame my_jframe = new JFrame("my jframe");
        JButton my_button = new JButton("my button");
        my_button.addActionListener((o)->{
            System.out.println(o);
        });
        my_jframe.add(my_button);
        my_jframe.pack();
        my_jframe.setVisible(true);
        my_jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
