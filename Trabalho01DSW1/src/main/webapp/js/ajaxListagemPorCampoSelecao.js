var xmlHttp;

function apresenta() {
    var cidade = document.getElementById("cidade");
    var hotel = document.getElementById("hotel");
    var selCidade = cidade.options[cidade.selectedIndex].value; 
	var selhotel = hotel.options[hotel.selectedIndex].value;
    alert("Hotel selecionado: " + selhotel); 
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