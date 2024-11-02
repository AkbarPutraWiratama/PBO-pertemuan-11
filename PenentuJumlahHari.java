package Latihan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.YearMonth;

class HitungHari {
    public int hitung(int tahun, int bulan) {
        YearMonth yearMonth = YearMonth.of(tahun, bulan);
        return yearMonth.lengthOfMonth();
    }
}

public class PenentuJumlahHari {

    private JFrame frame;
    private JTextField textField;
    private JLabel lblHasil;
    private Choice choiceBulan;
    private HitungHari hitungHari;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PenentuJumlahHari window = new PenentuJumlahHari();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public PenentuJumlahHari() {
        hitungHari = new HitungHari();
        initialize();
    }
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Aplikasi Penentu Jumlah Hari");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        panel.setBounds(50, 35, 331, 75);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setBounds(171, 11, 104, 20);
        panel.add(textField);
        textField.setColumns(10);

        Label labelTahun = new Label("Tahun");
        labelTahun.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelTahun.setBounds(57, 10, 75, 21);
        panel.add(labelTahun);

        choiceBulan = new Choice();
        choiceBulan.setBounds(171, 44, 104, 20);
        choiceBulan.add("Januari");
        choiceBulan.add("Februari");
        choiceBulan.add("Maret");
        choiceBulan.add("April");
        choiceBulan.add("Mei");
        choiceBulan.add("Juni");
        choiceBulan.add("Juli");
        choiceBulan.add("Agustus");
        choiceBulan.add("September");
        choiceBulan.add("Oktober");
        choiceBulan.add("November");
        choiceBulan.add("Desember");
        panel.add(choiceBulan);

        Label labelBulan = new Label("Bulan");
        labelBulan.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelBulan.setBounds(57, 43, 75, 21);
        panel.add(labelBulan);

        JPanel panelHasil = new JPanel();
        panelHasil.setBackground(new Color(255, 228, 196));
        panelHasil.setBounds(50, 115, 331, 50);
        frame.getContentPane().add(panelHasil);
        panelHasil.setLayout(null);

        lblHasil = new JLabel("");
        lblHasil.setBounds(10, 11, 311, 28);
        panelHasil.add(lblHasil);

        JPanel panelTombol = new JPanel();
        panelTombol.setBackground(Color.PINK);
        panelTombol.setBounds(50, 170, 331, 50);
        frame.getContentPane().add(panelTombol);
        panelTombol.setLayout(null);

        JButton btnHitung = new JButton("Hitung");
        btnHitung.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnHitung.setBounds(10, 11, 74, 28);
        panelTombol.add(btnHitung);
        btnHitung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hitungJumlahHari();
            }
        });

        JButton btnHapus = new JButton("Hapus");
        btnHapus.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnHapus.setBounds(90, 11, 74, 28);
        panelTombol.add(btnHapus);
        btnHapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hapusInput();
            }
        });

        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnSimpan.setBounds(170, 11, 76, 28);
        panelTombol.add(btnSimpan);
        btnSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simpanHasil();
            }
        });

        JButton btnKeluar = new JButton("Keluar");
        btnKeluar.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnKeluar.setBounds(251, 11, 74, 28);
        panelTombol.add(btnKeluar);
        btnKeluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        Label labelTitle = new Label("Aplikasi Penentu Jumlah Hari");
        labelTitle.setBounds(34, 0, 186, 22);
        frame.getContentPane().add(labelTitle);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(192, 192, 192));
        panel_1.setBounds(10, 11, 1, 239);
        frame.getContentPane().add(panel_1);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBackground(Color.LIGHT_GRAY);
        panel_1_1.setBounds(423, 11, 1, 239);
        frame.getContentPane().add(panel_1_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(192, 192, 192));
        panel_2.setBounds(10, 250, 414, 1);
        frame.getContentPane().add(panel_2);
        
        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBackground(new Color(192, 192, 192));
        panel_2_1.setBounds(176, 11, 248, 1);
        frame.getContentPane().add(panel_2_1);
        
        JPanel panel_2_1_1 = new JPanel();
        panel_2_1_1.setBounds(10, 11, 20, 1);
        frame.getContentPane().add(panel_2_1_1);
        panel_2_1_1.setBackground(Color.LIGHT_GRAY);
    }

    private void hitungJumlahHari() {
        try {
            int tahun = Integer.parseInt(textField.getText());
            int bulan = choiceBulan.getSelectedIndex() + 1;
            int jumlahHari = hitungHari.hitung(tahun, bulan);
            lblHasil.setText("Jumlah hari pada bulan " + choiceBulan.getItem(choiceBulan.getSelectedIndex()) +
                    " tahun " + tahun + " adalah " + jumlahHari);
        } catch (NumberFormatException e) {
            lblHasil.setText("Input tahun tidak valid.");
        }
    }

    private void hapusInput() {
        textField.setText("");
        choiceBulan.select(0);
        lblHasil.setText("");
    }

    private void simpanHasil() {
        String hasil = lblHasil.getText();
        if (!hasil.isEmpty()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("hasil_jumlah_hari.txt"))) {
                writer.write(hasil);
                JOptionPane.showMessageDialog(frame, "Hasil berhasil disimpan!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Gagal menyimpan hasil.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Tidak ada hasil yang bisa disimpan.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
