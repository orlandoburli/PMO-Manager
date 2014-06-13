<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="perfilconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="perfilcadastro.action">
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
					<div class="col-sm-7">
						<input id="idPerfil" type="text" disabled="disabled" class="form-control" value="${vo.idPerfil }" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Nome</label>
					<div class="col-sm-7">
						<input id="nome" type="text" value="${vo.nome}" autofocus="autofocus" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Ativo</label>

					<div class="col-sm-7">
						<select id="ativo" class="form-control">
							<option <c:if test="${vo.ativo == 'N'}">selected="selected"</c:if> value="N">Não</option>
							<option <c:if test="${vo.ativo == 'S'}">selected="selected"</c:if> value="S">Sim</option>
						</select>
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