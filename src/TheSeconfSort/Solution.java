package TheSeconfSort;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){System.arraycopy(nums2,0,nums1,0,n);return;}
        if(n==0){return;}

        int i=0;//起始下标
        int j=0;
        int N=m+n;
        int [] aux=new int [N];//起始下标

        //赋值元素
        for(int k=0;k<N;k++)
            if(i<m)aux[k]=nums1[i++];//首先赋值 nums 1 中的元素
            else if(j<n)aux[k]=nums2[j++];//在赋值 nums 2 中的元素

        i=0;
        j=i+m;
        //修改元素的下标
        //标注两个的数组的结束下标

        for(int k=0;k<=N-1;k++)
            if(i>m-1) nums1[k]=aux[j++];
            else if (j>N-1)nums1[k]=aux[i++] ;
            else if (aux[i]<aux[j]) nums1[k]=aux[i++];
            else nums1[k]=aux[j++];
    }
}