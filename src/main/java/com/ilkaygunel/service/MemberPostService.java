package com.ilkaygunel.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilkaygunel.entities.Member;
import com.ilkaygunel.logging.LoggingUtil;
import com.ilkaygunel.repository.MemberRepository;

@Service
public class MemberPostService {

	@Autowired
	private MemberRepository memberRepository;

	public void addOneMember(Member member) {
		Logger LOGGER = new LoggingUtil().getLoggerForMemberSaving(this.getClass());
		try {
			LOGGER.log(Level.INFO, "One member adding method is running!");
			memberRepository.save(member);
			LOGGER.log(Level.INFO, "Member saving is successfull. Member info is:" + member);
		} catch (Exception ex) {
			LOGGER.log(Level.SEVERE, "An error occured while saving member. Error is:" + ex.getMessage());
		}

	}

	public void addBulkMember(List<Member> memberList) {
		Logger LOGGER = new LoggingUtil().getLoggerForMemberSaving(this.getClass());
		try {
			LOGGER.log(Level.INFO, "Bulk member adding method is running!");
			memberRepository.save(memberList);
			LOGGER.log(Level.INFO, "Bulk member saving is successfull. Members info are:" + memberList);
		} catch (Exception ex) {
			LOGGER.log(Level.SEVERE, "An error occured while saving member. Error is:" + ex.getMessage());
		}
	}
}