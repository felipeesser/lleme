package oo.letreiro;

public class Display {

    private char caractere;

    public Display(char caractere) {
        this.caractere = caractere;
    }

    public void escreve(byte linha) {
        switch (caractere) {
            case 'a':
                escreveA(linha);
                break;
            case 'A':
                escreveA(linha);
                break;
            case 'd':
                escreveD(linha);
                break;
            case 'D':
                escreveD(linha);
                break;
            case 'n':
                escreveN(linha);
                break;
            case 'N':
                escreveN(linha);
                break;
        }
    }

    private void escreveA(int linha) {
        switch (linha) {
            case 1:
                System.out.print("   _____ ");
                break;
            case 2:
                System.out.print("  |     |");
                break;
            case 3:
                System.out.print("  |     |");
                break;
            case 4:
                System.out.print("  |-----|");
                break;
            case 5:
                System.out.print("  |     |");
                break;
            case 6:
                System.out.print("  |     |");
                break;
            case 7:
                System.out.print("         ");
                break;
            default:
                break;
        }
    }

    private void escreveN(int linha) {
        switch (linha) {
            case 1:
                System.out.print("         ");
                break;
            case 2:
                System.out.print("  |\\    |");
                break;
            case 3:
                System.out.print("  | \\   |");
                break;
            case 4:
                System.out.print("  |  \\  |");
                break;
            case 5:
                System.out.print("  |   \\ |");
                break;
            case 6:
                System.out.print("  |    \\|");
                break;
            case 7:
                System.out.print("         ");
                break;
            default:
                break;
        }
    }

    private void escreveD(int linha) {
        switch (linha) {
            case 1:
                System.out.print("   ____");
                break;
            case 2:
                System.out.print("  |     \\");
                break;
            case 3:
                System.out.print("  |     |");
                break;
            case 4:
                System.out.print("  |     |");
                break;
            case 5:
                System.out.print("  |     |");
                break;
            case 6:
                System.out.print("  |     /");
                break;
            case 7:
                System.out.print("   ----");
                break;
            default:
                break;
        }
    }
}
