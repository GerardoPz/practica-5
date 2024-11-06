package app;

import com.toedter.calendar.JCalendar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

public class Calendario {
    public Calendario() {
    }

    public LocalDate showCalendarAndGetDate() {
        JFrame frame = new JFrame("Selecciona una fecha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        JCalendar calendar = new JCalendar();
        frame.add(calendar, BorderLayout.CENTER);
        final LocalDate[] selectedDate = new LocalDate[1];
        JButton button = new JButton("Agendar");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = calendar.getDate();
                selectedDate[0] = convertToLocalDate(date);
                frame.dispose();
            }
        });
        frame.add(button, BorderLayout.SOUTH);
        frame.setVisible(true);
        while (selectedDate[0] == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return selectedDate[0];
    }

    private LocalDate convertToLocalDate(Date date) {
        return new java.sql.Date(date.getTime()).toLocalDate();
    }
}
