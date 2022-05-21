package hu.progmatic;

public class SuperBowl {
    private String ssz;
    private String date;
    private String gyoztes;
    private String eredmeny;
    private String vesztes;
    private String helyszin;
    private String varosAllam;
    private int nezoSzam;

    public SuperBowl() {
    }

    public SuperBowl(String ssz, String date, String gyoztes, String eredmeny, String vesztes, String helyszin, String varosAllam, int nezoSzam) {
        this.ssz = ssz;
        this.date = date;
        this.gyoztes = gyoztes;
        this.eredmeny = eredmeny;
        this.vesztes = vesztes;
        this.helyszin = helyszin;
        this.varosAllam = varosAllam;
        this.nezoSzam = nezoSzam;
    }

    public SuperBowl(String line){
        String[] pieces = line.split(";");
        this.ssz = pieces[0];
        this.date = pieces[1];
        this.gyoztes = pieces[2];
        this.eredmeny = pieces[3];
        this.vesztes = pieces[4];
        this.helyszin = pieces[5];
        this.varosAllam = pieces[6];
        this.nezoSzam = Integer.parseInt(pieces[7]);
    }

    public String getSsz() {
        return ssz;
    }

    public void setSsz(String ssz) {
        this.ssz = ssz;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGyoztes() {
        return gyoztes;
    }

    public void setGyoztes(String gyoztes) {
        this.gyoztes = gyoztes;
    }

    public String getEredmeny() {
        return eredmeny;
    }

    public void setEredmeny(String eredmeny) {
        this.eredmeny = eredmeny;
    }

    public String getVesztes() {
        return vesztes;
    }

    public void setVesztes(String vesztes) {
        this.vesztes = vesztes;
    }

    public String getHelyszin() {
        return helyszin;
    }

    public void setHelyszin(String helyszin) {
        this.helyszin = helyszin;
    }

    public String getVarosAllam() {
        return varosAllam;
    }

    public void setVarosAllam(String varosAllam) {
        this.varosAllam = varosAllam;
    }

    public int getNezoSzam() {
        return nezoSzam;
    }

    public void setNezoSzam(int nezoSzam) {
        this.nezoSzam = nezoSzam;
    }

    @Override
    public String toString() {
        return "SuperBowl{" +
                "ssz='" + ssz + '\'' +
                ", date='" + date + '\'' +
                ", gyoztes='" + gyoztes + '\'' +
                ", eredmeny='" + eredmeny + '\'' +
                ", vesztes='" + vesztes + '\'' +
                ", helyszin='" + helyszin + '\'' +
                ", varosAllam='" + varosAllam + '\'' +
                ", nezoSzam=" + nezoSzam +
                '}';
    }
}
