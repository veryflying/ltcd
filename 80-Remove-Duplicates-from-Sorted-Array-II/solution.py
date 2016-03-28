class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        c = 0
        i = 0
        n = len(nums)
        while i < n - 1:
            if nums[i] == nums[i+1]:
                if c >= 1:
                    nums.remove(nums[i])
                    n -= 1
                else:
                    c += 1
                    i += 1
            else:
                c = 0
                i += 1
        return len(nums)