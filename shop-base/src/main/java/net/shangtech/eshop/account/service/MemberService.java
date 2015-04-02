package net.shangtech.eshop.account.service;

import net.shangtech.eshop.account.entity.Member;
import net.shangtech.framework.orm.service.IBaseService;

public interface MemberService extends IBaseService<Member> {
	Member findByEmail(String email);
	
	Member findByMobile(String mobile);
	
	Member findByThirdId(String thirdId);
	
	Member register(Member temp);
}
