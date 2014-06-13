<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Datatable inside panel body -->

<%@include file="../../header-title.jsp"%>

<div class="panel panel-default panel-body">
	<div class="panel form-group">
		<div class="col-md-1 text-right">
			<label class="control-label text-right">Pesquisar por: </label>
		</div>
		<div class="col-sm-2">
			<select id="ParametroPesquisa" class="form-control">
				<option value="Versao">Versão</option>
				<option value="Versao">Versão</option>
			</select>
		</div>

		<div class="col-sm-3">
			<input id="PesquisarPor" type="text" autofocus="autofocus" autocomplete="off" class="form-control" tabindex="3" />
		</div>

		<div class="col-sm-2 ">
			<button tabindex="4" title="Clique para pesquisar [Atalho: ENTER]" class="BotaoPesquisar btn btn-default">Pesquisar</button>
		</div>
		<div class="col-sm-10"></div>
	</div>

	<c:set var="customButtons">
		<button title="Voltar para a consulta de projetos" class="BotaoVoltarProjeto btn btn-lg btn-success tip">
			<i class="icon-undo2"></i> Voltar para Projetos
		</button>
		
		<button title="Gerar PDF" class="BotaoGerarPDF btn btn-lg btn-info tip">
			<i class="icon-file-pdf"></i> Gerar PDF
		</button>
		
		<button title="Finalizar Termo" class="BotaoFinalizarTermo btn btn-lg btn-primary tip">
			<i class="icon-checkmark3"></i> Finalizar Termo
		</button>
		
		<button title="Finalizar Termo" class="BotaoCancelarTermo btn btn-lg btn-danger tip">
			<i class="icon-cancel-circle2"></i> Cancelar Termo
		</button>
		
		<button type="button" class="BotaoNovo2 btn btn-lg btn-primary tip" title="Novo Registro (Ctrl + N)">
			<i class="icon-plus-circle"></i> Novo
		</button>
		
	</c:set>
	
	<div class="panel-body">
		<div class="DataGridConsulta" data-page="termoaberturaconsulta.grid.action" data-page-size="8" data-detail-page="termoaberturacadastro.action"></div>
	</div>
	
	<c:set var="hideExcluir" value="hide"/>
	<c:set var="hideNovo" value="hide"/>

	<%@include file="../../botoes-consulta.jsp"%>
	<%@include file="../../messages.jsp"%>
</div>
<!-- /datatable inside panel body -->

<!-- /datatable inside panel body -->
<script type="text/javascript">
	function alterarTermo(operacao, funcaoOk) {
		if (!registroSelecionado2()) {
			return;
		}
		
		var paginaCadastro = "termoaberturacadastro.action";
		var paginaBase = paginaCadastro.split(".")[0];
		var paginaFinal = paginaBase + "." + operacao + "." + paginaCadastro.split(".")[1];
	
		paginaFinal += "?" + getSelectedDataId();

		var params = {
			'operacao' : operacao
		};

		$.ajax({
			url : paginaFinal,
			type : 'POST',
			data : params,
			beforeSend : function(data) {
				// console.log("loading...");
			},
			success : function(data) {

				var retorno = $.parseJSON(data);

				if (retorno.sucesso) {
					mensagemInfo(retorno.mensagem);
					loadDataGrid();
					funcaoOk();
				} else {
					mensagemErro(retorno.mensagem);
					$("#" + retorno.fieldFocus).focus();
				}
			},
			error : function(erro) {
				console.log("Erro no load ajax! " + erro);
			}
		});
	}

	$(".BotaoVoltarProjeto").click(function() {
		var paginaAcoes = "projetoconsulta.action";
		loadPage(paginaAcoes);
		loadJs("web/pages/js/consulta.js");
		loadJs("web/pages/js/load.js");
	});
	
	$(".BotaoFinalizarTermo").click(function() {
		confirmacaoModal('Confirma a finalização deste termo?', 'Confirmação', function() {
			// Funcao sim - Finaliza o termo
			alterarTermo('finalizar');
		});
	});
	
	$(".BotaoNovo2").click(function() {
		if (registroSelecionado2()) {
			confirmacaoModal('Deseja iniciar um novo termo com base na versão selecionada?', 'Confirmação', function() {
				// Funcao sim - Finaliza o termo
				alterarTermo('copiar', function() {
					// Se gerou corretamente, editar a versao que esta em ultimo
					setTimeout(function() {
						editar();	
					}, 1500);
				});
				
				// TODO
			}, function() {
				 // Nao - faz o padrao, novo registro somente.
				novo();
			});	
		} else {
			novo();
		}
		
	});
	
	$(".BotaoCancelarTermo").click(function() {
		confirmacaoModal('Confirma o cancelamento deste termo?', 'Confirmação', function() {
			// Funcao sim - Cancela o termo
			alterarTermo('cancelar');
		});
	});
	
</script>