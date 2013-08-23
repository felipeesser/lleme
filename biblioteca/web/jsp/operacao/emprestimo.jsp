<jsp:useBean id="mensagem" class="java.lang.String" scope="session" />
<%// Recupera Usuario
			ic.tcc00175.biblioteca.model.Usuario usuario = (ic.tcc00175.biblioteca.model.Usuario) request
					.getSession().getAttribute("usuario");
			if (usuario == null)
				usuario = new ic.tcc00175.biblioteca.model.AlunoGraduacao();

			// Recupera material
			ic.tcc00175.biblioteca.model.Material material = (ic.tcc00175.biblioteca.model.Material) request
					.getSession().getAttribute("material");
			if (material == null)
				material = new ic.tcc00175.biblioteca.model.Livro();

			//Recupera exemplar
			ic.tcc00175.biblioteca.model.Exemplar exemplar = (ic.tcc00175.biblioteca.model.Exemplar) request
					.getSession().getAttribute("exemplar");
			if (exemplar == null)
				exemplar = new ic.tcc00175.biblioteca.model.Exemplar();

			// Recupera emprestimo
			ic.tcc00175.biblioteca.model.Emprestimo emprestimo = (ic.tcc00175.biblioteca.model.Emprestimo) request
					.getSession().getAttribute("emprestimo");
			if (emprestimo == null)
				emprestimo = new ic.tcc00175.biblioteca.model.Emprestimo();

			// Cria tabela de lista de conteudo
			ic.tcc00175.biblioteca.view.Tabela tabela = (ic.tcc00175.biblioteca.view.Tabela) request
					.getSession().getAttribute("tabela");
			if (tabela == null
					|| !tabela.getClass().getName().equals(
							"ic.tcc00175.biblioteca.view.TabelaEmprestimo")) {
				tabela = new ic.tcc00175.biblioteca.view.TabelaEmprestimo(12,
						usuario);
				request.getSession().setAttribute("tabela", tabela);
			} else
				tabela.setColecao(usuario.getLnkEmprestimo());
			//Cria formulario de cadastro
			ic.tcc00175.biblioteca.view.FormularioEmprestimo formulario = new ic.tcc00175.biblioteca.view.FormularioEmprestimo();

			%>
<html>
<head>
<title>Projeto de Sistemas de Software, Biblioteca</title>
</head>
<body>
<div align="center">
<FORM NAME="cadastro"
	ACTION="../servlet/SystemController?page=../jsp/operacao/emprestimo.jsp"
	METHOD="POST" NAME="cadastro">
<TABLE BORDER="0" CELLPADDING="1" CELLSPACING="2" SUMMARY="">
	<TR>
		<td align="CENTER" valign="TOP"><%=tabela.getTabela()%></td>
		<td valign="TOP"><%=formulario.getFormulario(usuario, material, exemplar,
							emprestimo)%></td>
	</TR>

	<TR>
		<TD>
		<DIV ALIGN="center"><jsp:include page="../botoesColecao.jsp"
			flush="true" /></DIV>
		</TD>
		<TD>
		<DIV ALIGN="center"><script language="JavaScript">
								function selectUsuario(){
								document.cadastro.command.value="SelUsuario";
								document.cadastro.submit();
								}
								function selectMaterial(){
								document.cadastro.command.value="SelMaterial";
								document.cadastro.submit();
								}
                                function limpar(){
                                document.cadastro.command.value="NewEmprestimo";
                                document.cadastro.submit();
                                }
                                function incluir(){
                                document.cadastro.command.value="AddEmprestimo";
                                document.cadastro.submit();
                                }
                                function recuperar(){
                                document.cadastro.command.value="GetEmprestimo";
                                document.cadastro.submit();
                                }
                                function atualizar(){
                                document.cadastro.command.value="UpdEmprestimo";
                                document.cadastro.submit();
                                }
                                function excluir(){
                                document.cadastro.command.value="RemEmprestimo";
                                document.cadastro.submit();
                                }
                            </script> <INPUT TYPE="hidden"
			NAME="command" VALUE="AddEmprestimo" SIZE="1" MAXLENGTH="30"><INPUT
			TYPE="submit" VALUE="Add"> <INPUT TYPE="button" VALUE="Get"
			disabled="disabled" onclick="recuperar();"> <INPUT TYPE="button"
			disabled="disabled" VALUE="Upd" onclick="atualizar();"> <INPUT
			TYPE="button" VALUE="Del" onclick="excluir();"> <INPUT TYPE="button"
			VALUE="New" onclick="limpar();"></DIV>
		</TD>
	</TR>
	<TR>
		<TD bordercolor="RED">
		<DIV ALIGN="center"><TEXTAREA NAME="mensagens" COLS="60" ROWS="4"
			WRAP="on" READONLY>Mensagens:&nbsp;<%="\n" + mensagem%></TEXTAREA></DIV>
		</TD>
		<TD>(*) Campos de preenchimento obrigat&oacute;rio <br>
		(C) Chave de recupera&ccedil;&atilde;o</TD>
	</TR>
</TABLE>
</FORM>
</div>
<%@ include file="../../html/footer.html"%>
</body>
</html>
    