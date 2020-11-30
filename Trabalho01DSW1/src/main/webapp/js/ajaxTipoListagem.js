var xmlHttp;

function apresenta() {
    var selCidade = hotel.options[hotel.selectedIndex].value; 
    alert("Selecionado! ");
}

function getHotelPorCidade() {
	var hotel = document.getElementById("listaHoteisPorCidade");
	var nome = hotel.value;

	if (typeof XMLHttpRequest !== "undefined") {
		xmlHttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	if (xmlHttp === null) {
		alert("Browser does not support XMLHTTP Request");
		return;
	}

	var url = "/ListagemDeHoteisPorCidadeController"; /
	url += "?term=" + nome;
	xmlHttp.onreadystatechange = atualizaTabela;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}


function atualizaTabela() {
	if (xmlHttp.readyState === 4 || xmlHttp.readyState === "complete") {

		var hoteis = JSON.parse(xmlHttp.responseText);

		// CRIA UMA TABELA DINAMICA

		var table = document.createElement("table");
		table.border = "1";
		table.style.border = "1px solid black";
		table.style.width = "400px";

		// CRIA LINHA TABELA (LINHA CABECALHO).

		var tr = table.insertRow(-1);

		// CRIA COLUNA NA LINHA DE CABECALHO
		var thSel = document.createElement('th');
		thSel.innerHTML = '';
		thSel.style.width = "10%";
		tr.appendChild(thSel);

		// CRIA COLUNA NA LINHA DE CABECALHO
		var thNome = document.createElement('th');
		thNome.innerHTML = 'Nome';
		thNome.style.width = "70%";
		tr.appendChild(thNome);


		// CRIA DEMAIS LINHAS COM OS VALORES

		for (var i = 0; i < hoteis.length; i++) {

			// CRIA NOVA LINHA
			tr = table.insertRow(-1);

			var tmp = hoteis[i];
			var hotel = tmp;

			// CRIA COLUNA 1 NA LINHA

			var col1 = tr.insertCell(-1);
			var radio = document.createElement('input');
			radio.type = 'radio';
			radio.id = hotel;
			radio.name = 'selHotel';
			radio.value = hotel;
			radio.onclick = apresenta.bind(radio.value);
			
			col1.appendChild(radio);
			// col1.style = "text-align:center"; analogo ao comando abaixo
			col1.style.textAlign = "center";

			// CRIA COLUNA 2 NA LINHA

			var col2 = tr.insertCell(-1);
			col2.innerHTML = hotel;

			// CRIA COLUNA 3 NA LINHA

//			var col3 = tr.insertCell(-1);
//			// col3.style = "text-align:center"; analogo ao comando abaixo
//			col3.style.textAlign = "center";
//			col3.innerHTML = estado;
		}

		var divContainer = document.getElementById("hoteis");
		divContainer.innerHTML = "";

		// CRIA UM PARAGRAFO (TAG P) COM A QUANTIDADE DE hoteis

		var p = document.createElement('p');
		p.innerHTML = 'Quantidade: ' + hoteis.length;

		// ADICIONA O PARAGRAFO AO CONTAINER.
		divContainer.appendChild(p);

		// ADICIONA A NOVA TABELA AO CONTAINER.
		divContainer.appendChild(table);
	}
}