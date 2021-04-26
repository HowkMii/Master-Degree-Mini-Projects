def merge_sort(x):
    if len(x) <= 1:
        return x
    mid = len(x) // 2
    left, right = merge_sort(x[:mid]), merge_sort(x[mid:])
    return merge(left, right, x.copy())


def merge(left, right, merged):

    left_cursor, right_cursor = 0, 0
    while left_cursor < len(left) and right_cursor < len(right):

        # Sort each one and place into the result
        if left[left_cursor] <= right[right_cursor]:
            merged[left_cursor+right_cursor]=left[left_cursor]
            left_cursor += 1
        else:
            merged[left_cursor + right_cursor] = right[right_cursor]
            right_cursor += 1

    for left_cursor in range(left_cursor, len(left)):
        merged[left_cursor + right_cursor] = left[left_cursor]

    for right_cursor in range(right_cursor, len(right)):
        merged[left_cursor + right_cursor] = right[right_cursor]

    return merged

x = [2,0,8,3,9,4,5,4,5,5,5,7,4,8,5,2,1]

print(merge_sort(x))
