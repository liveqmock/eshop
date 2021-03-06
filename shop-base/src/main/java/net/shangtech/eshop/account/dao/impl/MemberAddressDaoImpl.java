package net.shangtech.eshop.account.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.shangtech.eshop.account.dao.MemberAddressDao;
import net.shangtech.eshop.account.entity.MemberAddress;
import net.shangtech.framework.dao.hibernate.BaseDao;
import net.shangtech.framework.dao.support.MapHolder;

@Repository
public class MemberAddressDaoImpl extends BaseDao<MemberAddress> implements MemberAddressDao {

	@Override
    public List<MemberAddress> findByMemberId(Long memberId) {
	    return findByProperty("memberId", memberId);
    }

	@Override
	public MemberAddress findDefaultMemberAddress(Long memberId) {
		MapHolder<String> holder = new MapHolder<String>();
		holder.put("memberId", memberId);
		holder.put("isDefault", true);
		return findOneByProperties(holder);
	}

}
