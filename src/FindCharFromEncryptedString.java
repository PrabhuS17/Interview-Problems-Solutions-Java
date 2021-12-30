import java.util.Scanner;

public class FindCharFromEncryptedString {

    public static void main(String[] args){

        Scanner in  =  new Scanner(System.in);
        System.out.println("Enter an encrypted String: ");
        String str = in.nextLine();
        System.out.println("Enter an index number: ");
        int indexToBeSearched = in.nextInt();
        System.out.println(findCharFromGivenEncryptedString(str,indexToBeSearched));
    }

    static char findCharFromGivenEncryptedString(String str, int indexToBeSearched){

        StringBuilder builder = new StringBuilder();
        StringBuilder tempBuilder;
        int totalLengthTillNow = 0;
        int prevTotalLength;
        int counter = 0;
        for(Character c: str.toCharArray()){
            if(Character.isDigit(c)){
                int digit = Character.getNumericValue(c);
                prevTotalLength = totalLengthTillNow;
                totalLengthTillNow = totalLengthTillNow + (builder.length()*digit);
                if( indexToBeSearched < totalLengthTillNow ){
                    tempBuilder = new StringBuilder();
                    while(counter < digit) {
                        tempBuilder.append(builder);
                        counter++;
                    }
                    return tempBuilder.toString().charAt(indexToBeSearched-prevTotalLength);
                }
                builder.setLength(0);
                continue;
            }
            builder.append(c);
        }
        return Character.MIN_VALUE;
    }
}
