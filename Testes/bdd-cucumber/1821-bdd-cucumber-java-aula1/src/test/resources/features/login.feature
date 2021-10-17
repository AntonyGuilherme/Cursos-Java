#language: pt

@login
Funcionalidade: Apenas usuarios cadastrados podem se logar
	
	Cenario: Um usuario valido consegue logar
		Dado o usuario "fulano" com senha "pass"
		Quando realiza login
		Entao eh redirecionado para a pagina de leiloes
		
	Cenario: Um usuario invalido nao consegue logar
		Dado o usuario "invalido" com senha "invalida"
		Quando realiza login
		Entao continua na pagina de login	
	