import java.awt.*;

class InsanOyuncusu extends Oyuncu{
  
  public InsanOyuncusu(){
    super(0, null ,0);
  }
  
  public InsanOyuncusu(int oyuncuID, String oyuncuAdi, int skor){
    super(oyuncuID , oyuncuAdi , skor);
  }

  @Override
  public boolean kartSec(){
    for(int i=0; i < this.getKartListesi().size(); i++){
      if(this.getKartListesi().get(i).tiklandiMi() == true){
        //println(this.kartListesi.size());
        Oyun.savasan1 = this.getKartListesi().get(i);
        this.getKartListesi().remove(i);
        return true;
      }
    }
    return false;
  }

  @Override
  public void skorGoster(Graphics g){
    g.drawString("Oyuncu Skor: " + getSkor(), 15, 720 -20);
  }

  //GET VE SET METODLARI SUPER SINIFTA TANIMLI

}