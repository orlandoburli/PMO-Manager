<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
					<!-- <li class="list-group-item"><i class="icon-camera7 text-muted"></i> Minhas aulas <span class="label label-success">289</span></li>
					<li class="list-group-item"><i class="icon-bubble5 text-muted"></i> Perguntas <span class="label label-danger">892</span></li>
					<li class="list-group-item"><i class="icon-stats2 text-muted"></i> Relatórios <span class="label label-primary">92</span></li>
					<li class="list-group-item"><i class="icon-stack text-muted"></i> Saldo Financeiro<h5 class="pull-right text-danger">$45.389</h5></li> -->
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