## 알바 대타 구인/구직 홈페이지 프로젝트



### 1 . 개발환경

#### Front-End

* Bootstrap 4

* JavaScript

  

#### Back-End

* Spring  5.0.2.RELEASE

* JDK 1.8 

* Tomcat 9.0

* Mybatis 3.4.1

* Maven 2.9

  

#### 협업도구

* Github
* Slack

------------------------------------------------------------------------------------------







### 2. 설계

#### 데이터베이스 모델링

	* 화원 정보를 담고 있는 mem_info 테이블의 mem_userid 를 외래키로 설정하고 게시판 테이블과 게시판 리뷰 테이블과의 관계를 설계했습니다. 

![image-20200331192913300](https://github.com/k1msu2/img4md/blob/master/image-20200331192913300.png?raw=true)

#### 패키지 구조

![image-20200331204114468](https://github.com/k1msu2/img4md/blob/master/image-20200331204114468.png?raw=true)



#### Front-End![image-20200331213232474](https://github.com/k1msu2/img4md/blob/master/image-20200331213232474.png?raw=true)



* URL 을 요청하면 매핑된 컨트롤러를 호출하여 최종적으로 화면에 렌더링 될 jsp 파일 명을 리턴해주면 웹페이지가 호출됩니다.
* 왼쪽은 카드형식으로 게시판이 출력되며 오른쪽은 구직 게시판 테이블에서 구직희망지역을 지도에 마킹하도록 하였습니다. 
* 구직게시판의 UI는 부트스트랩 테마를 적용하였고, 지도 출력은 **Leaflet open source** 를 사용하였습니다.
* 더보기 버튼을 클릭시, 상세페이지로 넘어가 등록된 유저의 사진과 기타 상세 내역을 볼수있습니다. 
* 로그인을 하지 않으면 댓글을 달지 못하도록 **인터셉터** 기능을 추가하였습니다. 
* 로그인 후, 유저의 권한(사장 or 알바)에 따라 게시판 글쓰기와 댓글 쓰기가 제한되도록 **인터셉터** 기능을 추가하였습니다. 
* 댓글은 **Ajax** 를 사용하여 클라이언트에서 서버로 요청을 보내고, Success 응답이 오면 해당 섹션에 페이지가 렌더링이 되게 하였습니다. 





#### Back-End![image-20200331215557053](https://github.com/k1msu2/img4md/blob/master/image-20200331215557053.png?raw=true)



##### 1. 사용자 글 등록

* 사용자가 글 등록 요청을 하면 매핑된 컨트롤러를 실행하게 되고 해당 컨트롤러는 DAO를 호출하고 DAO는 **Mybatis** 설정을 이용해서 SQL 쿼리를 전송하여 **Oracle** 데이터 베이스에 글을 등록합니다.

  ![image-20200331225630107](https://github.com/k1msu2/img4md/blob/master/image-20200331225630107.png?raw=true)

##### 2. FTP 서버로 회원 사진 전송 및 다운로드

* 회원 사진을 백업하는 용도로 사용하기 위하여 FTP서버를 구축하였습니다.
* **servlet-context.xml config** 파일에 FTPService **Bean** 을 등록하여 Controller에서 자동 주입하여 사용합니다.
* 회원 가입시, 회원 가입 페이지에서 본인의 사진을 업로드 하면 웹서버와 FTP 서버에도 저장합니다.
* 웹페이지에서 렌더링되는 회원 사진은 웹서버 내의 Resources 폴더 내에 존재합니다.
* FTP 서버로는 파일질라를 사용하였으며, Port 21, 22 을 이용하여 파일 전송하는 FTP 프로토콜 서비스를 구현하였습니다. 

* 해당 서버를 사용하기 위하여 아파치에서 지원하는 **Commons Net(FTPClient)** 를 Maven 리포지토리로부터 다운받아 사용하였습니다.

![image-20200331230059748](https://github.com/k1msu2/img4md/blob/master/image-20200331230059748.png?raw=true)



##### **3. Interceptor**

* 유저의 접근 권한을 제한하기 위해서 Filter 와 Inteceptor 중 어떤 것을 사용할지 고민해봤습니다.

* Filter는 사용자가 어떤 URL 을 요청시 무조건 실행되는 Dispatch servlet 이 실행되기 직전에 실행되는 것으로 각각의 URL 마다의 제어 권한을 처리할 수 없다고 판단하였습니다. 

* Interceptor 기능은 Interceptor  태그를 사용하여 사용자요청 컨트롤러를 호출하기 직전에 접근 제어를 가능하게 하는 기능입니다. 

* HandlerInterceptor 인터페이스를 사용하여, 클라이언트의 요청을 컨트롤러에 전달하기 전에 호출하는preHandle 추상함수내부에 원하는 코드를 구현하였습니다. 

  

  ![image-20200331231340354](![image-20200331231340354.png](https://github.com/k1msu2/img4md/blob/master/image-20200331231340354.png?raw=true)



##### 4.  게시판 댓글 기능

* 댓글은 **Ajax** 를 사용하여 클라이언트에서 서버로 요청을 보내고, Success 응답이 오면 해당 섹션에 페이지가 렌더링이 되게 하였습니다. 
* Success 응답시 화면에 출력이 될 리스트 또한 **Ajax** 로 요청하여 출력됩니다.![image-20200331232506276](https://github.com/k1msu2/img4md/blob/master/image-20200331232506276.png?raw=true)





---------------------------------------------------------------

### 3. 개선 방향

* 페이징 부분을 구현하였으나, PagingControl class 를 따로 설계하지 않고 멤버함수로 선언하여 구현하였습니다. 

* FTP 서비스 구현도 파일 업로드와 다운로드가 필요한 부분에 직접 코드를 구현하는 방식으로 하였습니다. 

* 이 두가지 부분은 코드의 가독성을 떨어뜨리며 유지보수가 어려울 것으로 보여서 추후 코드를 수정하는 작업을 진행 할 예정입니다. 

  
