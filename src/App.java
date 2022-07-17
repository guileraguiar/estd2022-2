import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class App {

    public static int[] criaVetorAleatorio(int tamanho) {
        int vetor[] = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = (int) (Math.random() * 100);
        }

        return vetor;
    }

    public static int[] criaVetorCrescente(int tamanho) {
        int vetor[] = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i;
        }

        return vetor;
    }

    public static int[] criaVetorDecrescente(int tamanho) {
        int vetor[] = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = tamanho - i;
        }

        return vetor;
    }

    static long count = 0;

    public static int[] bubblesort1(int v[]) {
        count = 0;

        for (int i = 0; i < v.length - 1; i++) {
            for (int j = i + 1; j < v.length; j++) {
                count++;
                if (v[i] > v[j]) {
                    int aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }

        return v;
    }

    public static void BubblepiorCaso() throws FileNotFoundException {
        int vetor[];
        System.out.println("BubbleSort1 - Array Decrescente");
        try (PrintWriter out = new PrintWriter("BubblePiorCaso.csv")) {
            for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
                vetor = criaVetorDecrescente(tamanhoVetor);
                bubblesort1(vetor);
                System.out.println("Tamanho: " + tamanhoVetor + " ;  Operacoes: " + count);

                out.println("Tamanho: " + tamanhoVetor + " ;  Operacoes: " + count);
            }
        }
    }

    public static void BubblecasoMedio() throws FileNotFoundException {
        long media;
        long somaOperacoes;
        int vetor[];

        System.out.println("BubbleSort1 - Array Aleatório");
        try (PrintWriter out = new PrintWriter("BubbleCasoMedio.csv")) {
            for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
                media = 0;
                somaOperacoes = 0;

                for (int execucoes = 1; execucoes <= 10; execucoes++) {
                    vetor = criaVetorAleatorio(tamanhoVetor);

                    bubblesort1(vetor);

                    somaOperacoes += count;
                }

                media = somaOperacoes / 10;
                System.out.println("Tamanho: " + tamanhoVetor + " ;  Operacoes: " + media);
                out.println("Tamanho: " + tamanhoVetor + " ;  Operacoes: " + count);
            }
        }
    }

    public static int[] insertionsort(int v[]) {
        count = 0;

        int pivo, j;
        for (int i = 1; i < v.length; i++) {
            count++;
            pivo = v[i];
            j = i - 1;

            while (j >= 0 && pivo < v[j]) {
                count++;
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = pivo;
        }
        return v;
    }

    public static void InsertionpiorCaso() throws FileNotFoundException {
        int vetor[];

        System.out.println("InsertionSort - Array Decrescente");
        try (PrintWriter out = new PrintWriter("InsertionPiorCaso.csv")) {
            for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
                vetor = criaVetorDecrescente(tamanhoVetor);
                insertionsort(vetor);
                System.out.println("Tamanho: " + tamanhoVetor + " ;  Operacoes: " + count);

                out.println("Tamanho: " + tamanhoVetor + " ;  Operacoes: " + count);

            }
        }
    }

    public static void InsertioncasoMedio() throws FileNotFoundException {
        long media;
        long somaOperacoes;
        int vetor[];

        System.out.println("InsertionSort - Array Aleatorio");
        try (PrintWriter out = new PrintWriter("InsertionCasoMedio.csv")) {
            for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
                media = 0;
                somaOperacoes = 0;

                for (int execucoes = 1; execucoes <= 10; execucoes++) {
                    vetor = criaVetorAleatorio(tamanhoVetor);
                    insertionsort(vetor);
                    somaOperacoes += count;
                }

                media = somaOperacoes / 10;
                System.out.println("Tamanho: " + tamanhoVetor + " ;  Operacoes: " + media);
                out.println("Tamanho: " + tamanhoVetor + " ;  Operacoes: " + count);
            }
        }
    }

    public static void heapsort(int v[]) {
        count = 0;

        for (int i = v.length / 2 - 1; i >= 0; i--) {
            heapify(v, v.length, i);
        }

        for (int i = v.length - 1; i > 0; i--) {
            swap(v, 0, i);

            heapify(v, i, 0);
        }
    }

    public static void heapify(int v[], int n, int i) {
        int raiz = i;

        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n && v[esquerda] > v[raiz]) {
            raiz = esquerda;
        }

        if (direita < n && v[direita] > v[raiz]) {
            raiz = direita;
        }

        count++;
        if (raiz != i) {
            swap(v, i, raiz);
            heapify(v, n, raiz);
        }
    }

    public static void swap(int v[], int i, int j) {
        int aux = v[j];
        v[j] = v[i];
        v[i] = aux;
    }

    public static void HeapSortpiorCaso() throws FileNotFoundException {
        int vetor[];

        System.out.println("HeapSort - Array Decrescente");
        try (PrintWriter out = new PrintWriter("HeapSortPiorCaso.csv")) {
            for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
                vetor = criaVetorDecrescente(tamanhoVetor);
                heapsort(vetor);
                System.out.println("Tamanho: " + tamanhoVetor + " ;  Operacoes: " + count);
                out.println("Tamanho: " + tamanhoVetor + " ;  Operacoes: " + count);
            }
        }
    }

    public static void HeapSortcasoMedio() throws FileNotFoundException {
        long media;
        long somaOperacoes;
        int vetor[];

        System.out.println("HeapSort - Array Aleatorio");
        try (PrintWriter out = new PrintWriter("HeapSortCasoMedio.csv")) {
            for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
                media = 0;
                somaOperacoes = 0;

                for (int execucoes = 1; execucoes <= 10; execucoes++) {
                    vetor = criaVetorAleatorio(tamanhoVetor);
                    heapsort(vetor);
                    somaOperacoes += count;
                }

                media = somaOperacoes / 10;
                System.out.println("Tamanho: " + tamanhoVetor + " ;  Operacoes: " + media);
                out.println("Tamanho: " + tamanhoVetor + " ;  Operacoes: " + count);
            }
        }
    }

    // Daqui pra baixo é pra rodar o programa

    public static void main(String[] args) throws Exception {

        BubblepiorCaso();
        BubblecasoMedio();
        InsertionpiorCaso();
        InsertioncasoMedio();
        HeapSortpiorCaso();
        HeapSortcasoMedio();

        System.out.println("---------------------------------");
        System.out.println("Arquivos CSV Gerados com sucesso");
        System.out.println("---------------------------------");

    }

}
