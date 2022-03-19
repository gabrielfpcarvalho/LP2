#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y; // posição inicial das figuras
    Color fg, bg;
    void (* print) (struct Figure*); // chama a print dentro do struct figura
} Figure;


typedef struct {
    Figure super;
    int x2, y2; // no caso de uma linha, como não tem largura nem altura, foi designada duas variáveis para a coordenada do final do traçado
} Line;

void line_print (Line* this) {
    Figure* sup = (Figure*) this;
    printf("Linha tracada da posicao (%d, %d) ata a posicao (%d, %d).\n",
           this->x2, this->y2, sup->x, sup->y);
}

Line* line_new (int x, int y, int x2, int y2) {
    Line* this  = malloc(sizeof(Line));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) line_print;
    sup->x = x;
    sup->y = y;
    this->x2 = x2;
    this->y2 = y2;
}


typedef struct {
    Figure super;
    int w, h; // elipse tem largura e altura, então foi designada duas variáveis exclusivas para elipse
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse desenhada na posicao (%d, %d) com largura %d e altura %d\n",
           sup->x, sup->y, this->w, this->h);
}

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

void main (void) {
    Figure* figs[4] = {
        (Figure*) line_new(20,40,97,100),
        (Figure*) ellipse_new(90,20,130,250),
        (Figure*) line_new(80,130,60,20),
        (Figure*) ellipse_new(280,108,400,200)
    };

    for (int i=0; i<4; i++) {
        figs[i]->print(figs[i]);
    }

    for (int i=0; i<4; i++) {
        free(figs[i]);
    }
}
