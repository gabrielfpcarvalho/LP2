public class RectApp 
{
    public static void main (String[] args) 
    {
        Rect r1 = new Rect(1,1, 10,10);
        r1.print();
        r1.drag(20,20);
        r1.printdrag();
    }
}
class Rect 
{
    int x, y;
    int w, h;
    Rect (int x, int y, int w, int h) 
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    int area ()
    {
       int a = this.w * this.h;
       return a;
    }
    void drag (int dx, int dy)
    {
        this.x += dx;
        this.y += dy;
    }
    void print () 
    {
        int a = area();
        System.out.format("\nRetangulo de tamanho (%d,%d) na posicao (%d,%d).\n", this.w, this.h, this.x, this.y);
        System.out.format("\nA area do retangulo e: %d\n", a);
    }
    void printdrag ()
    {
        System.out.format("\nO retangulo foi arrastado para a posicao (%d,%d).\n", this.x, this.y);
    }
}
© 2022 GitHub, Inc.
Terms
Privacy
