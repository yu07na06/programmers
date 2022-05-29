# 2021 카카오 채용연계형 인턴십
# 숫자 문자열과 영단어

numDic = {'zero': '0', 'one': '1', 'two': '2', 'three': '3', 'four': '4', 'five': '5', 'six': '6', 'seven': '7', 'eight': '8', 'nine': '9'}

def solution(s):
  answer = s
  for key, value in numDic.items():
      answer = answer.replace(key, value)
  return int(answer)

# numDic = {'zero': '0', 'one': '1', 'two': '2', 'three': '3', 'four': '4', 'five': '5', 'six': '6', 'seven': '7', 'eight': '8', 'nine': '9'}
# s = 'one4seveneight'
# strList = list(s)
# temp = ''
# answer = ''
# for i in strList:
#   if i.isdigit():
#     if temp=='':
#       answer += i
#     else:
#       answer += numDic[temp] + i
#       temp=''
#   elif temp in numDic:
#     answer += numDic[temp]
#     temp=i
#   else:
#     temp+=i

# if temp in numDic:
#   answer += numDic[temp]
# print(answer)