# [ Service 위임, 책임 분리에 대한 실습 ] 

## API Layer 와 Domain Layer 의 service 책임 분리

### [요건]  

- REST API 를 통해서 주식 정보를 불러온다.
- 주식이라는 도메인이 존재. (Stock)
- (주식은 시작가와 종가가 있다.)
- 주식은 현재가가 있어 실시간으로 업데이트 해와야 한다. -> Redis
- 현재가와 시작가를 비교해서 등락율을 구해야 한다. -> Logic


Controller (B')
Presentation Layer Service (A -> B') - manufacture
----------------------- Service 간의 전송객체
Domain Layer Service (A) - deliver
Repository (A)


Controller
Service - deliver & manufacture -> 가져오고 나서 변환 -> test 어려움 -> 완성도있는 프로덕트가 안나옴
Repository


## [TIP]

1. 함수가 가져야할 책임? - 스멜이 나는 코드인가? 너무 많은 역할과 책임이 있는게 아닌가?  
2. 그렇다면 이 함수가 몰라도 되는 것은 무엇인가?
3. 몰라도 된다면 다른 서비스에 넘겨보자  
4. 넘겼는데 모양이 개선이 안되는 느낌이다. 혹은 스코드가 깨진다.
5. 서비스간에 메세지를 주고받을 중간객체를 만들어보자.




