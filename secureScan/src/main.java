import java.util.List;
import java.util.Scanner;
import java.util.Locale;
import java.util.regex.Pattern;
import java.text.Normalizer;

public class main {

    private static List<String> palavrasSuspeitas = List.of(
            "pix",
            "deposito",
            "transferencia",
            "pagamento",
            "boleto",
            "urgente",
            "imediato",
            "confirmar",
            "confirmacao",
            "senha",
            "codigo",
            "token",
            "seguranca",
            "verificacao",
            "verificar",
            "validar",
            "atualizar",
            "cadastro",
            "conta",
            "bloqueada",
            "bloqueio",
            "desbloquear",
            "premio",
            "sorteio",
            "ganhou",
            "vencedor",
            "gratuito",
            "gratis",
            "oferta",
            "promocao",
            "desconto",
            "clique",
            "acesse",
            "link",
            "login",
            "banco",
            "cartao",
            "credito",
            "debito",
            "cpf",
            "cnpj",
            "receita",
            "governo",
            "correios",
            "entrega",
            "encomenda",
            "taxa",
            "multa",
            "pendencia",
            "regularizar",
            "reembolso",
            "estorno",
            "whatsapp",
            "suporte",
            "atendimento",
            "cancelamento",
            "expirado",
            "expira",
            "risco",
            "fraude",
            "acesso",
            "autenticacao",
            "anexo",
            "documento",
            "comprovante"
    );


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            String introduction = ("""
                    
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    Bem Vindo ao Secure Scan!!!
                    
                    Qual tipo de mensagem você deseja verificar?
                    
                    1-Aplicativos de Mensagem (Whatsapp, Facebook, Skype).
                    2-E-mail.
                    3-Sair
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    """);
            System.out.print(introduction);
            int userInput = 0;
            boolean validOption = false;
            while (!validOption) {

                if (scanner.hasNextInt()) {
                    userInput = scanner.nextInt();
                    scanner.nextLine();

                    if (userInput >= 1 && userInput <= 3) {
                        validOption = true;
                    } else {
                        System.out.println("Digite um número válido:");
                    }

                } else {
                    System.out.println("Digite um número válido:");
                    scanner.next(); // descarta a entrada inválida
                }
            }
            if (userInput == 3) {
                System.out.println("Obrigado por utilizar o Secure Scan!");
                scanner.close();
                System.exit(0);
            }


            System.out.println("Insira o texto: ");
            String suspectText = scanner.nextLine();
            suspectText = suspectText.toLowerCase();

            suspectText = removeAccent(suspectText);


            int porcentagem = 100;


            if (userInput == 1) {
                int txtresult = verifytxtmessage();
                porcentagem = porcentagem - (txtresult);

            } else if (userInput == 2) {
                int emailresult = verifyemail();
                porcentagem = porcentagem - (emailresult);

            }


            int wordcount = 0;
            String[] listapalavras = suspectText.split("\\s+");
            for (String palavraTexto : listapalavras) {
                palavraTexto = palavraTexto.replaceAll("[^a-zA-Z0-9]", "");
                if (palavrasSuspeitas.contains(palavraTexto)) {
                    wordcount = wordcount + 10;
                }
            }

            porcentagem = porcentagem - wordcount;

            if (porcentagem <= 0) {
                porcentagem = 0;
            }
            if (porcentagem >= 80) {
                System.out.println("O Secure scan detectou que esta mensagem possui mais de 80% de segurança!");
            } else if (porcentagem >= 50) {
                System.out.println("Leia a mensagem com cuidado,O Secure scan detectou que esta mensagem possui " + porcentagem + "% de segurança!");
            } else if (porcentagem < 50) {
                System.out.println("Cuidado!!!, O Secure scan detectou que esta mensagem possui um baixo nivel de segurança");
            }

            System.out.println("Aperte enter para utilizar o Secure scan novamente");;
            scanner.nextLine();

        }

    }







    static Scanner sc = new Scanner(System.in);


    public static String removeAccent(String userIN) {
        if (userIN == null) {
            return null;
        } else {
            String striped = Normalizer.normalize(userIN, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            String correct = pattern.matcher(striped).replaceAll("");
            return correct;

        }


    }

    public static int verifytxtmessage(){
        System.out.println("Você confia no numero/contato que te enviou esta mensagem? y/n");
        String answer = "";
        while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")){
            answer = sc.nextLine();
            if (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")){
                System.out.println("digite apenas (y) ou (n)!");;
            }else if(answer.equals("y")){
                return 0;
            } else if (answer.equals("n")) {
                return 25;
            }

        }

            return 0;
    }




    public static int verifyemail() {

        System.out.println("digite o endereço de e-mail:");
        String emailurl = sc.nextLine();
        if (emailurl.endsWith("@gmail.com")) {
            return 25;

        } else {
            return 0;
        }

    }

}
