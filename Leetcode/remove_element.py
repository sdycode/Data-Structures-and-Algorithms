

class Solution:
    def removeElement(self, nums: list[int], val: int) :
            i =0
            j=1
            
            while j< len(nums):
                if nums[i]==val:
                    if nums[j] is not val:
                        nums[i]=nums[j]
                        # j +=1
                        print(i,nums[i], j)
                    
                    # print(i, j, nums)
                else:
                    i +=1
                j+=1
                    
                print(i, j, nums)
          
            return i+1



if __name__=='__main__':
    s =Solution()

    s.removeElement([0,1,2,2,3,0,4,2],2)


