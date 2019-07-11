# -*- coding: utf-8 -*-
import re
import urllib.request

from bs4 import BeautifulSoup

from flask import Flask
from slack import WebClient
from slackeventsapi import SlackEventAdapter


SLACK_TOKEN = ""
SLACK_SIGNING_SECRET = ""


app = Flask(__name__)
# /listening 으로 슬랙 이벤트를 받습니다.
slack_events_adaptor = SlackEventAdapter(SLACK_SIGNING_SECRET, "/listening", app)
slack_web_client = WebClient(token=SLACK_TOKEN)





# 크롤링 함수 구현하기
def _crawl_portal_keywords(text):
    # url_match = re.search(r'<(http.*?)(\|.*?)?>', text)
    # if not url_match:
    #     return '올바른 URL을 입력해주세요.'
    if "벅스" in text or "차트" in text:
        # 여기에 함수를 구현해봅시다.
        keywords = []
        url = "https://music.bugs.co.kr/chart"
        # URL 주소에 있는 HTML 코드를 soup에 저장합니다.
        source_code = urllib.request.urlopen(url).read()
        soup = BeautifulSoup(source_code, "html.parser")

        for bugs in soup.find_all("tbody"):
            for idx, t in enumerate(bugs.find_all("p", class_="title")):
                keywords.append(str(idx+1)+"위 : "+t.get_text().strip())
        idx = 0
        for bugs in soup.find_all("p", class_="artist"):
            for t in bugs.find_all("a"):
                if "javascript"in t['href']:
                    continue
                keywords[idx] = keywords[idx] + " / " + t.get_text().strip()
                idx += 1


        temp_txt = text[12:]
        print(temp_txt)
        i = int(re.findall('\d+', temp_txt)[0])
        temp = []

        if i >= 1:
            temp = keywords[:i]
            return '\n'.join(temp)
        else:
            return '\n'.join(keywords)
    else:
        return "모르는 명령어 입니다. 오로지 '벅스'와 '차트'만 알아듣습니다."


# 챗봇이 멘션을 받았을 경우
@slack_events_adaptor.on("app_mention")
def app_mentioned(event_data):
    channel = event_data["event"]["channel"]
    text = event_data["event"]["text"]

    if "등" in text and "운동" in text or "스트레칭" in text:
        keywords="https://youtu.be/CWTgMIufGTw"
    else:
        keywords = _crawl_portal_keywords(text)
    slack_web_client.chat_postMessage(
        channel=channel,
        text=keywords
    )



# / 로 접속하면 서버가 준비되었다고 알려줍니다.
@app.route("/", methods=["GET"])
def index():
    return "<h1>Server is ready.</h1>"


if __name__ == '__main__':
    app.run('0.0.0.0', port=5001)
