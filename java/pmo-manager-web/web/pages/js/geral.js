var conteudoId = "#formulario-home";

var browser = {
	chrome: false,
	mozilla: false,
	opera: false,
	msie: false,
	safari: false
};

$(function() {
	var link_sair_visivel = false;
	
	$(".link-sair").click(function() {
		if (link_sair_visivel) {
			$(".div-link-sair").fadeOut();
			link_sair_visivel = false;
		} else {
			$(".div-link-sair").fadeIn();
			link_sair_visivel = true;
		}
	});

	$(".div-link-sair").hide();	

	var sBrowser, sUsrAg = navigator.userAgent;
	if(sUsrAg.indexOf("Chrome") > -1) {
		browser.chrome = true;
	} else if (sUsrAg.indexOf("Safari") > -1) {
		browser.safari = true;
	} else if (sUsrAg.indexOf("Opera") > -1) {
		browser.opera = true;
	} else if (sUsrAg.indexOf("Firefox") > -1) {
		browser.mozilla = true;
	} else if (sUsrAg.indexOf("MSIE") > -1) {
		browser.msie = true;
	}
	
//  $( document ).tooltip();
});

function mensagemModal(mensagem, titulo) {
  mensagemModal(mensagem, titulo, null);
}

function mensagemModal(mensagem, titulo, funcaoRetorno) {

	$("#div-message").attr("title", titulo);

	$("#div-message").html( mensagem);

	$( "#div-message" ).dialog({
	    modal: true,
	    buttons: {
	      Ok: function() {
	        $( this ).dialog( "close" );
	
	        if (funcaoRetorno) {
	         funcaoRetorno();
	    }
     }
   }
 });
}

function confirmacaoModal(mensagem, titulo, funcaoSim) {
	confirmacaoModal(mensagem, titulo, funcaoSim, null);
}

function confirmacaoModal(mensagem, titulo, funcaoSim, funcaoNao) {

  $(".modal-title").html(titulo);
  $(".modal-body").html( mensagem);
  $(".btn-modal-flex-sim").click(funcaoSim);
  $(".btn-modal-flex-nao").click(funcaoNao);
  $(".modal-confirmacao-sim-nao").modal('show');
}

function fillSelect(selectElement, values, valueKey, textKey, defaultValue) {
  if (typeof (selectElement) == "string") {
    selectElement = $(selectElement);
  }

  selectElement.empty();

  if (typeof (values) == 'object') {
    if (values.length) {

      var type = typeof (values[0]);
      var html = "";

      if (type == 'object') {
                // values is array of hashes
                var optionElement = null;

                $.each(values, function () {
                  var value = "";
                  var row = this;

                  if (valueKey.indexOf(";") >= 0) {
                    var keys = valueKey.split(";");

                    $.each(keys, function() {

                      if (row[this] != null) {
                        value += row[this] + ";";
                      } else {
                        value += "";
                      }
                    });

                  } else {
                    value = this[valueKey] == null ? "" :this[valueKey];
                  }

                  html += '<option value="' + value + '">' + this[textKey] + '</option>';                  
                });

              } else {
                // array of strings
                $.each(values, function () {
                  var value = this.toString();
                  html += '<option value="' + value + '">' + value + '</option>';                    
                });
              }
              selectElement.append(html);
            }

        // select the defaultValue is one was passed in
        if (typeof defaultValue != 'undefined') {
          selectElement.children('option[value="' + defaultValue + '"]').attr('selected', 'selected');
        }
      }
      return false;
    }


    // Widget combobox auto-complete jQuery UI
    
// Constantes de teclas de funcao

var KEY_UP = 38;
var KEY_DOWN = 40;
var KEY_NEXT = 39;
var KEY_PREVIOUS = 37;
var KEY_ENTER = 13;

var KEY_F3 = 114;
var KEY_F4 = 115;
var KEY_F5 = 116;
var KEY_F6 = 117;
var KEY_F7 = 118;
var KEY_F8 = 119;

var KEY_E = 69;
var KEY_N = 78;
var KEY_S = 83;
var KEY_DEL = 46;
var KEY_ESC = 27;

var KEY_END = 35;
var KEY_HOME = 36;
var KEY_PAGEUP = 33;
var KEY_PAGEDOWN = 34;

var DEBUG = 1;

function getTimeStamp() {
    var now = new Date();
    return ((now.getMonth() + 1) + '/' +
            (now.getDate()) + '/' +
             now.getFullYear() + " " +
             now.getHours() + ':' +
             ((now.getMinutes() < 10)
                 ? ("0" + now.getMinutes())
                 : (now.getMinutes())) + ':' +
             ((now.getSeconds() < 10)
                 ? ("0" + now.getSeconds())
                 : (now.getSeconds())));
}


// Funcao para debug javascript
//function console.log(o) {
//	if (DEBUG == 1) {
//		console.log(getTimeStamp() + " | " + o);
//	}
//}


function mensagem(oMensagem, tipo) {
	Messenger.options = {
        extraClasses: 'messenger-fixed messenger-on-bottom messenger-on-right',
        theme: 'flat'
    };
    Messenger().post({
        message: oMensagem,
        type: tipo,
        showCloseButton: true
    });
}

function mensagemInfo(oMensagem) {
	mensagem(oMensagem, 'info');
}

function mensagemErro(oMensagem) {
	mensagem(oMensagem, 'error');
}

function showLoader() {
	$(".page-content").append('<div class="overlay meu-loader"><div class="opacity"><i class="icon-spinner7 spin"></i></div>');
	$('.overlay').fadeIn(150);
}

function hideLoader() {
	$(".meu-loader").remove();
}