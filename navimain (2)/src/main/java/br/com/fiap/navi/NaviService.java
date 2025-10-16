package br.com.fiap.navi;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class NaviService {

    private final ChatClient chatClient;

    public NaviService(ChatClient.Builder buider) {
        this.chatClient = buider.build();
    }

    public String translate(String text, String style) {
        String systemMessage = """
            Você é um tradutor especializado em adaptar textos para diferentes estilos de escrita brasileiros.
            Sua tarefa é reescrever o texto fornecido mantendo o significado original, mas adaptando completamente
            o estilo de linguagem conforme solicitado. Seja criativo e autêntico ao estilo escolhido.
            """;
        
        String userMessage = String.format("""
            Reescreva o seguinte texto no estilo "%s":
            
            %s
            
            Responda apenas com o texto reescrito, sem explicações adicionais.
            """, style, text);
        
        return chatClient.prompt()
                .system(systemMessage)
                .user(userMessage)
                .call()
                .content();
    }
}
