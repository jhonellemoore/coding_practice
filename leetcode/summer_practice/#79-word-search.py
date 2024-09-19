class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        # check if each letter forms the word that we're looking for.
                # check with word at word index
        def word_from_letter(board, i, j, word, word_index, seen):
            if word_index > len(word) - 1:
                return True
            if i >= len(board) or j >= len(board[0]) or i < 0 or j < 0 or board[i][j] != word[word_index] or (i, j) in seen:
                return False
            # add to seen set
            seen.add((i, j))

            boolean_right = word_from_letter(board, i+1, j, word, word_index + 1, seen) 
            boolean_left = word_from_letter(board, i-1, j, word, word_index + 1, seen) 
            boolean_up = word_from_letter(board, i, j+1, word, word_index + 1, seen) # here # here
            boolean_down = word_from_letter(board, i, j-1, word, word_index + 1, seen)

            # remove from seen set
            seen.remove((i, j))
            if boolean_right or boolean_left or boolean_up or boolean_down:
                return True
            return False

        for i in range(len(board)):
            for j in range(len(board[0])):
                seen = set()
                if word_from_letter(board, i, j, word, 0, seen):
                    return True
        return False
