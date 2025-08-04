# 한국산업기술진흥협회 복지몰 SSO 연동

## 프로젝트 개요
한국산업기술진흥협회 복지몰 SSO(Single Sign-On) 로그인 기능을 구현하기 위한 Spring Boot 애플리케이션입니다.
## SSO 연동 정보
- **SSO 제공업체**: 현대이지웰
- **연동 방식**: AES256 암호화를 통한 토큰 기반 인증
- **암호화 알고리즘**: AES256 CBC 모드 (PKCS5Padding)

## 기술 스택
- **언어**: Kotlin
- **프레임워크**: Spring Boot
- **암호화**: AES256-CBC

## 환경 설정
`application.yml` 또는 `application.properties`에 다음 설정을 추가해야 합니다:

```yaml
hyundaiezwel:
 base-url: [현대이지웰 제공 URL]
 client-info: [클라이언트 정보]
 sso-key: [SSO 키]
 KEY: [AES 암호화 키 - 32바이트]
 IV: [AES 초기화 벡터 - 16바이트]