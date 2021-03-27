package ehu.isad.partaideak;

public class AdminTabla {

    private String herrialdea;
    private Integer puntuak;

    public AdminTabla(String herrialdea, Integer puntuak) {
        this.herrialdea = herrialdea;
        this.puntuak = puntuak;
    }

    public String getHerrialdea() {
        return herrialdea;
    }

    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    public Integer getPuntuak() {
        return puntuak;
    }

    public void setPuntuak(Integer puntuak) {
        this.puntuak = puntuak;
    }
}
