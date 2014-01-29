
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arnaud
 */
public class Fenetre extends javax.swing.JFrame {
    private enum STATE { INIT, FIRST, SECOND };
    private STATE state;
    private List<Line2D.Float> lineList;
    private Line2D.Float tmpLine;
    /**
     * Creates new form Fenetre
     */
    private void traceRedLine() {
        repaint();
    }
    
    private void traceBlacLine() {
        lineList.add(new Line2D.Float(tmpLine.getP1(), tmpLine.getP2()));
        tmpLine.setLine(0, 0, 0, 0);
        repaint();
    }
    
    private void setP1(int x, int y) {
        double x2 = tmpLine.getX2();
        double y2 = tmpLine.getY2();
        tmpLine.setLine(x, y, x2, y2);
    }
    
    private void setP2(int x, int y) {
        double x1 = tmpLine.getX1();
        double y1 = tmpLine.getY1();
        tmpLine.setLine(x1, y1, x, y);  
    }
    
    public Fenetre() {
        initComponents();
        state = STATE.INIT;
        lineList = new ArrayList();
        tmpLine = new Line2D.Float();
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.black);
        for( Line2D.Float l : lineList) {
            g2.draw(l);
        }
        g2.setColor(Color.red);
        g2.draw(tmpLine);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 629, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        switch(state) {
            case INIT:
                state = STATE.FIRST;
                setP1(evt.getX(), evt.getY());
                break;
            case FIRST:
                throw new RuntimeException("MouseReleased - INIT : Impossible action");
            case SECOND:
                throw new RuntimeException("MouseReleased - INIT : Impossible action");
        } 
    }//GEN-LAST:event_formMousePressed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        switch(state) {
            case INIT:
                state = STATE.INIT;
                // pas d'action
                break;
            case FIRST:
                state = STATE.SECOND;
                setP2(evt.getX(), evt.getY());
                traceRedLine();
                break;
            case SECOND:
                state = STATE.SECOND;
                setP2(evt.getX(), evt.getY());
                traceRedLine();
                break;
        }
    }//GEN-LAST:event_formMouseMoved

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        switch(state) {
            case INIT:
                throw new RuntimeException("MouseReleased - INIT : Impossible action");
            case FIRST:
                state = STATE.INIT;
                setP1(0, 0);
                break;
            case SECOND:
                state = STATE.INIT;
                traceBlacLine();
                break;
        }
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        switch(state) {
            case INIT:
                state = STATE.INIT;
                // pas d'action
                break;
            case FIRST:
                state = STATE.SECOND;
                setP2(evt.getX(), evt.getY());
                traceRedLine();
                break;
            case SECOND:
                state = STATE.SECOND;
                setP2(evt.getX(), evt.getY());
                traceRedLine();
                break;
        }
    }//GEN-LAST:event_formMouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fenetre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}