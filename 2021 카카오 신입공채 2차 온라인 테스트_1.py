import requests
import json

BASE_URL="https://kox947ka1a.execute-api.ap-northeast-2.amazonaws.com/prod/users/"

start_API=requests.post(BASE_URL+"start?problem=1", headers={"X-Auth-Token":"db71970d401b0e5f225cd1b41d4a50cc"})
print(start_API.json())
print()

auth_key=start_API.json()['auth_key']

locations_API=requests.get(BASE_URL+"locations", headers={"Authorization":auth_key})
print(locations_API.json())
print()

trucks_API=requests.get(BASE_URL+"trucks", headers={"Authorization":auth_key})
print(trucks_API.json())
print()

"""
0: 6초간 아무것도 하지 않음
1: 위로 한 칸 이동
2: 오른쪽으로 한 칸 이동
3: 아래로 한 칸 이동
4: 왼쪽으로 한 칸 이동
5: 자전거 상차
6: 자전거 하차
"""
simulate_API=requests.put(BASE_URL+"simulate", headers={"Authorization":auth_key}, json={"commands":[{"truck_id":0, "command":[2,5,1,3,6]}]})
print(simulate_API.json())
print()

score_API = requests.get(BASE_URL+'score', headers={'Authorization': auth_key})
print(score_API.json())
print()

file="C:/Users/박유나\Desktop\test.txt"
f = open(file, 'r')

f.close()

"""
dx, dy = [0, 0, -1, 1], [1, -1, 0, 0]
def BFS(x, y):
    q=deque()
    q.append((x, y))
    
    while q:
        X, Y = q.popleft()
        for i, j in zip(dx, dy):
            nx, ny=X+i, Y+j
            if nx<0 or nx>=N or ny<0 or ny>=N: continue # 범위 확인
            if visited[nx][ny]==1: continue # 방문 여부 확인
            q.append((nx, ny)) # 큐에 넣기
            visitied[nx][ny]=1 # 방문 표기
"""