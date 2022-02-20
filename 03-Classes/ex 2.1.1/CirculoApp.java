class Circulo
{
    int raio; //raio do circulo
    int x, y; // posição do círculo
    Circulo (int raio, int x, int y)
    {
        this.raio = raio;
        this.x = x;
        this.y = y;
    }

    void print()
    {
        System.out.format("\nFoi desenhado um circulo de raio %d na posicao (%d, %d).\n", this.raio, this.x, this.y);
    }
}

public class CirculoApp
{
   public static void main(String[] args) 
   {
       Circulo c1 = new Circulo(400, 50,50);
       c1.print();
   } 
}
