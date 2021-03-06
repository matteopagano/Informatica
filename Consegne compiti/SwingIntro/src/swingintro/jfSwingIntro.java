/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingintro;

import java.awt.Color;

/**
 *
 * @author stefano.giacomello
 */
public class jfSwingIntro extends javax.swing.JFrame {

	/**
	 * Creates new form jfSwingIntro
	 */
	public jfSwingIntro() {
		initComponents();
	}

	private void updateColor() {
		int red,green,blue;
		
		red = jSliderRed.getValue();
		green = jSliderGreen.getValue();
		blue = jSliderBlue.getValue();
		Color c = new Color(red,green,blue);
		
		jPanelColor.setBackground(c);
	}
	
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelColor = new javax.swing.JPanel();
        jSliderRed = new javax.swing.JSlider();
        jSliderGreen = new javax.swing.JSlider();
        jSliderBlue = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelColor.setBackground(new java.awt.Color(153, 153, 153));
        jPanelColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelColorLayout = new javax.swing.GroupLayout(jPanelColor);
        jPanelColor.setLayout(jPanelColorLayout);
        jPanelColorLayout.setHorizontalGroup(
            jPanelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );
        jPanelColorLayout.setVerticalGroup(
            jPanelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        jSliderRed.setMaximum(255);
        jSliderRed.setToolTipText("");
        jSliderRed.setValue(128);
        jSliderRed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderRedStateChanged(evt);
            }
        });
        jSliderRed.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSliderRedPropertyChange(evt);
            }
        });

        jSliderGreen.setMaximum(255);
        jSliderGreen.setToolTipText("");
        jSliderGreen.setValue(128);
        jSliderGreen.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderGreenStateChanged(evt);
            }
        });

        jSliderBlue.setMaximum(255);
        jSliderBlue.setToolTipText("");
        jSliderBlue.setValue(128);
        jSliderBlue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderBlueStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSliderGreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSliderRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSliderBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jPanelColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSliderRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jSliderGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jSliderBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSliderRedPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSliderRedPropertyChange
        // TODO add your handling code here:
		
		int x= 0;
    }//GEN-LAST:event_jSliderRedPropertyChange

    private void jSliderRedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderRedStateChanged
		this.updateColor();
    }//GEN-LAST:event_jSliderRedStateChanged

    private void jSliderGreenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderGreenStateChanged
		this.updateColor();
    }//GEN-LAST:event_jSliderGreenStateChanged

    private void jSliderBlueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderBlueStateChanged
		this.updateColor();
    }//GEN-LAST:event_jSliderBlueStateChanged

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelColor;
    private javax.swing.JSlider jSliderBlue;
    private javax.swing.JSlider jSliderGreen;
    private javax.swing.JSlider jSliderRed;
    // End of variables declaration//GEN-END:variables
}
