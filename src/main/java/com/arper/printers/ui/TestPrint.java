package com.arper.printers.ui;

import java.awt.print.PrinterJob;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.print.DocFlavor;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;

public class TestPrint {
	public static void main(String args[]) {
		// Input the file
		FileInputStream textstream = null;
		try {
			textstream = new FileInputStream("C:/Test.html");
		} catch (FileNotFoundException ffne) {
		}
		if (textstream == null) {
			return;
		}
		// Set the document type
		DocFlavor myFormat = DocFlavor.INPUT_STREAM.TEXT_HTML_UTF_8;
		// Create a Doc
		// Build a set of attributes
		PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
		aset.add(new Copies(1));
//		aset.add(MediaSize.ISO.A4);
//		aset.add(Sides.DUPLEX);
		// discover the printers that can print the format according to the
		// instructions in the attribute set
		// Create a print job from one of the print services
//		if (services.length > 0) {
			PrinterJob printJob = PrinterJob.getPrinterJob();
			 //--- Show the print dialog box. If the user click the
		    //--- print button we then proceed to print else we cancel
		    //--- the process.
		    if (printJob.printDialog(aset)) {
		      try {
		        printJob.print();
		      } catch (Exception PrintException) {
		        PrintException.printStackTrace();
		      }
		    }
//		}
	}
}
