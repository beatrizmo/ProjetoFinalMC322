# Projeto Final MC322
Projeto Final da disciplina de MC322 2023S01

## Desenvolvedoras do projeto
- Alexia Bettoni do Nascimento RA: 265670 
- Beatriz Moreira Alves RA: 166623
- Daniele Souza Gonçalves RA: 248029

# Cinema Totem

O Cinema Totem é um sistema de totem de compra de bilhetes de cinema que permite aos usuários comprar ingressos para filmes de forma conveniente. O projeto foi desenvolvido utilizando os princípios da POO e visa proporcionar aos clientes uma experiência intuitiva e fácil. Em nosso projeto, já na tela inicial é possivel visualizar os filmes disponiveis em cartaz, assim como os dias e os horários de exibição. Para cada filme temos as informações de título, sinopse e a duração. O cliente, no momento da compra de ingresso ,após selecionar o filme, a data e horário que quer assistir, terá a opção de selecionar a compra do ingresso no valor inteiro, ou como meia entrada. Ao final é gerado um recebido no formato de imagem contendo as principais informações relevantes como: preço total, posição dos assentos, titulo do fille, e data e hora de exibição. 


No desenvolvimento deste projeto foi explorado conceito de relacionamentos entre classes como agregação, associação e composição conforme ilustrado no diagrama UML. Além do conceito de classe abstrata, onde a classe Ingresso foi definida como uma classe abstrata que possui duas classes filhas: Ingresso Meia e Ingresso Inteira. A interface I_Arquivo também foi implementada para definir os metódos gravarArquivo e lerArquivo a serem implementados. 

Os diagramas UML contendo mais detalhes da implementação pode ser visto abaixo:

## Funcionalidades

- Visualização de filmes em cartaz e suas respectivas informações como titulo, sinopse, duração e horário de exibição. 
- Seleção de assentos disponíveis
- Compra de ingressos nas modalidades inteira ou meia
- Emissão de recibos em formato de imagem.


## Configuração do Projeto

1. Certifique-se de ter a versão Java 17.0 instalada na sua máquina.
2. Clone este repositório para o seu ambiente local:
3. Navegue até o diretório CinemaToten/src/CinemaToten e execute o arquivo Main.Java
4. A IDE utlizada no desenvolvimento deste projeto foi a IDE Eclipse, então recomendamos o uso da mesma para uma
execução correta do projeto. 