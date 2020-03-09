import java.awt.Color;
import java.awt.Graphics;

class Pokemon{
  private int pokemonID;
  private String pokemonAdi;
  private String pokemonTip;
  private int x;
  private int y;
  
  public Pokemon(){
    this.pokemonID = 0;
    this.pokemonAdi = null;
    this.pokemonTip = null;
    this.x = 0;
    this.y = 0;
  }
  
  public Pokemon(int pokemonID, String pokemonAdi, String pokemonTip){
    this.pokemonID = pokemonID;
    this.pokemonAdi = pokemonAdi;
    this.pokemonTip = pokemonTip;
    this.x = 0;
    this.y = 0;
  }

  //Override edilecek pokemonlarda orada doldurulacak.
  public void hasarPuaniGoster(Graphics g){

  }

  public void kartCiz(Graphics g,int x, int y){
    this.x = x;
    this.y = y;
    
    g.setColor(Color.black);
    g.fillRect(x,y,120,180);
    g.setColor(Color.white);
    g.drawString(pokemonAdi, x + 120/3, y+180/2);
  }
  
  public boolean tiklandiMi(){
     if(Oyun.mouseOver(x,y,120,180) && Oyun.getTiklandiMi()){
       return true;
     }
     return false;
  }

  public int getPokemonID() {
    return pokemonID;
  }

  public void setPokemonID(int pokemonID) {
    this.pokemonID = pokemonID;
  }

  public String getPokemonAdi() {
    return pokemonAdi;
  }

  public void setPokemonAdi(String pokemonAdi) {
    this.pokemonAdi = pokemonAdi;
  }

  public int getHasarPuani(){
    return -1;
  }

  public String getPokemonTip() {
    return pokemonTip;
  }

  public void setPokemonTip(String pokemonTip) {
    this.pokemonTip = pokemonTip;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }


}