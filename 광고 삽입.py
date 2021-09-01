"""
동영상 재생시간 길이 : play time
공익광고의 재생시간 길이 : adv_tiem
시청자들이 재생했던 구간 정보 : logs
"""

def solution(play_time, adv_time, logs):
    
    """ 1. 시,분,초 단위를 초로 바꾸기 """
    H, M, S = map(int, play_time.split(":"))
    pt=H*3600+M*60+S #동영상 재생시간 초로 바꿈
    H, M, S = map(int, adv_time.split(":"))
    at=H*3600+M*60+S #공익광고 재생시간 초로 바꿈
    
    L_log=[] #시청자들 재생 구간을 담을 리스트
    for log in logs:
        sH, sM, sS, eH, eM, eS = map(int, log.replace("-",":").split(":"))
        L_log.append((sH*3600+sM*60+sS, eH*3600+eM*60+eS)) #시청자들 재생 구간 초로 바꿈
    
    
    """ 2. 조건 """
    answer=21387601
    gap=0
    for si, ei in L_log: #이건 시간 초과되는 풀이(5^n)
        for sj, ej in L_log:
            if si==sj and ei==ej: continue #같은 시간은 확인하지 않음
            if si+at>pt: continue #시작 시각에 광고 시간을 합쳤을때, 최종 동영상 길이를 넘어설 경우
            if si<=sj and ej<=ei: #si<sj---ej<ei 인 경우(합집합인 경우)
                if gap<=ej-sj:
                    if answer>sj:
                        answer=sj #가장 작은 시작 시간
                        gap=ej-sj #겹치는 부분 정도
            if si<=sj and sj<=ei and ej>=ei: #si<sj--(ei)--ej 인 경우(교집합인 경우)
                if gap<=ei-sj:
                    if answer>si:
                        answer=si #가장 작은 시작 시간
                        gap=ei-sj #겹치는 부분 정도
                    
    if pt==at or answer==21387601: #동영상 길이와 광고 길이가 같다면,
        print("00:00:00")
    
    
    """ 3. 초 시간을 시,분,초로 바꾸기 """
    s=int(answer%60)
    answer=int(answer/60)
    m=(answer%60)
    h=int(answer/60)
    print(str(h).zfill(2)+":"+str(m).zfill(2)+":"+str(s).zfill(2))

"""
a="99:59:59"
b="25:00:00"
c=["69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"]
"""

a="02:03:55"
b="00:14:15"
c=["01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"]

solution(a,b,c)