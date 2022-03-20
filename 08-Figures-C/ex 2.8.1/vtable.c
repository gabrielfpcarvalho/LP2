#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);
typedef int  (* Figure_Area)  (struct Figure*);
typedef int  (* Figure_Comp)  (struct Figure*);
typedef int (* Figure_Dir)   (struct Figure*);


typedef struct {
    void (* print) (struct Figure*);
    int  (* area)  (struct Figure*);
    int  (* comp)  (struct Figure*);
    int  (* dir)   (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("\nRetangulo de largura %d e altura %d \nna posicao (%d, %d) \ncom area %d \ne cor RGB (%d,%d,%d).\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->fg.r, sup->fg.g, sup->fg.b);
}

int rect_area (Rect* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

Figure_vtable rect_vtable = {
    (Figure_Print) rect_print,
    (Figure_Area)  rect_area
};

Rect* rect_new (int x, int y, int w, int h, int r, int g, int b) { //foi adicionado o r g b no construtor
    Rect* this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->vtable = &rect_vtable;
    sup->fg.r = r;
    sup->fg.g = g;
    sup->fg.b = b;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

typedef struct {
    Figure super;
    int x2, y2;
} Line;

void line_print (Line* this) {
    Figure* sup = (Figure*) this;
    
    printf("\nLinha tracada da posicao (%d, %d) ate a posicao (%d, %d) \ncom o comprimento da linha de %d \ne cor RGB (%d, %d, %d).\n",
           sup->x, sup->y, this->x2, this->y2, sup->vtable->comp(sup), sup->fg.r, sup->fg.g, sup->fg.b);

    int int_result = line_dir(sup); // função que diz a direção que a linha foi traçada
    char str_result[3];
    itoa(int_result, str_result, 10); //transformando o resultado para string

    char dir_ed[20], dir_cb[20];

    if (str_result[0] == '1') {
        strcpy(dir_ed, "para a esquerda");
    }                                             //str_result[0] é o resultado de ed
    else if (str_result[0] == '2') {
        strcpy(dir_ed, "para a direita");
    }
    else {
        strcpy(dir_ed, "apenas vertical");
    }
    
    if (str_result[1] == '1') {
        strcpy(dir_cb, "para baixo");
    }                                             //str_result[1] é o resultado de cb
    else if (str_result[1] == '2') {
        strcpy(dir_cb, "para cima");
    }
    else{
        strcpy(dir_cb, "apenas horizontal");
    }

    printf("A direcao da linha eh %s e %s.\n", dir_ed, dir_cb);
    
}

int line_comp (Line* this) { // como linha não tem área, eu usei este método para representar o comprimento da linha no x e no y
    Figure* sup = (Figure*) this;
    return (this->x2 - sup->x) + (this->y2 - sup-> x); // (x final da linha - x inicial da linha) + (y final da linha - y inicial da linha) = soma do comprimento das coordenadas x e y
}

int line_dir (Line* this) { // este método vai mostrar a direção da linha traçada (para esquerda ou direita e para baixo ou para cima) usando o ponto inicial da coordenada como referência
    Figure* sup = (Figure*) this;
    int ed, cb; // variáveis ed (esquerda ou direita) e cb (cima ou baixo) vão receber 1 ou 2 como valores.

    if (sup->x > this->x2) { // (ed == 1 -> esquerda) (ed == 2 -> direita)
         ed = 1;
    }
    else if (sup->x < this->x2) {
        ed = 2;
    }
    else {
        ed = 3; //caso a linha não vá pra esquerda nem para a direita e fique apenas vertical.
    }

    if (sup->y > this->y2) {  
         cb = 1;
    }
    else if (sup->y < this->y2) { // (cb == 1 -> baixo) (cb == 2 -> cima)
        cb = 2;
    }
    else {
        cb = 3; //caso a linha não vá para cima nem para baixo e fique apenas horizontal.
    }
 
    //não consegui fazer a função retornar 2 valores diferentes (ed e cb) nem uma lista com os dois, então coloquei os dois valores em uma variavel string juntos e transformei para int.

    char str_result[3], str_ed[3], str_cb[3] = {NULL};
    int int_result;

    itoa(ed,str_ed,10); // transformando ed em string
    itoa(cb,str_cb,10); // transformando cb em string

    strcat(str_result,str_ed); 
    strcat(str_result,str_cb); //concatenando os valores em uma única string

    int_result = atoi(str_result); //transformando o resultado concatenado de volta para int
    
    return int_result;
}

Figure_vtable line_vtable = {
    (Figure_Print) line_print,
    (Figure_Comp)  line_comp, //line não tem a função para area no vtable
    (Figure_Dir)   line_dir
};

Line* line_new (int x, int y, int x2, int y2, int r, int g, int b) { //foi adicionado o r g b no construtor
    Line* this = malloc(sizeof(Line));
    Figure* sup = (Figure*) this;
    sup->vtable = &line_vtable;
    sup->fg.r = r;
    sup->fg.g = g;
    sup->fg.b = b;
    sup->x = x;
    sup->y = y;
    this->x2 = x2;
    this->y2 = y2;
}

int main (void) {
    Figure* figs[4] = {
        (Figure*) rect_new(10,10,100,100, 255,255,255),
        (Figure*) line_new(30,40,120,80, 255,255,255),
        (Figure*) rect_new(10,10,100,100, 255,255,255),
        (Figure*) line_new(10,110,300,160, 255,255,255)
    };

    for (int i=0; i<4; i++) {
        figs[i]->vtable->print(figs[i]);
    }

    for (int i=0; i<4; i++) {
        free(figs[i]);
    }
    return 0;
}
