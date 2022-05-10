public class SortMerge 
{

    public static void sort(int[] arr) 
    {
	    //TO BE IMPLEMENTED
        int length = arr.length;
        if(length < 2) {
            return;
        }

        int split = length/2;
        int[] sub1 = new int[split];
        int[] sub2 = new int[length - split];

        for (int i = split; i < length; i++) {
            sub2[i - split] = arr[i];
        }
        for (int i = 0; i < split; i++) {
            sub1[i] = arr[i];
        }

        sort(sub1);
        sort(sub2);

        int x = 0;
        int y = 0;
        int z = 0;

        while(x < split && y < length - split) {
            if (sub2[y] <= sub1[x]) {
                arr[z++] = sub2[y++];
            }
            else {
                arr[z++] = sub1[x++];
            }
        }
        while(x < split) {
            arr[z++] = sub1[x++];
        }
        while(y < length - split) {
            arr[z++] = sub2[y++];
        }
    }
    
}
	