create table public.course
(
    id   bigserial
        primary key,
    name text not null
);
comment on table public.course is 'Курс';
create table public.lesson
(
    id          bigserial
        primary key,
    name        text    not null,
    content     text    not null,
    description text,
    index       integer not null,
    cid         bigint  not null
        constraint lesson_course_fk
            references public.course
);
comment on table public.lesson is 'Урок';
comment on column public.lesson.name is 'Название';
comment on column public.lesson.content is 'Содержание';
comment on column public.lesson.description is 'Описание';
comment on column public.lesson.index is 'Порядковый номер';
comment on column public.lesson.cid is 'ID курса';
create table public.test
(
    id       bigserial
        primary key,
    theme    text    not null,
    min_ball integer not null,
    lid      bigint  not null
        constraint test_lesson_fk
            references public.lesson
);
comment on table public.test is 'Тест';
comment on column public.test.theme is 'Тема';
comment on column public.test.min_ball is 'Проходной балл';
comment on column public.test.lid is 'ID урока';
create table public.question
(
    id     bigserial
        primary key,
    title  text              not null,
    type   integer default 0 not null,
    points integer default 0 not null,
    tid    bigint            not null
        constraint question_test_fk
            references public.test
);
comment on table public.question is 'Вопрос';
comment on column public.question.title is 'Текст вопроса';
comment on column public.question.type is 'Тип вопроса (одиноч., множ., соотв.)';
comment on column public.question.points is 'Балл';
comment on column public.question.tid is 'ID теста';
create table public.answer
(
    id      bigserial
        primary key,
    content text                  not null,
    correct boolean default false not null,
    qid     bigint                not null
        constraint answer_question_fk
            references public.question
);
comment on table public.answer is 'Вариант ответа';
comment on column public.answer.content is 'Текст ответа';
comment on column public.answer.correct is 'Правильный';
comment on column public.answer.qid is 'ID вопроса';
create table public.option
(
    id      bigserial
        primary key,
    content text                 not null,
    is_left boolean default true not null
);
comment on table public.option is 'Варинт сопоставления';
comment on column public.option.content is 'Содержимое';
comment on column public.option.is_left is 'Является левым';
create table public.comparison
(
    id  bigserial
        primary key,
    lid bigint not null
        constraint comparison_left_option_fk
            references public.option,
    rid bigint not null
        constraint comparison_right_option_fk
            references public.option,
    qid bigint not null
        constraint comparison_question_fk
            references public.question
);
comment on table public.comparison is 'Сопоставление';
comment on column public.comparison.lid is 'ID левого варианта';
comment on column public.comparison.rid is 'ID правого варианта';
comment on column public.comparison.qid is 'ID вопроса';
create table public.storage
(
    id        bigserial
        primary key,
    name      text  not null,
    data      bytea not null,
    file_path text
);
comment on table public.storage is 'Хранилище';
comment on column public.storage.name is 'Имя файла';
comment on column public.storage.data is 'Содержимое';
comment on column public.storage.file_path is 'Путь к файлу';
create table public."user"
(
    id       bigserial
        primary key,
    "1c_id"  text,
    fio      text   not null,
    login    text   not null,
    password text   not null,
    boss     bigint
        constraint user_user_id_fk
            references public."user",
    photo    bigint not null
        constraint user_storage_id_fk
            references public.storage
);
comment on table public."user" is 'Пользователь';
comment on column public."user"."1c_id" is '1С ID';
comment on column public."user".fio is 'ФИО';
comment on column public."user".login is 'Логин';
comment on column public."user".password is 'Пароль';
comment on column public."user".boss is 'Начальник';
create table public.news
(
    id           bigserial,
    title        text                       not null,
    content      text                       not null,
    publish_date timestamp(6) default now() not null,
    author       bigint                     not null
        constraint news_user_fk
            references public."user",
    photo        bigint                     not null
        constraint news_storage_id_fk
            references public.storage
);
comment on table public.news is 'Новости';
comment on column public.news.title is 'Заголовок';
comment on column public.news.content is 'Содержимое';
comment on column public.news.publish_date is 'Дата публикации';
comment on column public.news.author is 'Автор';
create table public.user_test
(
    id     bigserial
        constraint test_result_pkey
            primary key,
    uid    bigint  not null
        constraint test_result_user_fk
            references public."user",
    tid    bigint  not null
        constraint test_result_test_fk
            references public.test,
    points integer not null,
    constraint user_test_pk
        unique (uid, tid)
);
comment on table public.user_test is 'Результаты теста';
comment on column public.user_test.uid is 'ID пользователя';
comment on column public.user_test.tid is 'ID теста';
comment on column public.user_test.points is 'Набранный балл';
create table public.user_lesson
(
    id     bigserial
        primary key,
    uid    bigint            not null
        constraint user_lesson_user_fk
            references public."user",
    lid    bigint            not null
        constraint user_lesson_lesson_fk
            references public.lesson,
    status integer default 0 not null,
    constraint user_lesson_pk
        unique (uid, lid)
);
comment on table public.user_lesson is 'Обучается';
comment on column public.user_lesson.uid is 'ID пользователя';
comment on column public.user_lesson.lid is 'ID урока';
comment on column public.user_lesson.status is 'Статус обучения уроку';
create table public.user_course
(
    id  bigserial
        primary key,
    uid bigint not null
        constraint user_course_user_fk
            references public."user",
    cid bigint not null
        constraint user_course_course_fk
            references public.course,
    constraint user_course_pk
        unique (uid, cid)
);
comment on table public.user_course is 'Записан';
comment on column public.user_course.uid is 'ID пользователя';
comment on column public.user_course.cid is 'ID курса';
