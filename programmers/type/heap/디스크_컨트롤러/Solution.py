import heapq

def solution(jobs):
    # 모든 요청 작업의 반환 시간 평균의 정수
    answer = 0

    # 우선순위: 소요시간이 짧은 것 > 요청시각이 빠른 것 > 작업 번호가 작은 것
    # jobs[i]: [작업 요청시각, 작업 소요시간] 형태

    # 요청큐 ㅡ 요청시각이 빠른 순으로 나오는 힙
    # [요청 시각, 작업 시간, 작업 번호]
    request_queue = []
    
    # 대기큐 ㅡ 소요시간이 짧은 순으로 나오는 힙
    # [작업 시간, 요청 시각, 작업 번호]
    work_queue = []
    
    # [0, 3, 0] < [1, 9, 1]
    for i in range(len(jobs)):
        heapq.heappush(request_queue, [jobs[i][0], jobs[i][1], i])

    # 현재 시간
    time = 0
    
    while request_queue or work_queue:
        
        # 현재 시간까지 요청된 작업을 요청큐에서 대기큐로 이동
        while request_queue and request_queue[0][0] <= time:
            request_time, work_time, number = heapq.heappop(request_queue)
            heapq.heappush(work_queue, [work_time, request_time, number])
        
        # 대기 중인 작업이 없으면 다음 작업의 요청 시간으로 이동
        if not work_queue:
            time = request_queue[0][0]
            continue
        
        # 우선순위가 가장 높은 작업 선택
        job = heapq.heappop(work_queue)
        
        # 작업 수행
        time += job[0]
        
        # 반환 시간
        answer += time - job[1]
    
    return answer // len(jobs)