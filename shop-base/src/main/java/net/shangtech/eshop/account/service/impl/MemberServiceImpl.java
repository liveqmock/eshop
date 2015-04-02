package net.shangtech.eshop.account.service.impl;

import net.shangtech.eshop.account.dao.MemberDao;
import net.shangtech.eshop.account.entity.Member;
import net.shangtech.eshop.account.service.MemberService;
import net.shangtech.framework.orm.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImpl extends BaseService<Member> implements MemberService {

	@Autowired private MemberDao dao;
	
	@Override
    public Member findByEmail(String email) {
	    return dao.findByEmail(email);
    }

	@Override
    public Member findByMobile(String mobile) {
	    return dao.findByMobile(mobile);
    }

	@Override
    public Member findByThirdId(String thirdId) {
	    return dao.findByThirdId(thirdId);
    }

	@Override
    public Member register(Member temp) {
	    
	    return null;
    }

}
