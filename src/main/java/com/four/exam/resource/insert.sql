
--testpaper试卷表
insert into testpaper(tpname,tpbeizhu,tptype,tpwritemessage,tpscore,tpstartdate,tpenddate,tpdatitime,tpfabu)
values('考试名称1','考试备注1','免登陆考试','姓名:文本/手机号码:手机号码/邮箱:邮箱/身份证号码:身份证','60','201901161630','201901171630','120','未发布');
insert into testpaper(tpname,tpbeizhu,tptype,tpwritemessage,tpscore,tpstartdate,tpenddate,tpdatitime,tpfabu)
values('考试名称2','考试备注2','口令登录','姓名:姓名/口令:121214','70','201901171630','201901171630','160','未发布');
insert into testpaper(tpname,tpbeizhu,tptype,tpwritemessage,tpscore,tpstartdate,tpenddate,tpdatitime,tpfabu)
values('考试名称3','考试备注3','免登陆考试+口令登录','姓名:文本/手机号码:手机号码/邮箱:邮箱/身份证号码:身份证/口令:121214','100','201901181630','201901191630','120','未发布');
insert into testpaper(tpname,tpbeizhu,tptype,tpwritemessage,tpscore,tpstartdate,tpenddate,tpdatitime,tpfabu)
values('考试名称4','考试备注4','安排考试','sdep:弘诚科技/java1809;snumber:777777/sname:邢强鹏','70','201901191630','201901201630','160','未发布');
select * from testpaper;

--user系统使用用户注册
insert into user(username,userpwd,usertel,usermessage) values ("ljh",'123456','15673496009','无');
insert into user(username,userpwd,usertel,usermessage) values ("xqp",'123456','15673491416','无');
insert into user(username,userpwd,usertel,usermessage) values ("dh",'123456','15677778888','无');
insert into user(username,userpwd,usertel,usermessage) values ("czf",'123456','19996666444','无');
select * from user;

--student考生安排表
insert into student(sname,snumber,spassword,sdep,ssex,screatdate) values('邢强鹏','777777','666666','弘诚科技/java1809','男','201901161629');
insert into student(sname,snumber,spassword,sdep,ssex,screatdate) values('邓欢','888888','666666','弘诚科技/java1809','男','201901161634');
insert into student(sname,snumber,spassword,sdep,ssex,screatdate) values('陈泽夫','999999','666666','弘诚科技/UI1809','男','201901161635');
insert into student(sname,snumber,spassword,sdep,ssex,screatdate) values('刘江徽','101010','666666','弘诚科技/UI1809','男','201901161636');
select * from student;

--questionbank题库-题目表
insert into questionbank(qboutline,qbtype,qbtext,qboptions,qbanswer,qbdifficulty,qbcreatetime) values("java/se",'单选题','谁是孙策的老婆','A:小乔/B:大乔/C:貂蝉/D:芈月','B','简单','20190116');
insert into questionbank(qboutline,qbtype,qbtext,qboptions,qbanswer,qbdifficulty,qbcreatetime) values("java/se",'单选题','谁是周瑜的老婆','A:小乔/B:大乔/C:貂蝉/D:芈月','A','简单','20190116');
insert into questionbank(qboutline,qbtype,qbtext,qboptions,qbanswer,qbdifficulty,qbcreatetime) values("UI/pp",'多选题','谁是刘备的老婆','A:小乔/B:大乔/C:孙尚香/D:甄姬','C','中等','20190116');
insert into questionbank(qboutline,qbtype,qbtext,qboptions,qbanswer,qbdifficulty,qbcreatetime) values("UI/pp",'多选题','谁是蜀国将军','A:黄忠/B:关羽/C:张飞/D:典韦','ABC','困难','20190116');
insert into questionbank(qboutline,qbtype,qbtext,qboptions,qbanswer,qbdifficulty,qbcreatetime) values("java/se",'多选题','谁是魏国将军','A:许诸/B:张郃/C:张飞/D:典韦','ABD','困难','20190116');
insert into questionbank(qboutline,qbtype,qbtext,qboptions,qbanswer,qbdifficulty,qbcreatetime) values("UI/pp",'单选题','谁是吴国将军','A:黄忠/B:徐晃/C:朱恒/D:典韦','C','特别困难','20190116');
insert into questionbank(qboutline,qbtype,qbtext,qboptions,qbanswer,qbdifficulty,qbcreatetime) values("UI/pp",'填空题','吴国将军是___,刘备的老婆是___,孙策叫周瑜___','3','朱恒/孙尚香/去中路','特别困难','20190116');
insert into questionbank(qboutline,qbtype,qbtext,qboptions,qbanswer,qbdifficulty,qbcreatetime) values("UI/pp",'问答题','jsp的九大内置对象','session，request，response,page,pageContext,apllaction,out,expction','不知道','特别困难','20190116');
insert into questionbank(qboutline,qbtype,qbtext,qboptions,qbanswer,qbdifficulty,qbcreatetime) values("UI/pp",'程序题','实现快速排序的算法','请填写内容','朱恒/孙尚香/去中路','特别困难','20190116');
select * from questionbank;

-- TestQuestions试卷题目表 每张试卷对应的题目
--第一张试卷答案：B A ABC C
insert into testquestions(tpid,tqbigtitle,tqnum,qbid,tqscore) values(1,'1',1,1,2.0);
insert into testquestions(tpid,tqbigtitle,tqnum,qbid,tqscore) values(1,'1',2,2,1.0);
insert into testquestions(tpid,tqbigtitle,tqnum,qbid,tqscore) values(1,'2',3,4,3.0);
insert into testquestions(tpid,tqbigtitle,tqnum,qbid,tqscore) values(1,'2',4,3,3.0);

--第二张试卷答案：C ABD ABC C
insert into testquestions(tpid,tqbigtitle,tqnum,qbid,tqscore) values(2,'1',1,3,2.0);
insert into testquestions(tpid,tqbigtitle,tqnum,qbid,tqscore) values(2,'2',2,5,1.0);
insert into testquestions(tpid,tqbigtitle,tqnum,qbid,tqscore) values(2,'2',3,4,3.0);
insert into testquestions(tpid,tqbigtitle,tqnum,qbid,tqscore) values(2,'3',4,6,3.0);

--第三张试卷答案：C ABD ABC 朱恒/孙尚香/去中路
insert into testquestions(tpid,tqbigtitle,tqnum,qbid,tqscore) values(3,'1',1,6,2.0);
insert into testquestions(tpid,tqbigtitle,tqnum,qbid,tqscore) values(3,'2',2,5,1.0);
insert into testquestions(tpid,tqbigtitle,tqnum,qbid,tqscore) values(3,'2',3,4,3.0);
insert into testquestions(tpid,tqbigtitle,tqnum,qbid,tqscore) values(3,'3',4,7,3.0);

--第四张试卷答案: A C ABC 朱恒/孙尚香/去中路
insert into testquestions(tpid,tqbigtitle,tqnum,qbid,tqscore) values(4,'1',1,2,2.0);
insert into testquestions(tpid,tqbigtitle,tqnum,qbid,tqscore) values(4,'2',2,3,1.0);
insert into testquestions(tpid,tqbigtitle,tqnum,qbid,tqscore) values(4,'3',3,8,3.0);
insert into testquestions(tpid,tqbigtitle,tqnum,qbid,tqscore) values(4,'4',4,9,3.0);
select * from testquestions;

--stutestscore考生试卷总分表
insert into stutestscore(sid,tpid,stsscore) values(1,1,3.0);
insert into stutestscore(sid,tpid,stsscore) values(1,2,3.0);
insert into stutestscore(sid,tpid,stsscore) values(2,2,4.0);
insert into stutestscore(sid,tpid,stsscore) values(1,3,6.0);
insert into stutestscore(sid,tpid,stsscore) values(3,3,6.0);
insert into stutestscore(sid,tpid,stsscore) values(2,3,6.0);
insert into stutestscore(sid,tpid,stsscore) values(1,3,6.0);
insert into stutestscore(sid,tpid,stsscore) values(1,4,6.0);
select * from stutestscore;

--loginstutestpaper 考生-试卷表-需要登录
insert into loginstutestpaper(snumber,tpid,tqnum,lstpanswer,lstpgetscore) values(777777,1,1,'B',2.0);
insert into loginstutestpaper(snumber,tpid,tqnum,lstpanswer,lstpgetscore) values(777777,1,2,'A',1.0);
insert into loginstutestpaper(snumber,tpid,tqnum,lstpanswer,lstpgetscore) values(777777,1,3,'CA',0.0);
insert into loginstutestpaper(snumber,tpid,tqnum,lstpanswer,lstpgetscore) values(777777,1,4,'ABC',0.0);

insert into loginstutestpaper(snumber,tpid,tqnum,lstpanswer,lstpgetscore) values(888888,2,1,'C',2.0);
insert into loginstutestpaper(snumber,tpid,tqnum,lstpanswer,lstpgetscore) values(888888,2,2,'ABD',1.0);
insert into loginstutestpaper(snumber,tpid,tqnum,lstpanswer,lstpgetscore) values(888888,2,3,'BC',0.0);
insert into loginstutestpaper(snumber,tpid,tqnum,lstpanswer,lstpgetscore) values(888888,2,4,'A',0.0);

insert into loginstutestpaper(snumber,tpid,tqnum,lstpanswer,lstpgetscore) values(999999,2,1,'B',0.0);
insert into loginstutestpaper(snumber,tpid,tqnum,lstpanswer,lstpgetscore) values(999999,2,2,'ABD',1.0);
insert into loginstutestpaper(snumber,tpid,tqnum,lstpanswer,lstpgetscore) values(999999,2,3,'ABC',3.0);
insert into loginstutestpaper(snumber,tpid,tqnum,lstpanswer,lstpgetscore) values(999999,2,4,'D',0.0);

insert into loginstutestpaper(snumber,tpid,tqnum,lstpanswer,lstpgetscore) values(101010,4,1,'A',2.0);
insert into loginstutestpaper(snumber,tpid,tqnum,lstpanswer,lstpgetscore) values(101010,4,2,'C',1.0);
insert into loginstutestpaper(snumber,tpid,tqnum,lstpanswer,lstpgetscore) values(101010,4,3,'ABD',0.0);
insert into loginstutestpaper(snumber,tpid,tqnum,lstpanswer,lstpgetscore) values(101010,4,4,'孙尚香/去中路',0.0);
select * from loginstutestpaper;




--stutestpaper 考生-试卷表-免登录
insert into stutestpaper(sname,tpwritemessage,tpid,tqnum,stpanswer,stpscore) values('傅正鹏','姓名:傅正鹏/口令:121214',3,1,'C',2.0);
insert into stutestpaper(sname,tpwritemessage,tpid,tqnum,stpanswer,stpscore) values('傅正鹏','姓名:傅正鹏/口令:121214',3,2,'ABD',1.0);
insert into stutestpaper(sname,tpwritemessage,tpid,tqnum,stpanswer,stpscore) values('傅正鹏','姓名:傅正鹏/口令:121214',3,3,'BC',0.0);
insert into stutestpaper(sname,tpwritemessage,tpid,tqnum,stpanswer,stpscore) values('傅正鹏','姓名:傅正鹏/口令:121214',3,4,'朱恒/孙尚香/去中路',3.0);

insert into stutestpaper(sname,tpwritemessage,tpid,tqnum,stpanswer,stpscore) values('黄芪','姓名:傅正鹏/口令:121214',3,1,'C',2.0);
insert into stutestpaper(sname,tpwritemessage,tpid,tqnum,stpanswer,stpscore) values('黄芪','姓名:傅正鹏/口令:121214',3,2,'ABD',1.0);
insert into stutestpaper(sname,tpwritemessage,tpid,tqnum,stpanswer,stpscore) values('黄芪','姓名:傅正鹏/口令:121214',3,3,'BC',0.0);
insert into stutestpaper(sname,tpwritemessage,tpid,tqnum,stpanswer,stpscore) values('黄芪','姓名:傅正鹏/口令:121214',3,4,'朱恒/孙尚香/去中路',3.0);

insert into stutestpaper(sname,tpwritemessage,tpid,tqnum,stpanswer,stpscore) values('真假诚','姓名:真假诚/口令:121214',2,1,'C',2.0);
insert into stutestpaper(sname,tpwritemessage,tpid,tqnum,stpanswer,stpscore) values('真假诚','姓名:真假诚/口令:121214',2,2,'ABD',1.0);
insert into stutestpaper(sname,tpwritemessage,tpid,tqnum,stpanswer,stpscore) values('真假诚','姓名:真假诚/口令:121214',2,3,'BC',0.0);
insert into stutestpaper(sname,tpwritemessage,tpid,tqnum,stpanswer,stpscore) values('真假诚','姓名:真假诚/口令:121214',2,4,'朱恒/孙尚香/去中路',3.0);
select * from stutestpaper;
--免登录考试的成绩表
insert into stutestscore2(information,tpid,stsscore) values('姓名:傅正鹏/口令:121214',1,8);
insert into stutestscore2(information,tpid,stsscore) values('姓名:傅正鹏/口令:121214',2,8);
insert into stutestscore2(information,tpid,stsscore) values('姓名:傅正鹏/口令:121214',3,10);