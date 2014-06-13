<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../header-title.jsp"%>

<div class="panel panel-body">
	<form class="form-horizontal" action="#" role="form">
		<div class="FormularioCadastro FormularioGeral panel panel-default form-group" data-page-consulta="termoaberturaconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="termoaberturacadastro.action">
			<div class="panel-body">
				
				<!-- Campos ocultos -->
				<input id="idTermoAbertura" type="hidden" disabled="disabled" class="form-control" value="${vo.idTermoAbertura }" />
				<input id="idProjeto" type="hidden" disabled="disabled" class="form-control" value="${projetoSelecionado.idProjeto }" />
						
				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Projeto</label>
					<div class="col-sm-3">
						<input id="nomeProjeto" type="text" value="${projetoSelecionado.nome}" disabled="disabled" class="form-control" />
					</div>
					
					<label class="col-sm-2 control-label text-right">Versão</label>
					<div class="col-sm-2">
						<input id="versao" type="text" value="${vo.versao}" disabled="disabled" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label text-right">Status</label>
					<div class="col-sm-2">
						<input id="statusDescritivo" type="text" value="${vo.statusTermoAberturaDescritivo}" disabled="disabled" class="form-control" />
					</div>
					
					<label class="col-sm-1 control-label text-right">Gerente</label>

					<div class="col-sm-4">
						<select id="idPessoaGerente" class="form-control">
							<option >[Selecione o Gerente]</option>
							<c:forEach items="${pessoas}" var="pessoa">
								<option <c:if test="${vo.idPessoaGerente == pessoa.idPessoa}">selected="selected"</c:if> value="${pessoa.idPessoa }">${pessoa.pessoa.nome} ${pessoa.cargo.nome } ${pessoa.unidadeOrganizacional.pessoa.nome }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-12">
						<div class="well block">
							<div class="tabbable">
								<ul class="nav nav-tabs nav-justified">
									<li class="active"><a href="#justified-tab1" data-toggle="tab">Justificativa</a></li>
									<li><a href="#justified-tab2" data-toggle="tab">Objetivos</a></li>
									<li><a href="#justified-tab3" data-toggle="tab">Descrição do Produto</a></li>
									<li><a href="#justified-tab4" data-toggle="tab">Requisitos</a></li>
									<li><a href="#justified-tab5" data-toggle="tab">Riscos</a></li>
									<li><a href="#justified-tab6" data-toggle="tab">Marcos</a></li>
									<li><a href="#justified-tab7" data-toggle="tab">Investimento</a></li>
									<li><a href="#justified-tab8" data-toggle="tab">Patrocinador</a></li>
								</ul>
			
								<div class="tab-content with-padding">
									<div class="tab-pane fade in active" id="justified-tab1">
										<div class="panel panel-default">
											<div class="panel-body">
												<div class="block-inner">
													<textarea id="justificativa" rows="20" class="editor form-control" placeholder="Digite o texto aqui...">${vo.justificativa}</textarea>
												</div>
											</div>
										</div>
									</div>
			
									<div class="tab-pane fade" id="justified-tab2">
										<div class="panel panel-default">
											<div class="panel-body">
												<div class="block-inner">
													<textarea id="objetivos" rows="20" class="editor form-control" placeholder="Digite o texto aqui...">${vo.objetivos}</textarea>
												</div>
											</div>
										</div>
									</div>
			
									<div class="tab-pane fade" id="justified-tab3">
										<div class="panel panel-default">
											<div class="panel-body">
												<div class="block-inner">
													<textarea id="descricaoProduto" rows="20" class="editor form-control" placeholder="Digite o texto aqui...">${vo.descricaoProduto}</textarea>
												</div>
											</div>
										</div>
									</div>
			
									<div class="tab-pane fade" id="justified-tab4">
										<div class="panel panel-default">
											<div class="panel-body">
												<div class="block-inner">
													<textarea id="requisitos" rows="20" class="editor form-control" placeholder="Digite o texto aqui...">${vo.requisitos}</textarea>
												</div>
											</div>
										</div>
									</div>
									
									<div class="tab-pane fade" id="justified-tab5">
										<div class="panel panel-default">
											<div class="panel-body">
												<div class="block-inner">
													<textarea id="riscos" rows="20" class="editor form-control" placeholder="Digite o texto aqui...">${vo.riscos}</textarea>
												</div>
											</div>
										</div>
									</div>
									
									<div class="tab-pane fade" id="justified-tab6">
										<div class="panel panel-default">
											<div class="panel-body">
												<div class="block-inner">
													<textarea id="marcos" rows="20" class="editor form-control" placeholder="Digite o texto aqui...">${vo.marcos}</textarea>
												</div>
											</div>
										</div>
									</div>
									
									<div class="tab-pane fade" id="justified-tab7">
										<div class="panel panel-default">
											<div class="panel-body">
												<div class="block-inner">
													<textarea id="investimento" rows="20" class="editor form-control" placeholder="Digite o texto aqui...">${vo.investimento}</textarea>
												</div>
											</div>
										</div>
									</div>
									
									<div class="tab-pane fade" id="justified-tab8">
										<div class="panel panel-default">
											<div class="panel-body">
												<div class="block-inner">
													<textarea id="patrocinador" rows="20" class="editor form-control" placeholder="Digite o texto aqui...">${vo.patrocinador}</textarea>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /justified tabs -->

				<%@include file="../../botoes-cadastro.jsp"%>
			</div>
		</div>

	</form>
</div>

<script type="text/javascript">
	
</script>