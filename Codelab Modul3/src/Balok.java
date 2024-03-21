public class Balok {
    private double panjang;
    private double lebar;
    private double tinggi;

    // Constructor
    public Balok(double panjang, double lebar, double tinggi) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    public Balok(String balok) {
    }

    public void inputNilai() {
    }

    public double luasPermukaan() {
        return 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
    }

    public double volume() {
        return panjang * lebar * tinggi;
    }
}