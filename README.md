# 💵 Conversor de Dólar para Real (Android)

<p align="center">
  <img src="app/src/main/res/mipmap-xxxhdpi/ic_launcher.png" alt="Ícone da App" width="100px"/>
</p>

## 📌 Sobre o Projeto

O **Conversor** é uma aplicação nativa para Android desenvolvida em **Java**. O seu objetivo principal é realizar a conversão monetária de Dólar Americano (USD) para Real Brasileiro (BRL) de forma rápida e precisa, oferecendo uma interface de utilizador simples e direta.

Esta aplicação destaca-se por não utilizar taxas estáticas, consumindo dados em tempo real através de uma API externa para garantir a cotação mais atualizada no momento da conversão.

---

## 🚀 Funcionalidades Principais

* **Cotação em Tempo Real:** Integração nativa com a API [Open Exchange Rates](https://openexchangerates.org/) para obter o valor exato do Dólar face ao Real no momento da utilização.
* **Sistema de *Fallback*:** Caso a ligação à internet falhe ou a API fique indisponível, a aplicação possui uma taxa de conversão padrão de segurança, garantindo que o utilizador nunca fica sem resposta.
* **Processamento Assíncrono:** Utilização de `AsyncTask` para realizar as chamadas de rede em *background*, garantindo que a interface da aplicação (*UI Thread*) não congela durante o carregamento dos dados.
* **Interface Simples (UI/UX):** Ecrã minimalista desenhado em `ConstraintLayout`, com campos de introdução de dados adaptados para números decimais.

---

## 🛠️ Tecnologias e Arquitetura

O projeto foi construído utilizando as ferramentas padrão do ecossistema Android:

* **Linguagem:** Java
* **Interface:** XML (com `ConstraintLayout`)
* **Comunicação Web:** `HttpURLConnection` nativo do Java para requisições HTTP GET.
* **Manipulação de Dados:** `org.json.JSONObject` para *parsing* da resposta da API.
* **Ambiente de Desenvolvimento:** Android Studio / Gradle.

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos
* [Android Studio](https://developer.android.com/studio) instalado na máquina.
* Um emulador configurado (AVD) ou um dispositivo físico Android ligado via cabo/Wi-Fi (com a depuração USB ativada).

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/Juubito/Conversor2.git](https://github.com/Juubito/Conversor2.git)
   
2. **Abra o projeto:**
  Inicie o Android Studio, selecione **Open** e navegue até à pasta onde clonou o repositório.

3. **Sincronize o Gradle:**
  Aguarde que o Android Studio faça o download das dependências e construa a configuração inicial (Gradle Sync)

4. **Executa a aplicação:**
  Clique no botão **Run** ou pressione **Shift + F10**

## 👨‍💻 Autor

**Allan Crisanto** *Técnico de TI & Estudante de Análise e Desenvolvimento de Sistemas (UNINTER)*
