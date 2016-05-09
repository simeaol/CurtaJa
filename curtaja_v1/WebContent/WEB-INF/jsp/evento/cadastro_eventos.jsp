<!DOCTYPE html>
<html lang="pt">
<head>
<title>Cadastro de Eventos</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script language="JavaScript1.2" type="text/javascript" src="mm_css_menu.js"></script>
<style type="text/css" media="screen">
	@import url("./layout_cadastro_eventos.css");
</style>
<style type="text/css">
	html{
      background:url(cadastro_pessoal.jpg) no-repeat center center fixed;
      - moz-background-size: cover;
      - o-background-sizer: cover;
      background-suze:cover;
	  background-position: 50%;
	  background-size: 1500px;

      }	  
</style>

<style type="text/css">
 #transp { 
 	 width: 80%; 
	 height: 560px; 
	 border: 0px solid black; 
	 opacity: 0.92;
     -moz-opacity:0.90;
     -webkit-opacity:0.90; }
</style>
</head>
<body>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<div align="right" id="transp">
 <div id="transp" align="center" style="background-color: #821F89" >

  <form name="myForm" action='cadastroevento' method="post" enctype="multipart/form-data">
  <br />
		<p>
			<label for = "companyName"><b>Nome Empresa:</b></label>
			<input type="text" name="compName" size=50 maxlength=20 align="center-left" required/>
			</br>
		</p>
	
		<p>
			<label for = "eventoName"><b>Nome Evento:  </b></label>
			<input type="text" name="eventName" placeholder="Ebola Party 2016" size=50 minlength=2 maxlength=20 align="center-left" required/>
			</br>
		</p>
	
		<p>
			<label for = "dataEvento" align="left"><b>Data Evento:</b></label>
			<input type="date" name="eventDate" required/>
			</br>
		</p>
		
		<p>
			<label for = "eventoEndereco"><b>Endereço Evento:  </b></label>
			<input type="text" name="eventAddress" placeholder="R. Ana Marques de Azevedo, 51, apt-30" size=50 minlength=10 maxlength=100 align="center-left" required/>
			</br>
		</p>
		
		<p>
			<label for = "eventoCidade"><b>Cidade Evento:  </b></label>
			<input type="text" name="eventCity" placeholder="São Paulo - SP" size=50 minlength=5 maxlength=20 align="center-left" required/>
			<br />
		</p>
	
		<p>
			<label for = "Desc"><b>Descrição:</b></label>
		</p>
	
		<p>
			<textarea placeholder="Colocar informações adicionais, como: Preço, atrações, músicos convidados, etc." rows="10" cols="50" maxlength=600 name="descricao" id="descricao" required></textarea>
		</p> 
		<br>
			<input type="file" name="fileupload" accept="image/*" required/>
		<br />
		<br>
			<input type="submit" name="enviar" value="Publicar" class = "btn btn-primary" />
	 
  </form>
   </div>
</div>
</body>
</html>
