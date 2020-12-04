var xmlHttp;

function apresenta() {
    var cidade = document.getElementById("cidade");
    var hotel = document.getElementById("hotel");
    var selCidade = cidade.options[cidade.selectedIndex].value; 
	var selhotel = hotel.options[hotel.selectedIndex].value;
    alert("Hotel selecionado: " + selhotel);
    var selEmail = document.getElementById("email");
    selEmail.innerHTML = atualizaEmail(selhotel);
    var selCnpj = document.getElementById("cnpj");
    selCnpj.innerHTML = atualizaCnpj(selhotel);
    var selPromoInicio = document.getElementById("promoinicio");
    selPromoInicio.innerHTML = atualizaPromoInicio(selhotel);
    var selPromoFim = document.getElementById("promofim");
    selPromoFim.innerHTML = atualizaPromoFim(selhotel);
    var selPromoSite = document.getElementById("promosite");
    selPromoSite.innerHTML = atualizaPromoSite(selhotel);
}

function cidadeSelecionada(str) {
    if (typeof XMLHttpRequest !== "undefined") {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    if (xmlHttp === null) {
        alert("Browser does not support XMLHTTP Request");
        return;
    }

    var url = "ListagemDeHoteisPorCidadeController";
    url += "?cidade=" + str;
    xmlHttp.onreadystatechange = atualizaCidades;
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);
}

function atualizaCidades() {
    if (xmlHttp.readyState === 4 || xmlHttp.readyState === "complete") {
        document.getElementById("hotel").innerHTML = xmlHttp.responseText;
    }
}

function atualizaEmail(str) {
    if (typeof XMLHttpRequest !== "undefined") {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    if (xmlHttp === null) {
        alert("Browser does not support XMLHTTP Request");
        return;
    }

    var url = "MostraDadosHotelSelecionadoController";
    url += "?hotel=" + str + "&emailsel=true";
    xmlHttp.onreadystatechange = function() {
        if (this.readyState == 4 || xmlHttp.readyState === "complete") {
            document.getElementById("email").innerHTML = this.responseText;
        }
    };
    xmlHttp.open("GET", url, true);
    xmlHttp.send();
}

function atualizaCnpj(str) {
    if (typeof XMLHttpRequest !== "undefined") {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    if (xmlHttp === null) {
        alert("Browser does not support XMLHTTP Request");
        return;
    }

    var url = "MostraDadosHotelSelecionadoController";
    url += "?hotel=" + str + "&cnpjsel=true";
    xmlHttp.onreadystatechange = function() {
        if (this.readyState == 4 || xmlHttp.readyState === "complete") {
            document.getElementById("cnpj").innerHTML = this.responseText;
        }
    };
    xmlHttp.open("GET", url, true);
    xmlHttp.send();
}

function atualizaPromoInicio(str) {
    if (typeof XMLHttpRequest !== "undefined") {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    if (xmlHttp === null) {
        alert("Browser does not support XMLHTTP Request");
        return;
    }

    var url = "MostraDadosHotelSelecionadoController";
    url += "?hotel=" + str + "&promoinicio=true";
    xmlHttp.onreadystatechange = function() {
        if (this.readyState == 4 || xmlHttp.readyState === "complete") {
            document.getElementById("promoinicio").innerHTML = this.responseText;
        }
    };
    xmlHttp.open("GET", url, true);
    xmlHttp.send();
}

function atualizaPromoFim(str) {
    if (typeof XMLHttpRequest !== "undefined") {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    if (xmlHttp === null) {
        alert("Browser does not support XMLHTTP Request");
        return;
    }

    var url = "MostraDadosHotelSelecionadoController";
    url += "?hotel=" + str + "&promofim=true";
    xmlHttp.onreadystatechange = function() {
        if (this.readyState == 4 || xmlHttp.readyState === "complete") {
            document.getElementById("promofim").innerHTML = this.responseText;
        }
    };
    xmlHttp.open("GET", url, true);
    xmlHttp.send();
}

function atualizaPromoSite(str) {
    if (typeof XMLHttpRequest !== "undefined") {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    if (xmlHttp === null) {
        alert("Browser does not support XMLHTTP Request");
        return;
    }

    var url = "MostraDadosHotelSelecionadoController";
    url += "?hotel=" + str + "&promosite=true";
    xmlHttp.onreadystatechange = function() {
        if (this.readyState == 4 || xmlHttp.readyState === "complete") {
            document.getElementById("promosite").innerHTML = this.responseText;
        }
    };
    xmlHttp.open("GET", url, true);
    xmlHttp.send();
}
