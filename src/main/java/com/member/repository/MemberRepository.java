package com.member.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.member.entity.Member;

import java.util.Optional;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface MemberRepository extends CrudRepository<Member, Long> {

	Member findByFirstName(String firstName);

	Member findByEmail(String email);

	Optional<Member> findByActivationToken(String activationToken);

	@Query("select m.password from Member m where m.id = :id")
	String getPasswordOfMember(@Param("id") long id);

	@Query("select m.enabled from Member m where m.id = :id")
	boolean getnabledOfMember(@Param("id") long id);
}
