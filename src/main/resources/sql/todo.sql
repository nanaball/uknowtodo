DROP TABLE IF EXISTS members;

-- 회원 정보
CREATE TABLE members (
    memberNo    BIGINT PRIMARY KEY auto_increment,  -- 회원번호
    id          VARCHAR(50)  NOT NULL,              -- 회원아이디
    password    VARCHAR(200) NOT NULL,              -- 회원 비밀번호
    name        VARCHAR(50)  NOT NULL,              -- 회원 이름
    createdDate DATETIME     NOT NULL default now() -- 가입 시간
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
CREATE INDEX member_id_idx ON members (id);
CREATE INDEX member_no_idx ON members (memberNo);

DROP TABLE IF EXISTS todos;

-- 할일 목록
CREATE TABLE todos (
    todoNo      BIGINT PRIMARY KEY auto_increment,  -- 할일 번호
    memberNo    BIGINT,                             -- 회원 번호(외래키)
    todoName    VARCHAR(200) NOT NULL,              -- 할일 목록
    todoContent TEXT,                               -- 할일 상세내용
    category    VARCHAR(20),                        -- 할일 카테고리
    completed   BOOLEAN      NOT NULL DEFAULT 0,    -- 완료여부(미완료시 0)
    deleted     BOOLEAN      NOT NULL DEFAULT 0,    -- 삭제여부(디폴트 0)
    todoDate    DATETIME,                           -- 마감시간
    createdDate DATETIME     NOT NULL default now(),-- 글 등록시간
    updatedDate  DATETIME     NOT NULL default now(),-- 수정시간
    FOREIGN KEY (memberNo) REFERENCES members (memberNo)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
CREATE INDEX todo_member_idx ON todos (memberNo);
CREATE INDEX todo_category_idx ON todos (memberNo, category);
CREATE INDEX todo_date_idx ON todos (memberNo, updatedDate);