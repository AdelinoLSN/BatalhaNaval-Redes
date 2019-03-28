package model;

import java.util.ArrayList;
import java.util.Collections;
import model.Celula;
import util.MyRandom;

public class Tabuleiro {
    private Celula[][] matriz; // = new Celula[10][10];
    private int tamanho = 5;
    public boolean clicavel;

    public Tabuleiro(boolean clicavel) {
        this.clicavel = clicavel;
        this.matriz = criarMatriz();
        if(clicavel == false){
            this.preencher();
        }
    }

    private Celula[][] criarMatriz() {
        int n = this.tamanho;
        Celula[][] m = new Celula[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                m[i][j] = new Celula();
            }
        }
        return m;
    }
    
    private void preencher() { //funcao que irá preencher o tabuleiro com as embarcacoes
        //this.inserirBarco(5);
        this.inserirBarco(4);
        this.inserirBarco(3);
        this.inserirBarco(2);
        this.inserirSubmarino();
    }
    
    private void inserirBarco(int tam) { //funcao que ira inserir os barcos
        boolean posValida = false;
        boolean ladoValido = false;
        int externoLado = 0;
        int tamBarco = tam;
        while(posValida == false){
            int linha = MyRandom.gerar(5);
            int coluna = MyRandom.gerar(5);
            while(tam==5 && linha==2 && coluna==2){
                linha = MyRandom.gerar(5);
                coluna = MyRandom.gerar(5);
            }
            if((this.matriz[linha][coluna]).getValor() == 0){
                ArrayList<Integer> lados = inserirLados();
                while(ladoValido == false && lados.size() > 0){
                    Collections.shuffle(lados);
                    int ladoSorteado = lados.remove(0);
                    if(ladoSorteado == 1 && linha-(tamBarco-1) >= 0){
                        ladoValido = this.testarColuna(false,tamBarco,linha,coluna);
                    }else if(ladoSorteado == 2 && coluna+(tamBarco-1) <= 4){//caso o lado seja 2 (para direita) testo se cabe a embarcacao e se ela nao ja foi inserida
                        ladoValido = this.testarLinha(true,tamBarco,linha,coluna); // chamo a funcao que testa a linha com um todo
                    }else if(ladoSorteado == 3 && linha+(tamBarco-1) <= 4){//caso o lado seja 3 (para baixo) testo se cabe a embarcacao e se ela nao ja foi inserida
                        ladoValido = this.testarColuna(true,tamBarco,linha,coluna); // chamo a funcao que testa a coluna com um todo
                    }else if(ladoSorteado == 4 && coluna-(tamBarco-1) >= 0){//caso o lado seja 4 (para esquerda) testo se cabe a embarcacao e se ela nao ja foi inserida
                        ladoValido = this.testarLinha(false,tamBarco,linha,coluna);// chamo a funcao que testa a linha com um todo
                    }if(ladoValido == true){
                        externoLado = ladoSorteado;
                    }
                }if(ladoValido == false){
                    break;
                }
            }if(ladoValido == true){
                if(externoLado == 1){ //caso cima
                    this.inserirBarcoColuna(false,linha,coluna,tamBarco); //insere na coluna
                }
                if(externoLado == 2){//caso direira
                    this.inserirBarcoLinha(true,linha,coluna,tamBarco); //insere na linha
                }
                if(externoLado == 3){//caso baixo
                    this.inserirBarcoColuna(true,linha,coluna,tamBarco); //insere na coluna
                }
                if(externoLado == 4){//caso esquerda
                    this.inserirBarcoLinha(false,linha,coluna,tamBarco); //insere na linha
                }
                posValida = true; //afirma a insercao com sucesso
            }
        }
    }

    private boolean testarColuna(boolean positivo, int tamBarco, int linha, int coluna) { //funcao que testa a coluna como um todo
        boolean retorno = true; //define o retorno de aceitacao
        if(positivo == true){ //vê se é pra subir na coluna
            int aux = tamBarco-1; // determina o tamanho do barco a ser testado
            while(aux != 0 && retorno != false){ //enquanto toda a coluna nao tiver testada e nenhum outro espaco dela esteja ocupado
                if(this.matriz[linha+aux][coluna].getValor()!=0){ //verifica se esta livre
                    retorno = false; // caso nao
                }aux--; // decrementa iterador para proximo loop
            }
        }else{ // caso em que descera
            int aux = tamBarco-1; //difine tamanho do barco a ser testado
            while(aux != 0 && retorno != false){ //enquanto toda a coluna nao tiver testada e nenhum outro espaco dela esteja ocupado
                if(this.matriz[linha-aux][coluna].getValor()!=0){//verifica se esta livre
                    retorno = false;
                }aux--;//decrementa iterador para proximo loop
            }
        }
        return retorno;//retorna resultado
    }

    private boolean testarLinha(boolean positivo, int tamBarco, int linha, int coluna) {//funcao que testa a linha como um todo
        boolean retorno = true;
        if(positivo == true){
            int aux = tamBarco-1;
            while(aux != 0 && retorno != false){
                if(this.matriz[linha][coluna+aux].getValor() != 0){
                    retorno = false;
                }aux--;
            }
        }else{
            int aux = tamBarco-1;
            while(aux != 0 && retorno != false){
                if(this.matriz[linha][coluna-aux].getValor() != 0){
                    retorno = false;
                }                aux--;
            }
        }
        return retorno;
    }

    private void inserirBarcoColuna(boolean positivo,int linha, int coluna, int barco) {
        int aux = barco-1;
        if(positivo == true){
            while(aux != -1){
                this.matriz[linha+aux][coluna].setValor(barco); 
                aux--;
            }
        }else{
            while(aux != -1){
                this.matriz[linha-aux][coluna].setValor(barco); 
                aux--;
            }
        }
    }
    
    private void inserirBarcoLinha(boolean positivo,int linha, int coluna, int barco) {
        int aux = barco-1;
        if(positivo == true){
            while(aux != -1){
                this.matriz[linha][coluna+aux].setValor(barco); 
                aux--;
            }
        }else{
            while(aux != -1){
                this.matriz[linha][coluna-aux].setValor(barco); 
                aux--;
            }
        }
    }

    private void inserirSubmarino() {
        boolean posValida = false;
        while(posValida == false){
            int linha = MyRandom.gerar(5);
            int coluna = MyRandom.gerar(5);
            if(this.matriz[linha][coluna].getValor() == 0){
                this.matriz[linha][coluna].setValor(1);
                posValida = true;
            }
        }
    } 

    private ArrayList<Integer> inserirLados() {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        return array;
    }

    private void printarMatriz(Tabuleiro principal) {
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                System.out.print(principal.matriz[i][j].getValor()+" ");
            }
        }
    }
    
    public void jogar(int linha, int coluna) {
        
    }
    
    public boolean testarEmbarcacao(int valor) {
        int count = 0;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(this.matriz[i][j].isAberto() == false && this.matriz[i][j].getValor() == valor){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean gameIsOver(){
        boolean checaUm, checaDois, checaTres, checaQuatro;
        checaUm = testarEmbarcacao(1);
        checaDois = testarEmbarcacao(2);
        checaTres = testarEmbarcacao(3);
        checaQuatro = testarEmbarcacao(4);
        
        if(checaUm == true && checaDois == true && checaTres == true && checaQuatro == true){
            return true;
        }
        return false;
    }

    public int getTamanho() {
        return tamanho;
    }
    
    public Celula[][] getMatriz() {
        return matriz;
    }
    
}
