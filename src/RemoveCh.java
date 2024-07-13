public class RemoveCh {
    public static void main(String[] args) {
        String str = "jssujspaky";
        String target = "juspay";


        int[] countStr = new int[26];
        int[] countTarget = new int[26];


        for (char ch : str.toCharArray()) {
            countStr[ch - 'a']++;
        }

        for (char ch : target.toCharArray()) {
            countTarget[ch - 'a']++;
        }

        int removeCount = 0;
        for (int i = 0; i < 26; i++) {

            if (countStr[i] > countTarget[i]) {
                removeCount += countStr[i] - countTarget[i];
            }
        }

        System.out.println("Number of characters to be removed: " + removeCount);
    }
}
