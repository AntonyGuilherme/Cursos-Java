#language: pt

Funcionalidade: Propondo lances ao leilao

Cenario: Propondo um unico lance valido
	Dado um lance valido
	Quando propoe ao leilao
	Entao o lance eh aceito
	
Cenario: Propondo varios lances validos
	Dado um lance de 10.0 reais do usuario "fulano"
	E um lance de 15.0 reais do usuario "beltrano"
	Quando propoe varios lances ao leilao
	Entao os lances sao aceitos
	
Esquema do Cenario: Propondo um lance invalido
	Dado um lance invalido de <valor> reais do usuario '<usuario>'
	Quando propoe ao leilao
	Entao o lance nao eh aceito
	
Exemplos:
    | valor 	 | 	usuario 	|
    |    -1.00 |	fulano		|
    |     0.00 |	beltrano	|
    
    
Cenario: Propondo uma sequencia de lances
	Dado dois lances
		| valor | 	usuario 	|
   	|    10 |	fulano		|
    |    15 |	fulano		|
	Quando propoe varios lances ao leilao
	Entao o segundo lance nao eh aceito
	