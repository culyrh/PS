import heapq

def solution(operations):
    # operations
    # ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]

    # [들어온 값, 들어온 순서]
    min_heap = []
    max_heap = []
    
    # 각 원소의 삭제 여부 (boolean 리스트)
    deleted = [False] * len(operations)
    
    for i, operation in enumerate(operations):
        command, value = operation.split()
        value = int(value)

        # "I 숫자" 삽입
        if command == "I":
            heapq.heappush(min_heap, (value, i))
            heapq.heappush(max_heap, (-value, i))
        
        elif command == "D":
            if value == 1:  # D 1 최댓값 삭제 
                while max_heap and deleted[max_heap[0][1]]:
                    heapq.heappop(max_heap)
                
                if max_heap:
                    _, index = heapq.heappop(max_heap)
                    deleted[index] = True
            
            else:  # D -1 최솟값 삭제
                while min_heap and deleted[min_heap[0][1]]:
                    heapq.heappop(min_heap)
                
                if min_heap:
                    _, index = heapq.heappop(min_heap)
                    deleted[index] = True
    
    # 이미 삭제된 값들을 각각의 힙에서 제거
    while min_heap and deleted[min_heap[0][1]]:
        heapq.heappop(min_heap)
        
    while max_heap and deleted[max_heap[0][1]]:
        heapq.heappop(max_heap)
    
    if not min_heap:
        return [0, 0]

    # [최댓값, 최솟값] return 
    return [-max_heap[0][0], min_heap[0][0]]