package com.jiang.localspringbootdemo.config.thymeleafproperties;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
//@Component
public class PDFGeneratorAA {


	//@Autowired
	private TemplateEngine templateEngine;

	//@Autowired
	//private org.thymeleaf.spring5.SpringTemplateEngine springTemplateEngine;






	/**
	 * Process the template and generate a PDF of this rendered template.
	 *
	 * @param ouputPDF Target pdf file.
	 * @param template Source template.
	 * @param model The data for the template.
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public void generate(File ouputPDF, String template, Map<String, ?> model) throws FileNotFoundException, DocumentException {
		final Context ctx = new Context();
	    ctx.setVariables(model);


	    String htmlContent = templateEngine.process(template, ctx);

	    ITextRenderer renderer = new ITextRenderer();
	    ITextFontResolver fontResolver = renderer.getFontResolver(); 
	    try {
			fontResolver.addFont("templates/simsun.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    // 解决图片的相对路径问题      
        //renderer.getSharedContext().setBaseURL("file:/C:/Users/Administrator.WIN7-1610080938/Desktop/word2pdf/");   
	    
	    renderer.setDocumentFromString(htmlContent);
	    renderer.layout();
	    renderer.createPDF(new FileOutputStream(ouputPDF));
	}
}
