package com.testing.quanlysieuthimini;

import com.testing.quanlysieuthimini.GUI.login;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuanLySieuThiMiniApplication {

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new login().setVisible(true);
        });      
        SpringApplication.run(QuanLySieuThiMiniApplication.class, args);
    }

}
