-- 1. 부서위치가 'CHICAGO' 인 모든 사원에 대해 이름, 업무, 급여 출력 (outer join)
select ename, job, sal
from emp left join dept
using(deptno)
where lower(loc) = lower('CHICAGO');

-- 2. 부하직원이 없는 사원의 사원번호, 이름, 업무, 부서번호 출력 (Sub Query) -> null 과 비교 불가!
select empno, ename, job, deptno
from emp
where empno not in(
	select distinct ifnull(mgr,-1)
    from emp
);

-- 3. 'BLAKE'와 같은 상사를 가진 사원의 이름, 업무, 상사번호 출력
select ename, job, mgr
from emp
where mgr = (
	select mgr
    from emp
    where upper(ename) = upper('BLAKE')
);

-- 4. 입사일이 가장 오래된 사람 5명을 검색
select *
from emp
order by ifnull(hiredate,now()) limit 0 , 5;

-- 5. 'JONES' 의 부하 직원의 이름, 업무, 부서명 검색
select ename, job, dname
from emp left join dept
using (deptno)
where mgr = (
	select empno
    from emp
    where upper(ename) = upper('JONES')
);