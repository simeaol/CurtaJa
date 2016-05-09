package br.curtaja.com.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import br.curtaja.com.controller.dao.ClienteDao;
import br.curtaja.com.model.Cliente;

@WebServlet(name = "adicionaContato", urlPatterns = { "/adicionaContato", "/adicionacontato" })
public class CadastroCliente extends HttpServlet {
	
	private final static Logger LOGGER = 
            Logger.getLogger(CadastroCliente.class.getCanonicalName());

	File file;
	String filePath;

	static String nome;
	static String email;
	static String cpf;
	static String empresa;
	static String categoria;
	static String endereco;
	static String cidade;
	static String telefone;
	static String senha;
	static String logo;

	Date dataCadastro;

	Cliente cliente;
	ClienteDao cDao;

	public void init() throws ServletException {
		filePath = getServletContext().getInitParameter("fileupload");
	};

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		nome = req.getParameter("name");
		email = req.getParameter("email");
		cpf = req.getParameter("cpf");
		empresa = req.getParameter("empresa");
		categoria = req.getParameter("categories");
		endereco = req.getParameter("endereco");
		cidade = req.getParameter("cidade");
		telefone = req.getParameter("telefone");
		senha = req.getParameter("senha");
		dataCadastro = getDataCadastro();

		boolean isMultipart = ServletFileUpload.isMultipartContent(req);

		// Create path components to save the file
		final String path = "C:\\Temp\\flyer";
		final Part filePart = req.getPart("fileupload");
		final String fileName = req.getParameter("fileupload");//getFileName(filePart);
		logo = path.toString() + "\\" + fileName;
		
		cliente = new Cliente(nome, email, cpf, empresa, getCategoria(categoria), endereco, cidade, telefone, senha,
				dataCadastro, dataCadastro, logo, 4);
		cDao = new ClienteDao();
		cDao.cadastrar(cliente);
		System.out.println("Dados do Cliente: "+cliente.toString());

		OutputStream out = null;
		InputStream filecontent = null;
		final PrintWriter writer = resp.getWriter();

		try {
			out = new FileOutputStream(new File(path + File.separator + fileName));
			filecontent = filePart.getInputStream();

			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			writer.println("Seu cadastro foi realizado com sucesso !!!\nVolte para a tela principal e faça login.");
			// LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
			// new Object[]{fileName, path});
		} catch (FileNotFoundException fne) {
			writer.println("You either did not specify a file to upload or are "
					+ "trying to upload a file to a protected or nonexistent " + "location.");
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

	private Date getDataCadastro() {
		java.util.Date dataUtil = new java.util.Date();
		java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
		return dataSql;
	}

	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	private int getCategoria(String categoria) {
		int id = 0;

		if ("bar".equals(categoria))
			id = 1;

		if ("evento".equals(categoria))
			id = 2;

		if ("festa".equals(categoria))
			id = 3;

		if ("show".equals(categoria))
			id = 4;

		if ("discoteca".equals(categoria))
			id = 5;

		if ("djs_bandas".equals(categoria))
			id = 6;

		return id;

	}

}
