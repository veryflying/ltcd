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

        p = i
        while p <= j:
            if nums[p] == 2:
                t = nums[j]
                nums[j] = 2
                nums[p] = t
                j -= 1
            elif nums[p] == 0:
                t = nums[i]
                nums[i] = 0
                nums[p] = t
                i += 1
            else:
                p += 1