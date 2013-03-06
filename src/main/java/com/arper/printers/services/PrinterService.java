package com.arper.printers.services;

import java.util.List;
import javax.print.PrintService;

/**
 *
 * @author owentar
 */
public interface PrinterService {
    
    List<PrintService> getPrinters();
    
    PrintService getDefaultPrinter();
    
}
