class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        c = 1
        tc = 1
        for i in xrange(1, len(nums)):
            if nums[i] == nums[i-1]:
                tc += 1
                if tc <= 2:
                    c += 1
            else:
                tc = 1
                c += 1
        return c