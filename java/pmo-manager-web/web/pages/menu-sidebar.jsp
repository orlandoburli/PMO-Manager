<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 
<!-- Sidebar -->
<div class="sidebar collapse">
	<div class="sidebar-content">

		<!-- User dropdown -->
		<div class="user-menu dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img
				src="${usuario.pathFoto}" class="thumbnail-boxed"> <span
				class="user-info"> ${usuario.nome} <span>${usuario.perfil.nome}</span>
					<span>${usuario.email}</span>
			</span>
			</a>

			<div class="popup dropdown-menu dropdown-menu-right">
				<div class="thumbnail">
					<div class="thumb">
						<img src="${usuario.pathFoto}" class="thumbnail-boxed">
						<div class="thumb-options">
							<span> <a href="#" data-placement="top"
								class="btn btn-icon btn-success tip"
								data-original-title="Editar meus dados"> <i
									class="icon-pencil"></i>
							</a> <!-- <a href="#" class="btn btn-icon btn-success"><i class="icon-remove"></i></a> -->
							</span>
						</div>
					</div>

					<div class="caption text-center">
						<h6>
							${usuario.nome} <small>${usuario.perfil.nome }</small>
						</h6>
					</div>
				</div>

				<ul class="list-group">
					
				</ul>
			</div>
		</div>
		<!-- /user dropdown -->

		<!-- Main navigation -->
		<ul class="navigation">
			
			<c:forEach items="${menus}" var="menu">
				<c:if test="${menu.subMenus.size() <= 0 }">
					<li class="activex"><a href="javascript:void(0)" data-link="${menu.objeto.url}"><span>${menu.nome}</span> <i class="${menu.classe}"></i></a></li>
				</c:if>
				<c:if test="${menu.subMenus.size() > 0 }">
					<li><a href="#" class="expand"><i class="${menu.classe}"></i><span>${menu.nome}</span> </a>
					
					<ul>
						<c:forEach items="${menu.subMenus}" var="submenu">
							<li><a data-menu-type="link" data-link="${submenu.objeto.url}"><i class="icon-arrow-right3"></i>${submenu.nome}</a></li>
						</c:forEach>
					</ul>
				</c:if>
			</c:forEach>

		</ul>
		<!-- /main navigation -->

	</div>
</div>
<!-- /sidebar -->


 --%>
<!-- BEGIN SIDEBAR1 -->
<div class="page-sidebar-wrapper">
	<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
	<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
	<div class="page-sidebar navbar-collapse collapse">
		<!-- BEGIN SIDEBAR MENU1 -->
		<ul class="page-sidebar-menu" data-slide-speed="200"
			data-auto-scroll="true" data-auto-scroll="true"
			data-slide-speed="200">
			
			<!-- DOC: To remove the search box from the sidebar you just need to completely remove the below "sidebar-search-wrapper" LI element -->
			
			<li class="sidebar-search-wrapper">
				<!-- BEGIN RESPONSIVE QUICK SEARCH FORM --> <!-- DOC: Apply "sidebar-search-bordered" class the below search form to have bordered search box -->
				<!-- DOC: Apply "sidebar-search-bordered sidebar-search-solid" class the below search form to have bordered & solid search box -->
				<form class="sidebar-search sidebar-search-bordered"
					action="extra_search.html" method="POST">
					<a href="javascript:;" class="remove"> <i class="icon-close"></i>
					</a>
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search...">
						<span class="input-group-btn"> <a href="javascript:;"
							class="btn submit"><i class="icon-magnifier"></i></a>
						</span>
					</div>
				</form> <!-- END RESPONSIVE QUICK SEARCH FORM -->
			</li>
			
			<c:forEach items="${menus}" var="menu">
				<c:if test="${menu.subMenus.size() <= 0 }">
					<c:set var="autoStart" value=""/>
					<c:if test="${menu.objeto.autoStart eq 'S'}">
						<c:set var="autoStart" value="start"/>
					</c:if>
					<li class="startx">
						<a class="ajaxify ${autoStart}" href="${menu.objeto.url}"> 
							<i class="fa ${menu.classe}"></i>
							<span class="title"> ${menu.nome} </span>
							<span class="selectedx"> </span>
						</a>
					</li>
					
				</c:if>
				<c:if test="${menu.subMenus.size() > 0 }">
					<li>
					<a href="javascript:;"> 
						<i class="fa ${menu.classe}"></i> 
						<span class="title"> ${menu.nome} </span> <span class=""></span> 
						<span class="arrow"> </span>
					</a>
					
					<ul class="sub-menu">
						<c:forEach items="${menu.subMenus}" var="submenu">
							<li><a class="ajaxify" href="${submenu.objeto.url}">${submenu.nome} </a></li>
						</c:forEach>
					</ul>
					</li>
				</c:if>
			</c:forEach>

			<!-- <li class="start">
				<a class="ajaxify start" href="layout_ajax_content_1.html"> 
					<i class="fa fa-home"></i>
					<span class="title"> Dashboard </span>
					<span class="selected"> </span>
				</a>
			</li>
			
			<li>
				<a href="javascript:;"> 
					<i class="fa fa-cogs"></i> 
					<span class="title"> Ajax Submenu 2 </span> <span class="selected"></span> 
					<span class="arrow"> </span>
				</a>
				
				<ul class="sub-menu">
					<li><a class="ajaxify" href="layout_ajax_content_2.html">Ajax Link Sample 1 </a></li>
					<li><a class="ajaxify" href="layout_ajax_content_3.html">Ajax Link Sample 2 </a></li>
					<li><a class="ajaxify" href="layout_ajax_content_2.html">Ajax Link Sample 3 </a></li>
					<li><a class="ajaxify" href="layout_ajax_content_3.html">Ajax Link Sample 4 </a></li>
				</ul>
			</li>
			<li class="last"><a href="javascript:;"> <i
					class="fa fa-cogs"></i> <span class="title"> Ajax Submenu 3
				</span> <span class="selected"> </span> <span class="arrow"> </span>
			</a>
				<ul class="sub-menu">
					<li><a class="ajaxify" href="layout_ajax_content_2.html">
							Ajax Link Sample 1 </a></li>
					<li><a class="ajaxify" href="layout_ajax_content_3.html">
							Ajax Link Sample 2 </a></li>
					<li><a class="ajaxify" href="layout_ajax_content_2.html">
							Ajax Link Sample 3 </a></li>
					<li><a class="ajaxify" href="layout_ajax_content_3.html">
							Ajax Link Sample 4 </a></li>
				</ul></li> -->
		</ul>
		<!-- END SIDEBAR MENU1 -->
	</div>
</div>
<!-- END SIDEBAR1 -->