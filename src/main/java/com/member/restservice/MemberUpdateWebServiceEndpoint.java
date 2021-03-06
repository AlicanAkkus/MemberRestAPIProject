package com.member.restservice;

import java.util.List;

import com.member.wrapper.MemberWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.member.pojo.MemberOperationPojo;
import com.member.service.MemberUpdateService;

import javax.validation.Valid;

@RestController
@RequestMapping("/memberUpdateWebServiceEndpoint")
public class MemberUpdateWebServiceEndpoint {

	@Autowired
	private MemberUpdateService memberUpdateServices;

	@RequestMapping(value = "/updateUserMember", method = RequestMethod.PUT)
	private ResponseEntity<MemberOperationPojo> updateBulkUserMember(@Valid @RequestBody MemberWrapper memberWrapper) {
		MemberOperationPojo memberOperationPojo = memberUpdateServices.updateUserMember(memberWrapper.getMemberList());
		return new ResponseEntity<>(memberOperationPojo, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateAdminMember", method = RequestMethod.PUT)
	private ResponseEntity<MemberOperationPojo> updateBulkAdminMember(@Valid @RequestBody MemberWrapper memberWrapper) {
		MemberOperationPojo memberOperationPojo = memberUpdateServices.updateAdminMember(memberWrapper.getMemberList());
		return new ResponseEntity<MemberOperationPojo>(memberOperationPojo, HttpStatus.OK);
	}

}
