package util;

import java.util.Scanner;

/**
 * Utilitários visuais para console com cores ANSI
 */
public class Util {
    
    // ═════════════════════════════════════════
    // CORES ANSI
    // ═════════════════════════════════════════
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";
    
    // Cores de fundo
    public static final String BG_BLACK = "\u001B[40m";
    public static final String BG_RED = "\u001B[41m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_PURPLE = "\u001B[45m";
    public static final String BG_CYAN = "\u001B[46m";
    
    // ═════════════════════════════════════════
    // MÉTODOS DE FEEDBACK
    // ═════════════════════════════════════════
    
    public static void sucesso(String msg) {
        System.out.println(GREEN + BOLD + "✨ " + msg + RESET);
    }
    
    public static void erro(String msg) {
        System.out.println(RED + BOLD + "❌ " + msg + RESET);
    }
    
    public static void aviso(String msg) {
        System.out.println(YELLOW + BOLD + "⚠️  " + msg + RESET);
    }
    
    public static void info(String msg) {
        System.out.println(CYAN + "ℹ️  " + msg + RESET);
    }
    
    // ═════════════════════════════════════════
    // ELEMENTOS VISUAIS
    // ═════════════════════════════════════════
    
    public static void titulo(String texto) {
        System.out.println();
        System.out.println(BG_BLUE + WHITE + BOLD + "  " + texto + "  " + RESET);
        System.out.println();
    }
    
    public static void separador(String cor, String texto) {
        System.out.println();
        System.out.println(cor + "┌" + "─".repeat(38) + "┐" + RESET);
        System.out.println(cor + "│  " + RESET + BOLD + texto + RESET + cor + "  │" + RESET);
        System.out.println(cor + "└" + "─".repeat(38) + "┘" + RESET);
        System.out.println();
    }
    
    public static void linha(String cor, int tamanho) {
        System.out.println(cor + "─".repeat(tamanho) + RESET);
    }
    
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public static void pausar(Scanner scanner) {
        System.out.print(CYAN + "\n  Pressione " + BOLD + "Enter" + RESET + CYAN + " para continuar... " + RESET);
        scanner.nextLine();
    }
}