<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="usuarioconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="usuariocadastro.action">
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
					<div class="col-sm-7">
						<input id="idUsuario" type="text" disabled="disabled" class="form-control" value="${vo.idUsuario }" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Nome</label>
					<div class="col-sm-7">
						<input id="nome" type="text" value="${vo.nome}" autofocus="autofocus" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Login</label>
					<div class="col-sm-7">
						<input id="login" type="text" value="${vo.login}" autofocus="autofocus" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Email</label>
					<div class="col-sm-7">
						<input id="email" type="email" value="${vo.email}" autofocus="autofocus" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Senha</label>
					<div class="col-sm-7">
						<input id="senha" type="password" value="${vo.senha}" autofocus="autofocus" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Ativo</label>

					<div class="col-sm-7">
						<select id="ativo" class="form-control">
							<option <c:if test="${vo.ativo == 'N'}">selected="selected"</c:if> value="N">N�o</option>
							<option <c:if test="${vo.ativo == 'S'}">selected="selected"</c:if> value="S">Sim</option>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Perfil</label>

					<div class="col-sm-7">
						<select id="idPerfil" class="form-control">
							<option >[Selecione o Perfil]</option>
							<c:forEach items="${perfis}" var="perfil">
								<option <c:if test="${vo.idPerfil == perfil.idPerfil}">selected="selected"</c:if> value="${perfil.idPerfil }">${perfil.nome}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<div>
						<label class="col-sm-2 control-label text-right">Foto do usu�rio</label> <a href="#" class="BotaoSelecionarImagem btn btn-primary" data-image-retorno="#imgFoto" data-input-retorno="#pathFoto"><i class="icon-image"></i> Selecionar imagem</a> <img id="imgFoto" name="imgFoto" src="${vo.pathFoto}" class="thumb img-thumbnail" style="max-height: 120px; max-width: 120px; width: auto; height: auto;" /> <input type="hidden" id="pathFoto" name="pathFoto" value="${vo.pathFoto}" class="form-control" />
					</div>
				</div>

				<%@include file="../../utils/lista_imagens.jsp"%>
				<%@include file="../../botoes-cadastro.jsp"%>
			</div>
		</div>

	</form>
</div>

<script type="text/javascript">
	
</script>