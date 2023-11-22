(select C.id, C.name, 0 "type", 'department' "target" from "user" U
join department_course DC on U.did = DC.did
join course C on DC.cid = C.id
where U.id=(:uid))

union all

(select L.id, L.name, 1 "type", 'department' "target" from "user" U
join department_lesson DL on U.did = DL.did
join lesson L on DL.lid = L.id
where U.id=(:uid))

union all

(select C.id, C.name, 0 "type", 'user' "target" from "user" U
join user_course UC on U.id = UC.uid
join course C on UC.cid = C.id
where U.id=(:uid))

union all

(select L.id, L.name, 1 "type", 'user' "target" from "user" U
join user_lesson UL on U.id = UL.uid
join lesson L on UL.lid = L.id
where U.id=(:uid))

order by 4, 3, 2