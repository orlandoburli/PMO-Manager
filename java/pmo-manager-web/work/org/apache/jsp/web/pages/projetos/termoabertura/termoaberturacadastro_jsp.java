/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.54
 * Generated at: 2014-06-12 16:21:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.web.pages.projetos.termoabertura;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class termoaberturacadastro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/web/pages/projetos/termoabertura/../../header-title.jsp", Long.valueOf(1402583704000L));
    _jspx_dependants.put("/web/pages/projetos/termoabertura/../../botoes-cadastro.jsp", Long.valueOf(1402086481000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write("<!-- Page header -->\n");
      out.write("<div class=\"page-header\">\n");
      out.write("\t<div class=\"page-title\">\n");
      out.write("\t\t<h3>\n");
      out.write("\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${titulo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" <small>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${subtitulo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</small>\n");
      out.write("\t\t</h3>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("<!-- /page header -->\n");
      out.write("\n");
      out.write("<!-- Breadcrumbs line -->\n");
      out.write("<div class=\"breadcrumb-line\">\n");
      out.write("\t<ul class=\"breadcrumb\">\n");
      out.write("\t\t<li><a data-link=\"blank.admin\">Home</a></li>\n");
      out.write("\t\t<li><a>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${subMenu}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a></li>\n");
      out.write("\t\t<li class=\"active\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${menuAtivo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</li>\n");
      out.write("\t</ul>\n");
      out.write("</div>\n");
      out.write("<!-- /breadcrumbs line -->");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"panel panel-body\">\n");
      out.write("\t<form class=\"form-horizontal\" action=\"#\" role=\"form\">\n");
      out.write("\t\t<div class=\"FormularioCadastro FormularioGeral panel panel-default form-group\" data-page-consulta=\"termoaberturaconsulta.action\" data-page-operacao=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${operacao}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" data-page-cadastro=\"termoaberturacadastro.action\">\n");
      out.write("\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<!-- Campos ocultos -->\n");
      out.write("\t\t\t\t<input id=\"idTermoAbertura\" type=\"hidden\" disabled=\"disabled\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.idTermoAbertura }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\n");
      out.write("\t\t\t\t<input id=\"idProjeto\" type=\"hidden\" disabled=\"disabled\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${projetoSelecionado.idProjeto }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t<label class=\"col-sm-2 control-label text-right\">Projeto</label>\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t\t\t\t<input id=\"nomeProjeto\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${projetoSelecionado.nome}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" disabled=\"disabled\" class=\"form-control\" />\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<label class=\"col-sm-2 control-label text-right\">Versão</label>\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t\t\t\t<input id=\"versao\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.versao}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" disabled=\"disabled\" class=\"form-control\" />\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t<label class=\"col-sm-2 control-label text-right\">Status</label>\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t\t\t\t<input id=\"statusDescritivo\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.statusTermoAberturaDescritivo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" disabled=\"disabled\" class=\"form-control\" />\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<label class=\"col-sm-1 control-label text-right\">Gerente</label>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t\t\t\t<select id=\"idPessoaGerente\" class=\"form-control\">\n");
      out.write("\t\t\t\t\t\t\t<option >[Selecione o Gerente]</option>\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-12\">\n");
      out.write("\t\t\t\t\t\t<div class=\"well block\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"tabbable\">\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"nav nav-tabs nav-justified\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<li class=\"active\"><a href=\"#justified-tab1\" data-toggle=\"tab\">Justificativa</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#justified-tab2\" data-toggle=\"tab\">Objetivos</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#justified-tab3\" data-toggle=\"tab\">Descrição do Produto</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#justified-tab4\" data-toggle=\"tab\">Requisitos</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#justified-tab5\" data-toggle=\"tab\">Riscos</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#justified-tab6\" data-toggle=\"tab\">Marcos</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#justified-tab7\" data-toggle=\"tab\">Investimento</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#justified-tab8\" data-toggle=\"tab\">Patrocinador</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"tab-content with-padding\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"tab-pane fade in active\" id=\"justified-tab1\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"panel panel-default\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"block-inner\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<textarea id=\"justificativa\" rows=\"20\" class=\"editor form-control\" placeholder=\"Digite o texto aqui...\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.justificativa}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"tab-pane fade\" id=\"justified-tab2\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"panel panel-default\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"block-inner\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<textarea id=\"objetivos\" rows=\"20\" class=\"editor form-control\" placeholder=\"Digite o texto aqui...\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.objetivos}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"tab-pane fade\" id=\"justified-tab3\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"panel panel-default\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"block-inner\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<textarea id=\"descricaoProduto\" rows=\"20\" class=\"editor form-control\" placeholder=\"Digite o texto aqui...\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.descricaoProduto}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"tab-pane fade\" id=\"justified-tab4\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"panel panel-default\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"block-inner\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<textarea id=\"requisitos\" rows=\"20\" class=\"editor form-control\" placeholder=\"Digite o texto aqui...\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.requisitos}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"tab-pane fade\" id=\"justified-tab5\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"panel panel-default\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"block-inner\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<textarea id=\"riscos\" rows=\"20\" class=\"editor form-control\" placeholder=\"Digite o texto aqui...\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.riscos}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"tab-pane fade\" id=\"justified-tab6\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"panel panel-default\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"block-inner\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<textarea id=\"marcos\" rows=\"20\" class=\"editor form-control\" placeholder=\"Digite o texto aqui...\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.marcos}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"tab-pane fade\" id=\"justified-tab7\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"panel panel-default\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"block-inner\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<textarea id=\"investimento\" rows=\"20\" class=\"editor form-control\" placeholder=\"Digite o texto aqui...\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.investimento}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"tab-pane fade\" id=\"justified-tab8\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"panel panel-default\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"block-inner\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<textarea id=\"patrocinador\" rows=\"20\" class=\"editor form-control\" placeholder=\"Digite o texto aqui...\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.patrocinador}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<!-- /justified tabs -->\n");
      out.write("\n");
      out.write("\t\t\t\t");
      out.write("\n");
      out.write("<div class=\"FormularioBotoes form-actions text-right\">\n");
      out.write("\t<button type=\"button\" title=\"Salvar (Ctrl + S)\" class=\"BotaoSalvar btn btn-lg btn-primary tip\">\n");
      out.write("\t\t<i class=\"icon-disk\"></i> Salvar\n");
      out.write("\t</button>\n");
      out.write("\n");
      out.write("\t<button type=\"button\" title=\"Excluir (Ctrl + Del)\" class=\"BotaoExcluir btn btn-lg btn-danger tip\">\n");
      out.write("\t\t<i class=\"icon-minus-circle\"></i> Excluir\n");
      out.write("\t</button>\n");
      out.write("\t<button type=\"button\" title=\"Voltar (Esc)\" class=\"BotaoVoltar btn btn-lg btn-success tip\">\n");
      out.write("\t\t<i class=\"icon-undo2\"></i> Voltar\n");
      out.write("\t</button>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t</form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t\n");
      out.write("</script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /web/pages/projetos/termoabertura/termoaberturacadastro.jsp(38,7) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/web/pages/projetos/termoabertura/termoaberturacadastro.jsp(38,7) '${pessoas}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pessoas}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /web/pages/projetos/termoabertura/termoaberturacadastro.jsp(38,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("pessoa");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t\t\t\t<option ");
          if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write(" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pessoa.idPessoa }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pessoa.pessoa.nome}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pessoa.cargo.nome }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pessoa.unidadeOrganizacional.pessoa.nome }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\n");
          out.write("\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /web/pages/projetos/termoabertura/termoaberturacadastro.jsp(39,16) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.idPessoaGerente == pessoa.idPessoa}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("selected=\"selected\"");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }
}