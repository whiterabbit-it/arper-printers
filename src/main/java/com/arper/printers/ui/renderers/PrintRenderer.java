package com.arper.printers.ui.renderers;

import java.awt.Component;
import javax.print.PrintService;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author owentar
 */
public class PrintRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        if (value instanceof PrintService) {
            PrintService printService = (PrintService) value;
            setText(printService.getName());
        }
        
        return this;
    }
    
}
