<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="pessoafisicaconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="pessoafisicacadastro.action">
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
					<label class="col-sm-2 control-label text-right">Cpf</label>
					<div class="col-sm-7">
						<input id="cpf" type="text" value="${vo.cpf}" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">RG</label>
					<div class="col-sm-7">
						<input id="rg" type="text" value="${vo.rg}" class="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Cargo</label>

					<div class="col-sm-7">
						<select id="idCargo" class="form-control">
							<option >[Selecione o Cargo]</option>
							<c:forEach items="${cargos}" var="cargo">
								<option <c:if test="${vo.idCargo == cargo.idCargo}">selected="selected"</c:if> value="${cargo.idCargo}">${cargo.nome}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Unidade Organizacional</label>

					<div class="col-sm-7">
						<select id="idPessoaUnidadeOrganizacional" class="form-control">
							<option >[Selecione a Unidade Organizacional]</option>
							<c:forEach items="${unidades}" var="unidade">
								<option <c:if test="${vo.idPessoaUnidadeOrganizacional == unidade.idPessoa}">selected="selected"</c:if> value="${unidade.idPessoa }">${unidade.pessoa.nome}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Data nascimento</label>
					<div class="col-sm-7">
						<fmt:formatDate value="${vo.dataNascimento.time}" pattern="dd/MM/yyyy" var="dataNascimentoFormatada" />
						<input id="dataNascimento" type="text" value="${dataNascimentoFormatada}" class="form-control datepicker" />
					</div>
				</div>
				
				<%@include file="../../botoes-cadastro.jsp"%>
			</div>
		</div>

	</form>
</div>

<script type="text/javascript">
	
</script>