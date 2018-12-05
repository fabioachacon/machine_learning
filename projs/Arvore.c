#include <stdio.h>
#include <malloc.h>


typedef int t_chave;


typedef struct aux{
	t_chave chave;
    struct aux *esq, *dir;
}NO;

typedef NO* t_no;

t_no inicializa(){
	
	return(NULL);
}


t_no inserir(t_no raiz, t_no no){   //Insere um novo nó na árvore.
	
	if(raiz == NULL) return(no);    //Checa se a árvore está vazia. 
	if(no->chave < raiz->chave)     //Checa se a chave do nó inserido é menor que a chave do nó raiz.
	  raiz->esq = inserir(raiz->esq, no); //Se a condição for verdadeira, insere-se o nó na subárvore da esquerda.
	else
	  raiz->dir = inserir(raiz->dir, no); //Caso contrário, insere-se na subárvore da direita.
	  
	return raiz;
}

t_no pesquisar(t_chave ch, t_no raiz){
	if(raiz == NULL) return NULL;
	if(raiz->chave == ch) return(raiz);
	if(raiz->chave > ch)
	 return(pesquisar(ch,raiz->esq));
	return(pesquisar(ch, raiz->dir));
}

void exibir(t_no raiz){
	if(raiz != NULL){
		printf("%i", raiz->chave);
		printf("(");
		exibir(raiz->dir);
		exibir(raiz->dir);
		printf(")");
	}
}

t_no criar_no(t_chave ch){
	
	t_no novo_no = (t_no) malloc(sizeof(NO));
	novo_no->esq = NULL;
	novo_no->dir = NULL;
	novo_no->chave = ch;
	
	return novo_no;
}

t_no buscar_no(t_no raiz, t_chave ch, t_no *pai){
	t_no atual = raiz;
	*pai = NULL;
	while(atual){
		if(atual->chave == ch) return(atual);
		*pai = atual;
		if(ch < atual->chave) atual = atual->esq;
		else atual = atual->dir;
	}
	
	return NULL;
}

t_no remover(t_no raiz, t_chave ch){
	t_no pai, no, p, q;
	no = buscar_no(raiz, ch, &pai);
	if(!no->esq || !no->dir){
		if(!no->esq) q = no->dir;
		else q = no->esq;
	}
	 else{
	 	p = no;
	 	q = no->esq;
	 	while(q->dir){
	 		p = q;
	 		q = q->dir;
		 }
		 
	  if(p != no){
	  	p->dir = q->esq;
	  	q->esq = no->esq;
	  }
	  q->dir = no->dir;
	 }
	 if(!pai){
	 	free(no);
	 	return q;
	 }
	 if(ch < pai->chave) pai->esq = q;
	 else pai->dir = q;
	 free(no);
	 return raiz;
}

void menu_principal(){
	
	printf("ALUNO: FABIO DE ANDRADE CHACON COSTA\n");
	printf("DISCIPLINA: ESTRUTURA DE DADOS\n");
	printf("PROFESSOR: WALACE BONFIM\n");
	puts("");
	printf("\t\tEDITOR DE ARVORE\n\n");
	
	printf("1-INSERIR\n2-REMOVER APENAS UM NO\n3-PESQUISAR\n4-EXIBIR A ARVORE\n0-SAIR\n\n");
}

void menu(){
	
	menu_principal();
	int x, y = 0;
	t_no raiz = inicializa();
	while(scanf("%d", &x) != 0){
	fflush(stdin);
	switch(x){
	

		case 1:
			printf("Insira o elemento\n");
			t_no no = criar_no(scanf("%d",&y));
		    raiz = inserir(raiz, no);
		    break;
		case 2:
			remover(raiz, scanf("%d", &y));
			break;
		case 3:
			pesquisar(scanf("%d", &y), raiz);
			break;
		case 4:
			exibir(raiz);
			break;
		default:
			printf("Opcao inválida\n");
			
  }
  menu_principal();
			
 }
		
}




int main(){

	menu();
	
}





