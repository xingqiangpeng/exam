-- TestPaper
create table  `TestPaper`
(
  `tpid`            INT auto_increment primary key not null comment '试卷自身编号',
  `tpname`          VARCHAR(32) not null comment '考试名称',
  `tpbeizhu`        VARCHAR(2000) comment '考试备注',
  `tptype`          VARCHAR(200) not null comment '参加方式',
  `tpwritemessage`  VARCHAR(2000) not null comment '考生填写信息',
  `tpscore`         INT not null comment '考试及格分数',
  `tpstartdate`     VARCHAR(32) not null comment '考试开始时间',
  `tpenddate`       VARCHAR(32) not null comment '考试结束时间',
  `tpdatitime`      NUMERIC(6) not null comment '答题时长',
  `tpfabu`          VARCHAR(32) not null comment '发布状态 已发布，未发布',
  `b1`              VARCHAR(2000) comment 'bei',
  `b2`              VARCHAR(2000) comment 'bei',
  `b3`              VARCHAR(2000) comment 'bei'
);
alter table `TestPaper` comment= '试卷表';

-- TestQuestions
create table  `TestQuestions`
(
  `tqid`            INT auto_increment primary key not null comment '试题自身编号',
  `tpid`            INT comment '试卷编号',
  `tqbigtitle`      VARCHAR(50) not null comment '试卷大题',
  `tqnum`           INT not null comment '题目序号',
  `qbid`            INT comment '题库题目自身编号',
  `tqscore`         DOUBLE not null comment '题目分数',
  `b1`              VARCHAR(2000) comment 'bei',
  `b2`              VARCHAR(2000) comment 'bei',
  `b3`              VARCHAR(2000) comment 'bei'
);
alter table `TestQuestions` comment= '试卷题目表 每张试卷对应的题目';

-- QuestionBank
create table  `QuestionBank`
(
  `qbid`            INT auto_increment primary key not null comment '题库题目自身编号',
  `qboutline`       VARCHAR(200) not null comment '所属大纲 java/se--ui/pp',
  `qbtype`          VARCHAR(200) not null comment '题型 选择、问答',
  `qbtext`          VARCHAR(2000) not null comment '题干',
  `qboptions`       VARCHAR(2000) not null comment '选项',
  `qbanswer`        VARCHAR(200) not null comment '答案',
  `qbdifficulty`    VARCHAR(200) not null comment '题目难度',
  `qbcreatetime`    VARCHAR(200) not null comment '创建日期',
  `b1`              VARCHAR(2000) comment 'bei',
  `b2`              VARCHAR(2000) comment 'bei',
  `b3`              VARCHAR(2000) comment 'bei'
);
alter table `QuestionBank` comment= '题库-题目表';

-- student
create table  `student`
(
  `sid`             INT auto_increment primary key not null comment '自身编号',
  `sname`           VARCHAR(200) not null comment '考生姓名',
  `snumber`         VARCHAR(11) comment '考生账号(手机号码)',
  `spassword`       VARCHAR(50) not null comment '考生密码',
  `sdep`            VARCHAR(200) comment '部门',
  `ssex`            VARCHAR(32) comment '性别',
  `screatdate`      VARCHAR(32) comment '考生创建时间',
  `b1`              VARCHAR(2000) comment 'bei',
  `b2`              VARCHAR(2000) comment 'bei',
  `b3`              VARCHAR(2000) comment 'bei'
);
create unique index `IDU_student_snumber` on `student`(`snumber`);
alter table `student` comment= '考生安排表';

-- StuTestPaper
create table  `StuTestPaper`
(
  `stpid`           INT auto_increment primary key not null comment '自身编号',
  `sname`           VARCHAR(32) not null comment '考生姓名',
  `tpwritemessage`  VARCHAR(2000) not null comment '考生信息',
  `tpid`            INT comment '试卷编号',
  `tqnum`           INT not null comment '题目序号',
  `stpanswer`       VARCHAR(2000) comment '考生对应答案',
  `stpscore`        DOUBLE not null comment '考生所得分数',
  `b1`              VARCHAR(2000) comment 'bei',
  `b2`              VARCHAR(2000) comment 'bei',
  `b3`              VARCHAR(2000) comment 'bei'
);
alter table `StuTestPaper` comment= '考生-试卷表免登录 免登录';

-- LoginStuTestPaper
create table  `LoginStuTestPaper`
(
  `lstpid`          INT auto_increment primary key not null comment '自身编号',
  `snumber`         VARCHAR(11) comment '考生账号',
  `tpid`            INT comment '试卷编号',
  `tqnum`           INT not null comment '题目序号',
  `lstpanswer`      VARCHAR(2000) comment '考生对应答案',
  `lstpgetscore`    DOUBLE not null comment '考生得分',
  `b1`              VARCHAR(2000) comment 'bei',
  `b2`              VARCHAR(2000) comment 'bei',
  `b3`              VARCHAR(2000) comment 'bei'
);
alter table `LoginStuTestPaper` comment= '考生-试卷表（需要登录）';

-- User
create table  `User`
(
  `uid`             INT auto_increment primary key not null comment '自身编号',
  `username`        VARCHAR(200) not null comment '用户名',
  `userpwd`         VARCHAR(200) not null comment '登录密码',
  `usertel`         VARCHAR(11) not null comment '用户手机号码',
  `usermessage`     VARCHAR(2000) not null comment '需求信息',
  `b1`              VARCHAR(2000) comment 'bei',
  `b2`              VARCHAR(2000) comment 'bei',
  `b3`              VARCHAR(2000) comment 'bei'
);
alter table `User` comment= '系统使用注册用户';

-- stutestscore
create table  `stutestscore`
(
  `stsid`           INT auto_increment primary key not null comment '自身编号',
  `uid`             INT comment '用户id',
  `tpid`            INT comment '试卷编号',
  `stsscore`        DOUBLE not null comment '学生试卷总分',
  `b1`              VARCHAR(2000) comment 'bei',
  `b2`              VARCHAR(2000) comment 'bei',
  `b3`              VARCHAR(2000) comment 'bei'
);
alter table `stutestscore` comment= '考生试卷总分表';

-- stutestscore2
create table  `stutestscore2`
(
  `stsid`           INT auto_increment primary key not null comment '自身编号',
  `information`     VARCHAR(2000) not null comment '用户信息',
  `tpid`            INT comment '试卷编号',
  `stsscore`        DOUBLE not null comment '学生试卷总分',
  `b1`              VARCHAR(2000) comment 'bei',
  `b2`              VARCHAR(2000) comment 'bei',
  `b3`              VARCHAR(2000) comment 'bei'
);
alter table `stutestscore2` comment= '考生试卷总分表';

alter  table `TestQuestions`
  add constraint `FK_TestQuestions_tpid` foreign key (`tpid`)
    references `TestPaper`(`tpid`);
alter  table `TestQuestions`
  add constraint `FK_TestQuestions_qbid` foreign key (`qbid`)
    references `QuestionBank`(`qbid`);

alter  table `StuTestPaper`
  add constraint `FK_StuTestPaper_tpid` foreign key (`tpid`)
    references `TestPaper`(`tpid`);

alter  table `LoginStuTestPaper`
  add constraint `FK_LoginStper_snumber638A` foreign key (`snumber`)
    references `student`(`snumber`);
alter  table `LoginStuTestPaper`
  add constraint `FK_LoginStper_tpid07A8` foreign key (`tpid`)
    references `TestPaper`(`tpid`);

alter  table `stutestscore`
  add constraint `FK_stutestscore_uid` foreign key (`uid`)
    references `User`(`uid`);
alter  table `stutestscore`
  add constraint `FK_stutestscore_tpid` foreign key (`tpid`)
    references `TestPaper`(`tpid`);

alter  table `stutestscore2`
  add constraint `FK_stutestscore2_tpid` foreign key (`tpid`)
    references `TestPaper`(`tpid`);

alter  table `User` change `username` `username` VARCHAR(200) null;

create unique index `IDU_User_username` on `User`(`username`);
