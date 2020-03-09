import java.awt.*;

class BilgisayarOyuncusu extends Oyuncu{
  
  public BilgisayarOyuncusu(){
    super(0, null ,0);
  }
  
  public BilgisayarOyuncusu(int oyuncuID, String oyuncuAdi, int skor){
    super(oyuncuID , oyuncuAdi , skor);
  }

  @Override
  public boolean kartSec(){
    int secilenKart = Oyun.random.nextInt(getKartListesi().size());
    Oyun.bilgisayarTimer++;
    if(Oyun.bilgisayarTimer > 100) {
      if (getOyuncuID() == 1) {
        Oyun.savasan1 = getKartListesi().get(secilenKart);
        getKartListesi().remove(secilenKart);
        Oyun.bilgisayarTimer = 0;
        return true;
      } else if (getOyuncuID() == 2) {
        Oyun.savasan2 = getKartListesi().get(secilenKart);
        getKartListesi().remove(secilenKart);
        Oyun.bilgisayarTimer = 0;
        return true;
      }
    }
    return false;
  }

  @Override
  public void skorGoster(Graphics g){
    if(getOyuncuID() == 1){
      g.drawString("Bilgisayar "+getOyuncuID()+ " Skor: " + getSkor(), 15, 720 - 20);
    }else if(getOyuncuID() == 2){
      if(Oyun.getSahne() == "oyunbb"){
        g.drawString("Bilgisayar "+getOyuncuID()+ " Skor: " + getSkor(), 15, 30);
      }else if(Oyun.getSahne() == "oyunbk"){
        g.drawString("Bilgisayar Skor: " + getSkor(), 15, 30);
      }

    }

  }

  //GET VE SET METOTLARI SUPER SINIFTA TANIMLI

}