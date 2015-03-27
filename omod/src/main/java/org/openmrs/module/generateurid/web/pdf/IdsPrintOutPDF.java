/**
 * 
 */
package org.openmrs.module.generateurid.web.pdf;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmrs.module.generateurid.GeneratedId;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

/**
 * @author Kamonyo
 *
 */
public class IdsPrintOutPDF extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter pdfWriter, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		
		//TODO: use this to have something to display
		Collection<GeneratedId> generatedIds = (Collection<GeneratedId>) model.get("generatedIds");
		
		Font infoTableValueFont = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		
		/* Setting Landscape format ... */
		doc.setPageSize(PageSize.A4);

		/* Opening document */
		doc.open();
		doc.newPage();
		Phrase custStatement = new Phrase();
		custStatement.add(new Paragraph("I acknowledge by my signature that the SWH system was installed as indicated in this report,"
				+ " and that it has been installed by ...", infoTableValueFont));
		
		doc.add(custStatement);

		doc.close();
		
	}

}
