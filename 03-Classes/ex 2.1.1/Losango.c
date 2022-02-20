#include <stdio.h>

typedef struct
{
    int d1, d2; //tamanho das diagonais do losango (d1- altura/ d2- largura)
    int x, y; // posição do vertice do topo do losango

} losango; //em um losango todos os lados têm o mesmo tamanho

void print (losango* l)
{
    printf("\nDesenho de um losango com diagonais de tamanho %d e %d, na posicao (%d, %d).\n", l->d1, l->d2, l->x, l->y);
}

void main (void)
{
    losango l1 = {80,100, 50,50};
    print(&l1);
}
