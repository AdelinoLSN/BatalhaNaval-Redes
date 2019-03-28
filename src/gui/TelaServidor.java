package gui;

import controlador.Jogo;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import model.Tabuleiro;

public class TelaServidor extends javax.swing.JFrame {
    Jogo jogo;
    int contadorProprio = 0;
    int contadorAdversario = 0;
    
    ServerSocket servidor;
    Socket conexao;
    BufferedReader entradaCliente;
    DataOutputStream saidaCliente;
    String auxiliar;
   
    public TelaServidor() {
        jogo = new Jogo();
        initComponents();
        
        renameAllButtonsPrincipal();
        renameAllButtonsAuxiliar();
        
        ArrayList a = getAllButtonsPrincipal();
        marcarSeusNavios(a,this.jogo.getPrincipal());
        
        desabilitarTabuleiro();
    }
    
    void fimDeJogo(){
        System.out.println("------"+this.contadorProprio+" "+this.contadorAdversario);
        if(this.contadorAdversario == 10 || this.contadorProprio == 10){
            desabilitarTabuleiro();
            if(this.contadorAdversario == 10){
                JOptionPane.showMessageDialog(null,"Fim de Jogo");
            }else{
                JOptionPane.showMessageDialog(null,"Fim de Jogo");
            }
        }else{
            //JOptionPane.showMessageDialog(null,"Sua vez");
            habilitaTabuleiro();
        }
    }
    
    private void habilitaTabuleiro(){
        ArrayList<javax.swing.JButton> botoes = getAllButtonsClick();
        while(botoes.isEmpty() == false){
            javax.swing.JButton b = botoes.remove(0);
            if(b.getText().equals("A") == false && b.getText().equals("X") == false){
                b.setEnabled(true);
            }
        }
    }
    
    private ArrayList<javax.swing.JButton> getAllButtonsClick(){
        ArrayList<javax.swing.JButton> botoes = new ArrayList<javax.swing.JButton>();
        botoes.add(jButton_A_0_0);
        botoes.add(jButton_A_0_1);
        botoes.add(jButton_A_0_2);
        botoes.add(jButton_A_0_3);
        botoes.add(jButton_A_0_4);
        botoes.add(jButton_A_1_0);
        botoes.add(jButton_A_1_1);
        botoes.add(jButton_A_1_2);
        botoes.add(jButton_A_1_3);
        botoes.add(jButton_A_1_4);
        botoes.add(jButton_A_2_0);
        botoes.add(jButton_A_2_2);
        botoes.add(jButton_A_2_1);
        botoes.add(jButton_A_2_3);
        botoes.add(jButton_A_2_4);
        botoes.add(jButton_A_3_0);
        botoes.add(jButton_A_3_1);
        botoes.add(jButton_A_3_2);
        botoes.add(jButton_A_3_3);
        botoes.add(jButton_A_3_4);
        botoes.add(jButton_A_4_0);
        botoes.add(jButton_A_4_1);
        botoes.add(jButton_A_4_2);
        botoes.add(jButton_A_4_3);
        botoes.add(jButton_A_4_4);
        return botoes;
    }
    
    private void desabilitarTabuleiro() {
        jButton_A_0_0.setEnabled(false);
        jButton_A_0_1.setEnabled(false);
        jButton_A_0_2.setEnabled(false);
        jButton_A_0_3.setEnabled(false);
        jButton_A_0_4.setEnabled(false);
        jButton_A_1_0.setEnabled(false);
        jButton_A_1_1.setEnabled(false);
        jButton_A_1_2.setEnabled(false);
        jButton_A_1_3.setEnabled(false);
        jButton_A_1_4.setEnabled(false);
        jButton_A_2_0.setEnabled(false);
        jButton_A_2_2.setEnabled(false);
        jButton_A_2_1.setEnabled(false);
        jButton_A_2_3.setEnabled(false);
        jButton_A_2_4.setEnabled(false);
        jButton_A_3_0.setEnabled(false);
        jButton_A_3_1.setEnabled(false);
        jButton_A_3_2.setEnabled(false);
        jButton_A_3_3.setEnabled(false);
        jButton_A_3_4.setEnabled(false);
        jButton_A_4_0.setEnabled(false);
        jButton_A_4_1.setEnabled(false);
        jButton_A_4_2.setEnabled(false);
        jButton_A_4_3.setEnabled(false);
        jButton_A_4_4.setEnabled(false);
    }
    
    private void marcarSeusNavios(ArrayList<javax.swing.JButton> c, Tabuleiro principal) {
        int tam = c.size();
        int i,j;
        javax.swing.JButton atual;
        String[] array;
        String nome;
        
        while(c.isEmpty() == false){
            atual = c.remove(0);
            nome = atual.getName();
            array = nome.split("_");
            i = Integer.parseInt(array[array.length-2]);
            j = Integer.parseInt(array[array.length-1]);
            int valor = principal.getMatriz()[i][j].getValor();
            if(valor != 0){
                atual.setEnabled(false);
                atual.setText(Integer.toString(valor));
            }
        }
    }
    
    public ArrayList getAllButtonsPrincipal(){
        ArrayList<javax.swing.JButton> botoes = new ArrayList<javax.swing.JButton>();
        
        botoes.add(jButton_0_0);
        botoes.add(jButton_0_1);
        botoes.add(jButton_0_2);
        botoes.add(jButton_0_3);
        botoes.add(jButton_0_4);
        botoes.add(jButton_1_0);
        botoes.add(jButton_1_1);
        botoes.add(jButton_1_2);
        botoes.add(jButton_1_3);
        botoes.add(jButton_1_4);
        botoes.add(jButton_2_0);
        botoes.add(jButton_2_1);
        botoes.add(jButton_2_2);
        botoes.add(jButton_2_3);
        botoes.add(jButton_2_4);
        botoes.add(jButton_3_0);
        botoes.add(jButton_3_1);
        botoes.add(jButton_3_2);
        botoes.add(jButton_3_3);
        botoes.add(jButton_3_4);
        botoes.add(jButton_4_0);
        botoes.add(jButton_4_1);
        botoes.add(jButton_4_2);
        botoes.add(jButton_4_3);
        botoes.add(jButton_4_4);

        return botoes;
    }
    
    private void renameAllButtonsPrincipal() {
        jButton_0_0.setName("jButton_0_0");
        jButton_0_1.setName("jButton_0_1");
        jButton_0_2.setName("jButton_0_2");
        jButton_0_3.setName("jButton_0_3");
        jButton_0_4.setName("jButton_0_4");
        jButton_1_0.setName("jButton_1_0");
        jButton_1_1.setName("jButton_1_1");
        jButton_1_2.setName("jButton_1_2");
        jButton_1_3.setName("jButton_1_3");
        jButton_1_4.setName("jButton_1_4");
        jButton_2_0.setName("jButton_2_0");
        jButton_2_1.setName("jButton_2_1");
        jButton_2_2.setName("jButton_2_2");
        jButton_2_3.setName("jButton_2_3");
        jButton_2_4.setName("jButton_2_4");
        jButton_3_0.setName("jButton_3_0");
        jButton_3_1.setName("jButton_3_1");
        jButton_3_2.setName("jButton_3_2");
        jButton_3_3.setName("jButton_3_3");
        jButton_3_4.setName("jButton_3_4");
        jButton_4_0.setName("jButton_4_0");
        jButton_4_1.setName("jButton_4_1");
        jButton_4_2.setName("jButton_4_2");
        jButton_4_3.setName("jButton_4_3");
        jButton_4_4.setName("jButton_4_4");
    }
    
    private void renameAllButtonsAuxiliar() {
        jButton_A_0_0.setName("jButton_A_0_0");
        jButton_A_0_1.setName("jButton_A_0_1");
        jButton_A_0_2.setName("jButton_A_0_2");
        jButton_A_0_3.setName("jButton_A_0_3");
        jButton_A_0_4.setName("jButton_A_0_4");
        jButton_A_1_0.setName("jButton_A_1_0");
        jButton_A_1_1.setName("jButton_A_1_1");
        jButton_A_1_2.setName("jButton_A_1_2");
        jButton_A_1_3.setName("jButton_A_1_3");
        jButton_A_1_4.setName("jButton_A_1_4");
        jButton_A_2_0.setName("jButton_A_2_0");
        jButton_A_2_1.setName("jButton_A_2_1");
        jButton_A_2_2.setName("jButton_A_2_2");
        jButton_A_2_3.setName("jButton_A_2_3");
        jButton_A_2_4.setName("jButton_A_2_4");
        jButton_A_3_0.setName("jButton_A_3_0");
        jButton_A_3_1.setName("jButton_A_3_1");
        jButton_A_3_2.setName("jButton_A_3_2");
        jButton_A_3_3.setName("jButton_A_3_3");
        jButton_A_3_4.setName("jButton_A_3_4");
        jButton_A_4_0.setName("jButton_A_4_0");
        jButton_A_4_1.setName("jButton_A_4_1");
        jButton_A_4_2.setName("jButton_A_4_2");
        jButton_A_4_3.setName("jButton_A_4_3");
        jButton_A_4_4.setName("jButton_A_4_4");
    }
    
    void esperaJogada(){
        SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                String stringServidor;
                System.out.println("Esperando jogada do cliente!");
                Thread.sleep(2000);
                stringServidor = entradaCliente.readLine();
                System.out.println("Recebeu jogada do cliente!");
                if (stringServidor != null){ 
                    String s = jogadaAdversaria(stringServidor);
                    saidaCliente.writeBytes(s+'\n');  
                    fimDeJogo();
                    
                }
                return null;
            }
        };
        worker.execute();
    }
    
    private void receberResposta(String botao) throws IOException {
        saidaCliente.writeBytes(botao+'\n');
        SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                String stringCliente;
                //Thread.sleep(1000);
                System.out.println("Esperando resposta do cliente!");               
                stringCliente = entradaCliente.readLine();
                System.out.println("Recebeu resposta do cliente!");
                if (stringCliente != null){
                    marcarBotao(stringCliente,botao);
                    if(stringCliente.equals('X')){
                        incrementaContadorAdversario();
                        System.out.println("INCREMENTEI O CONTADOR ADVERSARIO");
                        fimDeJogo();
                    }
                }
                return null;
            }
        };        
        worker.execute();
    }
    
    public void incrementaContadorAdversario(){
        this.contadorAdversario++;
    }
    
    public void incrementaContadorProprio(){
        this.contadorProprio++;
    }
    
    public void marcarBotao(String s, String botao){
        ArrayList<javax.swing.JButton> a = getAllButtonsClick();
        while(a.isEmpty() != true){
            javax.swing.JButton b = a.remove(0);
            if(b.getName().equals(botao) == true){
                b.setText(s);
            }
        }
    }
    
    private String jogadaAdversaria(String jogada) {
        String retorno = "A";
        String[] array = jogada.split("_");
        int linha = Integer.parseInt(array[2]);
        int coluna = Integer.parseInt(array[3]);
        Tabuleiro t = this.jogo.getPrincipal();
        if(t.getMatriz()[linha][coluna].getValor() != 0){
            retorno = "X";
            this.contadorAdversario++;
        }
        marcarBotaoPrincipal(linha,coluna);
        return retorno;
    }
    
    private void marcarBotaoPrincipal(int x, int y){
        ArrayList<javax.swing.JButton> a = getAllButtonsPrincipal();
        while(a.isEmpty() == false){
            javax.swing.JButton b = a.remove(0);
            String s = "jButton_"+x+"_"+y;
            if(b.getName().equals(s)==true){
                if(this.jogo.getPrincipal().getMatriz()[x][y].getValor() > 0){
                    b.setBackground(Color.red);
                    incrementaContadorProprio();
                    System.out.println("INCREMENTEI O PROPRIO");
                }else{
                    b.setBackground(Color.blue);
                }               
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        minhaMatriz = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton_0_0 = new javax.swing.JButton();
        jButton_0_1 = new javax.swing.JButton();
        jButton_0_3 = new javax.swing.JButton();
        jButton_0_2 = new javax.swing.JButton();
        jButton_0_4 = new javax.swing.JButton();
        jButton_1_0 = new javax.swing.JButton();
        jButton_1_1 = new javax.swing.JButton();
        jButton_1_2 = new javax.swing.JButton();
        jButton_1_3 = new javax.swing.JButton();
        jButton_1_4 = new javax.swing.JButton();
        jButton_2_0 = new javax.swing.JButton();
        jButton_2_1 = new javax.swing.JButton();
        jButton_2_2 = new javax.swing.JButton();
        jButton_2_3 = new javax.swing.JButton();
        jButton_2_4 = new javax.swing.JButton();
        jButton_3_0 = new javax.swing.JButton();
        jButton_3_1 = new javax.swing.JButton();
        jButton_3_2 = new javax.swing.JButton();
        jButton_3_3 = new javax.swing.JButton();
        jButton_3_4 = new javax.swing.JButton();
        jButton_4_0 = new javax.swing.JButton();
        jButton_4_1 = new javax.swing.JButton();
        jButton_4_2 = new javax.swing.JButton();
        jButton_4_3 = new javax.swing.JButton();
        jButton_4_4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton_A_0_0 = new javax.swing.JButton();
        jButton_A_0_1 = new javax.swing.JButton();
        jButton_A_0_2 = new javax.swing.JButton();
        jButton_A_0_3 = new javax.swing.JButton();
        jButton_A_0_4 = new javax.swing.JButton();
        jButton_A_1_0 = new javax.swing.JButton();
        jButton_A_1_1 = new javax.swing.JButton();
        jButton_A_1_2 = new javax.swing.JButton();
        jButton_A_1_3 = new javax.swing.JButton();
        jButton_A_1_4 = new javax.swing.JButton();
        jButton_A_2_0 = new javax.swing.JButton();
        jButton_A_2_2 = new javax.swing.JButton();
        jButton_A_2_1 = new javax.swing.JButton();
        jButton_A_2_3 = new javax.swing.JButton();
        jButton_A_2_4 = new javax.swing.JButton();
        jButton_A_3_0 = new javax.swing.JButton();
        jButton_A_3_1 = new javax.swing.JButton();
        jButton_A_3_2 = new javax.swing.JButton();
        jButton_A_3_3 = new javax.swing.JButton();
        jButton_A_3_4 = new javax.swing.JButton();
        jButton_A_4_0 = new javax.swing.JButton();
        jButton_A_4_1 = new javax.swing.JButton();
        jButton_A_4_2 = new javax.swing.JButton();
        jButton_A_4_3 = new javax.swing.JButton();
        jButton_A_4_4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        botaoIniciar = new javax.swing.JButton();
        jIpAddress = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_0_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_0_0ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_3_0, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_3_0, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton_A_0_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_0_0ActionPerformed(evt);
            }
        });

        jButton_A_0_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_0_1ActionPerformed(evt);
            }
        });

        jButton_A_0_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_0_2ActionPerformed(evt);
            }
        });

        jButton_A_0_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_0_3ActionPerformed(evt);
            }
        });

        jButton_A_0_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_0_4ActionPerformed(evt);
            }
        });

        jButton_A_1_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_1_0ActionPerformed(evt);
            }
        });

        jButton_A_1_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_1_1ActionPerformed(evt);
            }
        });

        jButton_A_1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_1_2ActionPerformed(evt);
            }
        });

        jButton_A_1_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_1_3ActionPerformed(evt);
            }
        });

        jButton_A_1_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_1_4ActionPerformed(evt);
            }
        });

        jButton_A_2_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_2_0ActionPerformed(evt);
            }
        });

        jButton_A_2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_2_2ActionPerformed(evt);
            }
        });

        jButton_A_2_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_2_1ActionPerformed(evt);
            }
        });

        jButton_A_2_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_2_3ActionPerformed(evt);
            }
        });

        jButton_A_2_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_2_4ActionPerformed(evt);
            }
        });

        jButton_A_3_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_3_0ActionPerformed(evt);
            }
        });

        jButton_A_3_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_3_1ActionPerformed(evt);
            }
        });

        jButton_A_3_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_3_2ActionPerformed(evt);
            }
        });

        jButton_A_3_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_3_3ActionPerformed(evt);
            }
        });

        jButton_A_3_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_3_4ActionPerformed(evt);
            }
        });

        jButton_A_4_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_4_0ActionPerformed(evt);
            }
        });

        jButton_A_4_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_4_1ActionPerformed(evt);
            }
        });

        jButton_A_4_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_4_2ActionPerformed(evt);
            }
        });

        jButton_A_4_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_4_3ActionPerformed(evt);
            }
        });

        jButton_A_4_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_A_4_4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_A_0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_A_1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_A_2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_A_3_0, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_A_4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_A_4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_A_0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_A_1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_A_2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_A_3_0, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_A_4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_A_4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        botaoIniciar.setText("Iniciar");
        botaoIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout minhaMatrizLayout = new javax.swing.GroupLayout(minhaMatriz);
        minhaMatriz.setLayout(minhaMatrizLayout);
        minhaMatrizLayout.setHorizontalGroup(
            minhaMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(minhaMatrizLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(minhaMatrizLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(minhaMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(minhaMatrizLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(botaoIniciar)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, minhaMatrizLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIpAddress)
                        .addGap(112, 112, 112))))
        );
        minhaMatrizLayout.setVerticalGroup(
            minhaMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, minhaMatrizLayout.createSequentialGroup()
                .addGroup(minhaMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(minhaMatrizLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(minhaMatrizLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jIpAddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoIniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)))
                .addGroup(minhaMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minhaMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(minhaMatriz, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_0_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_0_0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_0_0ActionPerformed

    private void jButton_A_0_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_0_0ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_0_0.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_0_0ActionPerformed

    private void botaoIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIniciarActionPerformed
        SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                conexao = servidor.accept();
                System.out.println("Conectou");
                Thread.sleep(1000);
                entradaCliente = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
                saidaCliente = new DataOutputStream(conexao.getOutputStream());
                habilitaTabuleiro();
                Thread.sleep(1000);
                return null;
            }
        };
        
        try {
            servidor = new ServerSocket(6666);
            worker.execute();
            botaoIniciar.setEnabled(false);
            jIpAddress.setText(""+InetAddress.getLocalHost().getHostAddress());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoIniciarActionPerformed

    private void jButton_A_0_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_0_1ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_0_1.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_0_1ActionPerformed

    private void jButton_A_0_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_0_2ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_0_2.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_0_2ActionPerformed

    private void jButton_A_0_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_0_3ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_0_3.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_0_3ActionPerformed

    private void jButton_A_0_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_0_4ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_0_4.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_0_4ActionPerformed

    private void jButton_A_1_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_1_0ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_1_0.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_1_0ActionPerformed

    private void jButton_A_1_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_1_1ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_1_1.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_1_1ActionPerformed

    private void jButton_A_1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_1_2ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_1_2.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_1_2ActionPerformed

    private void jButton_A_1_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_1_3ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_1_3.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_1_3ActionPerformed

    private void jButton_A_1_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_1_4ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_1_4.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_1_4ActionPerformed

    private void jButton_A_2_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_2_0ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_2_0.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_2_0ActionPerformed

    private void jButton_A_2_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_2_1ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_2_1.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_2_1ActionPerformed

    private void jButton_A_2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_2_2ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_2_2.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_2_2ActionPerformed

    private void jButton_A_2_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_2_3ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_2_3.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_2_3ActionPerformed

    private void jButton_A_2_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_2_4ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_2_4.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_2_4ActionPerformed

    private void jButton_A_3_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_3_0ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_3_0.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_3_0ActionPerformed

    private void jButton_A_3_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_3_1ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_3_1.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_3_1ActionPerformed

    private void jButton_A_3_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_3_2ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_3_2.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_3_2ActionPerformed

    private void jButton_A_3_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_3_3ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_3_3.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_3_3ActionPerformed

    private void jButton_A_3_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_3_4ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_3_4.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_3_4ActionPerformed

    private void jButton_A_4_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_4_0ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_4_0.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_4_0ActionPerformed

    private void jButton_A_4_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_4_1ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_4_1.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_4_1ActionPerformed

    private void jButton_A_4_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_4_2ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_4_2.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_4_2ActionPerformed

    private void jButton_A_4_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_4_3ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_4_3.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_4_3ActionPerformed

    private void jButton_A_4_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_A_4_4ActionPerformed
        desabilitarTabuleiro();
        try {
            receberResposta(this.jButton_A_4_4.getName());
        } catch (IOException ex) {
            Logger.getLogger(TelaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        esperaJogada();
    }//GEN-LAST:event_jButton_A_4_4ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaServidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoIniciar;
    private javax.swing.JButton jButton_0_0;
    private javax.swing.JButton jButton_0_1;
    private javax.swing.JButton jButton_0_2;
    private javax.swing.JButton jButton_0_3;
    private javax.swing.JButton jButton_0_4;
    private javax.swing.JButton jButton_1_0;
    private javax.swing.JButton jButton_1_1;
    private javax.swing.JButton jButton_1_2;
    private javax.swing.JButton jButton_1_3;
    private javax.swing.JButton jButton_1_4;
    private javax.swing.JButton jButton_2_0;
    private javax.swing.JButton jButton_2_1;
    private javax.swing.JButton jButton_2_2;
    private javax.swing.JButton jButton_2_3;
    private javax.swing.JButton jButton_2_4;
    private javax.swing.JButton jButton_3_0;
    private javax.swing.JButton jButton_3_1;
    private javax.swing.JButton jButton_3_2;
    private javax.swing.JButton jButton_3_3;
    private javax.swing.JButton jButton_3_4;
    private javax.swing.JButton jButton_4_0;
    private javax.swing.JButton jButton_4_1;
    private javax.swing.JButton jButton_4_2;
    private javax.swing.JButton jButton_4_3;
    private javax.swing.JButton jButton_4_4;
    private javax.swing.JButton jButton_A_0_0;
    private javax.swing.JButton jButton_A_0_1;
    private javax.swing.JButton jButton_A_0_2;
    private javax.swing.JButton jButton_A_0_3;
    private javax.swing.JButton jButton_A_0_4;
    private javax.swing.JButton jButton_A_1_0;
    private javax.swing.JButton jButton_A_1_1;
    private javax.swing.JButton jButton_A_1_2;
    private javax.swing.JButton jButton_A_1_3;
    private javax.swing.JButton jButton_A_1_4;
    private javax.swing.JButton jButton_A_2_0;
    private javax.swing.JButton jButton_A_2_1;
    private javax.swing.JButton jButton_A_2_2;
    private javax.swing.JButton jButton_A_2_3;
    private javax.swing.JButton jButton_A_2_4;
    private javax.swing.JButton jButton_A_3_0;
    private javax.swing.JButton jButton_A_3_1;
    private javax.swing.JButton jButton_A_3_2;
    private javax.swing.JButton jButton_A_3_3;
    private javax.swing.JButton jButton_A_3_4;
    private javax.swing.JButton jButton_A_4_0;
    private javax.swing.JButton jButton_A_4_1;
    private javax.swing.JButton jButton_A_4_2;
    private javax.swing.JButton jButton_A_4_3;
    private javax.swing.JButton jButton_A_4_4;
    private javax.swing.JLabel jIpAddress;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel minhaMatriz;
    // End of variables declaration//GEN-END:variables

}
