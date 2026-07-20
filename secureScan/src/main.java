import java.util.Scanner;
import java.util.Locale;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String introduction = ("""
                Bem Vindo ao Secure Scan!!!
                
                Qual tipo de mensagem você deseja verificar?
                
                1-SMS.
                2-E-mail.
                3-Aplicativos de Mensagem (Whatsapp, Facebook, Skype).
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
                    System.out.println("Digite um numero valido: ");
                }
            } else {
                System.out.println("Digite um numero valido: ");
                scanner.next();
            }
        }
        System.out.println("Insira o texto: ");
        String suspectText = scanner.nextLine();

        int porcentagem = 0;

        switch (userInput) {
            case 1:
                System.out.println(suspectText);
                break;
            case 2:



                break;
            case 3:
                break;
        }


        scanner.close();


    }

    static Scanner sc = new Scanner(System.in);


    public static int verifyemail() {

        System.out.println("digite o endereço de e-mail:");
        String emailurl = sc.nextLine();
        String padraogmail = ("@gmail.com");
        boolean emailSuspeito = emailurl.contains(padraogmail);
        System.out.println(emailSuspeito);

        return 0;
    }

}

