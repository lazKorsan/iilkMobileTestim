package eglencePaketi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class balonPanelTestiSucces {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Balon Testi: Başarı Durumu");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 600);
            frame.setLocationRelativeTo(null);

            // Başarılı bir senaryo için BalonPanel'i oluşturuyoruz
            BalonPanel panel = new BalonPanel();
            frame.add(panel);

            frame.setVisible(true);
        });
    }
}

// Bir önceki cevapta verdiğiniz BalonPanel sınıfı
/*

 */
class BalonPanel extends JPanel implements ActionListener {

    private int balonY;
    private final int balonHizi = 1;
    private final int balonGenislik = 50;
    private final int balonYukseklik = 50;
    private final int panelYukseklik = 600;
    private Timer timer;

    private boolean patladi = false;
    private long patlamaZamani;
    private final long PATLAMA_SURESI = 2000;

    private boolean durduruldu = false;

    public BalonPanel() {
        balonY = panelYukseklik;
        timer = new Timer(10, this);
        timer.start();
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (durduruldu) {
            if (patladi) {
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 24));
                String basariYazisi = "Başarılı!";
                int yaziGenislik = g.getFontMetrics().stringWidth(basariYazisi);
                g.drawString(basariYazisi, (getWidth() - yaziGenislik) / 2, getHeight() / 2);
            } else {
                g.setColor(Color.RED);
                g.setFont(new Font("Arial", Font.BOLD, 24));
                String hataYazisi = "Hata oluştu!";
                int yaziGenislik = g.getFontMetrics().stringWidth(hataYazisi);
                g.drawString(hataYazisi, (getWidth() - yaziGenislik) / 2, getHeight() / 2);
            }
        } else {
            if (!patladi) {
                g.setColor(Color.GREEN);
                g.fillOval(getWidth() / 2 - balonGenislik / 2, balonY, balonGenislik, balonYukseklik);
            } else {
                long gecerliZaman = System.currentTimeMillis();
                if (gecerliZaman - patlamaZamani < PATLAMA_SURESI) {
                    g.setColor(Color.ORANGE);
                    g.fillOval(getWidth() / 2 - balonGenislik / 2 - 10, balonY - 10, balonGenislik + 20, balonYukseklik + 20);
                    g.setColor(Color.YELLOW);
                    g.fillOval(getWidth() / 2 - balonGenislik / 2 - 5, balonY - 5, balonGenislik + 10, balonYukseklik + 10);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!durduruldu) {
            balonY -= balonHizi;

            if (balonY <= 200) {
                boolean assertionKontrol = kosulKontrolEt();
                durduruldu = true;
                timer.stop();

                if (assertionKontrol) {
                    patladi = true;
                    patlamaZamani = System.currentTimeMillis();
                } else {
                    patladi = false;
                }
            }
            repaint();
        }
    }

    private boolean kosulKontrolEt() {
        // Bu metot, her zaman 'true' döndürerek başarı durumunu simüle eder.
        return true;
    }
}
