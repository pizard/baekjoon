def binary_search(target, data, sort = False):
    if not sort:
        data.sort()
    start = 0
    end = len(data) - 1

    while start <= end:
        mid = (start + end) // 2

        if data[mid] == target:
            return mid # 함수를 끝내버린다.
        elif data[mid] < target:
            start = mid + 1
        else:
            end = mid -1


    # 무조건 더 큰 값을 출력
    # while data[mid] < target:
    #     mid += 1

    return mid


