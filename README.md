# Algorithms

## 排序算法

### 选择排序

从下表 i=0 开始, 记下标 min = i, 表示当前 i 是最小的元素. 在内层循环中 ,下标 j 从 i+1 开始 寻找 数值 小于 min 的元素的下标,并且 赋值给min ,得到 a[min]=a[j].内层循环结束后 将 min 与 i 进行交换.

### 插入排序

从下标 i = 1 开始, 一直到 N结束. 内层循环  j = i 开始,并且 一直到  less(a[ j ] , a[ j - 1]) 不成立和 j > 0的时间 停止, **这里代表的意思是:一直寻找到第 i   个元素 不小于前面的元素的时间 才停止,直到 前面为 0, 并且一直交换两者的元素位置.**

### 希尔排序

希尔排序开始的地点是 h (子数组的长度 ), 从h 开始向前排序, 将 j 与 j - h 的元素交换位置. 直到长度为1 

```java
while(h>=1)
for(int i=h ;j<N ;i++)
	for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h){
        exch(a,j,j-h);
    }
h/=3;


```

### 归并排序

1. 首先需要实现的是 merge 函数的实现

   - 需要注意的点就是 merge 所包含的参数列表是 lo mid hi 三个位置元素
   - 在这就是在合并两个元素的时间 直接调用的就是 less( ) 函数.实现比较交换

   ```java
   merge(Comarable[]a ,int lo, int mid ,int hi){
       int i=lo;
       int j=mid+1;
       //1.首先去将 a[]数组 复制到 aux 数组中.
       for(int k=low;j<=hi;k++)
           aux[k]=a[k];
       //2.开始将数组进行合并
       for(int k=lo;k<=hi;k++){
           if(i>mid)      			a[k]=aux[j++]//左半边可以赋值的元素已经为空.
           elseif(j>hi)   			a[k]=aux[i++]//右半边可以赋值的元素已经为空.
           elseif(less(a[i],a[j]) 	a[k]=aux[i++]
           
            else 					a[k]=aux[j++]
       }
   } 
   ```

2. UpToBottom( 自顶向下的归并排序算法 , 采用递归调用的方式来实现 **原子操作也是交换一个元素的两个子数组**)

   ​	

   ```JAVA
   public void sort(Comparable []a ,int lo,int mid, int hi){
       if(lo>=hi) return;
       mid=lo+(hi-lo)/2;
       sort(a,lo,mid);//将左半边排序
       sort(a,mid+1,hi);//将右半边排序
       merge(a,lo,mid,hi);//归并的结果 ,见merge 函数.
   }
   ```

3. BottomToUp( 自底向上的归并排序算法 )

   - 核心思想在于选择合并的长度(即子数组的长度从 1 开始)

   ```JAva
   for(int size = 1 ;size < N ;size + =size)//长度是成倍的增长的
   
       for(int lo=0;lo < N -size;lo+=size+size){
           merge(a,lo,lo+size-1,Math(lo+2*size-1,N-1));
      }
   }
   ```


### 题解

1. 合并两个有序的数组

   

   ```
   package TheSeconfSort;
   
   class Solution {
       public void merge(int[] nums1, int m, int[] nums2, int n) {
           if(m==0){System.arraycopy(nums2,0,nums1,0,n);return;};//java 中只有值传递,不能改变 nums1=nums2 是不能改变 其中 的值的
           if(n==0){return;}
   
           int i=0;//起始下标
           int j=0;
           int N=m+n;//长度用来
           int [] aux=new int [N];//起始下标
   
           //赋值元素,采用辅助空间
           for(int k=0;k<N;k++)
               if(i<m)aux[k]=nums1[i++];//首先赋值 nums 1 中的元素
               else if(j<n)aux[k]=nums2[j++];//在赋值 nums 2 中的元素
   
           i=0;//表示nums1的起点.
           j=i+m;//表示nums2的起点
           //m-1代表 mid
           //N-1 代表hi
   		//0 代表lo
   		
           for(int k=0;k<=N-1;k++)
               if(i>m-1) nums1[k]=aux[j++];
               else if (j>N-1)nums1[k]=aux[i++] ;
               else if (aux[i]<aux[j]) nums1[k]=aux[i++];
               else nums1[k]=aux[j++];
       }
   }
   ```
### PriorityQue(pq[1]存储的是最大的元素 的优先队列)
1. 上游函数 swim() 添加一个元素的时间,从N (元素的底部开始),调用Swim () 使得 堆是有序的.
```java
private void swim(int index){
    while(index>1 && less(index/2,index)){
        exch(index,index/2);
        index/=2;
        }
        
}
```
2. 下沉函数 sink()