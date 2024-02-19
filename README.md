# TODO LIST 

### History
- 20240129 GIT 생성
- 20240130 기본세팅
- 20240201 세팅 추가 완료/ 브랜치(nana) 생성 완

### 초기 세팅법
1. 기존 폴더 지우기
2. STS 메뉴에서 `File > Import > Git > Projects from Git (with smart import)` 선택
3. `Clone URI` 선택
4. URI 칸에 `https://github.com/nanaball/uknowtodo.git`, Authentication 칸에 User, Password 바르게 입력
5. `main` 브랜치 선택
6. Local Destination (저장할 폴더) 선택
7. 기다리면 다운로드 받아지면서 `Finish` 버튼 선택
8. 완료 후 에러 발생시 좌측 `Package Explorer`의 `uknowtodo` 폴더 우클릭
9. `Configure > Add Gradle Nature` 선택
10. 뭔가 다운받아지면서 위잉 하고 오류 없어짐
11. 잘 모르겠으면 [링크](https://powernote.tistory.com/40) 참조
12. [참고1](https://limdevbasic.tistory.com/12)
13. [참고2](https://shoney.tistory.com/entry/Spring-gradle-%EB%B9%8C%EB%93%9C-jar-%EC%8B%A4%ED%96%89%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95)

### 프로젝트 실행법
- 그냥 실행하면 다른 세팅없이 실행됨
- 서버 켜짐 성공후 http://localhost:8080/ 접속하여 메인페이지 제대로 뜨는지 확인
- `src/main/resources/templates` 폴더에 html 파일 수정하면 적용됨

### 데이터베이스 세팅
- mysql에 `create database uknowtodo` 입력
- `src/main/resources/application.yml` 파일에 `username`, `password` 를 입력
- `src/main/java/practice/project/domain/entity` 안에 있는 `User` 클래스 참조하여 sql 파일에 맞게 변수들 넣기 (`@Column` 필드 추가하기)
- 다른 테이블용 클래스도 비슷하게 생성