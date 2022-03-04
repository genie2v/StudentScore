# StudentScore
DAO(DATA ACCESS OBJECT) : DB 실질적 접근하는 객체 / Connection 관리, 보안성
* DB를 사용해 데이터를 조작하는 기능 전담
DTO(DATA TRANSFER OBJECT) : 데이터 교환을 위한 객체 / 읽고 쓰기
* 속성과 그 속성에 접근하기 위한 getter, setter 메소드만 가진 클래스
Process : 비즈니스 로직이 들어가는 부분
* 사용자로부터 요청을 받으면 적절한 서비스를 전달하고 전달받은 서비스는 비즈니스 로직을 처리
