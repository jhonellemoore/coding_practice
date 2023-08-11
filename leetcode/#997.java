/*
1. Create a list of person and their trust value
2. Increase trust value of trustee and decrease trust value of truster for each pair
3. Check if anyone achieves n-1 trust. This person is the town judge
4. If no one achieves n-1 trust, then there is no town judge. 
*/

class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] persons = new int [n+1];

        if (n == 1){
            return 1;
        }

        for (int [] pair : trust){
            persons[pair[0]]--;
            persons[pair[1]]++;
        }

        for (int i = 0; i < persons.length; i++){
            if (persons[i] == n -1){
                return i;
            }
        }

        return -1;


    }
}
