import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Meowth extends Pokemon{
  private int hasarPuani;
  private boolean kartKullanildiMi;
  private BufferedImage meowth;

  public Meowth(){
    super(0, null, null);
  }
  
  public Meowth(int pokemonID, String pokemonAdi, String pokemonTip){
    super(pokemonID, pokemonAdi, pokemonTip);
    this.hasarPuani = 40;
    this.kartKullanildiMi = false;
    try {
      meowth = ImageIO.read(new File(Oyun.dosyayolu + "meowth.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

    @Override
    public void hasarPuaniGoster(Graphics g){
      g.setColor(Color.white);
      g.setFont(Oyun.hasarPuaniFont);
      g.drawString(Integer.toString(hasarPuani),getX() + 50,getY() + 135);
      g.drawString(getPokemonTip(),getX() + 29,getY()+155);
    }

    @Override
  public void kartCiz(Graphics g, int x, int y){
    setX(x);
    setY(y);
    g.drawImage(meowth,x,y,null);
  }

  public int getHasarPuani(){
    kartKullanildiMi = true;
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

  public BufferedImage getMeowth() {
    return meowth;
  }

  public void setMeowth(BufferedImage meowth) {
    this.meowth = meowth;
  }
}