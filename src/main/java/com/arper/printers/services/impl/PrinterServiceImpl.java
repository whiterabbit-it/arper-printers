package com.arper.printers.services.impl;

import com.arper.printers.services.PrinterService;
import java.util.Arrays;
import java.util.List;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

/**
 *
 * @author owentar
 */
public class PrinterServiceImpl implements PrinterService {

    private List<PrintService> printers;
    
    public PrinterServiceImpl() {
        printers = Arrays.asList(PrintServiceLookup.lookupPrintServices(null, null));
    }

    public List<PrintService> getPrinters() {
        return printers;
    }

    @Override
    public PrintService getDefaultPrinter() {
        return PrintServiceLookup.lookupDefaultPrintService();
    }
    
}
