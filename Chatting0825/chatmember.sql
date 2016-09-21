CREATE TABLE friend
(
   friend_id   NUMBER PRIMARY KEY,
   me          NUMBER,
   you         NUMBER
);

CREATE SEQUENCE seq_friend INCREMENT BY 1 START WITH 1;

--�뀒�씠釉� 蹂�寃�(異붽�) DDL(create,,alter,drop),
--DML(insert,update,delete), DCL(沅뚰븳)

ALTER TABLE chatmember
   ADD profile VARCHAR2 (30);


ALTER TABLE chatmember
   ADD status VARCHAR2 (100);

--�봽濡쒗븘 �궗吏꾨챸怨� �긽�깭 硫붿꽭吏� �뾽�뜲�씠�듃

UPDATE CHATMEMBER
   SET PROFILE = '1.png', status = '�깭援�媛��뒗以�..'
 WHERE CHATMEMBER_ID = 1;

SELECT * FROM chatmember;

COMMIT;

INSERT INTO CHATMEMBER (CHATMEMBER_ID,
                        ID,
                        PASSWORD,
                        NAME,
                        PROFILE,
                        STATUS)
     VALUES (seq_chatmember.NEXTVAL,
             'super',
             '3223',
             '�뒋�띁留�',
             '1.png',
             '�삤�뒛�� 湲곕텇轅�轅�');

INSERT INTO CHATMEMBER (CHATMEMBER_ID,
                        ID,
                        PASSWORD,
                        NAME,
                        PROFILE,
                        STATUS)
     VALUES (seq_chatmember.NEXTVAL,
             'zenxen',
             '1111',
             '�씠�썝援�',
             '1.png',
             '�삤�뒛�� 洹몃깷');

INSERT INTO CHATMEMBER (CHATMEMBER_ID,
                        ID,
                        PASSWORD,
                        NAME,
                        PROFILE,
                        STATUS)
     VALUES (seq_chatmember.NEXTVAL,
             'sduper',
             '1111',
             '�뒪�띁留�',
             '1.png',
             '�삤�뒛�� 議몃젮');

INSERT INTO CHATMEMBER (CHATMEMBER_ID,
                        ID,
                        PASSWORD,
                        NAME,
                        PROFILE,
                        STATUS)
     VALUES (seq_chatmember.NEXTVAL,
             'ouper',
             '1111',
             '�삤�띁留�',
             '1.png',
             '�삤�뒛�� �뀋�뀋');

INSERT INTO CHATMEMBER (CHATMEMBER_ID,
                        ID,
                        PASSWORD,
                        NAME,
                        PROFILE,
                        STATUS)
     VALUES (seq_chatmember.NEXTVAL,
             'ruper',
             '1111',
             '湲고띁留�',
             '1.png',
             '�삤�뒛�� 爰쇱졇');

INSERT INTO CHATMEMBER (CHATMEMBER_ID,
                        ID,
                        PASSWORD,
                        NAME,
                        PROFILE,
                        STATUS)
     VALUES (seq_chatmember.NEXTVAL,
             'uuper',
             '1111',
             '�쑀�띁留�',
             '1.png',
             '�삤�뒛�� ��諛�');

INSERT INTO CHATMEMBER (CHATMEMBER_ID,
                        ID,
                        PASSWORD,
                        NAME,
                        PROFILE,
                        STATUS)
     VALUES (seq_chatmember.NEXTVAL,
             'iuper',
             '1111',
             '�씠�띁留�',
             '1.png',
             '�삤�뒛�� �옗');

COMMIT;