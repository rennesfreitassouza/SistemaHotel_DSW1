    Roteiro de execução Atividade AA-2 e Atividade AA-3:

- SGBD utilizado: MySQL version 8

- Nome do banco de dados: SistemaT2

- Comandos SQL para executar antes de compilar e executar o projeto:

  CREATE DATABASE SistemaT2;
  
  CREATE USER 'user'@'localhost' IDENTIFIED BY 'Us3rl0c4lh0st10@';
  
  GRANT ALL PRIVILEGES ON *.* TO 'user'@'localhost';
  
  FLUSH PRIVILEGES;
    
- Executar o comando no diretório raiz do projeto com usuário com privilégios de administrador: sudo mvn spring-boot:run

- IDE utilizada pela equipe: Eclipse IDE 2020;

- Versão do OpenJDK utilizada durante o desenvolvimento: OpenJDK 8;

- Versão do Apache Maven utilizada para compilar o projeto: 3.6;
      
      
 - Usuários populados:
	
	  login: luis@admin.com
	  senha: luis
	  papel: Admin
	  
	  login: rennes@admin.com
	  senha: rennes
	  papel: Admin
	  
      -(id's de hotéis populados: 3, 4, e 5)
	  
      login: hotel1@hotel.com
	  senha: hotel1
	  papel: Hotel
	  
	  login: hotel2@hotel.com
	  senha: hotel2
	  papel: Hotel
	  
	  login: hotel3@hotel.com
	  senha: hotel3
	  papel: Hotel
	  
      -(id's de sites de reservas populados: 6, 7, e 8)
      
	  login: site1@siteres.com
	  senha: site1
	  papel: Site de Reserva
	  
	  login: site2@siteres.com
	  senha: site2
	  papel: Site de Reserva
	  
	  login: site3@siteres.com
	  senha: site3
	  papel: Site de Reserva
	  
[a tabela PromoHotel, referente as promoções de um site de reservas, também está sendo populada].(id's de promoções populados: 1, 2, e 3)
    
