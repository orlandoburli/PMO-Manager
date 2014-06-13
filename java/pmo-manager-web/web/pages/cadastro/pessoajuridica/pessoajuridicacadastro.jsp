<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="pessoajuridicaconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="pessoajuridicacadastro.action">
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
					<div class="col-sm-7">
						<input id="idPessoa" type="text" disabled="disabled" class="form-control" value="${vo.idPessoa }" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Nome</label>
					<div class="col-sm-7">
						<input id="pessoa.nome" type="text" value="${vo.pessoa.nome}" autofocus="autofocus" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">CNPJ</label>
					<div class="col-sm-7">
						<input id="cnpj" type="text" value="${vo.cnpj}" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Razão Social</label>
					<div class="col-sm-7">
						<input id="razaoSocial" type="text" value="${vo.razaoSocial}" class="form-control" />
					</div>
				</div>
				
				<%@include file="../../botoes-cadastro.jsp"%>
			</div>
		</div>

	</form>
</div>

<script type="text/javascript">
	
</script>