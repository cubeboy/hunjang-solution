# hunjang-solution
Chat GPT 를 이용한 영어학습 프로그램

- 앱의 목표: 시간이 부족한 직장인이 출퇴근 시간을 이용해서 간단하고 재미있게 영어 학습을 할 수 있도록 하는 것
- 타겟 유저: 초급~중급 수준의 영어 학습자이면서 시간이 부족한 직장인
- 핵심 가치: 유명한 소설이나 영화, 게임의 지문을 영어로 제시하고 사용자가 선택한 문장을 해석해서 표현하는 것
- 차별점: 사용자의 관심사와 취향에 맞는 지문을 추천하고, 번역 결과뿐만 아니라 문장 구조와 문화적 배경에 대한 설명도 제공하는 것
- 주요 기능:
  - 지문 추천: 사용자가 처음 앱을 실행할 때 관심사와 취향에 대한 설문을 하고, 그에 따라 적절한 소설이나 영화, 게임의 지문을 영어로 추천해준다. 사용자는 원하는 지문을 선택하거나 다른 지문을 요청할 수 있다.
  - 선택문장 번역: 사용자가 지문에서 원하는 문장을 선택하면, 그 문장을 한국어로 번역해준다. 번역 결과는 단순한 단어 대응이 아니라 문장 구조와 의미를 고려한 자연스러운 표현이다. 또한, 문장에 특별한 문화적 배경이나 의미가 있으면 그에 대한 설명도 함께 제공한다.
  - 모르는 단어 설명: 사용자가 지문에서 모르는 단어를 선택하면, 그 단어에 대한 자세한 설명을 제공한다. 설명에는 단어의 발음, 뜻, 예문, 유의어, 반의어 등이 포함된다.

- 서브 기능:
  - 즐겨찾기: 사용자가 좋아하는 지문이나 단어를 즐겨찾기에 추가할 수 있다. 즐겨찾기에 추가된 지문이나 단어는 언제든지 다시 볼 수 있다.
  - 복습: 사용자가 학습한 지문이나 단어를 정기적으로 복습할 수 있도록 알림을 보낸다. 복습 시에는 지문이나 단어를 랜덤하게 섞어서 제시하고, 사용자가 해석하거나 설명하도록 한다.
  - 설정: 사용자가 앱의 화면 밝기, 폰트 크기, 알림 주기 등을 설정할 수 있다.

실행전 참고사항 : 실행 하기 전에 backend 프로젝트 폴더 루트에 .env 파일을 만들고 (./hunjang/.env)
```
api-key=<apikey>
```
항목을 추가 해야 합니다.

1. [요구사항 정의](./documents/requirements.md)
1. [Initialize Front End](./documents/scafold.md)