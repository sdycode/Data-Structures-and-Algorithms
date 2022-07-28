# https://leetcode.com/problems/two-sum/

# brut force
def twoSum(self, nums: List[int], target: int):
    
    self.nums=nums
    for i,e in enumerate(nums):
        for j in range(i+1, len(nums)):
            if(e+nums[j]== target):
                return [i,j]
    return []

# Using hashmap


def twoSum(self, nums: List[int], target: int) -> List[int]:
      numMap ={}
      
      for i, num in enumerate(nums):
          diff = target -num
          if diff in numMap:
              return [ numMap[diff],i]
          numMap[num] =i