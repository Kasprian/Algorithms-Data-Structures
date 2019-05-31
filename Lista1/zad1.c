#include<stdio.h> 
#include<stdlib.h>
#include <time.h>  
int dcounter=0;
int findCounter=0;
int insertCounter=0;

struct Node{
	int data;
	struct Node *next;
};

struct LinkedList{
	struct Node *head;
};
/**
Function returns new List.
*/
struct LinkedList *newList(){
	struct LinkedList *list = malloc(sizeof(struct LinkedList));
	list->head=NULL;
	return list;
}

/**
Function returns new Node.
*/
struct Node *newNode(int value){
	struct Node *node = malloc(sizeof(struct Node));
	node->next=NULL;
	node->data=value;
	return node;
}

/**
Function returns 1 if list is empty and 0 otherwise. Operation time complexy: O(1).
*/
int isempty(struct LinkedList *list){
	if(list->head==NULL){
		return 1;
	}else{
		return 0;
	}
}

/**
Function inserts value at the end of the list. Operation time complexy: O(n).
*/
void insert(struct LinkedList *list, int value){
	struct Node *p= list->head;

	insertCounter++;
	if(list->head==NULL){
		list->head=newNode(value);
	}else{
		insertCounter++;
		while(p->next != NULL){
			p= p-> next;
		}
		p->next = newNode(value);
	}
}
/**
Function inserts value on the begining of the list. Operation time complexy: O(1).
*/
void insertOnBegining(struct LinkedList *list, int value){
	struct Node *pnext=NULL;
	if(list->head!=NULL){
	pnext = list->head;
	}
	list->head=newNode(value);
	list->head->next=pnext;
}

/**
Function deletes first of the value in list. Operation time complexy: O(n).
*/
void delete(struct LinkedList *list, int value){
	struct Node *p = list->head;
	struct Node *prev = list->head;
	dcounter++;
	if(isempty(list)){
		return;
	}
	if(p->data==value){
		list->head=p->next;
		free(p);
	}else{
		p=p->next;
		dcounter++;
		while(p!=NULL){
			dcounter++;
			if(p->data==value){
				prev->next=p->next;
				free(p);
				return;
			}
			prev = p;
			p=p->next;
		}
	}
}
/**
Function returns 1 if a value is on the list and moves this value on the begging of the list,returns 0 otherwise. Operation time complexy: O(n).
*/
int findMTF(struct LinkedList *list, int value){
	struct Node *p= list->head;
	struct Node *prev= list->head;

	findCounter++;
	if(list -> head==NULL){
		return 0;
	}else{
		findCounter++;
		if(p->data==value){//sprawdzenie pierwszej pozycji
			return 1;
		}

		p=p->next;
		while(p!=NULL){
			findCounter++;
			if(p->data==value){//sprawdzenie kolejnych pozycji
				prev->next=p->next;
				p->next=list->head;
				list->head=p;
				return 1;
			}
			prev = p;
			p=p->next;
		}
		return 0;
	}
}
/**
Function returns 1 if a value is on the list and moves this value one postion closer to the begging of the list,returns 0 otherwise. Operation time complexy: O(n).
*/
int findTRANS(struct LinkedList *list, int value){
	struct Node *p= list->head;
	struct Node *prev= list->head;
	struct Node *pprev= list->head;

	findCounter++;
	if(list -> head==NULL){
		return 0;
	}else{
		if(p->data==value){
			return 1;//sprawdzenie pierwszej pozycji
		}
		p=p->next;
		
        if(p==NULL){
            return 0;
        }
        findCounter++;
        if(p->data==value){
            list->head=p;
            prev->next=p->next;
            p->next=prev;
            return 1;//sprawdzenie drugiej pozycji
        }
        prev = p;
		p=p->next;
		while(p!=NULL){
			findCounter++;
			if(p->data==value){//sprawdzenie kolejnych pozycji
				pprev->next=p;
				prev->next=p->next;
				p->next=prev;
				return 1;
			}
			pprev=prev;
			prev = p;
			p=p->next;
		}
		return 0;
	}
}

int isThere(struct LinkedList *list, int value){
	struct Node *p= list->head;
	if(list->head==NULL){
		return 0;
	}else{
		while(p!=NULL){
			if(p->data==value){
				return 1;
			}
			p=p->next;
		}
		return 0;
	}
}


/**
Functions prints list.
*/
void printList(struct LinkedList *list){
	if(list->head==NULL){
		return;
	}
    struct Node *p = list->head;
    printf("[ ");

    while (p->next != NULL){
        printf("%d ][ ", p->data);
        p = p->next;
    }

    printf("%d ]\n", p->data);
}

void shuffle(int *array, size_t n)
{
	srand(time(0));
    if (n > 1) 
    {
        size_t i;
        for (i = 0; i < n - 1; i++) 
        {
          size_t j = i + rand() / (RAND_MAX / (n - i) + 1);
          int t = array[j];
          array[j] = array[i];
          array[i] = t;
        }
    }
}

void randomInsert(){
	struct LinkedList *list=newList();
	struct LinkedList *list2=newList();
	
	for(int i=0;i<100;i++){
		int num=(rand() % 100)+1;
		insert(list,num);
		insert(list2,num);
	}
	printList(list);
	printList(list2);
	int j=100;
	while(!isempty(list)){
		for(int i=1;i<=100;i++){
			findMTF(list,i);
		}
		delete(list,j);
		if(!isThere(list,j)){
		j--;
	}
	}
	printf("Porównania podczas szukania: %d\n", findCounter);
	printf("Porównania podczas usuwania: %d\n", dcounter);
	dcounter=0;
	findCounter=0;
	j=100;
	while(!isempty(list2)){
		for(int i=1;i<=100;i++){
			findTRANS(list2,i);
		}
		delete(list2,j);
		if(!isThere(list2,j)){
		j--;
	}
	}
	printf("Porównania podczas szukania: %d\n", findCounter);
	printf("Porównania podczas usuwania: %d\n", dcounter);
}



void main(){
	struct LinkedList *list=newList();
	struct LinkedList *list2=newList();
	int tab[100];
	for(int i=0;i<100;i++){
		tab[i]=i+1;
	}
	shuffle(tab,100);
	for(int i=0;i<100;i++){
		insert(list,tab[i]);
		insert(list2,tab[i]);
	}
	printList(list);
	printList(list2);
	int j=100;
	while(!isempty(list)){
		for(int i=1;i<=100;i++){
			findMTF(list,i);
		}
		delete(list,j);
		j--;
	}
	printf("Porównania podczas szukania MTF: %d\n", findCounter+dcounter);
	dcounter=0;
	findCounter=0;
	j=100;
	while(!isempty(list2)){
		for(int i=1;i<=100;i++){
			findTRANS(list2,i);
		}
		delete(list2,j);
		j--;
	}
	printf("Porównania podczas szukania TRANS: %d\n", findCounter+dcounter);
	//randomInsert();
/*	struct LinkedList *list=newList();
	insert(list,5);
	insert(list,10);
	insert(list,1);
	insert(list,2);
	printList(list);
	findTRANS(list,10);
	printList(list);*/
}
