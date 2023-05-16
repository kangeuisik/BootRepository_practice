package com.rubypaper.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.rubypaper.domain.Board;

public interface DynamicBoardRepository extends CrudRepository<Board, Long>,
QuerydslPredicateExecutor<Board>{
	/*
	 * DynamicBoardRepository가 추가로 제공하는 메소드
	 * long count(Predicate P) : 검색된 데이터의 전체갯수
	 * boolean exists(Predicate P) : 검색된 데이터의 존재여부
	 * Iterable<T> findAll(Predicate P) : 조건에 맞는 모든 데이터 목록
	 * Page<T> findAll(Predicate P) : 위와 동일
	 * Iterable<t> findAll(Predicate P, Sort s) :조건에 맞는 모든 데이터 정렬
	 * T findOne(Predicate P) : 조건에 맞는 하나의 데이터
	 */
	

}
