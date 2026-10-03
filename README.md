# TobLabac (Cabal Online Bot)

Bot de automação e macros pessoais para **Cabal Online**.

## 🛠 Dependências e Como Rodar

O projeto foi construído em **Java 8+** usando **JavaFX** para a interface gráfica e `System Keyboard Hook` nativo para ler o teclado globalmente (mesmo com o jogo em tela cheia). 

**Dependências:**
- Todas as dependências (Jars do JavaFX e o hook de teclado `system-hook-3.8.jar`) já estão na pasta `lib/`. 

**Como Rodar:**
- A classe principal do projeto (Ponto de entrada) é: `src/control/TobLaba.java`.
- Se você for rodar via **VS Code** ou **Eclipse**, certifique-se de adicionar todos os `.jar` da pasta `lib/` no Classpath do seu projeto.
- Execute a classe `TobLaba.java` e a interface vai se abrir.
- Via launcher Cabal (`toblabac.sh`): heap padrão `-Xmx1g` (`java-opts.sh`); override com `TOBLABAC_JAVA_OPTS` (ex.: `-Xmx768m`). Ver `docs/launcher-heap.md`.

> ⚠️ **Atenção (Kill Switch):**
> O código possui uma data de validade travada em **30 de Junho de 2025** em `src/view/TabsController.java`. Passado dessa data, o app vai exibir um "Expired Use!" e fechar. Se precisar usar depois disso, é só alterar essa validação na linha ~292.

---

## 🎮 Teclas de Atalho de Macros (Global Hotkeys)

Você não precisa estar com o aplicativo em foco. Se os botões funcionarem:
* **`ESC`**: 🛑 **PANIC** (Para todas as macros imediatamente)
* **`F9`**: Liga/Desliga a **Macro BM2** (Ataque baseando em delay e Left Click)
* **`F10`**: Liga/Desliga a **Macro BM3** (Aplica o combo escolhido na interface ex: AABA, ABAA)
* **`Page Up`**: Liga/Desliga a **Macro Customizada** (Executa texto da abinha)
* **`Page Down`**: Liga/Desliga a **Macro de Poção** (Spamma a tecla `=`)
* **`Home`**: Liga/Desliga a **Extração (Quebra)** (Nota: Lê coordenadas engessadas para aba do inventário)
* **`End`**: Inspeciona a tela (útil na criação de macros! Printa no terminal as coordenadas do mouse no exato momento, e diz qual é a *Cor Dominante* naquele quadradinho).
* **`INSERT`**: Escreve "O will e um viadao" no chat para alívio cômico.

---

## 🧭 Configuração na Interface Gráfica

A página inteira se resume a setar as coordenadas iniciais, e construir sua barra de macro:
1. **Atalhos BM3**: Se você deixar os Synergy marcados (abaa, baab), a macro montará a sequência otimizada dependendo do seu *Battle Style* (WA, BL, etc.).
2. **Custom Script**: Você pode escrever strings separados por `.` para a macro ler customizada, exemplo: `.1.2.sleep0100.alt` — Executa 1, 2, espera 100ms e aperta ALT.
3. **Resoluções (Importante!)**: Muitas coordenadas do AFK Bot (ID 4) e do Macro de Quebras (ID 6) estão literalmente **Fixadas no código**. Ex: a extração procura a Aba 1 começando em `X=1690, Y=400`. Se sua janela do jogo estiver esticada, ou em outra resolução, vai clicar tudo errado. Caso precise alinhar: rode com o terminal aberto, dê `END` nas abas e atualize as coordenadas.

---

*Nota Pessoal: Guarde num lugar seguro, se um GM checar suas logs da Macro ID 4 e do delay perfeitinho das Poções pode desconfiar.*
