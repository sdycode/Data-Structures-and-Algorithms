# https://leetcode.com/problems/two-sum/

# brut force
def twoSum(self, nums: List[int], target: int):
    
    self.nums=nums
    for i,e in enumerate(nums):
        for j in range(i+1, len(nums)):
            if(e+nums[j]== target):
                return [i,j]
    return []

# Using hashmap one pass


def twoSum(self, nums: List[int], target: int) -> List[int]:
      numMap ={}
      
      for i, num in enumerate(nums):
          diff = target -num
          if diff in numMap:
              return [ numMap[diff],i]
          numMap[num] =i




# Using hashmap two pass

def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for i in range(len(nums)):
            hashmap[nums[i]] = i
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in hashmap and hashmap[complement] != i:
                return [i, hashmap[complement]] 
                