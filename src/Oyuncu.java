import java.awt.*;
import java.util.ArrayList;

public abstract class Oyuncu{
  private int oyuncuID;
  private String oyuncuAdi;
  private int skor;
  private ArrayList<Pokemon> kartListesi;
  
  public Oyuncu(){
    this.oyuncuID = 0;
    this.oyuncuAdi = null;
    this.skor = 0;
    this.kartListesi = new ArrayList<Pokemon>();
  }
  
  public Oyuncu(int oyuncuID, String oyuncuAdi, int skor){
    this.oyuncuID = oyuncuID;
    this.oyuncuAdi = oyuncuAdi;
    this.skor = skor;
    this.kartListesi = new ArrayList<Pokemon>();
  }
  
  public void skorGoster(Graphics g){
    //Override edilip skor gösterme işlemi her oyuncu için farklı yapılacak koordinatlar farklı!
  }
  
  public abstract boolean kartSec(); //Abstract fonksiyon extend eden sınıflarda doldurulacak

  public int getOyuncuID() {
    return oyuncuID;
  }

  public void setOyuncuID(int oyuncuID) {
    this.oyuncuID = oyuncuID;
  }

  public String getOyuncuAdi() {
    return oyuncuAdi;
  }

  public void setOyuncuAdi(String oyuncuAdi) {
    this.oyuncuAdi = oyuncuAdi;
  }

  public int getSkor() {
    return skor;
  }

  public void setSkor(int skor) {
    this.skor = skor;
  }

  public ArrayList<Pokemon> getKartListesi() {
      return kartListesi;
  }

  public void setKartListesi(ArrayList<Pokemon> kartListesi) {
      this.kartListesi = kartListesi;
  }

}