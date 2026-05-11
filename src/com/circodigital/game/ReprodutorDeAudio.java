import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class ReprodutorDeAudio {

    // Método estático para você chamar de qualquer lugar (ex: ReprodutorDeAudio.tocarSom("flecha.wav"))
    public static void tocarSom(String caminhoDoArquivo) {
        try {
            // Procura o arquivo de áudio no seu computador
            File arquivoSom = new File(caminhoDoArquivo);
            
            if (arquivoSom.exists()) {
                // Cria um fluxo de áudio e abre o "player" interno do Java (o Clip)
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(arquivoSom);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                
                // Dá o play! Ele toca o som de forma assíncrona (não trava o jogo)
                clip.start();
            } else {
                System.out.println(" Arquivo de som não encontrado: " + caminhoDoArquivo);
            }
        } catch (Exception e) {
            System.out.println(" Erro ao tocar o som: " + e.getMessage());
        }
    }

    // método feito especificamente para músicas de fundo
    private static Clip musicaDeFundoAtual;

    public static void tocarMusicaEmLoop(String caminhoDoArquivo) {
        try {
            // 2. A Regra de Ouro: Se já tiver uma música tocando, pare ela!
            if (musicaDeFundoAtual != null && musicaDeFundoAtual.isRunning()) {
                musicaDeFundoAtual.stop();
                musicaDeFundoAtual.close();
            }

            File arquivoSom = new File(caminhoDoArquivo);
            
            if (arquivoSom.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(arquivoSom);
                
                // 3. Salva a nova música na nossa variável e dá o play
                musicaDeFundoAtual = AudioSystem.getClip();
                musicaDeFundoAtual.open(audioInput);
                musicaDeFundoAtual.loop(Clip.LOOP_CONTINUOUSLY);
                musicaDeFundoAtual.start();
            } else {
                System.out.println(" Música não encontrada: " + caminhoDoArquivo);
            }
        } catch (Exception e) {
            System.out.println(" Erro ao tocar a música: " + e.getMessage());
        }
    }
}