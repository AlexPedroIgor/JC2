# Como escrever a história

## Eventos
Cada linha de evento deve estar contida dentro dos indicadores da numeração do evento dentro do arquivo ```gameEvents.txt```.
Exemplo:
```
1
Descrição do evento
1
```

## Ações
### Escolhas
Para indicar a existência de escolhas, é preciso adicionar a linha ```[choice]``` logo após a linha que indíca a existência da escolha
Tambem é preciso indicar no arquivo ```gameChoices.txt``` quais as escolhas possíveis utilizando a mesma sintáxe do arquivo ```gameEvents.txt``` e utilizando a numeração do evento que chamou esta escolha.
Cada linha representa uma escolha, exemplo:
```
2
Você sai da frente do carro
Você tenta pular o carro
Você não faz nada
2
```

### Respostas
Para indicar as respostas do jogo para cada escolha, deve-se utilizar a mesma sintáxe do ```gameEvents.txt``` também mantendo a mesma numeração do evento que chamou a escolha.
Cada linha representa uma resposta do jogo para cada escolha possível.
```
2
Você escapou por pouco
Você morreu
Você morreu
2
```

## Outras ações de eventos

### Eventos de multiplas linhas
```[multi]```: indica que o evento possui multiplas possibilidades
Exemplo:
```
3
[multi]
Você e seu amigo estão na floresta quando escutam um barulho estranho.
Você está sozinho na floresta quando nota um estranho vulto passando pelas árvores.
Você e seu amigo estão sozinhos na floresta, quando você nota que seu amigo desapareceu.
3
```
### Eventos com descrições longas e quebra de paragrafos
```[p]```: Indica uma quebra de paragrafo dentro da linha de texto


