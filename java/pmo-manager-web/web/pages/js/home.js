var tempo = 250;

console.log("Inicio load home.js");

function loadDataLink(dataLink) {
	if (dataLink == "null") {
		console.log("Link nulo!");
	} else {
		if (dataLink != null && dataLink != "null" && dataLink != "") {
			
		    showLoader();

			
			loadPage(dataLink);

			if (dataLink.indexOf("cadastro") > 0) {
				loadJs("web/pages/js/cadastro.js");
			} else if (dataLink.indexOf("consulta") > 0) {
				loadJs("web/pages/js/consulta.js");
			}
			
			// Forca o load dos componentes
			loadJs("web/pages/js/load.js");
			
			hideLoader();
		} else {
			clearPage();
		}
	}
}

// Carrega uma pagina no corpo
function loadPage(pagina) {
	
	$(conteudoId).html("");
	
	console.log("Carregando pagina " + pagina);

	$(conteudoId).fadeOut(tempo);
	setTimeout(function() {
		
		$(conteudoId).load(pagina);
		
		setTimeout(function() {
			$(conteudoId).fadeIn(tempo);
		}, tempo);
		
	}, tempo);
	
	console.log("Pagina " + pagina + " carregada com sucesso.");
}

// Limpa conteudo do form
function clearPage(pagina) {
	$(conteudoId).fadeOut(tempo);
	
	setTimeout(function() {
		$(conteudoId).html("");
		setTimeout(function() {
			$(conteudoId).fadeIn(tempo);
		}, tempo);
	}, tempo);
}

// Carrega um arquivo css
function loadCSS(href) {
	setTimeout(function() {
		var cssLink = $("<link>");
		$("head").append(cssLink); // IE hack: append before setting href

		cssLink.attr({
			rel : "stylesheet",
			type : "text/css",
			href : href
		}, tempo * 4);
	});
}

// Carrega um arquivo js
function loadJs(jsFile) {
	setTimeout(function() {
		console.log("Carregando arquivo " + jsFile);
		$.getScript(jsFile).done(function(script, textStatus) {
			console.log("Arquivo " + jsFile + " carregado com sucesso.");
		}).fail(function(jqxhr, settings, exception) {
			console.log("Erro ao carregar js file " + jsFile + " - Erro: " + exception);
		});
	}, tempo * 2);
}

$(function() {
	// Funcoes de navegacao
//	$("[data-menu-type='link']").click(function(e) {
	$("a").click(function(e) {
		var dataLink = $(this).attr("data-link");
		
		if (dataLink != null && dataLink != '') {
			e.preventDefault();
			
			console.log("data-link: " + dataLink);
			loadDataLink(dataLink);
		}
	});

	textboxes = $("input, select, textarea");

	function checkForEnter(event) {

		if (event.keyCode == 13) {

			currentBoxNumber = textboxes.index(this);

			if (textboxes[currentBoxNumber + 1] != null) {
				nextBox = textboxes[currentBoxNumber + 1]
				nextBox.focus();
				event.preventDefault();
				return false;
			}
		}
	}

	if (browser.mozilla) {
		$(textboxes).keypress(checkForEnter);
	} else {
		$(textboxes).keydown(checkForEnter);
	}

	// Monta menu
//	$("#menu-lateral").menu();

	console.log("Fim load home.js");
});