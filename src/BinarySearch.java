public class BinarySearch {
    public static void main(String[] args) {
    int[]a={60,70,10,20,30,40,50};
       // System.out.println(searchInSortedRotatedArray(a,20));
        //System.out.println(countNoOfShiftsOfRotaions(a));
        /*int[]a1={10,20,20,20,30,40,50};
        System.out.println(firstOcuurenceUsingModifiedBinarySearch(a1,20));
        System.out.println(lastOcuurenceUsingModifiedBinarySearch(a1,20));
        System.out.println(totalOccurencesOfAnumberInASortedArrayInLogNTime(a1,20));*/

    int[] b={10,20,30,40,50,60,70};
    rotateArray(b,2);
    }
    public static void rotateArray( int [] a, int d)
    {

        while(d>0)
        {
            d--;
            int temp=a[a.length-1];
            for (int i = a.length-1; i>0; i--) {
              a[i]=a[i-1];
            }
            a[0]=temp;
        }
        for(int u:a)
            System.out.print(u+"    ");
        System.out.println();

    }

    public static int searchInSortedRotatedArray(int[]a,int key)
    {
        int low=0;
        int high= a.length-1;
        int mid=0;
        while(low<=high) {
            mid = (low + high) / 2;
            if (a[mid] == key)
                return mid;
            else if (a[mid] <= a[high])//rtight part is sorted
            {// out of two parts atleast 1 one will be sorted
                if( key>a[mid] && key <=a[high])
                    low=mid+1;
                else
                    high=mid-1;

            }
            else//a[low]<=a[mid] // left part is sorted
            {
                if(a[low]>=key&&key<a[mid])
                {
                    high=mid-1;
                }
                else
                    low=mid+1;
            }
        }
        return -1;

    }
    public static int countNoOfShiftsOfRotaions(int[]a)
    {// no of shifts = index of the minimum element in the array
        int low=0;
        int high=a.length-1;
        int mid=0;

        while(low<=high)
        {
            mid=(low + high)/2;
            if( a[low]<=a[high])//array is sorted already
                return low;
            int next=(mid+1)%a.length;
            int prev=(mid-1+a.length)%a.length;//+a.length for avoiding -ve values
            if(a[next]>a[mid]&&a[prev]>a[mid])
            return mid;
          else  if(a[mid]>=a[low])
                low=mid+1;
           else if(a[mid]<=a[high])
                high=mid-1;
        }

return -1;
    }
public static int firstOcuurenceUsingModifiedBinarySearch(int[]a,int key)
{
    int low=0;
    int high=a.length-1;
    int mid=0;
    int result=-1;
    while(low<=high)
    {
        mid=(low+high)/2;
        if(a[mid]==key)
        {
            result=mid;
            high=mid-1;
        }
        else if (a[mid]<key)
            low=mid+1;
        else
            high=mid-1;
    }
    return result;
}

    public static int lastOcuurenceUsingModifiedBinarySearch(int[]a,int key)
    {
        int low=0;
        int high=a.length-1;
        int mid=0;
        int result=-1;
        while(low<=high)
        {
            mid=(low+high)/2;
            if(a[mid]==key)
            {
                result=mid;
                low=mid+1;
            }
            else if (a[mid]<key)
                low=mid+1;
            else
                high=mid-1;
        }
        return result;
    }
    public static int totalOccurencesOfAnumberInASortedArrayInLogNTime(int[]a,int key)
    {
        int firstOccurence=firstOcuurenceUsingModifiedBinarySearch(a,key);
        int lastOccurence=lastOcuurenceUsingModifiedBinarySearch(a,key);
        return lastOccurence-firstOccurence+1;
    }
}
