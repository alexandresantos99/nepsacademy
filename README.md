# Neps Academy 1334 e 143

Resolução dos exercícios 1334 (Palíndromo) e 143 (Troco em Moedas) do site NepsAcademy utilizando a linguagem Kotlin.

# Exercício 1334 - Palíndromo

A solução é dividida em etapas, começando com a geração de subsequências de palavras inseridas, utilizando a recursividade como base do algoritmo.

Em seguida, são feitas verificações para encontrar os palíndromos dentro da lista de subsequências.

Após isso, são extraídas as posições especiais a partir dos números informados, convertendo-os em uma lista de inteiros e, em seguida, em uma lista de caracteres com as posições especiais.

Com a lista de subsequências que são palíndromos, é feito um filtro para saber qual dos palíndromos possui as posições especiais, e o resultado é o maior palíndromo obtido pelo tamanho da subsequência.

# Exercício 143 - Troco em Moedas

A solução consiste em extrair quantas vezes cada moeda cabe dentro do valor inserido. Por exemplo, se a entrada for 250, cabem 2 moedas de "100" e 1 moeda de "50".

Foi criado um mapa para armazenar os valores das moedas como chave e a quantidade de vezes que elas cabem como valor. Em seguida, o valor é subtraído e o loop continua até que o valor chegue a 0.

Depois, os valores armazenados no mapa são impressos, passando os centavos como chave. Caso a chave não exista no mapa, significa que não foi usada e, portanto, retorna 0.
