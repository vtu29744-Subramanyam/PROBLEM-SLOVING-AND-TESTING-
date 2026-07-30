import java.util.Scanner;
public class Task2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] a = {10,20,30,40,50,60};
        int key = sc.nextInt();
        int low=0;int high=a.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(a[mid]==key){
                System.out.println("elememnt found");
                return;
            }else if(key<a[mid]){
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        System.out.println("eleement not found");
    }
}
    

