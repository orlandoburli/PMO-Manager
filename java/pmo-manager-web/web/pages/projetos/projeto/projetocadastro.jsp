<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="projetoconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="projetocadastro.action">
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">C&oacute;digo</label>
					<div class="col-sm-7">
						<input id="idProjeto" type="text" disabled="disabled" class="form-control" value="${vo.idProjeto }" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Nome</label>
					<div class="col-sm-7">
						<input id="nome" type="text" value="${vo.nome}" autofocus="autofocus" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Data Inicial</label>

					<div class="col-sm-2">
						<div class="col-sm-7">
							<fmt:formatDate value="${vo.dataInicial.time}" pattern="dd/MM/yyyy" var="dataInicialFormatada" />
							<input id="dataInicial" type="text" value="${dataInicialFormatada}" class="form-control datepicker" />
						</div>
					</div>

					<label class="col-sm-2 control-label text-right">Data Final</label>

					<div class="col-sm-2">
						<div class="col-sm-7">
							<fmt:formatDate value="${vo.dataFinal.time}" pattern="dd/MM/yyyy" var="dataFinalFormatada" />
							<input id="dataFinal" type="text" value="${dataFinalFormatada}" class="form-control datepicker" />
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right"> </label>
					<div class="col-sm-7">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h6 class="panel-title">
									<i class="icon-pencil"></i>Descrição
								</h6>
							</div>
							<div class="panel-body">
								<div class="block-inner">
									<textarea id="descricao" rows="20" class="editor form-control" placeholder="Digite o texto aqui...">${vo.descricao}</textarea>
								</div>
							</div>
						</div>
					</div>
				</div>

				<%@include file="../../botoes-cadastro.jsp"%>
			</div>
		</div>

	</form>
</div>

<script type="text/javascript">
	
</script>