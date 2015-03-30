package net.shangtech.eshop.account.dao;

import java.util.List;

import net.shangtech.eshop.account.entity.MemberAddress;
import net.shangtech.framework.dao.IBaseDao;

public interface MemberAddressDao extends IBaseDao<MemberAddress> {
	
	List<MemberAddress> findByMemberId(Long memberId);
	
}
