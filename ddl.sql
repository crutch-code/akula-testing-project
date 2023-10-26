create table "user"
(
    id       bigserial
        primary key,
    "1c_id"  text,
    fio      text not null,
    login    text not null,
    password text not null,
    boss     bigint
        constraint user_user_id_fk
            references "user"
);

comment on table "user" is 'Пользователь';
comment on column "user"."1c_id" is '1С ID';
comment on column "user".fio is 'ФИО';
comment on column "user".login is 'Логин';
comment on column "user".password is 'Пароль';
comment on column "user".boss is 'Начальник';

create table news
(
    id           bigserial,
    title        varchar(255)               not null,
    content      varchar(255)               not null,
    publish_date timestamp(6) default now() not null,
    author       bigint                     not null
        constraint news_user_fk
            references "user"
);

comment on table news is 'Новости';
comment on column news.title is 'Заголовок';
comment on column news.content is 'Содержимое';
comment on column news.publish_date is 'Дата публикации';
comment on column news.author is 'Автор';

create table course
(
    id   bigserial
        primary key,
    name text not null
);

comment on table course is 'Курс';

create table lesson
(
    id          bigserial
        primary key,
    name        text    not null,
    content     text    not null,
    description text,
    index       integer not null,
    cid         bigint  not null
        constraint lesson_course_fk
            references course
);

comment on table lesson is 'Урок';
comment on column lesson.name is 'Название';
comment on column lesson.content is 'Содержание';
comment on column lesson.description is 'Описание';
comment on column lesson.index is 'Порядковый номер';
comment on column lesson.cid is 'ID курса';

create table test
(
    id       bigserial
        primary key,
    theme    text    not null,
    min_ball integer not null,
    lid      bigint  not null
        constraint test_lesson_fk
            references lesson
);

comment on table test is 'Тест';
comment on column test.theme is 'Тема';
comment on column test.min_ball is 'Проходной балл';
comment on column test.lid is 'ID урока';

create table question
(
    id     bigserial
        primary key,
    title  text              not null,
    type   integer default 0 not null,
    points integer default 0 not null,
    tid    bigint            not null
        constraint question_test_fk
            references test
);

comment on table question is 'Вопрос';
comment on column question.title is 'Текст вопроса';
comment on column question.type is 'Тип вопроса (одиноч., множ., соотв.)';
comment on column question.points is 'Балл';
comment on column question.tid is 'ID теста';

create table answer
(
    id      bigserial
        primary key,
    content text                  not null,
    correct boolean default false not null,
    qid     bigint                not null
        constraint answer_question_fk
            references question
);

comment on table answer is 'Вариант ответа';
comment on column answer.content is 'Текст ответа';
comment on column answer.correct is 'Правильный';
comment on column answer.qid is 'ID вопроса';

create table user_test
(
    id     bigserial not null
        constraint test_result_pkey
            primary key,
    uid    bigint                                                 not null
        constraint test_result_user_fk
            references "user",
    tid    bigint                                                 not null
        constraint test_result_test_fk
            references test,
    points integer                                                not null,
    constraint user_test_pk
        unique (uid, tid)
);

comment on table user_test is 'Результаты теста';
comment on column user_test.uid is 'ID пользователя';
comment on column user_test.tid is 'ID теста';
comment on column user_test.points is 'Набранный балл';

create table user_lesson
(
    id     bigserial
        primary key,
    uid    bigint            not null
        constraint user_lesson_user_fk
            references "user",
    lid    bigint            not null
        constraint user_lesson_lesson_fk
            references lesson,
    status integer default 0 not null,
    constraint user_lesson_pk
        unique (uid, lid)
);

comment on table user_lesson is 'Обучается';
comment on column user_lesson.uid is 'ID пользователя';
comment on column user_lesson.lid is 'ID урока';
comment on column user_lesson.status is 'Статус обучения уроку';

create table user_course
(
    id  bigserial
        primary key,
    uid bigint not null
        constraint user_course_user_fk
            references "user",
    cid bigint not null
        constraint user_course_course_fk
            references course,
    constraint user_course_pk
        unique (uid, cid)
);

comment on table user_course is 'Записан';
comment on column user_course.uid is 'ID пользователя';
comment on column user_course.cid is 'ID курса';

create table option
(
    id      bigserial
        primary key,
    content text                 not null,
    is_left boolean default true not null
);

comment on table option is 'Варинт сопоставления';
comment on column option.content is 'Содержимое';
comment on column option.is_left is 'Является левым';

create table comparison
(
    id  bigserial
        primary key,
    lid bigint not null
        constraint comparison_left_option_fk
            references option,
    rid bigint not null
        constraint comparison_right_option_fk
            references option,
    qid bigint not null
        constraint comparison_question_fk
            references question
);

comment on table comparison is 'Сопоставление';
comment on column comparison.lid is 'ID левого варианта';
comment on column comparison.rid is 'ID правого варианта';
comment on column comparison.qid is 'ID вопроса';

create table storage
(
    id bigserial primary key,
    name text  not null,
    data bytea not null,
    file_path text
);
comment on table storage is 'Хранилище';
comment on column storage.name is 'Имя файла';
comment on column storage.data is 'Содержимое';
comment on column storage.file_path is 'Путь к файлу';
