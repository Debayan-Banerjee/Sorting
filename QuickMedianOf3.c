#include "stdio.h"

int FindMedian(int start,int end){
	int middle;
	if((end-start)%2==0)
		middle=(end-start)/2;
	else
		middle=(end-start)/2+1;

	return middle;
}
int medianof3(int arr[],int start,int end){
	int middle;
	middle=FindMedian(start,end);
	if((arr[start]-arr[end])*(arr[middle]-arr[start])>=0)//CAUTION!WHEN THERE'S ONLY TWO ELEMENT THE GREATER IS SELETED AS PIVOT,UNLESS THE "EQUAL" CONDITION IS CHECKED!
	{
		return start;
	}
	if((arr[end]-arr[start])*(arr[middle]-arr[end])>=0){
		return end;
	}
	else
		return middle;
}
void quickmedianof3(int arr[],int start,int end){
	int Slice;
	if(start<end)//recurrenceENDcondition
	{
		Slice=partitionmedianof3(arr,start,end);
		printf("PartitionWhere=%d AtPartition=%d AfterPartition=%d BeforePartition=%d\n",Slice,arr[Slice],arr[Slice+1],arr[Slice-1]); //keep track on loop invariant!
		quickmedianof3(arr,start,Slice-1);
		quickmedianof3(arr,Slice+1,end);
	}
}


int partitionmedianof3(int arr[],int start,int end){
	int pivot,transitory,StartDog,EndDog;
	pivot=arr[medianof3(arr,start,end)];
	arr[medianof3(arr,start,end)]=arr[start];
	arr[start]=pivot;
	StartDog=start;
	EndDog=end+1;
	for(;;){
			do{
				StartDog=StartDog+1;//WatchDog from START
			} while(arr[StartDog]<pivot);
			do{
				EndDog=EndDog-1;//WatchDog from END
			} while(arr[EndDog]>pivot);
			if(StartDog>=EndDog){
				break;
			}
			transitory=arr[StartDog];
			arr[StartDog]=arr[EndDog];
			arr[EndDog]=transitory;//if no partition found,compel to shift WatchDog Elements,BUT NOT THE PIVOT ELEMENT!-YET.
		}
	arr[start]=arr[EndDog];
	arr[EndDog]=pivot;//ensure the current pivot needs no more shifting
	return EndDog;
}


int main(){
	int i,size;
	printf("enter array size=");
	scanf("%d",&size);
	printf("size=%d",size);
	int arr[size];
	printf("\n");
	printf("enter array= ");
	for(i=0;i<size;i++){
		scanf("%d",&arr[i]);
	}
	printf("\n");
	printf("InProcess!");
	printf("\n\n");
	quickmedianof3(arr,0,size-1);
	printf("\n");
	printf("DONE!");
	printf("\n\n");
	printf("sorted= ");
	for(i=0;i<size;i++){
		printf("%d ",arr[i]);
	}
	return 0;
}
