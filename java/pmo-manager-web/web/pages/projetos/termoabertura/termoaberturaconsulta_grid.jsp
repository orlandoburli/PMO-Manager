<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
table thead td:nth-child(1) {
	width: 60px;
}


table thead td:nth-child(1) {
	text-align: right;
}

table tbody tr td:nth-child(1) {
	text-align: right;
}
</style>


<table data-page-count="${pageCount}" class="table">
	<thead>
		<tr>
			<td>Versão</td>
			<td>Status</td>
			<td>Gerente</td>
		</tr>
	</thead>

	<tfoot>
		<tr>
			<td colspan="4">P&aacute;gina ${pageNumber} de ${pageCount}</td>
		</tr>
	</tfoot>

	<tbody>
		<c:forEach items="${listSource}" var="termoabertura">
			<tr
				data-id="idTermoAbertura=${termoabertura.idTermoAbertura}">
				<td>${termoabertura.versao }</td>
				<td>${termoabertura.statusTermoAberturaDescritivo }</td>
				<td>${termoabertura.gerente.pessoa.nome }</td>
			</tr>
		</c:forEach>
	</tbody>

</table>


