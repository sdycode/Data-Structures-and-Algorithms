

def wordSubsets( words1: list[str], words2: list[str]) -> list[str]:
    ans = []
    for word in words1:
        univ =True
        for letter in words2:
            if letter  in word:
                pass
            else: 
                univ= False
        if univ:
            ans.append(word)
    print(ans)
    return ans

    pass


wordSubsets(["amazon","apple","facebook","google","leetcode"], ["l","e"])


