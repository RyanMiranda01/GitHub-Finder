package br.com.projeto.LocaizadorDePerfilGITHUB.perfil;

public class Perfil {
    private String name;
    private Integer id;
    private String bio;
    private String html_url;



    public Perfil(ConverterTexto convertido) {
        this.name = convertido.name();
        this.id = convertido.id();
        this.bio = convertido.bio();
        this.html_url = convertido.html_url();

    }

    @Override
    public String toString() {
        return """
            ==============================
            📄 Informações do Perfil GitHub
            ==============================
            👤 Nome: %s
            🆔 ID: %d
            📝 Bio: %s
            🌐 URL do Perfil: %s
            """.formatted(
                name != null ? name : "Não informado",
                id,
                bio != null ? bio : "Não informado",
                html_url != null ? html_url : "Não informado");
    }
}