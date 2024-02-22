-- 회원 정보
CREATE TABLE members(
	memberNo BIGINT PRIMARY KEY auto_increment,	-- 회원번호
    id VARCHAR(50) NOT NULL,					-- 회원아이디
    password VARCHAR(200) NOT NULL,				-- 회원 비밀번호
    writer VARCHAR(50) NOT NULL,				-- 회원 이름
    regdate DATETIME NOT NULL default now()	-- 가입 시간
);

-- 할일 목록
CREATE TABLE todo(
	todoNo BIGINT PRIMARY KEY auto_increment,		-- 할일 번호
	memberNo BIGINT,								-- 회원 번호(외래키)
    todoName VARCHAR(200) NOT NULL, 			-- 할일 목록
    todoContent TEXT,							-- 할일 상세내용
    completed BOOLEAN NOT NULL DEFAULT 0,				-- 완료여부(미완료시 0) 
    createdDate DATETIME NOT NULL default now(),-- 글 등록시간
    todoDate DATETIME,							-- 마감시간
    updateDate DATETIME NOT NULL,				-- 수정시간
    FOREIGN KEY (memberNo) REFERENCES members(memberNo)
);