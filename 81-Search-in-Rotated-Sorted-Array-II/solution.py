class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        i, j = 0, len(nums)-1
        while i <= j:
            m = (i + j)/2
            if nums[m] == target:
                return True
            elif nums[m] > target:
                if target >= nums[i]:
                    j = m - 1
                else:
                    if nums[m] >= nums[i]:
                        i = m + 1
                    else:
                        j = m - 1
            else:
                if nums[m] >= nums[i]:
                    i = m + 1
                else:
                    if target >= nums[i]:
                        j = m - 1
                    else:
                        i = m + 1
        return False