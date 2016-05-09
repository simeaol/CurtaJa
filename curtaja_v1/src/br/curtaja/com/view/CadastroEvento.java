package br.curtaja.com.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.curtaja.com.controller.dao.EventoDao;
import br.curtaja.com.model.Evento;

@WebServlet(name="cadastroevento", urlPatterns={"/cadastroeventos", "/cadastroevento"})
@MultipartConfig
public class CadastroEvento extends HttpServlet{
	
	private final static Logger LOGGER = 
            Logger.getLogger(CadastroEvento.class.getCanonicalName());
	
	//file upload
	String filePath;
	java.io.File file;
	
	static String compNome;
	static String eventNome;
	static String data;
	static String endereco;
	static String cidade;
	static String descricao; 
	static double preco;
	
	Evento evento;
	EventoDao eventDao;	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		filePath = 
	             getServletContext().getInitParameter("fileupload"); 
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
	        HttpServletResponse response)
	        throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");

	    compNome = request.getParameter("compName");
		eventNome = request.getParameter("eventName");
		preco = Double.parseDouble(request.getParameter("preco"));
		data = request.getParameter("eventDate");
		endereco = request.getParameter("eventAddress");
		cidade = request.getParameter("eventCity");
		descricao = request.getParameter("descricao"); 
	    
	    // Create path components to save the file
	    final String path = "C:\\Temp\\flyer";
	    final Part filePart = request.getPart("fileupload");
	    final String fileName = getFileName(filePart);

	    OutputStream out = null;
	    InputStream filecontent = null;
	    final PrintWriter writer = response.getWriter();

	    try {
	        out = new FileOutputStream(new File(path + File.separator
	                + fileName));
	        filecontent = filePart.getInputStream();

	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = filecontent.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        
	       // evento = new Evento(eventNome, fileName, fileName, fileName, path, preco, imagem, evento_idCliente);
	        writer.println("Evento Publicado com sucesso !!!");
	        LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
	                new Object[]{fileName, path});
	    } catch (FileNotFoundException fne) {
	        writer.println("You either did not specify a file to upload or are "
	                + "trying to upload a file to a protected or nonexistent "
	                + "location.");
	        writer.println("<br/> ERROR: " + fne.getMessage());

	        LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
	                new Object[]{fne.getMessage()});
	    } finally {
	        if (out != null) {
	            out.close();
	        }
	        if (filecontent != null) {
	            filecontent.close();
	        }
	        if (writer != null) {
	            writer.close();
	        }
	    }
	}

	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}

}
