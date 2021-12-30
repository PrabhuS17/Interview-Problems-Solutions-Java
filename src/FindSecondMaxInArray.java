public class FindSecondMaxInArray {

    public static void main(String[] args)
    {
        System.out.println(findSecondMax(new int[]{13,12,21,19,23}));
    }


    static int findSecondMax(int[] arr){
        int prevMax=Integer.MIN_VALUE;
        int currMax=Integer.MIN_VALUE;

        for(int val: arr){
            if(val>currMax){
                prevMax = currMax;
                currMax = val;
            }
            if(val<currMax && val>prevMax){
                prevMax = val;
            }
        }
        return prevMax;
    }

}


