## Calculadora Básica em Java

Este projeto foi desenvolvido com o objetivo de criar uma calculadora gráfica simples utilizando a linguagem de programação Java e a biblioteca Swing. A ideia central foi proporcionar uma introdução prática ao uso de variáveis, condicionais, captura de eventos e interface gráfica.

A construção do código seguiu um raciocínio lógico dividido em etapas:

1. Definição da interface gráfica
   O primeiro passo foi importar a biblioteca Swing, que fornece os componentes necessários para criar uma interface gráfica em Java. Em seguida, foi criada a classe principal chamada Calculadora, que estende JFrame para representar a janela do aplicativo.
   Dentro dessa classe foram instanciados os elementos da interface: um campo de texto (para exibir os números e resultados) e botões numéricos (0 a 9), além dos botões de operações (+, -, *, /), o botão de igual e o botão de limpar.
   A interface foi organizada utilizando um GridLayout, para simular a disposição tradicional de uma calculadora física.

2. Lógica interna de funcionamento
   Para processar as operações matemáticas, foram definidas variáveis que armazenam os operandos (num1 e num2), o resultado e o operador selecionado.
   A cada clique de botão, o ActionListener identifica o evento. Se o botão for numérico, o valor correspondente é concatenado no campo de texto. Se o botão for de operação, o número atual é armazenado em num1 e o operador é salvo. Quando o usuário pressiona o botão de igual, o valor do campo de texto é convertido para num2, e então ocorre o cálculo por meio de uma estrutura switch-case, que decide qual operação executar.

3. Tratamento de erros e boas práticas
   Foi implementado tratamento básico de erros, como a verificação de divisão por zero, exibindo uma mensagem apropriada para o usuário.
   Outro ponto importante é que a interface foi criada dentro da Event Dispatch Thread (com SwingUtilities.invokeLater), uma boa prática no desenvolvimento com Swing para evitar travamentos ou comportamentos inesperados na interface.

4. Escolhas técnicas e didáticas
   O projeto foi mantido simples, em um único arquivo, para facilitar a compreensão por iniciantes. No entanto, ele foi estruturado de forma que possa ser facilmente expandido, por exemplo, para incluir funções científicas (como potência, raiz quadrada e funções trigonométricas), uma calculadora de dicas ou até mesmo um conversor de unidades.
   O código utiliza nomenclatura clara, comentários explicativos e organização lógica para facilitar a leitura e manutenção.

5. Possibilidades futuras
   Além da versão básica, este código pode ser ampliado em diferentes direções:

   * Criar uma calculadora científica utilizando a classe Math.
   * Adicionar uma interface de conversão de unidades (comprimento, massa, temperatura).
   * Migrar a interface de Swing para JavaFX, tornando-a mais moderna e responsiva.
