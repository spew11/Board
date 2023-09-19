# Mini Board
![게시판2](https://github.com/spew11/Board/assets/95565246/79d2f177-c8b7-4a15-8982-f5b4667a212e)
간단한 커뮤니티 게시판 입니다.

## Table of Contents
- [Mini Board](#mini-board)
- [WHY I BUILT THIS](#why-i-built-this)
- [Feature](#feature)
- [Technologies Used](#technologies-used)
  - [Programming Language](#programming-language)
  - [Front-End](#front-end)
  - [Back-End](#back-end)
  - [Database](#database)
- [Design](#design)
  - [Diagrams](#diagrams)
    - [Entity Relationship Diagram](#entity-relationship-diagram)
    - [Entity Diagram](#entity-diagram)
    - [Service Diagrams](#service-diagrams)
    - [Repository Diagrams](#repository-diagrams)
- [Screenshots](#screenshots)
  - [board1](#board1)
  - [board2](#board2)
  - [notice1](#notice1)
  - [notice2](#notice2)
- [Review](#review)

## WHY I BUILT THIS
웹 개발 초심자로서 독학으로 개발 지식 및 기술을 직접 프로젝트에 접목해보기 위해서,  
다른 컨텐츠에 비해서 비교적 작은 규모의 프로젝트인 게시판을 선택하게 되었습니다.  
회원 관리, 게시글 관리, 댓글 관리 세 가지 핵심 기능을 선택하여 구현하였습니다.

## Feature
- 회원관리 (회원가입 및 로그인)
- 게시글 관리 (CRUD 기능)
- 댓글 관리 (CRUD 기능)

## Technologies Used
### Programming Language
- JAVA 11
- JavaScript
### Front-End
백엔드에 집중하고자 프론트엔드는 최신 프레임워크를 사용하지않고 vanilaJS만으로 모든걸 해결였습니다.  
- HTML
- CSS
### Back-End
- SPring Boot 2.7.11
- spring Web
- Thymeleaf
- Spring Data JPA
- MariaDB Driver
- Spring security
- Lombok
### Database
- MariaDB 11.1.0
## Design
### Diagrams
#### Entity RelationShip Diagram
![boardERD](https://github.com/spew11/Board/assets/95565246/ec1dd78e-9dde-409e-8776-4710c910ef03)
#### Entity diagram
![스크린샷 2023-09-19 오후 11 44 21](https://github.com/spew11/Board/assets/95565246/eb76b7a1-ad2a-4789-bbc5-ed8f41c3aae2)
#### Service digrams
![스크린샷 2023-09-20 오전 1 07 27](https://github.com/spew11/Board/assets/95565246/1a088e75-e8b4-45e0-a212-c49207dd44c9)
#### Repository diagrams
![스크린샷 2023-09-20 오전 1 04 07](https://github.com/spew11/Board/assets/95565246/968c89db-b3a1-42c3-a40a-d805756812c5)
## Screenshots
#### board1
![게시판1](https://github.com/spew11/Board/assets/95565246/246b7248-1703-4661-9e50-7de29c52a469)
#### board2
![게시판2](https://github.com/spew11/Board/assets/95565246/216abe1c-9e4e-4d68-8de4-2b149382e4b1)
#### notice1
![게시글1](https://github.com/spew11/Board/assets/95565246/d60eb445-ca12-46fd-8dab-486e18d50fa5)
#### notice2
![댓글](https://github.com/spew11/Board/assets/95565246/d1299eb7-780a-4e0d-bc27-a0c74dc94a48)

## Review
웹 개발을 하면서 필요한 지식이나 기술이 생길 때마다 직접 서적이나 강의를 참고하면서 부딪히면서 만든 프로젝트라서 그런지   
더욱 웹 개발의 전체적인 틀을 몸소 이해하게 되었습니다. 데이터베이스 강의를 듣고 DB설계를 해본 것도 좋은 경험이었습니다.  
과제를 하면서 자바, JPA에서 제공하는 다양한 어노테이션의 기능과 동작원리를 배울 수 있었고,  
PK로 autoincrement, DTO클래스, MVC패턴 등을 사용하는 이유를 스스로 유추하고 깨닫는 계기가 되었습니다.  
게시판에 추가해야할 기능이 많은데, 앞으로 차차 업데이트할 생각입니다.
