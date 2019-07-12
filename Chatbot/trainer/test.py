

# def rmtxt(filename, food_name):
#     temp = []
#     with open(filename, 'rt', encoding='UTF8') as file:

#         food = ''
#         kal = 0
#         for i in file:
#             food = i.strip().split(',')[0].strip()
#             try:
#                 kal = int(round(float((i.strip().split(',')[1].strip()))))
#             except ValueError:
#                 try:
#                     kal = int(round(float((i.strip().split(',')[2].strip()))))
#                 except ValueError:
#                     try:
#                         kal = int(round(float((i.strip().split(',')[3].strip()))))
#                     except ValueError:
#                         kal = int(round(float((i.strip().split(',')[4].strip()))))

#             temp.append((food, kal))

#     # indexes = []
#     # for match in filter(lambda 1D_list: food_name in temp, b_list[0]):
#     #     indexes.append(b_list[0].index(match))
    
#     print(temp)
#     # print(food_name + "의 칼로리는" + temp[0].index(food_name))
    
# rmtxt("food ver2.txt", "요거트")


# def findFood(food_name):
#     with open("food5.csv", 'rt', encoding='UTF8') as file:
#         kal = 0
#         for i in file:
#             if food_name == i.split(',')[0].strip():
#                 kal = float(i.split(',')[1].strip())
#         if kal == 0:
#             print(food_name + "에 대한 칼로리 정보가 없습니다.")
#             return
#     with open("user.txt", "a+") as userfile:
#         data = food_name + "/" + str(kal)
#         userfile.write(data)

#     print(food_name + "의 칼로리는 " + str(kal) + " 입니다.")

# findFood("초콜릿")

# import random
# temp = ["a","b","c","d","e","f","g"]
# print(temp[random.randrange(0,7)])

import os

temp = os.getcwd()

with open('C:/Users/student/Documents/ssafy/Daily_commit/Chatbot/trainer/db/user.txt', 'r') as file:
    for i in file:
        print(i)