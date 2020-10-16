create table task
(
    id int identity primary key,
    body varchar(2000) not null,
    [state] tinyint not null,
    created datetime2 default getdate()
);

insert into task (body, state)
    values ('吃早餐', 1),
           ('玩游戏', 1),
           ('上厕所', 2),
           ('谈恋爱', 8);