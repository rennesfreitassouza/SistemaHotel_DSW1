-> Checklist das funcionalidades implementadas e divisão dos requisitos por membro da equipe:

- R1:

( ) Implementado (X) Parcialmente implementado ( ) Não implementado
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

Divisão Referente a Atividade AA-3
REST API -- CRUD de sites de reserva
	Cria um novo site de reserva [Create - CRUD]
		POST http://localhost:8080/sites
		Body: raw/JSON (application/json)
		( ) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Daniel ( ), Luis ( ) e Rennes ( )

	Retorna a lista de sites de reserva [Read - CRUD]
		GET http://localhost:8080/sites
		( ) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Daniel ( ), Luis ( ) e Rennes ( )
					
	Retorna o site de reserva de id = {id} [Read - CRUD]
		GET http://localhost:8080/sites/{id}
		( ) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Daniel ( ), Luis ( ) e Rennes ( )
		
	Atualiza o site de reserva de id = {id} [Update - CRUD]
		PUT http://localhost:8080/sites/{id}Body: raw/JSON (application/json)
		( ) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Daniel ( ), Luis ( ) e Rennes ( )
		
	Remove o site de reserva de id = {id} [Delete - CRUD]	
		DELETE http://localhost:8080/sites/{id}
		( ) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Daniel ( ), Luis ( ) e Rennes ( )

REST API -- CRUD de hotéis
	Cria uma novo hotel [Create - CRUD]
		POST http://localhost:8080/hoteis
		Body: raw/JSON (application/json)
		( ) Implementado (X) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Daniel ( ), Luis ( ) e Rennes ( )

	Retorna a lista de hotéis [Read - CRUD]
		GET http://localhost:8080/hoteis
		( ) Implementado (X) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Daniel ( ), Luis ( ) e Rennes ( )
	
	Retorna o hotel de id = {id} [Read - CRUD]
		GET http://localhost:8080/hoteis/{id}
		( ) Implementado (X) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Daniel ( ), Luis ( ) e Rennes ( )
		
	Retorna a lista de todos os hotéis da cidade de nome = {nome}
		GET http://localhost:8080/hoteis/cidades/{nome}
		( ) Implementado (X) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Daniel ( ), Luis ( ) e Rennes ( )

	Atualiza o hotel de id = {id} [Update - CRUD]
		PUT http://localhost:8080/hoteis/{id}
		Body: raw/JSON (application/json)
		( ) Implementado (X) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Daniel ( ), Luis ( ) e Rennes ( )

	Remove o hotel de id = {id} [Delete - CRUD]
		DELETE http://localhost:8080/hoteis/{id}
		( ) Implementado (X) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Daniel ( ), Luis ( ) e Rennes ( )

Retorna a lista de promoções [Read - CRUD]
	GET http://localhost:8080/promocoes
	( ) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Daniel ( ), Luis ( ) e Rennes ( )

REST API -- Retorna a promoção de id = {id} [Read - CRUD]
	GET http://localhost:8080/promocoes/{id}
	( ) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Daniel ( ), Luis ( ) e Rennes ( )

REST API -- Retorna a lista de promoções do site de reserva de id = {id} [Read - CRUD]
	GET http://localhost:8080/promocoes/sites/{id}
	( ) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Daniel ( ), Luis ( ) e Rennes ( )

REST API -- Retorna a lista de promoções do hotel de id = {id} [Read - CRUD]
	GET http://localhost:8080/promocoes/hotel/{id}
	( ) Implementado ( ) Parcialmente implementado ( ) Não implementado
		Divisão na implementação da funcionalidade: Daniel ( ), Luis ( ) e Rennes ( )

