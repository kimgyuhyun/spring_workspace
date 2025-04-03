-- 첫 번째 데이터 등록
INSERT INTO todos (todo, detail, created_at, updated_at)
VALUES
('쇼핑', '마트에서 식재료 구입하기', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
-- 두 번째 데이터 등록
INSERT INTO todos (todo, detail, created_at, updated_at)
VALUES
('도서관에 가기', '책 빌리기', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
-- 세 번째 데이터 등록
INSERT INTO todos (todo, detail, created_at, updated_at)
VALUES
('헬스장 가기', '운동하기', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 인증 테이블에 더미 데이터를 추가
-- password: adminpass
INSERT INTO authentications (username, password, authority) VALUES
('admin', '$2a$10$MSm5rYNjEKF3iTKL3z.klufpmo5.FTFtD3rPgL79vXDTPfAAzDlhm', 'ADMIN');
-- password: userpass
    INSERT INTO authentications (username, password, authority) VALUES
    ('user', '$2a$10$eQTUaTY/5LBrp5FpSrnKLO9FgbKcJF1edLyZuLxPtn2ehx25C8gu2', 'USER');