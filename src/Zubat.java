import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Zubat extends Pokemon{
  private int hasarPuani;
  private boolean kartKullanildiMi;
  private BufferedImage zubat;

  public Zubat(){
    super(0, null, null);
  }
  
  public Zubat(int pokemonID, String pokemonAdi, String pokemonTip){
    super(pokemonID ,pokemonAdi, pokemonTip);
    this.hasarPuani = 50;
    this.kartKullanildiMi = false;
    try {
      zubat = ImageIO.read(new File(Oyun.dosyayolu + "zubat.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

    @Override
    public void hasarPuaniGoster(Graphics g){
      g.setColor(Color.PINK);
      g.setFont(Oyun.hasarPuaniFont);
      g.drawString(Integer.toString(hasarPuani),getX() + 50,getY() + 135);
      g.drawString(getPokemonTip(),getX() + 40,getY()+155);
    }

  public void kartCiz(Graphics g, int x, int y){
    setX(x);
    setY(y);
    g.drawImage(zubat,x,y,null);
  }

  public int getHasarPuani(){
    return hasarPuani;
  }

  public void setHasarPuani(int hasarPuani) {
    this.hasarPuani = hasarPuani;
  }

  public boolean isKartKullanildiMi() {
    return kartKullanildiMi;
  }

  public void setKartKullanildiMi(boolean kartKullanildiMi) {
    this.kartKullanildiMi = kartKullanildiMi;
  }

  public BufferedImage getZubat() {
    return zubat;
  }

  public void setZubat(BufferedImage zubat) {
    this.zubat = zubat;
  }
}