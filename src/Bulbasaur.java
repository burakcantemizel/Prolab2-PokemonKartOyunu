import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Bulbasaur extends Pokemon{
  private int hasarPuani;
  private boolean kartKullanildiMi;
  private BufferedImage bulbasaur;

  public Bulbasaur(){
    super(0, null, null);
    this.hasarPuani = 0;
    this.kartKullanildiMi = false;
  }
  
  public Bulbasaur(int pokemonID,String pokemonAdi, String pokemonTip){
    super(pokemonID, pokemonAdi, pokemonTip);
    this.hasarPuani = 50;
    this.kartKullanildiMi = false;

    try {
      bulbasaur = ImageIO.read(new File(Oyun.dosyayolu + "bulbasaur.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void hasarPuaniGoster(Graphics g){
    g.setColor(Color.green);
    g.setFont(Oyun.hasarPuaniFont);
    g.drawString(Integer.toString(hasarPuani),getX() + 50,getY() + 135);
    g.drawString(getPokemonTip(),getX() + 44,getY()+155);
  }

  @Override
  public void kartCiz(Graphics g, int x, int y){
    setX(x);
    setY(y);
    g.drawImage(bulbasaur,x,y,null);

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

  public BufferedImage getBulbasaur() {
    return bulbasaur;
  }

  public void setBulbasaur(BufferedImage bulbasaur) {
    this.bulbasaur = bulbasaur;
  }
}