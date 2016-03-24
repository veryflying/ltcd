class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        i = 0
        j = len(nums) - 1
        while i <= j:
            if nums[i] == 0:
                i += 1
            else:
                break
        while i <= j:
            if nums[j] == 2:
                j -= 1
            else:
                break
        p = i+1
        while p <= j:
            if nums[p] == 2:
                nums[j] = 2
                nums[p] = 1
                j -= 1
                p += 1
            elif nums[p] == 0:
                nums[i] = 1
                nums[p] = 1
                i += 1
                p += 1
            else:
                p += 1