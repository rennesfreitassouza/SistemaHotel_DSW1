		Checklist das funcionalidades implementadas e divisão dos requisitos por membro da equipe:

	
Divisão referente a Atividade AA-2:

- R1:

(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

- R2:

(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

- R3:

(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

- R4:

(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

- R5:

(X) Implementado ( ) Parcialmente implementado ( ) Não implementado 
Divisão na implementação da funcionalidade: Daniel (33,3%), Luis (33,3%) e Rennes (33,3%) 

- R6:

(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

- R7:

(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

- R8:

(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

- R9:

(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

- R10:

(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

Divisão referente a Atividade AA-3:

REST API -- CRUD de sites de reserva

	Cria um novo site de reserva [Create - CRUD]
		POST http://localhost:8080/sites
		Body: raw/JSON (application/json)
		( ) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade:  Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

	Retorna a lista de sites de reserva [Read - CRUD]
		GET http://localhost:8080/sites
		( ) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade:  Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)
					
	Retorna o site de reserva de id = {id} [Read - CRUD]
		GET http://localhost:8080/sites/{id} (id's de sites de reservas populados: 6, 7, e 8)
		( ) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade:  Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)
		
	Atualiza o site de reserva de id = {id} [Update - CRUD]
		PUT http://localhost:8080/sites/{id}Body: raw/JSON (application/json) (id's de sites de reservas populados: 6, 7, e 8)
		( ) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade:  Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)
		
	Remove o site de reserva de id = {id} [Delete - CRUD]	
		DELETE http://localhost:8080/sites/{id} (id's de sites de reservas populados: 6, 7, e 8)
		( ) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade:  Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

REST API -- CRUD de hotéis
Comandos GET, POST, PUT e DELETE funcionando no código antigo cujo link é: https://github.com/rennesfreitassouza/SistemaHotel_DSW1/tree/b24dd23827af737fa2bd0befa8bd58dc7a7dc6f8 
Após a integração com o restante de projeto, apenas os métodos GET do CRUD de hotéis funcionam.

	Cria uma novo hotel [Create - CRUD]
		POST http://localhost:8080/hoteis
		Body: raw/JSON (application/json)
		( ) Implementado (X) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade:  Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

	Retorna a lista de hotéis [Read - CRUD]
		GET http://localhost:8080/hoteis
		(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade:  Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)
	
	Retorna o hotel de id = {id} [Read - CRUD]
		GET http://localhost:8080/hoteis/{id} (id's de hotéis populados: 3, 4, e 5)
		(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade:  Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)
		
	Retorna a lista de todos os hotéis da cidade de nome = {nome}
		GET http://localhost:8080/hoteis/cidades/{nome}
		(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade:  Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

	Atualiza o hotel de id = {id} [Update - CRUD]
		PUT http://localhost:8080/hoteis/{id} (id's de hotéis populados: 3, 4, e 5)
		Body: raw/JSON (application/json)
		( ) Implementado (X) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade:  Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

	Remove o hotel de id = {id} [Delete - CRUD]
		DELETE http://localhost:8080/hoteis/{id} (id's de hotéis populados: 3, 4, e 5)
		( ) Implementado (X) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade:  Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

Retorna a lista de promoções [Read - CRUD]

	GET http://localhost:8080/promocoes
	(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade:  Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

REST API -- Retorna a promoção de id = {id} [Read - CRUD]

	GET http://localhost:8080/promocoes/{id} (id's de promoções populados: 1, 2, e 3)
	(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade:  Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

REST API -- Retorna a lista de promoções do site de reserva de id = {id} [Read - CRUD]
	
	GET http://localhost:8080/promocoes/sites/{id} (id's de sites de reservas populados: 6, 7, e 8)
	(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade:  Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

REST API -- Retorna a lista de promoções do hotel de id = {id} [Read - CRUD]
	
	GET http://localhost:8080/promocoes/hotel/{id} (id's de hotéis populados: 3, 4, e 5)
	(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade:  Daniel (33,3%), Luis (33,3%) e Rennes (33,3%)

