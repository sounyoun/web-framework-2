# Spring Boot + Spring Security 기반 상품 관리

## 주요 기능
1. 사용자 인증
   - 회원가입
   - 로그인 및 로그아웃 기능 (Spring Security)
   - 비밀번호 암호화 (BCryptPasswordEncoder)
   - 로그인 성공 시 상품 목록으로 리다이렉트
3. 권한 기반 인가
   - 관리자 계정 등록
   - 관리자 계정 로그인 시 -> 상품 등록, 수정, 삭제 기능
   - 일반 계정 로그인 시 -> 상품 목록 조회만 가능
5. 추가 기능
   - 상품 등록/수정 시 유효성 검사 (@Min으로 가격 0이상)
   - 로그인 후 환영 메시지
   - 관리자 사용자만 접근 가능한 전체 사용자 리스트

## 기술 스택
- Backend: Spring Boot 3, Spring Data JPA, Spring Security
- Frontend: Thymeleaf
- Database: MySQL
